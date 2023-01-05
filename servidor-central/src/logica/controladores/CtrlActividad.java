package logica.controladores;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;

import datatypes.DTActividad;
import datatypes.DTPaquete;
import datatypes.DTSalida;
import datatypes.estadoActividad;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import excepciones.YaExisteException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import logica.clases.Departamento;
import logica.clases.ActividadTuristica;
import logica.clases.Categoria;
import logica.clases.ContadorVisitas;
import logica.clases.PaqueteTuristico;
import logica.handlers.HandlerDepartamentos;
import logica.handlers.HandlerPaquetes;
import logica.handlers.HandlerActividades;
import logica.handlers.HandlerCategorias;
import logica.interfaces.ICtrlActividad;
import logica.clases.SalidaTuristica;
import logica.clases.Turista;
import logica.clases.Usuario;
import logica.clases.dao.ActividadDao;
import logica.clases.dao.InscripcionDao;
import logica.clases.dao.ProveedorDao;
import logica.clases.dao.SalidaDao;
import logica.clases.dao.TuristaDao;
import logica.clases.dao.UsuarioDao;
import logica.clases.Proveedor;
import logica.handlers.HandlerSalidas;
import logica.handlers.HandlerUsuarios;

public class CtrlActividad implements ICtrlActividad{
	
	
	public void altaDepartamento(String nombreDepartamento, String descripcion , String URL) throws YaExisteException{
		HandlerDepartamentos handlerDepto = HandlerDepartamentos.getInstance();
		if (handlerDepto.existeDepartamento(nombreDepartamento)){
			throw new YaExisteException("El departamento " + nombreDepartamento + " ya se encuentra registrado.");
		}
		Departamento newD = new Departamento(nombreDepartamento, descripcion, URL);
		handlerDepto.add(newD);
		
	}
	
	public void altaCategoria(String nombre) throws YaExisteException{
		HandlerCategorias handlerCategorias = HandlerCategorias.getInstance();
		if (handlerCategorias.existeCategoria(nombre)){
			throw new YaExisteException("La Categoria " + nombre + " ya se encuentra registrada.");
		}
		Categoria nuevaCat = new Categoria(nombre);
		handlerCategorias.add(nuevaCat);
	}
	
	public Set<String> listarDepartamentos(){
		Set<String> departamentos = new HashSet<String>();
		HandlerDepartamentos handlerDpto = HandlerDepartamentos.getInstance();
		Set<Departamento> depto = handlerDpto.obtenerDepartamentos();
		depto.forEach(e -> { 
		  departamentos.add(e.getNombre()); });
		return departamentos;
	}
	
	public Set<String> listarActividadesDepartamento(String depto){
		HandlerDepartamentos handlerDpto = HandlerDepartamentos.getInstance();
		Departamento departamento = handlerDpto.getDepto(depto);
		Set<String> actividades = departamento.listarActividades();
		return actividades;
	}

	//Actividades
	public DTActividad getInfoActividad(String actividad) {
		//Falta la parte de Paquetes
		HandlerActividades handlerAct = HandlerActividades.getInstance();
		HandlerPaquetes handlerPaquete = HandlerPaquetes.getInstance();
		ActividadTuristica act = handlerAct.obtenerActividadTuristica(actividad);
		DTActividad res = act.getDTActividad();
		
		Set<PaqueteTuristico> paquete = handlerPaquete.getPaquetes();
		Set<String> paquetes = new HashSet<String>();
		paquete.forEach(e -> {
		  if (e.tieneActividad(actividad)) { 
		    paquetes.add(e.getNombre());
		  }});
		res.setPaquetes(paquetes);
		return res;
	}
	
