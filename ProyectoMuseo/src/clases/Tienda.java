package clases;

public class Tienda extends Articulo implements Venta {
	
	protected float precio;
	protected boolean descuento;

	public Tienda(String idArticulo, String nombreArticulo, String descripcion, float precio, boolean descuento) {
		super(idArticulo, nombreArticulo, descripcion);
		this.precio = precio;
		this.descuento = descuento;
	}
	
	public Tienda() {
		super();
		this.precio = 0;
		this.descuento = false;
	}
	
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public boolean isDescuento() {
		return descuento;
	}

	public void setDescuento(boolean descuento) {
		this.descuento = descuento;
	}
	
	@Override
	public String toString() {
		return "Tienda [precio=" + precio + ", descuento=" + descuento + ", idArticulo=" + idArticulo
				+ ", nombreArticulo=" + nombreArticulo + ", descripcion=" + descripcion + "]";
	}

	@Override
	public void vender() {
		// TODO Auto-generated method stub
		
	}
}
