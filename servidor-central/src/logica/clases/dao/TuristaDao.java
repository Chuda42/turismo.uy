package logica.clases.dao;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import logica.clases.Turista;

@Entity
@Table(name = "TuristaDao")
public class TuristaDao {

	@Id
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="usuarioId")
	private UsuarioDao usuarioId;
	private String nacionalidad;
	
	public TuristaDao() {
		
	}
	
	public void setUsuario(UsuarioDao usr) {
		usuarioId = usr;
	}
	
	public TuristaDao(Turista tur) {
		nacionalidad = tur.getNacionalidad();
	}
	
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public UsuarioDao getUsuario() {
		return usuarioId;
	}
	
	
	
}
