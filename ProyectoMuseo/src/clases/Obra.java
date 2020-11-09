package clases;

public class Obra extends Articulo {
	
	protected String zona;
	protected String artista;
	protected String fecha;
	
	public Obra(String idArticulo, String nombreArticulo, String descripcion, String zona, String artista,
			String fecha) {
		super(idArticulo, nombreArticulo, descripcion);
		this.zona = zona;
		this.artista = artista;
		this.fecha = fecha;
	}
	
	public Obra() {
		super();
		this.zona = "";
		this.artista = "";
		this.fecha = "";
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Obra [zona=" + zona + ", artista=" + artista + ", fecha=" + fecha + ", idArticulo=" + idArticulo
				+ ", nombreArticulo=" + nombreArticulo + ", descripcion=" + descripcion + "]";
	}
}