	public void altaActividadTuristica(String nomDep, String nomActividad, String desc, int duraHs, float costo, String nombCiudad, String nickProv, GregorianCalendar fechaAlta, String imgDir, Set<String> categorias, String url, estadoActividad estado) throws YaExisteException {
		HandlerActividades handlerAct = HandlerActividades.getInstance();
		
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test");
    EntityManager em = emf.createEntityManager();
    Query query = em.createQuery("SELECT act FROM ActividadDao act WHERE act.nombre = '" + nomActividad + "'");
    
    try {
      ActividadDao result = (ActividadDao) query.getSingleResult();      
      throw new YaExisteException("Ya existe una actividad turistica " + nomActividad + " registrada.");
    } catch(NoResultException e) {
    }
    
    em.close();
    emf.close();
    
		if (handlerAct.existeActividad(nomActividad)){
			throw new YaExisteException("Ya existe una actividad turistica " + nomActividad + " registrada.");
		}

		ActividadTuristica resu = new ActividadTuristica(nomActividad, desc, duraHs, costo, nombCiudad, fechaAlta, imgDir, url, estado);

		HandlerDepartamentos handlerDpto = HandlerDepartamentos.getInstance();
		handlerDpto.getDepto(nomDep).agregarActividad(resu);

		
		HandlerCategorias handlerCategorias = HandlerCategorias.getInstance();
		categorias.forEach(cat -> {
			handlerCategorias.getCategoria(cat).agregarActividad(resu);
		});
		
		HandlerUsuarios handlerUsr = HandlerUsuarios.getInstance();
		Proveedor prov = (Proveedor) handlerUsr.getProveedorByNickname(nickProv);
		prov.agregarActividad(resu);
		handlerAct.agregarActividad(resu);
	}
	
	
	public Set<String> listarNombresSalidasDeActividad(String actividad){

		HandlerActividades handlerAct= HandlerActividades.getInstance();
		ActividadTuristica act = handlerAct.obtenerActividadTuristica(actividad);
		return act.getSalidasNombre();
	
	}
	
	//Salidas
	public Set<DTSalida> listarInfoSalidasVigentes(String actividad, GregorianCalendar fechaSistema){
		HandlerActividades handlerAct = HandlerActividades.getInstance();
		ActividadTuristica act = handlerAct.obtenerActividadTuristica(actividad);
		return act.getInfoBasicaSalidasVigentes(fechaSistema);
	}
	
	public void altaSalidaTuristica(String nombreSal, GregorianCalendar fechaSal, String lugarSal, int cantMaxTuristas, GregorianCalendar fechaAlta, String  actividad, String img) throws YaExisteException {
		HandlerSalidas handlerSal = HandlerSalidas.getInstance();
		if (handlerSal.existeSalida(nombreSal)) {
			throw new YaExisteException("La salida " + nombreSal + " ya se encuentra registrada");
			
		}
		HandlerActividades handlerAct = HandlerActividades.getInstance();
		ActividadTuristica actividadAux = handlerAct.obtenerActividadTuristica(actividad);
		
		SalidaTuristica newSal = new SalidaTuristica(nombreSal, fechaSal, lugarSal, cantMaxTuristas, fechaAlta, actividadAux, img);
		actividadAux.agregarSalida(newSal);
		handlerSal.addSalidas(newSal);
	
	}
	
	public DTSalida getInfoCompletaSalida(String salida) {
	
		HandlerSalidas handlerSal = HandlerSalidas.getInstance();
		SalidaTuristica sal = handlerSal.obtenerSalidaTuristica(salida);
		DTActividad dtAct = getInfoActividad(sal.getActividad().getNombre());
		
		DTSalida nueva = new DTSalida(sal.getNombre(), dtAct.getNombre(), dtAct.getDepartamento(), sal.getfechaSalida(), sal.getfechaAlta(), sal.getcantidadMaximaDeTuristas(), sal.getlugarSalida(), sal.getTuristasInscriptos(), sal.getImg());
		
		
		return nueva;
	}
	
	//Paquetes
	public void crearPaquete(String nombre, String descripcion, int validez, float descuento, GregorianCalendar  fechaDeAlta, String img) throws YaExisteException {
		HandlerPaquetes handlerPaq = HandlerPaquetes.getInstance();
		if (handlerPaq.existePaquete(nombre))
			throw new YaExisteException("El paquete " + nombre + " ya se encuentra registrado");
		PaqueteTuristico newPaquete = new PaqueteTuristico(nombre, descripcion, validez, descuento, fechaDeAlta, img);
		handlerPaq.addPaquete(newPaquete);
	}
	
	public Set<String> listarPaquetes(){
		HandlerPaquetes handlerPaq = HandlerPaquetes.getInstance();
		Set<PaqueteTuristico> paquetes = handlerPaq.getPaquetes();
		Set<String> res = new HashSet<String>();
		paquetes.forEach(e -> {
		  res.add(e.getNombre());
		  });
		return res;
	}
	
