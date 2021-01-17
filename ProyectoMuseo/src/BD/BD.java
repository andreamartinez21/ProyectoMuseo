package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import clases.Obra;
import clases.Usuario;

public class BD {
	
	private static Logger logger = null; //inicializar logger

	static Connection conn; // Conexión BD (link)

	public BD() {
		try {
			Class.forName("org.sqlite.JDBC");
			
			//LLAMADA A LOGGER
			log(Level.INFO, "El driver se ha cargado correctamente.", null); //saca información
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo cargar el driver de BD");
			
			//logger --> por si falla
			log(Level.SEVERE, "Ha habido un error en la CREACIÓN de la tabla.", e);
		}

		try {
			conn = DriverManager.getConnection("jdbc:sqlite:baseDatosTotal.db");

			//LLAMADA A LOGGER
			log(Level.INFO, "La conexión se ha realizado correctamente.", null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error en la BD");
			
			//logger
			log(Level.SEVERE, "Ha habido un error en la CREACIÓN de la tabla.", e);
		}
	}
	
	public List<Obra> obras() {

		List<Obra> obras = new ArrayList<Obra>();
		Statement stmt;
		ResultSet rs;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM obras");

			while(rs.next()) {

				obras.add(new Obra(rs.getInt("id_articulo"), rs.getString("nom_articulo"), rs.getString("descripcion"),
						rs.getString("zona"), rs.getString("artista"), rs.getString("fecha"), rs.getString("imagen"), rs.getInt("x"),
						rs.getInt("y")));
			}
			//LLAMADA A LOGGER
			log(Level.INFO, "Las obras se han añadido correctamente.", null);	
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
			//logger
			log(Level.SEVERE, "No se han podido añadir las obras.", e);
		}
		
		return obras;
	}
	public List<Usuario> usuarios() {

		List<Usuario> usuarios = new ArrayList<Usuario>();
		Statement stmt;
		ResultSet rs;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM usuarios");

			while(rs.next()) {

				usuarios.add(new Usuario(rs.getString("email"), rs.getString("password")));
			}
			//LLAMADA A LOGGER
			log(Level.INFO, "Los usuarios se han añadido correctamente.", null);	
			
		} catch (SQLException e) {
			// TODO: handle exception 
			e.printStackTrace();
			
			//logger
			log(Level.SEVERE, "No se han podido añadir los usuarios.", e);
		}
		
		return usuarios;
	}
	
	public static boolean existeUsuario(Usuario usuario) {
		try {
			ResultSet rs;
			 
			//preparamos una sentencia donde la bd selecciona la FILA q tenga AMBOS VALORES q le hemos pasado por parámetro
			String consulta = "SELECT * FROM usuarios WHERE email=? AND password=?;";
			
			PreparedStatement ps = conn.prepareStatement(consulta);
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getPassword());
			
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("email").equals(usuario.getEmail()) && rs.getString("password").equals(usuario.getPassword())) {
					JOptionPane.showMessageDialog(null, "¡Ya existe este usuario! ", "Error", JOptionPane.ERROR_MESSAGE);
					return true;
				}	
			}
			
			ps.close();
			return false;
			
			
		} catch (Exception e) {
			//logger
			log(Level.SEVERE, "No se ha podido comprobar si existe el usuario.", e);
			return false; //si no funciona pues devuelve false
		}	
	}
	
    public static void insertarUsuario(Usuario usuario) {
    	try {
    		
    		Statement stmt = conn.createStatement(); //Estas son las variables locales
           
            String consulta = "INSERT INTO usuarios (email, password)";
			
			consulta = consulta + " VALUES (?, ?);"; //sentencia sql que leerá el stm
			
			PreparedStatement ps = conn.prepareStatement(consulta);
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getPassword());
			
			ps.setQueryTimeout(30); //esperará 30 milisegundos
			ps.executeUpdate();
			
            stmt.close();
            
          //LLAMADA A LOGGER
			log(Level.INFO, "Los datos se han introducido CORRECTAMENTE.", null);	
        } catch (SQLException e) {
            e.printStackTrace();
        	//logger
			log(Level.SEVERE, "No se han podido insertar los datos en la tabla usuarios.", e);
        }
    }
    
    //MÉTODO para comprobar login --> miramos si COINDIDE el mail && password
	public static boolean comprobarLogin(String email, String password) {
	
		//LAS BD SE EMPIEZAN SIEMPRE CON TRYCATCH
		try {
			ResultSet rs;
			
			//preparamos una sentencia donde la bd selecciona la FILA q tenga AMBOS VALORES q le hemos pasado por parámetro
			String consulta = "SELECT * FROM usuarios WHERE email=? AND password=?;";
			
			PreparedStatement ps = conn.prepareStatement(consulta);
			ps.setString(1, email);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("email").equals(email) && rs.getString("password").equals(password)) {
					
					//LLAMADA A LOGGER
					log(Level.INFO, "El login se ha realizado correctamente.", null);
					
					return true;
				}	
			}
			JOptionPane.showMessageDialog(null, "¡Contraseña o email incorrectos!", "Error", JOptionPane.ERROR_MESSAGE);
			
			ps.close();
			return false;
			
			
		} catch (Exception e) {
			//logger --> por si falla
			log(Level.SEVERE, "Ha habido un error al hacer el login.", e);
			
			return false; //si no funciona pues devuelve false xd
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