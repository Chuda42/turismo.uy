package logica.handlers;

//importaciones
//import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
//import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//import java.util.HashSet;

import logica.clases.ActividadTuristica;
import logica.clases.Departamento;
//import logica.controladores.hD;


public class HandlerDepartamentos{
	private Map<String, Departamento> departamentos;
	private static HandlerDepartamentos instancia = null;
	
	private HandlerDepartamentos() {
		this.departamentos = new HashMap<String, Departamento>();
	};
	
	public static HandlerDepartamentos getInstance() {
		if (HandlerDepartamentos.instancia == null) {
			HandlerDepartamentos.instancia = new HandlerDepartamentos();
		}
		return HandlerDepartamentos.instancia;
	}
	
	//Pre: no existe un departamento con nombre d.getNombre
	public void add(Departamento dpto) {
		String nombreDepartamento = dpto.getNombre();
		this.departamentos.put(nombreDepartamento, dpto);
	}
	
	public boolean existeDepartamento(String nombreDepartamento) {
		return this.departamentos.containsKey(nombreDepartamento);
	}

	public Set<Departamento> obtenerDepartamentos() {
		Set<Departamento> departamentos = new HashSet<Departamento>(this.departamentos.values());
		return departamentos;
	}
	
	public Departamento getDepto(String depto) {
		return departamentos.get(depto);
	}
	
	//Pre: la actividad tiene que estar en un departamento
	//Pre: la actividad solo esta en un depto
	public String getDeptoContains(ActividadTuristica actividad) {
		return departamentos.entrySet().stream()
			.filter(depto -> depto.getValue().getActividades().containsValue(actividad))
			.findFirst().get().getValue().getNombre();
	}
	
	public static void clear() {
		instancia = null;
	}

}