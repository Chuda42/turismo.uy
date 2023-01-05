package logica.handlers;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import java.util.HashSet;

import logica.clases.PaqueteTuristico;

/*
 * Clase que contiene la coleccion global de Paquetes
 */
public class HandlerPaquetes {
	private Map<String, PaqueteTuristico> paquetes;
	private static HandlerPaquetes instancia = null;
	
	public HandlerPaquetes() {
		paquetes = new HashMap<String, PaqueteTuristico>();
	}
	
	public static HandlerPaquetes getInstance() {
		if (instancia == null)
			instancia = new HandlerPaquetes();
		return instancia;
	}
	
	public void addPaquete(PaqueteTuristico paquete) {
		paquetes.put(paquete.getNombre(), paquete);
	}
	
	public PaqueteTuristico obtenerPaqueteTuristico(String nombre) {
		return paquetes.get(nombre);
	}
	
	public boolean existePaquete(String nombre) {
		return paquetes.containsKey(nombre);
	}
	
	public Set<PaqueteTuristico> getPaquetes(){
	    Set<PaqueteTuristico> res = new HashSet<PaqueteTuristico>(paquetes.values());
	    return res;
	}
	
	public static void clear() {
		instancia = null;
	}
}
