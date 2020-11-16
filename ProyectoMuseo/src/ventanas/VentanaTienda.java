package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class VentanaTienda extends JFrame{

	private JPanel panelTienda;
	//private JPanel panelPrincipal;
	private JScrollPane scrollPanePrincipal;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaTienda window = new VentanaTienda();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaTienda() {
		
		setTitle("Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelTienda = new JPanel();
		panelTienda.setBounds(100, 100, 882, 456);
		
		//panelPrincipal = new JPanel();
		
		
		scrollPanePrincipal = new JScrollPane();
		scrollPanePrincipal.setBounds(0, 0, 1086, 700);
		scrollPanePrincipal.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panelTienda.setLayout(null);
		
		JButton botonCarrito = new JButton("Carrito");
		botonCarrito.setBounds(832, 0, 50, 46);
		panelTienda.add(botonCarrito);
		
		JList list = new JList();
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(674, 61, 167, 190);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setVisible(false);
		panelTienda.add(scrollPane);
		
		scrollPanePrincipal.add(panelTienda);
		//panelPrincipal.add(scrollPanePrincipal);
		panelTienda.setVisible(true);
		//panelPrincipal.setVisible(true);
		scrollPanePrincipal.setVisible(true);
		this.setVisible(true);
		getContentPane().setLayout(null);
		getContentPane().add(scrollPanePrincipal);
		this.setSize(1100, 900);
		
		botonCarrito.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(scrollPane.isVisible() == false) {
					scrollPane.setVisible(true);
				} else
					scrollPane.setVisible(false);
			}
		});
	}
}
