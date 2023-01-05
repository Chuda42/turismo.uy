package logica.controladores;

import logica.interfaces.ICtrlUsuario;
import logica.clases.Proveedor;
import logica.clases.Turista;
import logica.clases.Usuario;
import logica.clases.dao.SalidaDao;
import logica.clases.SalidaTuristica;
import logica.clases.InscripcionSalida;
import logica.handlers.HandlerSalidas;
import logica.handlers.HandlerUsuarios;
import datatypes.DTActividad;
import datatypes.DTInscripcion;
import datatypes.DTProveedor;
import datatypes.DTSalida;
import datatypes.DTTurista;
import datatypes.DTUsuario;
import datatypes.tipoUsuario;
import datatypes.tipoInscripcion;
import logica.handlers.HandlerPaquetes;
import logica.clases.PaqueteTuristico;
import logica.clases.Compra;
import logica.clases.ComprobanteInscripcion;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Set;

import com.itextpdf.text.DocumentException;

import java.util.HashSet;

import excepciones.YaExisteException;
import jakarta.jws.WebMethod;
import excepciones.InscriptionFailException;
import excepciones.CompraFailException;

public class CtrlUsuario implements ICtrlUsuario {

  public CtrlUsuario() {
  }

  public void altaUsuario(String nickname, String email, String nombre, String apellido,
      String contrasena, GregorianCalendar fechaNac, String imgDir, tipoUsuario tipo,
      String nacionalidad, String descripcion, String sitioWeb) throws YaExisteException {
    HandlerUsuarios handlerUsr = HandlerUsuarios.getInstance();
    if (tipo == tipoUsuario.turista) {
      Turista turista = new Turista(nickname, email, nombre, apellido, contrasena, fechaNac, imgDir,
          nacionalidad);
      handlerUsr.agregarTurista(turista);
    } else {
      Proveedor proveedor = new Proveedor(nickname, email, nombre, apellido, contrasena, fechaNac,
          imgDir, descripcion, sitioWeb);
      handlerUsr.agregarProveedor(proveedor);
    }
  }

  public void ingresarInscripcion(String nickname, String salida, int cant, GregorianCalendar fecha,
      tipoInscripcion tipo, String paquete) throws InscriptionFailException {
    HandlerUsuarios handlerUsr = HandlerUsuarios.getInstance();
    HandlerSalidas handlerSal = HandlerSalidas.getInstance();
    HandlerPaquetes handlerPaq = HandlerPaquetes.getInstance();
    Turista turista = handlerUsr.getTuristaByNickname(nickname);
    SalidaTuristica salidaT = handlerSal.obtenerSalidaTuristica(salida);
    PaqueteTuristico paq;
    Compra com;

    if (turista.inscriptoSalida(salidaT))
      throw new InscriptionFailException("El usuario " + turista.getNickname()
          + " ya se encuentra registrado en la salida seleccionada");
    if (salidaT.getPlazosDisponibles() < cant)
      throw new InscriptionFailException("La salida " + salidaT.getNombre()
          + " no tiene los plazos suficientes para la inscripcion");

    if (tipo == tipoInscripcion.paquete) {
      com = turista.getCompras().get(paquete);
      if (com.disponiblesEnActividad(salidaT.getActividad().getNombre()) < cant)
        throw new InscriptionFailException("No quedan cupos suficientes para la Actividad "
            + salidaT.getActividad().getNombre() + " en el paquete seleccionado");
      else {
        com.reducirDisponiblesEnActividad(cant, salidaT.getActividad().getNombre());
      }
    }

    float costo = salidaT.calcularCosto(cant);

    float descuento = 0;
    if (tipo == tipoInscripcion.paquete) {
      paq = handlerPaq.obtenerPaqueteTuristico(paquete);
      descuento += paq.getDescuento() / 100;
    }

    InscripcionSalida insc = new InscripcionSalida(cant, fecha, salidaT, costo * (1 - descuento),
        tipo);
    salidaT.reducirPlazos(cant);
    turista.agregarInscripcion(insc);
  }

  public void ingresarCompra(String nickname, String paquete, int cant, GregorianCalendar fecha)
      throws CompraFailException {
    HandlerUsuarios handlerUsr = HandlerUsuarios.getInstance();
    HandlerPaquetes handlerPaq = HandlerPaquetes.getInstance();
    Turista turista = handlerUsr.getTuristaByNickname(nickname);
    PaqueteTuristico paq = handlerPaq.obtenerPaqueteTuristico(paquete);

    if (turista.comproPaquete(paquete))
      throw new CompraFailException(
          "El usuario " + turista.getNickname() + " ya compró el paquete anteriormente.");

    Compra comp = new Compra(fecha, cant, paq);
    turista.agregarCompra(comp);
  }

  public Set<String> listarTuristas() {
    Set<String> res = new HashSet<String>();
    HandlerUsuarios handlerUsr = HandlerUsuarios.getInstance();
    Set<Turista> turistas = handlerUsr.listarTuristas();
    turistas.forEach(e -> {
      res.add(e.getNickname());
    });
    return res;
  }

