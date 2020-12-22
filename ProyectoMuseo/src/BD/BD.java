package BD;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clases.Obra;

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
			conn = DriverManager.getConnection("jdbc:sqlite:baseDatosTotal.db");


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error en la BD");
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
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return obras;
	}
}
