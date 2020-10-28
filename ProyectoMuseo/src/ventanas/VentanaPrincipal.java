package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

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
		panel.setLayout(new GridLayout(8, 0, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("PR\u00D3XIMOS EVENTOS:");
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Vida y obra de Basquiat (11 sept - 25 enero)");
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Kandinsky obras (29 sept - 22 abril)");
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Charla: arte y feminismo (27 oct, 17:00h)");
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Actividad infantil: el arte y el espacio (31 oct, 18:00h)");
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Dali y el surrealismo (12 dic - 30 jun)");
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Taller: Cer\u00E1mica (65+) (11 dic, 14:00h)");
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel = new JLabel("Expresionismo alem\u00E1n (9 enero - 30 jul)");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		//IMAGEN DE PRUEBA!!!!!!!!!!
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Asus\\eclipse-workspace\\proyecto\\src\\imagenes\\Museo-AGS-1000x570.jpg"));
		panel_1.add(lblNewLabel_8);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("COMMUNITY");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Login");
		mnNewMenu.add(mntmNewMenuItem);
		
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
