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

public class VentanaTodasLasObras extends JFrame{ //no funciona
	
	private int i = 0;
	private int numBotones = 20;
	private Map<String,JButton> botones = new HashMap<String,JButton>();
	private Map<String,JLabel> titulos = new HashMap<String,JLabel>();
	
	public VentanaTodasLasObras() {
		
		Container cp = this.getContentPane();
		cp.setLayout(new GridLayout(20, 2));
		
		this.setTitle("Todas las obras: ");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JMenuBar barraMenu = new JMenuBar();
		JMenu menuDatos = new JMenu("Atrás");
		
		barraMenu.add(menuDatos);
		this.setJMenuBar(barraMenu);
		
		if(numBotones % 2 == 0) {
			while(i <= numBotones) {
				JButton boton1 = new JButton();
				botones.put("boton" +i, boton1);
				cp.add(botones.get("boton" +i)); 
				i++;
				JButton boton2 = new JButton();
				botones.put("boton" +i, boton2);
				cp.add(botones.get("boton" +i));
				i--;
				JLabel titulo1 = new JLabel();
				titulos.put("titulo" +i, titulo1);
				cp.add(titulos.get("titulo" +i));
				i++;
				JLabel titulo2 = new JLabel();
				titulos.put("titulo" +i, titulo2);
				cp.add(titulos.get("titulo" +i));
				i++;
			}
		} else {
			while(i <= numBotones) {
				if(i == numBotones) {
					JButton boton1 = new JButton();
					botones.put("boton" +i, boton1);
					cp.add(botones.get("boton" +i)); 
					i++;
					JButton boton2 = new JButton();
					botones.put("boton" +i, boton2);
					cp.add(botones.get("boton" +i));
					i--;
					JLabel titulo1 = new JLabel();
					titulos.put("titulo" +i, titulo1);
					cp.add(titulos.get("titulo" +i));
					i++;
					JLabel titulo2 = new JLabel();
					titulos.put("titulo" +i, titulo2);
					cp.add(titulos.get("titulo" +i));
					i++;
				} else {
					JButton boton1 = new JButton();
					botones.put("boton" +i, boton1);
					cp.add(botones.get("boton" +i)); 
					i++;
					JButton boton2 = new JButton();
					botones.put("boton" +i, boton2);
					cp.add(botones.get("boton" +i));
					botones.get("boton" +i).setVisible(false);
					i--;
					JLabel titulo1 = new JLabel();
					titulos.put("titulo" +i, titulo1);
					cp.add(titulos.get("titulo" +i));
					i++;
					JLabel titulo2 = new JLabel();
					titulos.put("titulo" +i, titulo2);
					cp.add(titulos.get("titulo" +i));
					titulos.get("titulo" +i).setVisible(false);
					i++;
				}
			}
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
