package BD;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import clases.Coordenadas;

public class BD {
	
	Connection conn; // Conexión BD (link)
	
	public BD() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo cargar el driver de BD");
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:coordenadas.db");

			
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		return coordenadas;	// El método me devuelve el array de coords
	}
}

