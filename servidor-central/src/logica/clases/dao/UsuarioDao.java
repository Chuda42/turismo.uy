package logica.clases.dao;

import java.util.GregorianCalendar;
import datatypes.tipoUsuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import logica.clases.Turista;
import logica.clases.Usuario;

@Entity
@Table(name = "UsuarioDao")
public class UsuarioDao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String nickname;
	private String email;
	private String nombre;
	private String apellido;
	private GregorianCalendar fechaNac;
	private tipoUsuario tipo;
	
	public UsuarioDao() {
		
	}
	
	public UsuarioDao(Usuario usr) {
		nickname = usr.getNickname();
		email = usr.getEmail();
		nombre = usr.getNombre();
		apellido = usr.getApellido();
		fechaNac = usr.getFechaNac();
		if(usr instanceof Turista) {
			tipo = tipoUsuario.turista;
		}else {
			tipo = tipoUsuario.proveedor;
		}
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public GregorianCalendar getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(GregorianCalendar fechaNac) {
		this.fechaNac = fechaNac;
	}
	public tipoUsuario getTipoUsuario() {
		return tipo;
	}
	public void setTipoUsuario(tipoUsuario tipoUsuario) {
		this.tipo = tipoUsuario;
	}
	
	
	
}
