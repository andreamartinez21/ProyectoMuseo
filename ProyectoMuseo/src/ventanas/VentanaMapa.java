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

public class VentanaMapa extends JFrame {
	
	JTextField barraBuscadora; // panel barra buscadora	
	JPanel panelAbajo; // panel botones abajo
	JButton verObrasTotales;
	JButton buscarObra;
	
	// Botones de localización de obras
	
	JButton obra1;
	JButton obra2;
	JButton obra3;
	JButton obra4;
	JButton obra5;
	JButton obra6;
	JButton obra7;
	JButton obra8;
	JButton obra9;
	JButton obra10;
	JButton obra11;
	JButton obra12;
	JButton obra13;
	JButton obra14;
	JButton obra15;
	JButton obra16;
	JButton obra17;
	JButton obra18;
	JButton obra19;
	JButton obra20;
	
	// setBounds para tamaño botón
	// quitar layout y poner los botones con coordenadas
	
	public VentanaMapa() throws IOException {
		
		obra1 = new JButton();
		obra2 = new JButton();
		obra3 = new JButton();
		obra4 = new JButton();
		obra5 = new JButton();
		obra6 = new JButton();
		obra7 = new JButton();
		obra8 = new JButton();
		obra9 = new JButton();
		obra10 = new JButton();
		obra11 = new JButton();
		obra12 = new JButton();
		obra13 = new JButton();
		obra14 = new JButton();
		obra15 = new JButton();
		obra16 = new JButton();
		obra17 = new JButton();
		obra18 = new JButton();
		obra19 = new JButton();
		obra20 = new JButton();
		
		// Dimensiones de los botones, color y visibilidad
		
		obra1.setPreferredSize(new Dimension(20, 20));
		obra2.setPreferredSize(new Dimension(20, 20));
		obra3.setPreferredSize(new Dimension(20, 20));
		obra4.setPreferredSize(new Dimension(20, 20));
		obra5.setPreferredSize(new Dimension(20, 20));
		obra6.setPreferredSize(new Dimension(20, 20));
		obra7.setPreferredSize(new Dimension(20, 20));
		obra8.setPreferredSize(new Dimension(20, 20));
		obra9.setPreferredSize(new Dimension(20, 20));
		obra10.setPreferredSize(new Dimension(20, 20));
		obra11.setPreferredSize(new Dimension(20, 20));
		obra12.setPreferredSize(new Dimension(20, 20));
		obra13.setPreferredSize(new Dimension(20, 20));
		obra14.setPreferredSize(new Dimension(20, 20));
		obra15.setPreferredSize(new Dimension(20, 20));
		obra16.setPreferredSize(new Dimension(20, 20));
		obra17.setPreferredSize(new Dimension(20, 20));
		obra18.setPreferredSize(new Dimension(20, 20));
		obra19.setPreferredSize(new Dimension(20, 20));
		obra20.setPreferredSize(new Dimension(20, 20));
		
		obra1.setBackground(Color.GREEN);
		obra2.setBackground(Color.GREEN);
		obra3.setBackground(Color.GREEN);
		obra4.setBackground(Color.GREEN);
		obra5.setBackground(Color.GREEN);
		obra6.setBackground(Color.GREEN);
		obra7.setBackground(Color.GREEN);
		obra8.setBackground(Color.GREEN);
		obra9.setBackground(Color.GREEN);
		obra10.setBackground(Color.GREEN);
		obra11.setBackground(Color.GREEN);
		obra12.setBackground(Color.GREEN);
		obra13.setBackground(Color.GREEN);
		obra14.setBackground(Color.GREEN);
		obra15.setBackground(Color.GREEN);
		obra16.setBackground(Color.GREEN);
		obra17.setBackground(Color.GREEN);
		obra18.setBackground(Color.GREEN);
		obra19.setBackground(Color.GREEN);
		obra20.setBackground(Color.GREEN);
		
		//obra1.setVisible(false);       <-- Botones ocultos siempre, se cambiará a "true" si existe la obra.
		
		// Componentes
		
		ImagePanel panelImagen = new ImagePanel();	// panelB (imágen mapa)	
		Insets insets = panelImagen.getInsets();
		Dimension size = obra1.getPreferredSize();
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
		
		// Botones de todas las obras
		
			// obra1 a obra5 = Zona Romana
			// obra6 a obra10 = Zona Griega
			// obra11 a obra15 = Zona Egipcia
			// obra16 a obra20 = Zona Latina
			
		obra1.setBounds(200 + insets.left, 64 + insets.top, size.width, size.height);
		obra2.setBounds(250 + insets.left, 64 + insets.top, size.width, size.height);
		obra3.setBounds(300 + insets.left, 64 + insets.top, size.width, size.height);
		obra4.setBounds(180 + insets.left, 120 + insets.top, size.width, size.height);
		obra5.setBounds(180 + insets.left, 170 + insets.top, size.width, size.height);
		obra6.setBounds(125 + insets.left, 300 + insets.top, size.width, size.height);
		obra7.setBounds(170 + insets.left, 365 + insets.top, size.width, size.height);
		obra8.setBounds(270 + insets.left, 365 + insets.top, size.width, size.height);
		obra9.setBounds(370 + insets.left, 365 + insets.top, size.width, size.height);
		obra10.setBounds(200 + insets.left, 270 + insets.top, size.width, size.height);
		obra11.setBounds(520 + insets.left, 40 + insets.top, size.width, size.height);
		obra12.setBounds(580 + insets.left, 40 + insets.top, size.width, size.height);
		obra13.setBounds(640 + insets.left, 40 + insets.top, size.width, size.height);
		obra14.setBounds(700 + insets.left, 40 + insets.top, size.width, size.height);
		obra15.setBounds(755 + insets.left, 110 + insets.top, size.width, size.height);
		obra16.setBounds(745 + insets.left, 270 + insets.top, size.width, size.height);
		obra17.setBounds(745 + insets.left, 330 + insets.top, size.width, size.height);
		obra18.setBounds(630 + insets.left, 390 + insets.top, size.width, size.height);
		obra19.setBounds(700 + insets.left, 390 + insets.top, size.width, size.height);
		obra20.setBounds(580 + insets.left, 320 + insets.top, size.width, size.height);
		
		// Añadir componentes a contenedor
		
		cp.add(barraBuscadora, BorderLayout.PAGE_START);
		cp.add(panelImagen, BorderLayout.CENTER);
		cp.add(panelAbajo, BorderLayout.PAGE_END);
		
		panelImagen.add(obra1);	
		panelImagen.add(obra2);	
		panelImagen.add(obra3);	
		panelImagen.add(obra4);	
		panelImagen.add(obra5);	
		panelImagen.add(obra6);	
		panelImagen.add(obra7);	
		panelImagen.add(obra8);	
		panelImagen.add(obra9);	
		panelImagen.add(obra10);	
		panelImagen.add(obra11);	
		panelImagen.add(obra12);	
		panelImagen.add(obra13);	
		panelImagen.add(obra14);	
		panelImagen.add(obra15);	
		panelImagen.add(obra16);	
		panelImagen.add(obra17);	
		panelImagen.add(obra18);	
		panelImagen.add(obra19);	
		panelImagen.add(obra20);
		
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
