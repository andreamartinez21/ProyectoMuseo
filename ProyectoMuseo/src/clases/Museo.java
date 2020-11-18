package clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Museo {
	
	// Ask
	
	protected String idMuseo;
	protected String nombreMuseo;
	protected List<Articulo> articulos = new ArrayList<Articulo>();
	protected List<Socio> socios = new ArrayList<Socio>();
	
	public Museo(String idMuseo, String nombreMuseo, List<Articulo> articulos, List<Socio> socios) {
		super();
		this.idMuseo = idMuseo;
		this.nombreMuseo = nombreMuseo;
		this.articulos = articulos;
		this.socios = socios;
	}
	
	public Museo() {
		this.idMuseo = "";
		this.nombreMuseo = "";
		this.articulos = null;
		this.socios = null;
	}

	public String getIdMuseo() {
		return idMuseo;
	}

	public void setIdMuseo(String idMuseo) {
		this.idMuseo = idMuseo;
	}

	public String getNombreMuseo() {
		return nombreMuseo;
	}

	public void setNombreMuseo(String nombreMuseo) {
		this.nombreMuseo = nombreMuseo;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	public List<Socio> getSocios() {
		return socios;
	}

	public void setSocios(List<Socio> socios) {
		this.socios = socios;
	}

	@Override
	public String toString() {
		return "Museo" + idMuseo + ", nombre " + nombreMuseo + ", artículos " + articulos + ", socios " + socios + "." ;
	}
}
