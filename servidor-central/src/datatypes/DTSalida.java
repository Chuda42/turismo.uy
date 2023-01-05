package datatypes;

import java.util.GregorianCalendar;
import java.util.Set;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

//import logica.clases.SalidaTuristica;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTSalida {
	private String nombre;
	private String nombreActividad;
	private String nombreDepartamentoActividad;
	private String imgDir;
	private GregorianCalendar fechaSalida;
	private GregorianCalendar fechaAlta;
	private int maxTuristas;
	private String lugarSalida;
	private Set<String> turistasInscriptos;
	
	 public DTSalida() {
		this.setNombre(new String());
		this.setfechaSalida(new GregorianCalendar());
	    this.setfechaAlta(new GregorianCalendar());
	    this.setmaxTuristas(0);
	    this.setlugarSalida(new String());
	    this.setTuristas(null);
	        
	        
	    }

	 public DTSalida(String nomSalida, GregorianCalendar fechaSal, GregorianCalendar fechaAlta, int CmaxT, String SlugarSal, Set<String> SSturistas, String img) {
	        this.nombre = nomSalida;
	        this.fechaSalida = fechaSal;
	        this.fechaAlta= fechaAlta;
	        this.maxTuristas = CmaxT;
	        this.lugarSalida = SlugarSal;
	        this.turistasInscriptos = SSturistas;
	        this.imgDir = "imagen?sal=" + img;
	    }
	 
	 public DTSalida(String nomSalida, String actividad, String deptoAct, GregorianCalendar fechaSal, GregorianCalendar fechaAlt, int CmaxT, String SlugarSal, Set<String> SSturistas, String img) {
	        this.nombre = nomSalida;
	        this.nombreActividad = actividad;
	        this.nombreDepartamentoActividad = deptoAct;
	        this.imgDir = "imagen?sal=" + img;
	        this.fechaSalida = fechaSal;
	        this.fechaAlta= fechaAlt;
	        this.maxTuristas = CmaxT;
	        this.lugarSalida = SlugarSal;
	        this.turistasInscriptos = SSturistas;
	    }
	 
   ////////////////////////SETTERS////////////////////////////////////////////////
    public void setNombre(String nomSalida) {
        nombre = nomSalida;
    }

    public void setfechaSalida(GregorianCalendar Dsalida ) {
        fechaSalida = Dsalida;
    }
    public void setfechaAlta(GregorianCalendar Dalta ) {
        fechaAlta = Dalta;
    }
    public void setmaxTuristas(int ImaxT ) {
        maxTuristas = ImaxT;
    }
    public void setlugarSalida(String SLugarSal) {
        lugarSalida = SLugarSal;
    }
    
    public void setTuristas(Set<String> SSTuristas) {
        turistasInscriptos = SSTuristas;
    }
    
    //////////////////////GETTERS/////////////////////////////////////////////////
    public String getNombre() {
        return nombre;
    }

	public String getNombreActividad() {
		return nombreActividad;
	}

	public String getNombreDepartamentoActividad() {
		return nombreDepartamentoActividad;
	}
    
	public String getImgDir() {
		return imgDir;
	}
	
    public GregorianCalendar getfechaSalida() {
        return fechaSalida;
    }

    public GregorianCalendar getfechaAlta() {
        return fechaAlta;
    }
    public int getcantidadMaximaDeTuristas() {
        return maxTuristas;
    }
    public String getlugarSalida() {
        return lugarSalida;
    }

	public Set<String> getTuristasInscriptos() {
		return turistasInscriptos;
	}
	
	public String toString() {
		return nombre + " - " + lugarSalida;
	}


    
////////////////////////////////////////////////////////////////////////////
    /* Sirve para mostrar textualmente la información del usuario, por ejemplo en un ComboBox
     */
   // String toString() {
       // return getCedulaIdentidad() + " (" + getNombre() + " " + getApellido() + ")";
    //}

}
