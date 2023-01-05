package datatypes;

import java.util.GregorianCalendar;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTInscripcion{
	private int cantTuristas;
	private GregorianCalendar fechaAlta, fechaSalida;
	private float costo;
	private String salida, actividad, nombreTurista;
	private tipoInscripcion tipo;
	
	public DTInscripcion(){
		
	}
	
	public DTInscripcion(String salida, String actividad, String nombreTurista, GregorianCalendar fechaAlta, GregorianCalendar fechaSalida, int cantTuristas, float costo, tipoInscripcion tipo){
		this.setSalida(salida);
		this.setActividad(actividad);
		this.setNombreTurista(nombreTurista);
		this.setFechaAlta(fechaAlta);
		this.setFechaSalida(fechaSalida);
		this.setCantTuristas(cantTuristas);
		this.setCosto(costo);
		this.setTipo(tipo);
	}

	public String getNombreTurista() {
		return nombreTurista;
	}

	public void setNombreTurista(String nombreTurista) {
		this.nombreTurista = nombreTurista;
	}

	public GregorianCalendar getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(GregorianCalendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public GregorianCalendar getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(GregorianCalendar fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public int getCantTuristas() {
		return cantTuristas;
	}

	public void setCantTuristas(int cantTuristas) {
		this.cantTuristas = cantTuristas;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getSalida() {
		return salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}

	public tipoInscripcion getTipo() {
		return tipo;
	}

	public void setTipo(tipoInscripcion tipo) {
		this.tipo = tipo;
	}
}