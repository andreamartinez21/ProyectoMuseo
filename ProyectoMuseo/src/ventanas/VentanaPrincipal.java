package ventanas;

import java.awt.*;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import BD.BD;
import clases.Obra;

public class VentanaPrincipal extends JFrame {
	private JPanel panel,panelIzqda,panelDcha;
	private DefaultListModel<String> listModel;
	private JList list;
	private JScrollPane scroll;
	private JMenuBar menuBar;
	private JMenu menu;
	
	private List<Obra> listaObras;
	
	public VentanaPrincipal() {
		BD bd = new BD();
		
		listaObras = new ArrayList<Obra>(bd.obras());
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		
		panelIzqda = new JPanel();
		
		listModel = new DefaultListModel<String>();
		for (int i = 0; i < listaObras.size(); i++) {
			listModel.addElement(listaObras.get(i).getNombreArticulo());
			
			}
		
		list = new JList(listModel);
		JScrollPane scrollPane = new JScrollPane(list);
		
		panelDcha = new JPanel(); 
		
		

		
		add(panel);
	
		panel.add(panelIzqda);
		panel.add(panelDcha);
		
		panelIzqda.add(scrollPane);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Bienvenido");
		setSize(650, 415);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new VentanaPrincipal();
		
	}

}
