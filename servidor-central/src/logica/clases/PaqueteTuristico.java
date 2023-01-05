package logica.clases;

//import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.GregorianCalendar;

import datatypes.DTPaquete;

public class PaqueteTuristico {
	private String nombre, descripcion;
	private int periodoValidez;
	private float descuento;
	private GregorianCalendar fechaAlta;
	private Map<String, ActividadTuristica> actividades;
	private String img;
	
	public PaqueteTuristico(String nombre, String descripcion, int periodoValidez, float descuento, GregorianCalendar fechaAlta, String img) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.periodoValidez = periodoValidez;
		this.descuento = descuento;
		this.fechaAlta = fechaAlta;
		actividades = new HashMap<String, ActividadTuristica>();
		this.img = img;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public int getPeriodoValidez() {
		return periodoValidez;
	}

	public float getDescuento() {
		return descuento;
	}
	
	public GregorianCalendar getFechaAlta() {
		return fechaAlta;
	}
	
	public boolean tieneActividad(String nombre) {
		return actividades.containsKey(nombre);
	}
	
	public void agregarActividad(ActividadTuristica act) {
		actividades.put(act.getNombre(), act);
	}
	
	public Set<String> getNombreActividades(){
	    return actividades.keySet();
	}
	
	public String getImg() {
	    return img;
	}
	
	public DTPaquete getDTPaquete() {
	    Set<String> categorias = new HashSet<String>();
	    actividades.forEach((key, value) -> {
	    	categorias.addAll(value.getCategorias()); 
	    	});
		return new DTPaquete(nombre, descripcion, periodoValidez, descuento, calcularCosto(), fechaAlta, actividades.keySet(), categorias, img);
	}
	
	public float calcularCosto() {
	    float res = 0;
	    for (ActividadTuristica act : actividades.values())
	        res += act.getCostoPorTurista();
	    
	    return res*(1-descuento/100);
	}
}