	public void ingresarActividadAPaquete(String nombrePaquete, String nombreActividad) {
		HandlerPaquetes handlerPaq = HandlerPaquetes.getInstance();
		HandlerActividades handlerAct = HandlerActividades.getInstance();
		PaqueteTuristico paq = handlerPaq.obtenerPaqueteTuristico(nombrePaquete);
		ActividadTuristica act = handlerAct.obtenerActividadTuristica(nombreActividad);
		paq.agregarActividad(act);
	}
	
	public DTPaquete getInfoPaquete(String paqueteSeleccionado) {
		HandlerPaquetes handlerPaq = HandlerPaquetes.getInstance();
		PaqueteTuristico paq = handlerPaq.obtenerPaqueteTuristico(paqueteSeleccionado);
		return paq.getDTPaquete();
	}
	
	public Set<String> listarActividadesDepartamentoMenosPaquete(String depto, String nombrePaquete){
		Set<String> resu = new HashSet<String>();
		Set<String> depAct = this.listarActividadesDepartamento(depto);
		HandlerActividades handlerAct = HandlerActividades.getInstance();
		Set<ActividadTuristica> actividades = new HashSet<ActividadTuristica>();
		for (String s: depAct) {
			ActividadTuristica act = handlerAct.obtenerActividadTuristica(s);
			actividades.add(act);
		}
		
		HandlerPaquetes handlerPaq = HandlerPaquetes.getInstance();
		PaqueteTuristico paq = handlerPaq.obtenerPaqueteTuristico(nombrePaquete);
		
		actividades.forEach(e -> {
			if (!paq.tieneActividad(e.getNombre()) & e.getEstado() == estadoActividad.confirmada  ) {
				resu.add(e.getNombre());
			}
		});
		return resu;
	} 
	
	public Set<String> listarCategorias(){
		Set<String> resultado = new HashSet<String>();
		HandlerCategorias handlerCat = HandlerCategorias.getInstance();
		Set<Categoria> categorias = handlerCat.obtenerCategorias();
		categorias.forEach(e -> {
			resultado.add(e.getNombre());
		});
		return resultado;
	}
	
	public void cambiarEstadoActividad(estadoActividad estado, String nombreAct) {
		HandlerActividades handlerAct = HandlerActividades.getInstance();
		ActividadTuristica act = handlerAct.obtenerActividadTuristica(nombreAct);
		act.setEstado(estado);
	}
	
	public <T> Set<T> filterActividades(Function<ActividadTuristica, T> returnFunction, Predicate<ActividadTuristica> condition) {
	    Set<T> res = new HashSet<T>();
	    Set<ActividadTuristica> actividades = HandlerActividades.getInstance().obtenerActividadesTuristicas();
		for (ActividadTuristica act : actividades) {
			if (condition.test(act))
				res.add(returnFunction.apply(act));
		}
		return res;
	}
	
  public Set<String> listarActividadesConfirmadas(){
    return filterActividades(
        a -> { return a.getNombre(); },
        a -> { return a.getEstado().equals(estadoActividad.confirmada); }
    ); 
  }
	
	public Set<DTActividad> getDTActividadesConfirmadas() {                                    
    return filterActividades(
        a -> { return a.getDTActividad(); },
        a -> { return a.getEstado().equals(estadoActividad.confirmada); }
    );
	}

    public Set<String> listarPaquetesCategoria(String categoria) {
        Set<String> res = new HashSet<String>();
        
        Set<String> paquetes = listarPaquetes();
        for (String paq : paquetes) {
            DTPaquete actual = getInfoPaquete(paq);
            if (actual.getCategorias().contains(categoria))
                res.add(paq);
        }
        
        return res;
    }
    
    public void leGusto(String nombreActividad, String nombreUsuario) {
    	HandlerActividades hA = HandlerActividades.getInstance();
    	ActividadTuristica act = hA.obtenerActividadTuristica(nombreActividad);
    	
    	if(!act.tieneFan(nombreUsuario)) {
    		HandlerUsuarios hU = HandlerUsuarios.getInstance();
    		Usuario fan = hU.getUsuarioByNickname(nombreUsuario);
    		act.agregarFan(fan);
    	}
    	else
    		act.eliminarFan(nombreUsuario);
    }
    
