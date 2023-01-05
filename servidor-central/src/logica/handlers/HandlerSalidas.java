package logica.handlers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import logica.clases.SalidaTuristica;

/*
 * Clase que contiene la coleccion global de Salidas Turisticas 
 */
public class HandlerSalidas{
    private Map<String, SalidaTuristica> salidasTuristicas;
    private static HandlerSalidas instancia = null;

    private HandlerSalidas() {
        salidasTuristicas = new HashMap<String, SalidaTuristica>();
    }

    public static HandlerSalidas getInstance() {
        if (instancia == null)
            instancia = new HandlerSalidas();
        return instancia;
    }

    public void addSalidas(SalidaTuristica sal) {
        String SnameSal= sal.getNombre();
        
       salidasTuristicas.put(SnameSal, sal);
    }

    public SalidaTuristica obtenerSalidaTuristica(String IDsal) {
        return (SalidaTuristica) salidasTuristicas.get(IDsal);
    }

    public SalidaTuristica[] getSalidas() {
        if (salidasTuristicas.isEmpty())
            return null;
        else {
            Collection<SalidaTuristica> salidas = salidasTuristicas.values();
            Object[] objeto = salidas.toArray();
            SalidaTuristica[] salida = new SalidaTuristica[objeto.length];
            for (int i = 0; i < objeto.length; i++) {
                salida[i] = (SalidaTuristica) objeto[i];
            }

            return salida;
        }
    }
    public boolean existeSalida(String nombreSalida) {
		return this.salidasTuristicas.containsKey(nombreSalida);
	}

	public static void clear() {
		instancia = null;
		
	}
	
	public void eliminarSalida(String nombreSal) {
		salidasTuristicas.remove(nombreSal);		
	}


}
