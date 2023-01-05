package logica.clases;

import java.util.GregorianCalendar;
import java.util.Map;
import java.util.HashMap;

import datatypes.DTCompra;

public class Compra {
    private GregorianCalendar fechaCompra;
    private int cantidadTuristas;
    private float costoTotal;
    private GregorianCalendar vencimiento;
    private PaqueteTuristico paquete;
    private Map<String, Integer> disponibles;
    
    public Compra(GregorianCalendar fechaCompra, int cantidadTuristas , PaqueteTuristico paquete) {
        this.fechaCompra = fechaCompra;
        this.cantidadTuristas = cantidadTuristas;
        this.paquete = paquete;
        this.vencimiento = (GregorianCalendar) fechaCompra.clone();
        this.vencimiento.add(GregorianCalendar.DATE, paquete.getPeriodoValidez());
        this.costoTotal = cantidadTuristas * paquete.calcularCosto();
        
        disponibles = new HashMap<String, Integer>();
        for (String act : paquete.getNombreActividades())
            disponibles.put(act, cantidadTuristas);
    }
    
    public DTCompra getDT() {
        return new DTCompra(paquete.getNombre(), fechaCompra, vencimiento, cantidadTuristas, estaVigente(new GregorianCalendar()), disponibles);
    }
    
    public PaqueteTuristico getPaquete() {
        return this.paquete;
        
    }
    public float getCostoTotal() {
        return costoTotal;
        
    }
    public int disponiblesEnActividad(String actividad) {
        return disponibles.get(actividad);
    }
    
    
    //Pre: (disponiblesEnActividad(actividad) >= cantTuristas)
    public void reducirDisponiblesEnActividad(int cantTuristas, String actividad) {
        int actual = disponibles.get(actividad);
        disponibles.put(actividad, actual - cantTuristas);
    }
    
    public boolean estaVigente(GregorianCalendar fecha) {
        return vencimiento.after(fecha);
    }
}
