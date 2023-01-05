package logica.interfaces;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Set;

import com.itextpdf.text.DocumentException;

import datatypes.DTActividad;
import datatypes.DTSalida;
import datatypes.DTUsuario;
import datatypes.tipoUsuario;
import datatypes.tipoInscripcion;

import excepciones.YaExisteException;
import excepciones.CompraFailException;
import excepciones.InscriptionFailException;

public interface ICtrlUsuario {

	public abstract void altaUsuario(String nickname, String email , String nombre, String apellido, String contrasena, GregorianCalendar fechaNac, String imgDir, tipoUsuario tipo, String nacionalidad, String desc, String sitioWeb) throws YaExisteException; 
	public abstract void ingresarInscripcion(String nickname, String salida, int cant, GregorianCalendar fecha, tipoInscripcion tipo, String paquete) throws InscriptionFailException;
	public abstract void ingresarCompra(String nickname, String paquete, int cant, GregorianCalendar fecha) throws CompraFailException;
	public abstract Set<String> listarTuristas();
	public abstract Set<String> listarProveedores();
	public abstract void actualizarUsuario(String nickname, String nombre, String apellido, GregorianCalendar fechaNac, String img, String nacionalidad, String desc, String sitioWeb);
	public abstract Set<DTSalida> listarInfoSalidasTurista(String turista); 
	public abstract Set<DTActividad> listarInfoCompletaActividadesProveedor(String proveedor);
	public abstract Set<String> listarUsuarios();
	public abstract DTUsuario getInfoBasicaUsuario(String usr);
	public abstract DTUsuario getUsuarioByEmail(String email);
	public abstract DTUsuario getUsuarioByNickName(String nickname);
	public abstract boolean verifiedUserPassword(String nick, String pass);
	public abstract void seguirUsuario(String nickSeguidor, String nickSeguido);
	public abstract byte[] obtenerComprobanteInscripcion(String usuario, String salida) throws DocumentException, IOException;
  public boolean existeUsuarioConEmail(String email);
  public boolean existeUsuarioConNickname(String nick);
}