    public Set<DTActividad> listarActividadesSinSalidasVigentesNiPaquetes(String nickProv){
    	HandlerActividades hAct = HandlerActividades.getInstance();
    	Set<ActividadTuristica> actividades = hAct.obtenerActividadesTuristicas();
    	Set<DTActividad> resultado = new HashSet<DTActividad>();
    	actividades.forEach(act ->{
    		boolean cond1 = act.getEstado().equals(estadoActividad.confirmada);
    		boolean cond2 = act.getInfoBasicaSalidasVigentes(new GregorianCalendar()).isEmpty();
    		boolean cond3 = getInfoActividad(act.getNombre()).getPaquetes().isEmpty();
    		boolean cond4 = act.getProveedor().equals(nickProv);
     		if(cond1 && cond2 && cond3 && cond4) {
    			resultado.add(act.getDTActividad());
    		}
    	});
    	return resultado;
    }
    
    public void finalizarActividad(String nombreActividad) {
    	ActividadTuristica act = HandlerActividades.getInstance().obtenerActividadTuristica(nombreActividad);
    	DTActividad dtAct = act.getDTActividad();
    	ActividadDao actDao = new ActividadDao(dtAct);
    	Set<SalidaTuristica> salidas = act.getSalidas();
    	salidas.forEach((sal)->{
    		if(sal != null) {
        		SalidaDao salDao = new SalidaDao(sal);
        		salDao.setActividad(actDao);
        		
        		Set<String> turistasSal = sal.getTuristasNicknameInscriptos();
        		turistasSal.forEach((tur)->{
        			Turista turInstancia = HandlerUsuarios.getInstance().getTuristaByNickname(tur);
        			
        			UsuarioDao usrTurDao = new UsuarioDao((Usuario) turInstancia);
        			TuristaDao turDao = new TuristaDao(turInstancia);
        			turDao.setUsuario(usrTurDao);
        			
        			InscripcionDao insDao = new InscripcionDao(turInstancia.getInfoInscripcion(sal.getNombre()));
        			insDao.setTurista(turDao);
        			insDao.setSalida(salDao);
        			salDao.addIncripcion(insDao);
        			turInstancia.eliminarIncripcionesDeActividad(nombreActividad);
        		});
        		actDao.addSalida(salDao);
        		HandlerSalidas.getInstance().eliminarSalida(sal.getNombre());
    		}

    	});
    	
    	/*El proveedor*/
    	Proveedor prov = HandlerUsuarios.getInstance().getProveedorByNickname(act.getProveedor());
    	UsuarioDao usr = new UsuarioDao(prov);
    	ProveedorDao provDao = new ProveedorDao(prov);
    	provDao.setUsuario(usr);
    	
    	actDao.setProveedor(provDao);
    	//provDao.addActividad(actDao);
    	//guardar en la base de datos	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test");
    	EntityManager eman = emf.createEntityManager();
    		
    	EntityTransaction trans = eman.getTransaction();
    	trans.begin();
    	eman.persist(actDao);
    	trans.commit();
    	eman.close();
    	emf.close();
    	
    	
    	/*Eliminar del programa las actividades*/
    	HandlerCategorias hCat = HandlerCategorias.getInstance();
    	Set<Categoria> categorias = hCat.obtenerCategorias();
    	categorias.forEach((cat)->{
    		cat.eliminarAcividad(nombreActividad);
    	});
    	HandlerDepartamentos hDep = HandlerDepartamentos.getInstance();
    	Set<Departamento> departamentos = hDep.obtenerDepartamentos();
    	departamentos.forEach((dep)->{
    		dep.eliminarActividad(nombreActividad);
    	});
    	
    	prov.eliminarActividad(nombreActividad);
    	
    	Set<SalidaTuristica> salidasParaEliminar = act.getSalidas();
    	HandlerSalidas hSal = HandlerSalidas.getInstance();
    	for(SalidaTuristica salt: salidasParaEliminar) {
    		hSal.eliminarSalida(salt.getNombre());
    	}
    	
    	HandlerActividades hAct = HandlerActividades.getInstance();
    	hAct.eliminarActividad(nombreActividad);
    };
    
