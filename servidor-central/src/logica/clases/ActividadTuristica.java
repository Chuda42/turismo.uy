package logica.clases;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.GregorianCalendar;

import datatypes.DTActividad;
import datatypes.DTPaquete;
import datatypes.DTSalida;
import datatypes.estadoActividad;
import logica.handlers.HandlerDepartamentos;
import logica.handlers.HandlerUsuarios;
import logica.handlers.HandlerCategorias;

import java.util.HashMap;

public class ActividadTuristica{
	private String nombre, descripcion, nombreCiudad;
	private int duracionHs;
	private float costoPorTurista;
	private GregorianCalendar fechaAlta;
	private estadoActividad estado;
	private Map<String, SalidaTuristica> salidas;
	private String imgDir, url;
	private Map<String, Usuario> likedBy;
	
	public ActividadTuristica(String nombre, String descripcion, int duracionHs, float costoPorTurista, String nombreCiudad, GregorianCalendar fechaAlta, String imgDir, String url, estadoActividad estado) {
		this.url = url;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracionHs = duracionHs;
		this.costoPorTurista = costoPorTurista;
		this.nombreCiudad = nombreCiudad;
		this.fechaAlta = fechaAlta;
		this.estado = estado;
		salidas = new HashMap<String, SalidaTuristica>();
		likedBy = new HashMap<String, Usuario>();
		this.imgDir = imgDir;
	}
	
	public String getNombre() {
		return nombre;
	}
	public estadoActividad getEstado() {
		return this.estado;
	}
	public void setEstado(estadoActividad estado) {
		 this.estado = estado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
	public int getDuracionHs() {
		return duracionHs;
	}
	
	public float getCostoPorTurista() {
		return costoPorTurista;
	}
	
	public String getNombreCiudad() {
		return nombreCiudad;
	}
	
	public Map<String, Usuario> getLikedBy(){
		return likedBy;
	}
	
	public GregorianCalendar getFechaAlta() {
		return fechaAlta;
	}
	public Set<String> getSalidasNombre() {
		return this.salidas.keySet();
	}
	
	public String getImgDir() {
		return this.imgDir;
	}
	
	public void agregarSalida(SalidaTuristica salida) {
		salidas.put(salida.getNombre(), salida);
	}

	public Set<DTSalida> getInfoBasicaSalidasVigentes(GregorianCalendar fechaSistema) {
		Set<DTSalida> res = new HashSet<DTSalida>();
		salidas.values().forEach(e -> {
			if (e.getfechaSalida().after(fechaSistema)) {
				Set<String> turistas = new HashSet<String>();
				DTActividad dtAct = getDTActividad();
				DTSalida actual = new DTSalida(e.getNombre(), dtAct.getNombre(), dtAct.getDepartamento(),  e.getfechaSalida(), e.getfechaAlta(), e.getcantidadMaximaDeTuristas(), e.getlugarSalida(), turistas, e.getImg());
				res.add(actual);
			}
		});
		return res;
	}
	
	public DTActividad getDTActividad() {
		String nombre = this.nombre;
		String des =this.descripcion;
		String nombreCiudad = this.nombreCiudad;
		GregorianCalendar fechaAlta = this.fechaAlta;
		int dura = this.duracionHs;
		float costo = this.costoPorTurista;
		Set<String> salidas = new HashSet<String>();
 		this.salidas.forEach((key, value)-> {
			salidas.add(value.getNombre());
		});
 		String imgDireccion = this.imgDir;
		Set<String> categorias = getCategorias();
		HandlerDepartamentos handlerDepartamentos = HandlerDepartamentos.getInstance();
		String nombreDepto = handlerDepartamentos.getDeptoContains(this);
		return new DTActividad(nombre, des, nombreDepto, nombreCiudad, fechaAlta, dura, costo, salidas, categorias, imgDireccion, estado, likedBy.keySet(), url);
	}

    public Set<String> getCategorias() {
        Set<String> res = new HashSet<String>();
        HandlerCategorias handlerCategorias = HandlerCategorias.getInstance();
        Set<Categoria> categorias = handlerCategorias.obtenerCategorias();
        categorias.forEach(e -> {
        	if ( e.tieneActividad(nombre)) res.add(e.getNombre()); });
        return res;
    }

	public boolean tieneFan(String nombreUsuario) {
		return likedBy.containsKey(nombreUsuario);
	}

	public void agregarFan(Usuario fan) {
		likedBy.put(fan.getNickname(), fan);
	}

	public void eliminarFan(String nombreUsuario) {
		likedBy.remove(nombreUsuario);
	}
	
	public String getUrl() {
		return url;
	}

	public String getProveedor() {
		Set<Proveedor> proveedores = HandlerUsuarios.getInstance().listarProveedores();
		String resu = "";
		for (Proveedor prov : proveedores) {
            if (prov.proveeActividad(this.nombre)) {
            	resu = prov.getNickname();
            	return resu;
            }
        }
		return resu;
	}
	
	public Set<SalidaTuristica> getSalidas() {
		 Set<SalidaTuristica> resultado = new HashSet<SalidaTuristica>();
		 salidas.forEach((key, value)->{
			 resultado.add(value);
		 });
		 return resultado;
	}
}
