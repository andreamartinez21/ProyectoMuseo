package BD;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import clases.Coordenadas;
import clases.Obra;
import clases.Socio;

public class BD {
	
	
	private static Logger logger = null; //inicializar logger
	
	private static Statement stm; //Crear sentencias sql
	private static Connection conn = null; // Conexión BD (link)
	private static ResultSet rs; //coger info de las sentencias -->para coger muchas cosas
	private static BD instance = null; //para instanciar la BD
	
	public static BD getInstance() { //Esta es la llamada a la base de datos --> para que NO SE HAGA MAS DE UNAINSTANCIA A LA BD
	//	(q se conecte 1 ÚNICA vez)
		if (instance == null) {
			instance = new BD(); //con el constructor generamos una nueva instancia de la BD
			instance.conectar(); //con el método conectar hacemos la conexión (!!!)
			
		}
		return instance;	
	}
	
	
	public void creacionTabla() {	
		try {
			stm = conn.createStatement(); //cogemos la conexión q se ha realizado a nuestra bd y la metemos en stm y después ya podemos hacer cosas
			stm.executeUpdate("CREATE TABLE IF NOT EXISTS SOCIO (DNI VARCHAR(9) PRIMARY KEY NOT NULL, NOMBRE_SOCIO VARCHAR(20), "
					+ "APELLIDOS_SOCIO VARCHAR(30), EMAIL_SOCIO VARCHAR(25), TELEFONO VARCHAR(12), NUMCUENTA_SOCIO VARCHAR(30), CONTRASENYA_SOCIO VARCHAR(15));");

			//LLAMADA A LOGGER
			log(Level.INFO, "La tabla se ha creado correctamente.", null); //saca información
		} catch (SQLException e) { //ESTO CREA LA CONEXIÓN
			// TODO Auto-generated catch block
			System.out.println("No se pudo cargar el driver de BD");

			//logger --> por si falla
			log(Level.SEVERE, "Ha habido un error en la CREACIÓN de la tabla.", e);
		}
	}
	
	public void conectar() {
		
		try {
			//crear conexión a la bd estas 2 lineas
			Class.forName("org.sqlite.JDBC");

			conn = DriverManager.getConnection("jdbc:sqlite:baseDatosTotal.db"); //nombre de la bd a la q nos queremos conectar
			
			//LLAMADA A LOGGER
			log(Level.INFO, "La conexión se ha realizado correctamente.", null); //saca información
		} catch (ClassNotFoundException | SQLException e) { //ESTO CREA LA CONEXIÓN
			// TODO Auto-generated catch block
			System.out.println("No se pudo cargar el driver de BD");
			
			//logger --> por si falla
			log(Level.SEVERE, "Ha habido un error en la CONEXIÓN DE LA BD.", e);
		}
		
	}
	
	public Coordenadas[] coords() { 	// Hago un método que me defvuelve un array de coords para pasarselo a VM lleno, si no, está null
		
		Coordenadas[] coordenadas = new Coordenadas[20];
		Statement stmt;		// Preparar una query que le pasaré a la BD
		ResultSet rs;		// Resultado que me devuelve la BD
		
		try {										// Envolver siempre en try/catch
			stmt = conn.createStatement();	
			rs = stmt.executeQuery("SELECT * FROM tablacoordenadas");	
			
			int i = 0;
			
			while(rs.next()) {												// El while es como un for
				// If array[i] == null, initialize the variable	

				coordenadas[i] = new Coordenadas(rs.getInt("x"), rs.getInt("y"));
				i++;
			}	
			//LLAMADA A LOGGER
			log(Level.INFO, "Las coordenadas se han seleccionado correctamente.", null); //saca información
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			//logger --> por si falla
			log(Level.SEVERE, "Ha habido un error al seleccionar las COORDENADAS.", e);
		}				
		return coordenadas;	// El método me devuelve el array de coords
	}
	
	public Obra[] obras() {
		
		Obra[] obras = new Obra[20];
		Statement stmt;
		ResultSet rs;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM obras");
			
			int i = 0;
			
			while(rs.next()) {
				
				obras[i] = new Obra(rs.getInt("id_articulo"), rs.getString("nom_articulo"), rs.getString("descripcion"),
					rs.getString("zona"), rs.getString("artista"), rs.getString("fecha"));
			
				i++;
			}
			//LLAMADA A LOGGER
			log(Level.INFO, "Las obras se han seleccionado correctamente.", null); //saca información
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
			//logger --> por si falla
			log(Level.SEVERE, "Ha habido un error a la hora de seleccionar las OBRAS.", e);
		}
		