    public Set<ActividadDao> getActividadesFinalizada(String proveedor) {
    	Set<ActividadDao> resultado = new HashSet<ActividadDao>();
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test");
  		EntityManager em = emf.createEntityManager();
  		Query query = em.createQuery("SELECT act FROM ActividadDao act WHERE act.id_proveedor.usuarioId.nickname = '" + proveedor + "'");
  		List<ActividadDao> result = (List<ActividadDao>) query.getResultList();
  		for (ActividadDao dao : result) {
  		  resultado.add(dao);
  		}
  		em.close();
		  emf.close();
    	return resultado;
    }
    
    public Set<SalidaDao> getSalidasFinalizadas(String nombreAct) {
    	Set<SalidaDao> resultado = new HashSet<SalidaDao>();
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test");
  		EntityManager em = emf.createEntityManager();
  		Query query = em.createQuery("SELECT sal FROM SalidaDao sal WHERE sal.actividad.nombre = '" + nombreAct + "'");
  		List<SalidaDao> result = (List<SalidaDao>) query.getResultList();
  		for (SalidaDao dao : result) {
  		  resultado.add(dao);
  		}
  		em.close();
		  emf.close();
    	return resultado;
    }
    
    public ActividadDao getActividadFinalizada(String nombreActividad) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test");
  		EntityManager em = emf.createEntityManager();
  		Query query = em.createQuery("SELECT act FROM ActividadDao act WHERE act.nombre = '" + nombreActividad + "'");
  		ActividadDao result = (ActividadDao) query.getSingleResult();
  		em.close();
		  emf.close();
    	return result;
    }
    
    public SalidaDao getSalidaDeActividadFinalizada(String nombreSalida) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test");
  		EntityManager em = emf.createEntityManager();
  		Query query = em.createQuery("SELECT sal FROM SalidaDao sal WHERE sal.nombre = '" + nombreSalida + "'");
  		SalidaDao result = (SalidaDao) query.getSingleResult();
  		em.close();
		  emf.close();
    	return result;
    }

    public Set<InscripcionDao> getInscripcionesDeSalidasDeActividadesFinalizadas(String turista) {
    	Set<InscripcionDao> resultado = new HashSet<InscripcionDao>();
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test");
  		EntityManager em = emf.createEntityManager();
  		Query query = em.createQuery("SELECT insc FROM InscripcionDao insc WHERE insc.turistaId.usuarioId.nickname = '" + turista + "'");
  		List<InscripcionDao> inscripciones = (List<InscripcionDao>) query.getResultList();
  		for (InscripcionDao dao : inscripciones) {
  		  resultado.add(dao);
  		}
  		em.close();
		  emf.close();
    	return resultado;
    }
    
    public Set<DTActividad> infoBusquedaActividades(String busqueda){
    	Set<DTActividad> dtActs = new HashSet<DTActividad>();
    	HandlerActividades hA = HandlerActividades.getInstance();
    	for(ActividadTuristica actual: hA.obtenerActividadesTuristicas())
    		if(actual.getEstado() == estadoActividad.confirmada && (actual.getDescripcion().toLowerCase().contains(busqueda.toLowerCase()) || actual.getNombre().toLowerCase().contains(busqueda.toLowerCase())))
    			dtActs.add(actual.getDTActividad());
    	return dtActs;
    }
    
    public Set<DTPaquete> infoBusquedaPaquetes(String busqueda){
    	Set<DTPaquete> dtPaqs = new HashSet<DTPaquete>();
    	HandlerPaquetes hP = HandlerPaquetes.getInstance();
    	DTPaquete actual;
    	for(PaqueteTuristico paq: hP.getPaquetes()) {
    		actual = paq.getDTPaquete();
    		if(!actual.getActividades().isEmpty() && (actual.getDescripcion().toLowerCase().contains(busqueda.toLowerCase())||actual.getNombre().toLowerCase().contains(busqueda.toLowerCase())))
    			dtPaqs.add(actual);
    	}
    	return dtPaqs;
    }
    
    public void agregarVisita(String nombre, boolean esActividad) {
    	ContadorVisitas cV = ContadorVisitas.getInstance();
    	cV.agregar(nombre, esActividad);
    }
    
    public Map<String, Integer> listarTop10Visitados(){
    	ContadorVisitas cV = ContadorVisitas.getInstance();
    	return cV.getTop10();
    }
}