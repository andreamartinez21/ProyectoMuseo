   package ventanas;

import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;



public class VentanaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		DefaultListModel listModel = new DefaultListModel();
		listModel.addElement("frase");
		listModel.addElement("frase");
		listModel.addElement("frase");
		
		JList list = new JList(listModel);
		JScrollPane scrollPane = new JScrollPane(list);
		
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		//IMAGEN DE PRUEBA!!!!!!!!!!
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("fondos/images/nombre"));
		panel_1.add(lblNewLabel_8);
		ImagePanel imgBg = new ImagePanel("");
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("COMMUNITY");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Login");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		        new VentanaLogin();    
		    	
		    	System.exit(0);
		    }
		});
		
		JMenu mnNewMenu_1 = new JMenu("Tienda");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Exposiciones");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Mapa");
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Temporal");
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Permanente");
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_3 = new JMenu("Actividades");
		menuBar.add(mnNewMenu_3);
		
		
	}

}
