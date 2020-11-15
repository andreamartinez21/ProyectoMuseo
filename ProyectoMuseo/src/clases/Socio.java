package clases;

public class Socio {
	
	protected String nombreSocio;
	protected String apellidos;
	protected String dni;
	protected String email;
	protected String telefono;
	protected String numCuenta;
	protected String contrasenya;
	
	public Socio(String nombreSocio, String apellidos, String dni, String email, String telefono, String numCuenta, String contrasenya) {
		this.nombreSocio = nombreSocio;
		this.apellidos = apellidos;
		this.dni = dni;
		this.email = email;
		this.telefono = telefono;
		this.numCuenta = numCuenta;
		this.contrasenya = contrasenya;
	}
	
	public Socio() {
		this.nombreSocio = "";
		this.apellidos = "";
		this.dni = "";
		this.email = "";
		this.telefono = "";
		this.numCuenta = "";
		this.contrasenya = "";
	}

	public String getNombreSocio() {
		return nombreSocio;
	}

	public void setNombreSocio(String nombreSocio) {
		this.nombreSocio = nombreSocio;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	@Override
	public String toString() {
		return "Socio [nombreSocio=" + nombreSocio + ", apellidos=" + apellidos + ", dni=" + dni + ", email=" + email
				+ ", telefono=" + telefono + ", numCuenta=" + numCuenta + ", contrasenya=" + contrasenya + "]";
	}
}
