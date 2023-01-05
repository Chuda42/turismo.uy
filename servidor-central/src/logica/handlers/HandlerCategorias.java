package logica.handlers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import logica.clases.Categoria;

public class HandlerCategorias {
	private Map<String, Categoria> categorias;
	private static HandlerCategorias instancia = null;
	
	private HandlerCategorias() {
		this.categorias = new HashMap<String, Categoria>();
	};
	
	public static HandlerCategorias getInstance() {
		if (HandlerCategorias.instancia == null) {
			HandlerCategorias.instancia = new HandlerCategorias();
		}
		return HandlerCategorias.instancia;
	}
	
	//Pre: no existe una categoria con nombre cat.getNombre
	public void add(Categoria cat) {
		String nombreCategoria = cat.getNombre();
		this.categorias.put(nombreCategoria, cat);
	}
	
	public boolean existeCategoria(String nombreCategoria) {
		return this.categorias.containsKey(nombreCategoria);
	}

	public Set<Categoria> obtenerCategorias() {
		Set<Categoria> resu = new HashSet<Categoria>(this.categorias.values());
		return resu;
	}
	
	public Categoria getCategoria(String categoria) {
		return categorias.get(categoria);
	}
	
	public static void clear() {
		instancia = null;
	}

}
