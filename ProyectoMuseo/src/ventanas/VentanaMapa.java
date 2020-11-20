package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import BD.BD;
import clases.Coordenadas;
import clases.Obra;

//import clases.Coordenadas;

public class VentanaMapa extends JFrame {
	
	JTextField barraBuscadora;
	JPanel panelAbajo;
	JButton verObrasTotales;
	JButton buscarObra;
	
	JButton[] arrayBotonesObras = new JButton[20];	
	
	// setBounds : button size
	
	public VentanaMapa() throws IOException {
		
		for(int i = 0; i < arrayBotonesObras.length; i++) {
			arrayBotonesObras[i] = new JButton();
			arrayBotonesObras[i].setPreferredSize(new Dimension(20, 20));
			arrayBotonesObras[i].setBackground(Color.GREEN);
		}
		
		// Components
		
		ImagePanel panelImagen = new ImagePanel("images/fondos/mapaMuseo.jpg");
		Insets insets = panelImagen.getInsets();
		Dimension size = arrayBotonesObras[0].getPreferredSize();
		panelAbajo = new JPanel();
		
		barraBuscadora = new JTextField("Busca el nombre de la obra");
		verObrasTotales = new JButton("Ver total de obras");
		buscarObra = new JButton("Buscar obra");
		
		panelAbajo.setLayout(new GridLayout(1, 2));
		
		panelAbajo.add(buscarObra);
		panelAbajo.add(verObrasTotales);
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout(3, 1));
		
		barraBuscadora.setSize(900, 100);
		verObrasTotales.setSize(900, 100);
		
		panelImagen.setSize(900, 450);
		panelImagen.setLayout(null);
		
			// obra1 to obra5 = Roman Zone
			// obra6 to obra10 = Greek Zone
			// obra11 to obra15 = E. Zone
			// obra16 to obra20 = Latin Zone

		BD BDTotal = new BD();	// Base de datos entera
		
		Coordenadas[] coordenadas = BDTotal.coords();	// BD().coords(); entro al public BD y luego al método coords 
		
		for (int i = 0; i < coordenadas.length; i++) {
			arrayBotonesObras[i].setBounds(coordenadas[i].x + insets.left, coordenadas[i].y + insets.top, size.width, size.height);
		}
		
		Obra[] obras = BDTotal.obras(); // Sin uso todavía
		
		cp.add(barraBuscadora, BorderLayout.PAGE_START);
		cp.add(panelImagen, BorderLayout.CENTER);
		cp.add(panelAbajo, BorderLayout.PAGE_END);
				
		for(int i = 0; i < 20; i++) {
			panelImagen.add(arrayBotonesObras[i]);
		}
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Museo - Mapa");
		setSize(900, 515);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new VentanaMapa();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
