package ventanas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class VentanaMapa extends JFrame {
	
	JTextField barraBuscadora; // panelA
	JButton verObrasTotales;	// panelC
	
	public VentanaMapa() throws IOException {
		
		barraBuscadora = new JTextField("Busca el nombre de la obra");
		verObrasTotales = new JButton("Ver total de obras");

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout(3, 1));
		
		barraBuscadora.setSize(900, 100);
		verObrasTotales.setSize(900, 100);
		
		ImagePanel panelImagen = new ImagePanel();	// panelB (JPanel)
		panelImagen.setSize(900, 450);
		panelImagen.setLayout(new GridLayout(5, 5));
		
		cp.add(barraBuscadora, BorderLayout.PAGE_START);
		cp.add(panelImagen, BorderLayout.CENTER);
		cp.add(verObrasTotales, BorderLayout.PAGE_END);
		
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
