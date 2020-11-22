package ventanas;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class VentanaTodasLasObras extends JFrame{
	
	private Container cp;
	private JPanel panel1;
	private JScrollPane panelScroll;
	private int numBotones = 19;
	private List<JButton> botones = new ArrayList<JButton>();
	private List<JLabel> titulos = new ArrayList<JLabel>();
	//private List<JPanel> paneles = new ArrayList<JPanel>();
	
	public VentanaTodasLasObras() {
		
		cp = this.getContentPane();
		this.setPreferredSize(new Dimension(1200, 600));
		this.setTitle("Todas las obras: ");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(1500, 600));
		panel1.setLayout(new GridLayout(0, 2));
		panelScroll = new JScrollPane();
		
		cp.add(panelScroll);
		panelScroll.setViewportView(panel1);
		
		JMenuBar barraMenu = new JMenuBar();
		JMenu menuDatos = new JMenu("Atrás");
		
		barraMenu.add(menuDatos);
		this.setJMenuBar(barraMenu);
		
		for (int i = 0; i < numBotones; i++) { // recorrer el array de obras
			botones.add(new JButton());
			//paneles.add(new JPanel());
			botones.get(i).setSize(new Dimension(60,60));
			//paneles.get(i).add(botones.get(i));
			panel1.add(botones.get(i));
			i++;
			botones.add(new JButton());
			//paneles.add(new JPanel());
			botones.get(i).setSize(new Dimension(60,60));
			//paneles.get(i).add(botones.get(i));
			panel1.add(botones.get(i));
			i--;
			titulos.add(new JLabel("kfjsldkf"));
			//titulos.get(i).setSize(new Dimension(60,60));
			panel1.add(titulos.get(i));
			i++;
			titulos.add(new JLabel("kjjsdhfkjsd"));
			//titulos.get(i).setSize(new Dimension(60,60));
			panel1.add(titulos.get(i));
		}
		
		if(numBotones % 2 != 0) {
			botones.get(botones.size()-1).setVisible(false);
			titulos.get(titulos.size()-1).setVisible(false);
		}
		
		this.pack();
		this.setVisible(true);
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