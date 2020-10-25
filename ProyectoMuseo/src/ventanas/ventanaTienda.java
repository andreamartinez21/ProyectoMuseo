package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JButton;

public class ventanaTienda {

	private JFrame frmTienda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaTienda window = new ventanaTienda();
					window.frmTienda.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ventanaTienda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTienda = new JFrame();
		frmTienda.setTitle("Tienda");
		frmTienda.setBounds(100, 100, 882, 456);
		frmTienda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTienda.getContentPane().setLayout(null);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setEnabled(false);
		scrollBar_1.setBounds(818, 57, 23, 190);
		frmTienda.getContentPane().add(scrollBar_1);
		scrollBar_1.setVisible(false);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(851, 0, 17, 419);
		frmTienda.getContentPane().add(scrollBar);
		
		JList list = new JList();
		list.setBounds(674, 57, 167, 190);
		frmTienda.getContentPane().add(list);
		list.setVisible(false);
		
		JButton botonCarrito = new JButton("Carrito");
		botonCarrito.setBounds(791, 11, 50, 46);
		frmTienda.getContentPane().add(botonCarrito);
		
		botonCarrito.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(list.isVisible() == false) {
					list.setVisible(true);
				} else
					list.setVisible(false);
					
				if(list.isVisible() == false) {
					scrollBar_1.setVisible(false);
				} else
					scrollBar_1.setVisible(true);
			}
		});
	}
}
