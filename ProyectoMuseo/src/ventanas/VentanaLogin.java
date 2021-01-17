package ventanas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import clases.Usuario;
import BD.BD;

public class VentanaLogin extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel;
	JLabel labelEmail,labelPassword;
	JTextField textoEmail,textoPassword;
	JButton boton;
	
	public VentanaLogin(Usuario usuario) {
		new BD();
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(5,1)); //5 filas 1 columna
		
		labelEmail = new JLabel("Introduzca su email para acceder:");
		textoEmail = new JTextField();
		
		labelPassword = new JLabel("Introduzca su contraseña para acceder:");
		textoPassword = new JTextField();
		
		boton = new JButton("Aceptar");
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(BD.comprobarLogin(textoEmail.getText(), textoPassword.getText())) {
					try {
						new VentanaMapa();
						new VentanaContador();
						dispose();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			}
		});
		
		
		this.add(panel);
		
		panel.add(labelEmail);
		panel.add(textoEmail);
		panel.add(labelPassword);
		panel.add(textoPassword);
		panel.add(boton);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Login");
		pack();
		setSize(350,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new VentanaLogin(null);
		
	}

}
