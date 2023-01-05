package datatypes;

import java.util.HashSet;
import java.util.Set;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import logica.clases.Compra;
import logica.clases.Turista;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTTurista extends DTUsuario {
	private String nacionalidad;
	private Set<DTCompra> compras;
	
	public DTTurista() {
	  
	}
	
	public DTTurista(Turista turista) {
		super(turista);
		nacionalidad = turista.getNacionalidad();
		compras = new HashSet<DTCompra>();
		for (Compra compra : turista.getCompras().values()) {
                compras.add(compra.getDT());
        }
        
	}

	public String getNacionalidad() {
		return nacionalidad;
	}
	
	public Set<DTCompra> getCompras() {
        return new HashSet<DTCompra>(compras);
    }
}
