package logica.clases.dao;

import java.util.GregorianCalendar;

import datatypes.DTInscripcion;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import logica.clases.InscripcionSalida;

@Entity
@Table(name = "InscripcionDao")
public class InscripcionDao {

	@Id
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "turistaId")
	private TuristaDao turistaId;
	@Id
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "salidaId")
	private SalidaDao salidaId;
	
	private GregorianCalendar fechaInscripcion;
	private int cantidadTuristas;
	private float costo;
	
	public InscripcionDao() {
		
	}
	
	public InscripcionDao(DTInscripcion ins) {
		fechaInscripcion = ins.getFechaAlta();
		cantidadTuristas = ins.getCantTuristas();
		costo = ins.getCosto();
	}
	
	public GregorianCalendar getFechaInscripcion() {
		return fechaInscripcion;
	}
	public void setFechaInscripcion(GregorianCalendar fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}
	public int getCantidadTuristas() {
		return cantidadTuristas;
	}
	public void setCantidadTuristas(int cantidadTuristas) {
		this.cantidadTuristas = cantidadTuristas;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	
	public void setTurista(TuristaDao tur) {
		turistaId = tur;
	}
	
	public void setSalida(SalidaDao sal) {
		salidaId = sal;
	}
	
	public TuristaDao getTurisita() {
		return turistaId;
	}
	
	public SalidaDao getSalida() { 
		return salidaId;
	}
}
