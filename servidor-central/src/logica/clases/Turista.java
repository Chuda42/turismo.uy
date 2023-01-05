package logica.clases;

import java.util.GregorianCalendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import java.util.HashSet;

import datatypes.DTInscripcion;
import datatypes.DTSalida;

public class Turista extends Usuario {
	private Map<String, InscripcionSalida> inscripciones;
	private String nacionalidad;
	private Map<String, Compra> compras;

	public Turista(String nickname, String email, String nombre, String apellido, String contrasena, GregorianCalendar fechaNac, String imgDir, String nacionalidad) {
		super(nickname, email, nombre, apellido, contrasena, fechaNac, imgDir);
		this.nacionalidad = nacionalidad;
		this.inscripciones = new HashMap<String, InscripcionSalida>();
		this.compras = new HashMap<String, Compra>();
	}

	public String getNacionalidad() {
		return nacionalidad;
	}
	
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public Set<DTSalida> getInfoInscripciones() {
		Set<DTSalida> resultado = new HashSet<DTSalida>();
		inscripciones.forEach((key, value) -> {
			resultado.add(value.getDTSalida());
		});
		return resultado;
	}
	
	public Map<String, Compra> getCompras() {
        return compras;
    }

	public void agregarInscripcion(InscripcionSalida insc) {
		inscripciones.put(insc.getSalida().getNombre(), insc);
	}
	
	public boolean inscriptoSalida(SalidaTuristica salida) {
		return inscripciones.containsKey(salida.getNombre());
	}

    public boolean comproPaquete(String paquete) {
        return compras.containsKey(paquete);
    }

    public void agregarCompra(Compra comp) {
        compras.put(comp.getPaquete().getNombre(), comp);
    }
    
	public Set<InscripcionSalida> getInscripciones() {
        return new HashSet<InscripcionSalida>(inscripciones.values());
    }
	
	public DTInscripcion getInfoInscripcion(String salida) {
		InscripcionSalida insc = inscripciones.get(salida);
		DTInscripcion res = new DTInscripcion(salida, insc.getSalida().getActividad().getNombre(), nombre + " " + apellido, insc.getFechaAlta(), insc.getSalida().getfechaSalida(), insc.getCantTuristas(), insc.getCosto(), insc.getTipo());
		return res;
	}
	
	public void eliminarIncripcionesDeActividad(String nombreActividad) {
		Set<String> inscripcionesAEliminar = new HashSet<String>();
		inscripciones.forEach((key, val)->{
			if(val.getSalida().getActividad().getNombre().equals(nombreActividad)) {
				inscripcionesAEliminar.add(key);
			}
		});
		inscripcionesAEliminar.forEach((ins)->{
			inscripciones.remove(ins);
		});
	}
}
