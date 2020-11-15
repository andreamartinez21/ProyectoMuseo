package clases;

public class Socio {
	
	protected String nombreSocio;
	protected String apellido;
	protected String dni;
	protected String email;
	protected String numCuenta;
	protected String contrasenya;
	
	public Socio(String nombreSocio, String apellido, String dni, String email, String numCuenta, String contrasenya) {
		this.nombreSocio = nombreSocio;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.numCuenta = numCuenta;
		this.contrasenya = contrasenya;
	}
	
	public Socio() {
		this.nombreSocio = "";
		this.apellido = "";
		this.dni = "";
		this.email = "";
		this.numCuenta = "";
		this.contrasenya = "";
	}

	public String getNombreSocio() {
		return nombreSocio;
	}

	public void setNombreSocio(String nombreSocio) {
		this.nombreSocio = nombreSocio;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public String getNumCuenta() {
		return numCuenta;
	}
	
	public void setNumCuenta() {
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
		return "Socio [dni=" + dni + ", nombreSocio=" + nombreSocio + ", apellido=" + apellido + ", email=" + email
				+  ", contrasenya=" + contrasenya + "]";
	}
}
