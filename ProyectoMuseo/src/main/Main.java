package main;

import java.awt.EventQueue;

import BD.BD;
import ventanas.VentanaLogin;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new VentanaLogin();
					BD.getInstance().creacionTabla(); //en esta instancia CREAMOS las TABLAS (en nuestro caso la tabla SOCIO)
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
