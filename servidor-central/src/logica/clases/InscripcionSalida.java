package logica.clases;

import java.util.GregorianCalendar;
import java.util.Set;

import datatypes.DTActividad;
import datatypes.DTSalida;
import datatypes.tipoInscripcion;

public class InscripcionSalida{
	
	private int cantTuristas;
	private GregorianCalendar fechaAlta;
	private float costo;
	private SalidaTuristica salida;
	private tipoInscripcion tipo;

	public InscripcionSalida(int cant, GregorianCalendar fecha, SalidaTuristica salidaT, float costo, tipoInscripcion tipo) {
		this.cantTuristas = cant;
		this.fechaAlta = fecha;
		this.salida = salidaT;
		this.costo = costo;
		this.tipo = tipo;
	}
	
	public InscripcionSalida() {
		
	}

	public int getCantTuristas() {
		return cantTuristas;
	}
	
	public GregorianCalendar getFechaAlta() {
		return fechaAlta;
	}
	
	public float getCosto() {
		return costo;
	}
	
	public SalidaTuristica getSalida() {
		return salida;
	}
	
	public tipoInscripcion getTipo() {
	    return tipo;
	}
	
	public DTSalida getDTSalida() {
		String salidaNombre = this.salida.getNombre();
		GregorianCalendar dateSalida = this.salida.getfechaSalida();
		GregorianCalendar dateAct = this.salida.getfechaAlta();
		int CmaxT  = this.salida.getcantidadMaximaDeTuristas();
		String SlugarSal = this.salida.getlugarSalida();
		Set<String> SSturistas = this.salida.getTuristasInscriptos();
		DTActividad actSalida = salida.getActividad().getDTActividad();
		return new DTSalida(salidaNombre , actSalida.getNombre(), actSalida.getDepartamento(), dateSalida, dateAct, CmaxT, SlugarSal, SSturistas, this.salida.getImg());
	}
}
