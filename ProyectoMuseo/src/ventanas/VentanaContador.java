package ventanas;

import javax.swing.*;

import clases.TimerSesion;

public class VentanaContador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public VentanaContador() {
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Contador");
		setSize(100, 75);
		setVisible(true);
		
		iniciarComponentes();
	}
	
	public void iniciarComponentes() {
		JPanel panelTimer = new JPanel();
		getContentPane().add(panelTimer);
		
		JLabel labelTimer = new JLabel("00:00:00");
		
		panelTimer.add(labelTimer);
		TimerSesion timer = new TimerSesion(labelTimer);
		timer.iniciarCronometro();
	}

}
