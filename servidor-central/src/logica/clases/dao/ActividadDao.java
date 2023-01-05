package logica.clases.dao;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import logica.clases.ActividadTuristica;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import datatypes.DTActividad;
import datatypes.estadoActividad;

@Entity
@Table(name= "Act_table")
public class ActividadDao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String descripcion;
	private int duracion;
	private float costo;
	private String ciudad;
	private String nombreDepartamento;
	private estadoActividad estado = estadoActividad.finalizada;
	private GregorianCalendar fechaAlta;
	private GregorianCalendar fechaBaja;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="ProveedorDao_Id")
	private ProveedorDao id_proveedor;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name="SalidaId")
	private List<SalidaDao> salidas = new ArrayList<SalidaDao>();
	
	public ActividadDao() {
		
	}
	
	public ActividadDao(DTActividad act) {
		nombre = act.getNombre();
		setDescripcion(act.getDescripcion());
		setDuracion(act.getDuracionHs());
		setCosto(act.getCosto());
		setCiudad(act.getNombreCiudad());
		setNombreDepartamento(act.getDepartamento());
		setFechaAlta(act.getFechaAlta());
		setFechaBaja(new GregorianCalendar());
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	public estadoActividad getEstado() {
		return estado;
	}

	public void setEstado(estadoActividad estado) {
		this.estado = estado;
	}

	public GregorianCalendar getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(GregorianCalendar fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public GregorianCalendar getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(GregorianCalendar fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	
	public ProveedorDao getProveedor() {
		return id_proveedor;
	}
	
	public void setProveedor(ProveedorDao prov) {
		id_proveedor = prov;
	}
	
	public void addSalida(SalidaDao sal) {
		salidas.add(sal);
	}
	
	public List<SalidaDao> getSalidas(){
		return salidas;
	}
	
	
}
