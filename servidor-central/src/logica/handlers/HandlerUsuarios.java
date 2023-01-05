package logica.handlers;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;
//import java.util.Collection;
//import java.util.GregorianCalendar;
import java.util.HashMap;

import logica.clases.Usuario;
import logica.clases.Turista;
import logica.clases.Proveedor;
import excepciones.YaExisteException;

public class HandlerUsuarios {
	private static HandlerUsuarios instance = null;
	
	private Map<String, Usuario> usuarios; //guarda todos por el nickname
	private Map<String, Proveedor> proveedores; //guarda por el email
	private Map<String, Turista> turistas; //guarda por el email

	private HandlerUsuarios() {
		usuarios = new HashMap<String, Usuario>();
		proveedores = new HashMap<String, Proveedor>();
		turistas = new HashMap<String, Turista>();
	}

	public static HandlerUsuarios getInstance() {
		if (instance == null)
			instance = new HandlerUsuarios();
		return instance;
	}

	public void agregarTurista(Turista turista) throws YaExisteException {
		if (usuarios.containsKey(turista.getNickname())) {
			throw new YaExisteException("El usuario con el nickname " + turista.getNickname() + " ya se encuentra registrado.");
		}
		if (turistas.containsKey(turista.getEmail())) {
			throw new YaExisteException("El usuario con el email " + turista.getEmail() + " ya se encuentra registrado.");
		}
		if (proveedores.containsKey(turista.getEmail())) {
			throw new YaExisteException("El usuario con el email " + turista.getEmail() + " ya se encuentra registrado.");
		}
		usuarios.put(turista.getNickname(), turista);
		turistas.put(turista.getEmail(), turista);
	}

	public void agregarProveedor(Proveedor prov) throws YaExisteException {
		if (usuarios.containsKey(prov.getNickname())) {
			throw new YaExisteException("El usuario con el nickname " + prov.getNickname() + " ya se encuentra registrado.");
		}
		if (proveedores.containsKey(prov.getEmail())) {
			throw new YaExisteException("El usuario con el email " + prov.getEmail() + " ya se encuentra registrado.");
		}
		if (turistas.containsKey(prov.getEmail())) {
			throw new YaExisteException("El usuario con el email " + prov.getEmail() + " ya se encuentra registrado.");
		}
		usuarios.put(prov.getNickname(), prov);
		proveedores.put(prov.getEmail(), prov);
	}

	//tira null si no existe
	public Usuario getUsuarioByNickname(String nick){
		return usuarios.get(nick);
	}
	
	 //tira null si no existe
  public Usuario getUsuarioByEmail(String email){
    Usuario usr = proveedores.get(email);
    if (usr == null)
       usr = turistas.get(email);
    return usr;
  }
	
	public Proveedor getProveedorByNickname(String nick) {
		return (Proveedor) usuarios.get(nick);
	}
	
	public Turista getTuristaByNickname(String nick) {
		return (Turista) usuarios.get(nick);
	}

	public Set<Turista> listarTuristas() {
		Set<Turista> res = new HashSet<Turista>(turistas.values());
		return res;
	}

	public Set<Proveedor> listarProveedores() {
		Set<Proveedor> res = new HashSet<Proveedor>(proveedores.values());
		return res;
	}

	public Set<Usuario> listarUsuarios() {
		Set<Usuario> res = new HashSet<Usuario>(usuarios.values());
		return res;
	}
	
	public static void clear() {
		instance = null;
	}
	
	public boolean existeUsuarioConEmail(String email) {
		return turistas.containsKey(email) || proveedores.containsKey(email);
	}
	public boolean existeUsuarioConNickname(String nick) {
    return usuarios.containsKey(nick);
  }
}