  public Set<String> listarProveedores() {
    HandlerUsuarios handlerUsr = HandlerUsuarios.getInstance();
    Set<String> res = new HashSet<String>();
    handlerUsr.listarProveedores().forEach(e -> {
      res.add(e.getNickname());
    });
    return res;
  }

  public void actualizarUsuario(String nickname, String nombre, String apellido,
      GregorianCalendar fechaNac, String img, String nacionalidad, String desc, String sitioWeb) {
    HandlerUsuarios handlerU = HandlerUsuarios.getInstance();
    Usuario usuario = handlerU.getUsuarioByNickname(nickname);
    usuario.setNombre(nombre);
    usuario.setApellido(apellido);
    usuario.setFechaNac(fechaNac);
    if (!img.isEmpty())
      usuario.setImg(img);
    if (usuario instanceof Turista) {
      ((Turista) usuario).setNacionalidad(nacionalidad);
    } else {
      ((Proveedor) usuario).setDescripcion(desc);
      ((Proveedor) usuario).setSitioWeb(sitioWeb);
    }

  }

  public Set<DTSalida> listarInfoSalidasTurista(String turista) {
    HandlerUsuarios handlerUsr = HandlerUsuarios.getInstance();
    Set<DTSalida> resultado = null;
    Turista turis = handlerUsr.getTuristaByNickname(turista);
    resultado = turis.getInfoInscripciones();
    return resultado;
  }

  public Set<DTActividad> listarInfoCompletaActividadesProveedor(String paquete) {
    HandlerUsuarios handlerUsr = HandlerUsuarios.getInstance();
    Set<DTActividad> resultado = null;
    Proveedor prov = handlerUsr.getProveedorByNickname(paquete);
    resultado = prov.getDTActividades();
    return resultado;
  }

  public Set<String> listarUsuarios() {
    HandlerUsuarios handlerUsr = HandlerUsuarios.getInstance();
    Set<Usuario> usuarios = handlerUsr.listarUsuarios();
    Set<String> resultado = new HashSet<String>();
    usuarios.forEach((Usuario usuario) -> {
      resultado.add(usuario.getNickname());
    });
    return resultado;
  }

  public DTUsuario getInfoBasicaUsuario(String usr) {
    HandlerUsuarios handlerUsr = HandlerUsuarios.getInstance();
    DTUsuario resultado = null;
    Usuario usuario = handlerUsr.getUsuarioByNickname(usr);
    if (usuario instanceof Proveedor) {
      resultado = new DTProveedor((Proveedor) usuario);
    } else {
      resultado = new DTTurista((Turista) usuario);
    }
    return resultado;
  }

  public DTUsuario getUsuarioByEmail(String email) {
    HandlerUsuarios handlerUsr = HandlerUsuarios.getInstance();
    DTUsuario resultado = null;
    Usuario usuario = handlerUsr.getUsuarioByEmail(email);
    if (usuario instanceof Proveedor) {
      resultado = new DTProveedor((Proveedor) usuario);
    } else {
      resultado = new DTTurista((Turista) usuario);
    }
    return resultado;
  }

  public DTUsuario getUsuarioByNickName(String nickname) {
    HandlerUsuarios handlerUsr = HandlerUsuarios.getInstance();
    DTUsuario resultado = null;
    Usuario usuario = handlerUsr.getUsuarioByNickname(nickname);
    if (usuario instanceof Proveedor) {
      resultado = new DTProveedor((Proveedor) usuario);
    } else {
      resultado = new DTTurista((Turista) usuario);
    }
    return resultado;
  }
  
  public boolean verifiedUserPassword(String nick, String pass) {
    String realPass = HandlerUsuarios.getInstance().getUsuarioByNickname(nick).getContrasena();
    return realPass.equals(pass);
  }
  
  // nickSeguidor comienza a seguir a nickSeguido.
  // Si ya lo seguia, lo deja de seguir.
  public void seguirUsuario(String nickSeguidor, String nickSeguido) {
	  HandlerUsuarios hU = HandlerUsuarios.getInstance();
	  Usuario seguido = hU.getUsuarioByNickname(nickSeguido);
	  Usuario seguidor = hU.getUsuarioByNickname(nickSeguidor);
	  
	  if(seguido.tieneSeguidor(nickSeguidor)) {
		  seguido.eliminarSeguidor(nickSeguidor);
		  seguidor.eliminarSeguido(nickSeguido);
	  }
	  else {
		  seguido.agregarSeguidor(seguidor);
		  seguidor.agregarSeguido(seguido);
	  }
  }
  
  public byte[] obtenerComprobanteInscripcion(String nick, String salida) throws DocumentException, IOException {
	  HandlerUsuarios hU = HandlerUsuarios.getInstance();
	  Turista turista = hU.getTuristaByNickname(nick);
	  
	  DTInscripcion dtInsc = turista.getInfoInscripcion(salida);
	  
	  return new ComprobanteInscripcion().generar(dtInsc);
  }
  
  public boolean existeUsuarioConEmail(String email) {
    HandlerUsuarios hU = HandlerUsuarios.getInstance();
    return hU.existeUsuarioConEmail(email);
  }
  
  public boolean existeUsuarioConNickname(String nick) {
    HandlerUsuarios hU = HandlerUsuarios.getInstance();
    return hU.existeUsuarioConNickname(nick);
  }
  
}
