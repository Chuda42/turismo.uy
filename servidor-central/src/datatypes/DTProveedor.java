package datatypes;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import logica.clases.Proveedor;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTProveedor extends DTUsuario {
	private String descripcion;
	private String sitioWeb;
	
	public DTProveedor() {
	  
	}
	
	public DTProveedor(Proveedor prov){
		super(prov);
		descripcion = prov.getDescripcion();
		sitioWeb = prov.getSitioWeb();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getLinkSitioWeb() {
		return sitioWeb;
	}
}