		return obras;
	}
	
	public boolean insertarSocio(Socio socio) {//hemos creado un método donde metamos todos los datos de lso SOCIOS (+logger porsiaca)

		try {
			stm = conn.createStatement(); //Estas son las variables locales
			
			String consulta = "INSERT INTO SOCIO (DNI, NOMBRE_SOCIO , APELLIDOS_SOCIO, EMAIL_SOCIO, TELEFONO, NUMCUENTA_SOCIO, CONTRASENYA_SOCIO)";
			
			consulta = consulta + " VALUES (?, ?, ?, ?, ?, ?, ?);"; //sentencia sql que leerá el stm
			
			PreparedStatement ps = conn.prepareStatement(consulta);
			ps.setString(1, socio.getDni());
			ps.setString(2, socio.getNombreSocio());
			ps.setString(3, socio.getApellidos());
			ps.setString(4, socio.getEmail());
			ps.setString(5, socio.getTelefono());
			ps.setString(6, socio.getNumCuenta());
			ps.setString(7, socio.getContrasenya());
			
			ps.setQueryTimeout(30); //esperará 30 milisegundos
			ps.executeUpdate();
			
			ps.close(); //NO OLVIDAR CERRAR STM
			
			//LLAMADA A LOGGER
			log(Level.INFO, "Los datos de socio han sido guardados correctamente.", null);
			
			return true; //En  de q todo haya ido BIEN --> RETURN TRUE
		} catch (Exception e) {
			//logger --> por si falla
			log(Level.SEVERE, "Ha habido un error al insertar los datos en SOCIO.", e);
			
			return false; //En caso de q haya fallado --> RETURN FALSE
		}
		
	} 
	
	
	//COMPROBAR LOGIN
	public boolean comprobarLogin(String email, String contrasenya) { //Creamos un método para comprobar q SÍ EXISTE este socio con este mail y contrasenya
	//LAS BD SE EMPIEZAN SIEMPRE CON TRYCATCH
		try {
			//preparamos una sentencia donde la bd selecciona la FILA q tenga AMBOS VALORES q le hemos pasado por parámetro
			String consulta = "SELECT * FROM SOCIO WHERE EMAIL_SOCIO=? AND CONTRASENYA_SOCIO=?;";
			
			PreparedStatement ps = conn.prepareStatement(consulta);
			ps.setString(1, email);
			ps.setString(2, contrasenya);
			
			//en caso de q SÍ EXISTA:
			//todo chachi seguimo palante ;)

			ps.close();

			//LLAMADA A LOGGER
			log(Level.INFO, "El login se ha realizado correctamente.", null);

			JOptionPane.showMessageDialog(null, "¡Este usuario no está registrado!");
			return true;
			
		} catch (Exception e) {
			//logger --> por si falla
			log(Level.SEVERE, "Ha habido un error al hacer el login.", e);
			
			return false; //si no funciona pues devuelve false xd
		}
		
		
	}
	//---------------------------------------------------------------
	//COMPROBAR REGISTRO
	public Socio comprobarRegistro(Socio socio) { //Creamos un método para comprobar q no existe un socio ya
	//LAS BD SE EMPIEZAN SIEMPRE CON TRYCATCH
		try {
		
			Socio socioBD = null;
			
			//preparamos una sentencia donde la bd selecciona la FILA q tenga AMBOS VALORES q le hemos pasado por parámetro
			String consulta = "SELECT * FROM SOCIO WHERE EMAIL_SOCIO=? AND CONTRASENYA_SOCIO=?;";
			
			PreparedStatement ps = conn.prepareStatement(consulta);
			ps.setString(1, socio.getEmail());
			ps.setString(2, socio.getContrasenya());
			
			//en caso de q SÍ EXISTA:
			rs = ps.executeQuery();
			
			while(rs.next()) { //rs.next() es para seleccionar columnas
				
				//CREAREMOS UN NUEVO SOCIO
				//para savber a q columna nos referimos usaremos getString (ya q todos son string) e INDICAMOS EL NOMBRE USADO EN LA BASE DE DATOS
				socioBD = new Socio(rs.getString("NOMBRE_SOCIO"), rs.getString("APELLIDOS_SOCIO"), rs.getString("DNI"), rs.getString("EMAIL_SOCIO"), 
						rs.getString("TELEFONO"), rs.getString("NUMCUENTA_SOCIO"), rs.getString("CONTRASENYA_SOCIO"));
			}
			rs.close(); //NO OLVIDAR!!!!!!!!
			ps.close();
			
			//LLAMADA A LOGGER
			log(Level.INFO, "El socio se ha creado correctamente.", null);
			
			return socioBD;
			
		} catch (Exception e) {
			//logger --> por si falla
			log(Level.SEVERE, "Ha habido un error al crear el SOCIO.", e);
			
			return null; //si no funciona pues no devuelve nada xd
		}
		
		
	}
	
	
	//LOGGER
	public static void log(Level level, String msg, Throwable exception) {
		
		if(logger == null) {
			logger = Logger.getLogger(BD.class.getName());
			logger.setLevel(Level.ALL);
		}
		if(exception == null) logger.log(level, msg);
		else logger.log(level,msg,exception);
	}
}

