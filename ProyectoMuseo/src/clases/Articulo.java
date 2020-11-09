package clases;

public abstract class Articulo {
	
	protected String idArticulo;
	protected String nombreArticulo;
	protected String descripcion;
	
	public Articulo(String idArticulo, String nombreArticulo, String descripcion) {
		this.idArticulo = idArticulo;
		this.nombreArticulo = nombreArticulo;
		this.descripcion = descripcion;
	}
	
	public Articulo() {
		this.idArticulo = "";
		this.nombreArticulo = "";
		this.descripcion = "";
	}

	public String getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(String idArticulo) {
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
