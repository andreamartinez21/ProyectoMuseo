package BD;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import clases.Obra;

public class BD {
	
	private static Logger logger = null; //inicializar logger

	Connection conn; // Conexión BD (link)

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