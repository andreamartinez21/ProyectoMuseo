package ventanas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import BD.BD;
import clases.Obra;

public class VentanaTodasLasObras extends JFrame{
	
	private Container cp;
	private JPanel panel1;
	private JPanel panel2;
	private JScrollPane panelScroll;
	private int numBotones = 20;
	private List<JButton> botones = new ArrayList<JButton>();
	private List<JLabel> titulos = new ArrayList<JLabel>();
	private List<Obra> listaObras;
	private static final Dimension TAMANYO_BOTON = new Dimension(320, 470);
	
	public VentanaTodasLasObras() {
		
		BD bd = new BD();
		
		cp = this.getContentPane();
		this.setTitle("Todas las obras: ");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		listaObras = new ArrayList<Obra>(bd.obras());
		
		panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(800, 6000));
		panel1.setLayout(new GridLayout(0, 2));
		panelScroll = new JScrollPane();
		
		cp.add(panelScroll);
		panelScroll.setViewportView(panel1);
		
		JMenuBar barraMenu = new JMenuBar();
		JMenu menuDatos = new JMenu("Atrás");
		
		barraMenu.add(menuDatos);
		this.setJMenuBar(barraMenu);
		
		for (int i = 0; i < listaObras.size(); i++) {
			
			panel2 = new JPanel();
			panel2.setLayout(new BorderLayout());
			
			JButton b = new JButton(new ImageIcon(listaObras.get(i).getImagen()));
			
			b.setSize(TAMANYO_BOTON);
			panel2.add(b, BorderLayout.CENTER);
			panel2.add(new JLabel(listaObras.get(i).getNombreArticulo()), BorderLayout.PAGE_END);
			panel1.add(panel2);	
		}
		
		this.setVisible(true);
		this.setResizable(true);
//		this.setPreferredSize(new Dimension(900, 600));
		this.setSize(900, 800);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {	
				new VentanaTodasLasObras();
			}
		});
	}
}