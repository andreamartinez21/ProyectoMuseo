package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import BD.BD;
import clases.Obra;

//import clases.Coordenadas;

public class VentanaMapa extends JFrame implements ActionListener {
	
	JTextField barraBuscadora;
	JPanel panelAbajo;
	JButton verObrasTotales;
	JButton buscarObra;
	private static final Dimension TAMANYO_BOTON = new Dimension(20, 20);
	
	List<BotonObra> botones = new ArrayList<BotonObra>();
	List<Obra> listaObras;
	
	// setBounds : button size
	
	public VentanaMapa() throws IOException {
		
		BD BDTotal = new BD();
		listaObras = new ArrayList<Obra>(BDTotal.obras());		// Cargo todos los datos de las obras
		
//		for (Obra obra : listaObras) {
//			BotonObra boton = new BotonObra(obra);
//			boton.setPreferredSize(TAMANYO_BOTON);
//			boton.setBackground(Color.GREEN);
//		}
		
//		for (int i = 0; i < listaObras.size(); i++) {
//			botones.add(new BotonObra(listaObras.get(i)));			// rellenar lista botones
//		}
		
		
		for(int i = 0; i < listaObras.size(); i++) {
			BotonObra boton = new BotonObra(listaObras.get(i));
			boton.setPreferredSize(TAMANYO_BOTON);
			boton.setBackground(Color.GREEN);
			
			botones.add(boton);
		}
		
		// Components
		
		ImagePanel panelImagen = new ImagePanel("images/fondos/mapaMuseo.jpg");
		Insets insets = panelImagen.getInsets();
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
			// BD().coords(); entro al public BD y luego al método coords 
		
		
		for (int i = 0; i < listaObras.size(); i++) {
			botones.get(i).setBounds(botones.get(i).getObra().getX() + insets.left, botones.get(i).getObra().getY() + insets.top,
					TAMANYO_BOTON.width, TAMANYO_BOTON.height);
		}

		for(int i = 0; i < botones.size(); i++) {
			panelImagen.add(botones.get(i));
		}
		
		cp.add(barraBuscadora, BorderLayout.PAGE_START);
		cp.add(panelImagen, BorderLayout.CENTER);
		cp.add(panelAbajo, BorderLayout.PAGE_END);
		
		// Listeners
		
		verObrasTotales.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
				VentanaTodasLasObras todasObras = new VentanaTodasLasObras();
			}
		});
		
		buscarObra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//if(barraBuscadora.getText().equals(Articulo.nombreArticulo)) {
				//	
				//}
			}
		});
		
		for(BotonObra b : botones) {
			b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					setVisible(false);
					VentanaObra vo = new VentanaObra(b.getObra());
				}
			});
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
	}
}
