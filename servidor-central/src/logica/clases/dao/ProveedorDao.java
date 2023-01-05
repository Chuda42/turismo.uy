package logica.clases.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



import datatypes.DTActividad;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import logica.clases.Proveedor;

@Entity
@Table(name= "Prov_table")
public class ProveedorDao {
	
	@Id
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="usuarioId")
	private UsuarioDao usuarioId;
	
	private String descripcion;
	
	private String sitioWeb;
	
	//@OneToMany(mappedBy = "id_proveedor")
    //private List<ActividadDao> actividades = new ArrayList<ActividadDao>();
	
	public ProveedorDao() {
		
	}
	
	public ProveedorDao(Proveedor prov) {
		descripcion = prov.getDescripcion();
		sitioWeb = prov.getSitioWeb();
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public void setUsuario(UsuarioDao usr) {
		usuarioId = usr;
	}
	
	public UsuarioDao getUsuario() {
		return usuarioId;
	}
	
}
