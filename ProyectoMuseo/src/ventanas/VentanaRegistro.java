package ventanas;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clases.Socio;
import BD.BD;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaRegistro extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	public Socio socio;


	/**
	 * Create the application.
	 */
	public VentanaRegistro() {
		initialize();
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 284, 458);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(17, 0, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("REGISTARSE");
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellidos:");
		getContentPane().add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("DNI:");
		getContentPane().add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("e-mail:");
		getContentPane().add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Tel\u00E9fono:");
		getContentPane().add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("N\u00FAmero de cuenta:");
		getContentPane().add(lblNewLabel);
		
		textField_5 = new JTextField();
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Contrase\u00F1a:");
		getContentPane().add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceptar");
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String nombreSocio = textField.getText();
				String apellido = textField_1.getText();
				String dni = textField_2.getText();
				String email = textField_3.getText();
				String telefono = textField_4.getText();
				String numCuenta = textField_5.getText();
				String contrasenya = textField_6.getText();
				
				
				Socio socio = new Socio(nombreSocio, apellido, dni, email, telefono, numCuenta, contrasenya);
				
//				if (BD.getInstance().comprobarRegistro(socio)==null) { //para comprobar si los datos no están vacíos
//					
//					//insertamos el nuevo socio en la bd
//					BD.getInstance().insertarSocio(socio);
//					JOptionPane.showMessageDialog(null, "¡El socio ha sido registrado correctamente!");
//				} else {
//					JOptionPane.showMessageDialog(null, "¡Este socio ya existe!");				
//					
//				}
				
				
				

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
				
				setVisible(false);
				new VentanaLogin();
				
			}
		});
		getContentPane().add(btnNewButton_1);
	}

}
