package clases;

import java.util.ArrayList;
import java.util.Arrays;

public class Museo {
	
	protected String idMuseo;
	protected String nombreMuseo;
	protected ArrayList<Articulo> articulos = new ArrayList<Articulo>();
	protected ArrayList<Socio> socios = new ArrayList<Socio>();
	
	public Museo(String idMuseo, String nombreMuseo, ArrayList<Articulo> articulos, ArrayList<Socio> socios) {
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

	public ArrayList<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(ArrayList<Articulo> articulos) {
		this.articulos = articulos;
	}

	public ArrayList<Socio> getSocios() {
		return socios;
	}

	public void setSocios(ArrayList<Socio> socios) {
		this.socios = socios;
	}

	@Override
	public String toString() {
		return "Museo" + idMuseo + ", nombre " + nombreMuseo + ", artículos " + articulos + ", socios " + socios + "." ;
	}
}
