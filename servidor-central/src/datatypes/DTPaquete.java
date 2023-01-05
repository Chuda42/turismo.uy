package datatypes;

import java.util.GregorianCalendar;
import java.util.Set;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTPaquete {
	private String nombre, descripcion, imgDir;
	private int periodoValidez;
	private float descuento;
	private GregorianCalendar fechaAlta;
	private Set<String> actividades;
	private Set<String> categorias;
	private float costo;

	public DTPaquete(String nombre, String descripcion, int periodoValidez, float descuento, float costo, GregorianCalendar fechaAlta,
			Set<String> actividades, Set<String> categorias, String img) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.periodoValidez = periodoValidez;
		this.descuento = descuento;
		this.fechaAlta = fechaAlta;
		this.actividades = actividades;
		this.imgDir = "imagen?paq=" +  img;
		this.categorias = categorias;
		this.costo = costo;
	}

	public DTPaquete() {
		
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public String getImg() {
		return imgDir;
	}
	
	public int getPeriodoValidez() {
		return periodoValidez;
	}

	public float getDescuento() {
		return descuento;
	}
	
	public Set<String> getCategorias() {
		return categorias;
	}

	public GregorianCalendar getFechaAlta() {
		return fechaAlta;
	}

	public Set<String> getActividades() {
		return actividades;
	}
	
	public float getCosto() {
	    return costo;
	}

}
