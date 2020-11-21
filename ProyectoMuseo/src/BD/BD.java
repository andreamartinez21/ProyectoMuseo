package BD;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import clases.Coordenadas;
import clases.Obra;

public class BD {
	
	Connection conn; // Conexión BD (link)
	private static Logger logger = null;
	
	public BD() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo cargar el driver de BD");
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:baseDatosTotal.db");

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error en la BD");
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
			log(Level.SEVERE, "Ha habido un error.", e);
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
			log(Level.SEVERE, "Ha habido un error.", e);
		}
		
		return obras;
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

