package ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import BD.BD;
import clases.Usuario;

public class VentanaRegistro extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;

	private JLabel emailLabel;
	private JLabel passwordLabel;
	
	private JTextField emailTexto;
	private JTextField passwordTexto;
	
	private JButton boton;
	
	
	public VentanaRegistro() {
		new BD();
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(5,1));
		
	
		emailLabel = new JLabel("Introduzca nuevo e-mail");
		emailTexto = new JTextField();
		
		passwordLabel = new JLabel("Introduzca nueva contraseña");
		passwordTexto = new JTextField();
		
		boton = new JButton("Aceptar");
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)  {
				String email = emailTexto.getText();
				String password = passwordTexto.getText(); 
				
				Usuario usuario = new Usuario(email, password);
				
				if(BD.existeUsuario(usuario) == false) {
					BD.insertarUsuario(usuario);
					
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
		
		getContentPane().add(panel);
		pack();
		
		panel.add(emailLabel);
		panel.add(emailTexto);
		panel.add(passwordLabel);
		panel.add(passwordTexto);
		panel.add(boton);
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Registro");
		setSize(250, 350);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new VentanaRegistro();
	}
	
		
}
