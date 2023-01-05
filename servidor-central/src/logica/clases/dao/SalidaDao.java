package logica.clases.dao;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import datatypes.DTSalida;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import logica.clases.SalidaTuristica;

@Entity
@Table(name = "Salida_table")
public class SalidaDao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private GregorianCalendar fecha;
	private int turistasMax;
	private String lugar;
	private GregorianCalendar fechaAlta;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="actividadId")
	private ActividadDao actividad;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name="inscripcionId")
	private List<InscripcionDao> inscripciones = new ArrayList<InscripcionDao>();

	public SalidaDao() {
		
	}
	
	public SalidaDao(SalidaTuristica salida) {
		nombre = salida.getNombre();
		fecha = salida.getfechaSalida();
		turistasMax = salida.getcantidadMaximaDeTuristas();
		lugar = salida.getlugarSalida();
		fechaAlta = salida.getfechaAlta();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public int getTuristasMax() {
		return turistasMax;
	}

	public void setTuristasMax(int turistasMax) {
		this.turistasMax = turistasMax;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public GregorianCalendar getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(GregorianCalendar fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	public void addIncripcion(InscripcionDao ins) {
		inscripciones.add(ins);
	}
	
	public void setActividad(ActividadDao act) {
		actividad = act;
	}
	
	public ActividadDao getActividad() {
		return actividad;
	}
	
	public List<InscripcionDao> getInscripciones(){
		return inscripciones;
	}
}
