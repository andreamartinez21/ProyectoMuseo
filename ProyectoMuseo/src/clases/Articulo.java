package clases;

public abstract class Articulo {
	
	protected int idArticulo;
	protected String nombreArticulo;
	protected String descripcion;
	
	public Articulo(int idArticulo, String nombreArticulo, String descripcion) {
		this.idArticulo = idArticulo;
		this.nombreArticulo = nombreArticulo;
		this.descripcion = descripcion;
	}
	
	public Articulo() {
		this.idArticulo = 0;
		this.nombreArticulo = "";
		this.descripcion = "";
	}

	public int getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getNombreArticulo() {
		return nombreArticulo;
	}

	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Articulo [idArticulo=" + idArticulo + ", nombreArticulo=" + nombreArticulo + ", descripcion="
				+ descripcion + "]";
	}
}
