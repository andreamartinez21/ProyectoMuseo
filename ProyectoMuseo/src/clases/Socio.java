package clases;

public class Socio {
	
	protected String dni;
	protected String nombreSocio;
	protected String apellido;
	protected String email;
	protected String usuario;
	protected String contrasenya;
	
	public Socio(String dni, String nombreSocio, String apellido, String email, String usuario, String contrasenya) {
		this.dni = dni;
		this.nombreSocio = nombreSocio;
		this.apellido = apellido;
		this.email = email;
		this.usuario = usuario;
		this.contrasenya = contrasenya;
	}
	
	public Socio() {
		this.dni = "";
		this.nombreSocio = "";
		this.apellido = "";
		this.email = "";
		this.usuario = "";
		this.contrasenya = "";
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
				+ ", usuario=" + usuario + ", contrasenya=" + contrasenya + "]";
	}
}
