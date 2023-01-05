package logica.clases;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Categoria {
	private String nombre;
    private Map<String, ActividadTuristica> actividades;

	public Categoria(String nombre) {
		this.nombre = nombre;
		actividades = new HashMap<String, ActividadTuristica>();
	}
	
	public String getNombre() {
		return this.nombre;	
	}
    
	public Map<String, ActividadTuristica> getActividades(){
        return actividades;
    }
    
    public Set<String> listarActividades() {
        return actividades.keySet();
    }
    
    public void agregarActividad(ActividadTuristica actividad) {
        this.actividades.put(actividad.getNombre(), actividad);
    }

    public boolean tieneActividad(String nombre) {
        return actividades.containsKey(nombre);
    }
    
    public void eliminarAcividad(String nombreAct) {
    	actividades.remove(nombreAct);
    }
	
}
