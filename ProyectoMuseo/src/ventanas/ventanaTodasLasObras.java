package ventanas;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class ventanaTodasLasObras extends JFrame{
	
	private JButton boton1;
	private JButton boton2;
	private JButton boton3;
	private JButton boton4;
	private JButton boton5;
	private JButton boton6;
	private JButton boton7;
	private JButton boton8;
	private JButton boton9;
	private JButton boton10;
	private JButton boton11;
	private JButton boton12;
	private JButton boton13;
	private JButton boton14;
	private JButton boton15;
	private JButton boton16;
	private JButton boton17;
	private JButton boton18;
	private JButton boton19;
	private JButton boton20;
	private JButton botonAtras;
	
	public ventanaTodasLasObras() {
		
		Container cp = this.getContentPane();
		cp.setLayout(new GridLayout(20, 2));
		
		this.setTitle("Todas las obras: ");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JMenuBar barraMenu = new JMenuBar();
		JMenu menuDatos = new JMenu("Atrás");
		
		barraMenu.add(menuDatos);
		this.setJMenuBar(barraMenu);
		
		boton1 = new JButton("Boton 1");
		boton2 = new JButton("Boton 1");
		boton3 = new JButton("Boton 1");
		boton4 = new JButton("Boton 1");
		boton5 = new JButton("Boton 1");
		boton6 = new JButton("Boton 1");
		boton7 = new JButton("Boton 1");
		boton8 = new JButton("Boton 1");
		boton9 = new JButton("Boton 1");
		boton10 = new JButton("Boton 1");
		boton11 = new JButton("Boton 1");
		boton12 = new JButton("Boton 1");
		boton13 = new JButton("Boton 1");
		boton14 = new JButton("Boton 1");
		boton15 = new JButton("Boton 1");
		boton16 = new JButton("Boton 1");
		boton17 = new JButton("Boton 1");
		boton18 = new JButton("Boton 1");
		boton19 = new JButton("Boton 1");
		boton20 = new JButton("Boton 1");
		
		cp.add(boton1);
		cp.add(boton2);
		cp.add(new JLabel("Nomobre 1"));
		cp.add(new JLabel("Nomobre 1"));
		cp.add(boton3);
		cp.add(boton4);
		cp.add(new JLabel("Nomobre 1"));
		cp.add(new JLabel("Nomobre 1"));
		cp.add(boton5);
		cp.add(boton6);
		cp.add(new JLabel("Nomobre 1"));
		cp.add(new JLabel("Nomobre 1"));
		cp.add(boton7);
		cp.add(boton8);
		cp.add(new JLabel("Nomobre 1"));
		cp.add(new JLabel("Nomobre 1"));
		cp.add(boton9);
		cp.add(boton10);
		cp.add(new JLabel("Nomobre 1"));
		cp.add(new JLabel("Nomobre 1"));
		cp.add(boton11);
		cp.add(boton12);
		cp.add(new JLabel("Nomobre 1"));
		cp.add(new JLabel("Nomobre 1"));
		cp.add(boton13);
		cp.add(boton14);
		cp.add(new JLabel("Nomobre 1"));
		cp.add(new JLabel("Nomobre 1"));
		cp.add(boton15);
		cp.add(boton16);
		cp.add(new JLabel("Nomobre 1"));
		cp.add(new JLabel("Nomobre 1"));
		cp.add(boton17);
		cp.add(boton18);
		cp.add(new JLabel("Nomobre 1"));
		cp.add(new JLabel("Nomobre 1"));
		cp.add(boton19);
		cp.add(boton20);
		cp.add(new JLabel("Nomobre 1"));
		cp.add(new JLabel("Nomobre 1"));
		
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {	
				new ventanaTodasLasObras();
			}
		});
	}

}
