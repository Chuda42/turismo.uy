package datatypes;

import java.util.Set;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import logica.clases.dao.ActividadDao;

import java.util.GregorianCalendar;
import java.util.HashSet;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTActividad {
	
	private String nombre;
	private String descripcion;
	private String departamento;
	private String imgDir;
	private String nombreCiudad;
	private GregorianCalendar fechaAlta;
	private int duracionHs;
	private float costo;
	private Set<String> nombCategorias;
	private Set<String> salidas;
	private Set<String> paquetes;
	private estadoActividad estado;
	private Set<String> likedBy;
	private String url;

	public DTActividad(ActividadDao adao) {
	  nombre = adao.getNombre();
	  descripcion = adao.getDescripcion();
	  estado = adao.getEstado();
	  fechaAlta = adao.getFechaAlta();
	  nombreCiudad = adao.getCiudad();
	  costo = adao.getCosto();
	}
	
	public DTActividad(String nombre, String des, String departamento, String nombCiudad , GregorianCalendar fechaAlta, int dura, float costo, Set<String> salidas, Set<String> nombCat, String imgDir, estadoActividad estado, Set<String> likedBy, String url) {
		this.nombre = nombre;
		this.descripcion = des;
		this.departamento = departamento;
		this.nombreCiudad =  nombCiudad;
		this.fechaAlta = fechaAlta;
		this.duracionHs = dura;
		this.costo = costo;
		this.nombCategorias = nombCat;
		this.salidas = salidas;
		this.estado = estado;
		paquetes = new HashSet<String>();
		this.imgDir = "imagen?act=" + imgDir;
		this.likedBy = likedBy;
		this.url = url;
	}

	public DTActividad() {
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	
	public int getDuracionHs() {
		return duracionHs;
	}
	
	public float getCosto() {
		return costo;
	}
	
	public Set<String> getSalidas() {
	  if (salidas == null)
	    return new HashSet<String>();
		return salidas;
	}
	
	public estadoActividad getestado() {
		return this.estado;
	}



	public Set<String> getPaquetes() {
		return paquetes;
	}
	
	public Set<String> getCategorias(){
		return nombCategorias;
	}
	
	public GregorianCalendar getFechaAlta() {
		return fechaAlta;
	}
	
	@SuppressWarnings("static-access")
    public String getFechaAltaString() {
		String dia = String.valueOf(fechaAlta.get(fechaAlta.DAY_OF_MONTH));
		String mes = String.valueOf(fechaAlta.get(fechaAlta.MONTH) + 1);
		String anio = String.valueOf(fechaAlta.get(fechaAlta.YEAR));
		String resultado =	dia + "/" + mes + "/" + anio;
		return resultado;
	}
	
	public String getImgDir(){
		return imgDir;
	}
	
	public String getNombreCiudad(){
		return nombreCiudad;
	}
	
	public Set<String> getLikedBy(){
		return likedBy;
	}
	
	public void setPaquetes(Set<String> paquetes) {
		this.paquetes = paquetes;
	}

	public String toString() {
		return "Nombre: " + getNombre();
	}

	public String getUrl() {
		return url;
	}

	
}
