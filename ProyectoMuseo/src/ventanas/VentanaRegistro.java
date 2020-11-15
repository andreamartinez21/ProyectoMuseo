package ventanas;

import java.awt.EventQueue;

//nombre
//apellido
//dni
//email
//telefono
//numcuenta
//usuario
//contraseña

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clases.Socio;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class VentanaRegistro {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	public Socio socio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro window = new VentanaRegistro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaRegistro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 284, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(17, 0, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("REGISTARSE");
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellidos:");
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("DNI:");
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("e-mail:");
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Tel\u00E9fono:");
		frame.getContentPane().add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("N\u00FAmero de cuenta:");
		frame.getContentPane().add(lblNewLabel);
		
		textField_5 = new JTextField();
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Contrase\u00F1a:");
		frame.getContentPane().add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceptar");
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nombreSocio = textField.getText();
				String apellido = textField_1.getText();
				String dni = textField_2.getText();
				String email = textField_3.getText();
				String numCuenta = textField_4.getText();
				String contrasenya = textField_5.getText();
				
				textField.setText(nombreSocio);
				textField_1.setText(apellido);
				textField_2.setText(dni);
				textField_3.setText(email);
				textField_4.setText(numCuenta);
				textField_5.setText(contrasenya);
				
				JOptionPane.showMessageDialog(null, "¡El socio ha sido registrado correctamente!");

			}
		});
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_5.setText("");
				textField_6.setText("");
				
				System.exit(0);
			}
		});
		frame.getContentPane().add(btnNewButton_1);
	}

}
