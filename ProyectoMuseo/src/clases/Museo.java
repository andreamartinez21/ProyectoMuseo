package clases;

import java.util.Arrays;

public class Museo {
	
	protected String idMuseo;
	protected String nombreMuseo;
	protected Articulo[] articulos;
	protected Socio[] socios;
	
	public Museo(String idMuseo, String nombreMuseo, Articulo[] articulos, Socio[] socios) {
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

	public Articulo[] getArticulos() {
		return articulos;
	}

	public void setArticulos(Articulo[] articulos) {
		this.articulos = articulos;
	}

	public Socio[] getSocios() {
		return socios;
	}

	public void setSocios(Socio[] socios) {
		this.socios = socios;
	}

	@Override
	public String toString() {
		return "Museo [idMuseo=" + idMuseo + ", nombreMuseo=" + nombreMuseo + ", articulos="
				+ Arrays.toString(articulos) + ", socios=" + Arrays.toString(socios) + "]";
	}
}
