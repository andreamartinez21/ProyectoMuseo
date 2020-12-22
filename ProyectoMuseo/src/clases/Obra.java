package clases;

public class Obra extends Articulo {
	
	protected String zona;
	protected String artista;
	protected String fecha;
	public String imagen;
	public int x;
	public int y;
	//image
	//x,y
	
	public Obra(int idArticulo, String nombreArticulo, String descripcion, String zona, String artista,
			String fecha, String imagen, int x, int y) {
		super(idArticulo, nombreArticulo, descripcion);
		this.zona = zona;
		this.artista = artista;
		this.fecha = fecha;
		this.imagen = imagen;
		this.x = x;
		this.y = y;
	}
	
	public Obra() {
		super();
		this.zona = "";
		this.artista = "";
		this.fecha = "";
		this.imagen = "";
		this.x = 0;
		this.y = 0;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Obra [zona=" + zona + ", artista=" + artista + ", fecha=" + fecha + ", imagen=" + imagen + ", x=" + x
				+ ", y=" + y + ", idArticulo=" + idArticulo + ", nombreArticulo=" + nombreArticulo + ", descripcion="
				+ descripcion + "]";
	}
}
