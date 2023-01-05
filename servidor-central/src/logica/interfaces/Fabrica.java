package logica.interfaces;
import logica.controladores.CtrlActividad;
import logica.controladores.CtrlUsuario;

public class Fabrica {
	private static Fabrica instancia = null;

	  public static Fabrica getInstance() {
	    if (instancia == null) {
	      instancia = new Fabrica();
	    }
	    return instancia;
	  }

	  public ICtrlActividad getICtrlActividad() {
	    return new CtrlActividad();
	  }

	  public  ICtrlUsuario getICtrlUsuario() {
	    return new CtrlUsuario();
	  }

	  

	  private Fabrica() {
	  }
}
