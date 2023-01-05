package datatypes;

import java.util.GregorianCalendar;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTCompra {
	private String paquete;
	private GregorianCalendar fechaCompra;
	private GregorianCalendar fechaVencimiento;
	private int cantidadTuristas;
	private boolean vigente;
	private Map<String, Integer> disponibles;
	
	public DTCompra(String nomPaq, GregorianCalendar fecha, GregorianCalendar fechaVenc, int cantTur, boolean vig, Map<String, Integer> dis) {
		paquete = nomPaq;
		fechaCompra = fecha;
		fechaVencimiento = fechaVenc;
		cantidadTuristas = cantTur;
		vigente = vig;
		disponibles = dis;
	}
	
	public DTCompra() {
		
	}
	
	public String getPaquete() {
		return paquete;
	}
	public GregorianCalendar getFechaCompra() {
		return fechaCompra;
	}
	public GregorianCalendar getFechaVencimiento() {
		return fechaVencimiento;
	}
	public int getCantTuristas() {
		return cantidadTuristas;
	}
	public boolean getVigente() {
	    return vigente;
	}

    public int disponiblesEnActividad(String nomAct) {
        return disponibles.get(nomAct);
    }
    
    public boolean tieneActividad(String atividad) {
        return disponibles.containsKey(atividad);
    }
}
