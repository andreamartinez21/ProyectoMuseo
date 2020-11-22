package ventanas;


import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import BD.BD;

public class VentanaLogin extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField textField;
	private JTextField textField_1; 


	/**
	 * Create the application.
	 */
	public VentanaLogin() {
		initialize(); 
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 236, 368);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(7, 0, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("e-mail:");
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a:");
		getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Continuar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//cada vez que usemos algo de la clase BD TENEMOS QUE PIRMERO PONER BD.GETINSTANE() 
				//(pq es lo que hace que creemos la base de datos UNA ÚNICA VEZ!!!!!!!!)
				//base de datos --> llamar 1 vez (instancia) --> metodo de comprobar el login para entrar :D
				BD.getInstance().comprobarLogin(textField.getText(), textField_1.getText());
				
			}
		});
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Registrarse");
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new VentanaRegistro();
				
				dispose();
			}
		});
		
	}

}
