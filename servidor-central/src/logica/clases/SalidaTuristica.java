package logica.clases;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import logica.handlers.HandlerUsuarios;

public class SalidaTuristica{
	
	 private String nombre;
	    private GregorianCalendar fechaSalida;
	    private GregorianCalendar fechaAlta;
	    private int cantidadMaximaDeTuristas;
	    private String lugarSalida;
	    private ActividadTuristica actividad;
	    private int plazosDisponibles;
	    private String img;
		   
	    public SalidaTuristica(String salidaNombre, GregorianCalendar dateSalida, String SlugarSal, int CmaxT, GregorianCalendar dateAct, ActividadTuristica actividad, String img) {
	        this.nombre = salidaNombre;
	        this.fechaSalida = dateSalida;
	        this.fechaAlta= dateAct;
	        this.cantidadMaximaDeTuristas = CmaxT;
	        this.lugarSalida = SlugarSal;
	        this.actividad = actividad;
	        this.plazosDisponibles = cantidadMaximaDeTuristas;
	        this.img = img;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public GregorianCalendar getfechaSalida() {
	        return fechaSalida;
	    }

	    public GregorianCalendar getfechaAlta() {
	        return fechaAlta;
	    }
	    public int getcantidadMaximaDeTuristas() {
	        return cantidadMaximaDeTuristas;
	    }
	    public String getlugarSalida() {
	        return lugarSalida;
	    }
	    
	    public ActividadTuristica getActividad() {
	    	return actividad;
	    }
	    
	    public int getPlazosDisponibles() {
	    	return plazosDisponibles;
	    }
	    
	    public float calcularCosto(int cant) {
			return cant*actividad.getCostoPorTurista();
		}
		
		public void reducirPlazos(int cantidad) {
			plazosDisponibles = plazosDisponibles - cantidad;
		}
		
		public Set<String> getTuristasInscriptos(){
			HandlerUsuarios handUsr = HandlerUsuarios.getInstance();
			Set<String> resultado = new HashSet<String>();
			Set<Turista> turistas = handUsr.listarTuristas();
			turistas.forEach( t-> {
				if (t.inscriptoSalida(this)) {
					resultado.add(t.getNombre());
				}
			});
			return resultado;
		}
		
		public Set<String> getTuristasNicknameInscriptos(){
			HandlerUsuarios handUsr = HandlerUsuarios.getInstance();
			Set<String> resultado = new HashSet<String>();
			Set<Turista> turistas = handUsr.listarTuristas();
			turistas.forEach( t-> {
				if (t.inscriptoSalida(this)) {
					resultado.add(t.getNickname());
				}
			});
			return resultado;
		}
		
		public String getImg() {
		    return img;
		}
		
}
