package ventanas;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class VentanaTodasLasObras extends JFrame{
	
	private int numBotones = 19;
	private List<JButton> botones = new ArrayList<JButton>();
	private List<JLabel> titulos = new ArrayList<JLabel>();
	
	public VentanaTodasLasObras() {
		
		Container cp = this.getContentPane();
		cp.setLayout(new GridLayout(20, 2));
		
		this.setTitle("Todas las obras: ");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JMenuBar barraMenu = new JMenuBar();
		JMenu menuDatos = new JMenu("Atrás");
		
		barraMenu.add(menuDatos);
		this.setJMenuBar(barraMenu);
		
		for (int i = 0; i < numBotones; i++) {
			botones.add(new JButton());
			cp.add(botones.get(i));
			i++;
			botones.add(new JButton());
			cp.add(botones.get(i));
			i--;
			titulos.add(new JLabel());
			cp.add(titulos.get(i));
			i++;
			titulos.add(new JLabel());
			cp.add(titulos.get(i));
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
