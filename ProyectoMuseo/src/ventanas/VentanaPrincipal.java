package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import BD.BD;
import clases.Obra;

public class VentanaPrincipal extends JFrame {
	private JPanel panel, panelIzqda, panelDcha;
	private DefaultListModel<String> listModel;
	private JList list;
	private JScrollPane scroll;
	private JMenuBar menuBar;
	private JMenu menuLogin,menuRegistro;
	private JLabel label,label1;

	private List<Obra> listaObras;

	public VentanaPrincipal() {
		BD bd = new BD(); 

		panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));

		//PANEL IZQDA --> Aquí va el scrollpane
		panelIzqda = new JPanel();
		panelIzqda.setLayout(new BorderLayout());

		menuBar = new JMenuBar();
		menuLogin = new JMenu("Login");	
		menuLogin.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new VentanaLogin(null);
				dispose();
				
			}
		});
		
		menuRegistro = new JMenu("Registro");
		menuRegistro.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new VentanaRegistro();
				dispose();
			}
		});
		
		listModel = new DefaultListModel<String>();

		listaObras = new ArrayList<Obra>(bd.obras());
		Map<Integer, String> mapa = new HashMap<Integer, String>();
		for (int i = 0; i < listaObras.size(); i++) {
			mapa.put(listaObras.get(i).getIdArticulo(), listaObras.get(i).getNombreArticulo());
		}

		Iterator it = mapa.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			listModel.addElement((String) pair.getValue());
			it.remove(); // avoids a ConcurrentModificationException
		}

		list = new JList(listModel);
		JScrollPane scrollPane = new JScrollPane(list);
		
		label = new JLabel("<html>Bienvenido al Museo.<br/>Aquí puede visualizar los títulos de las obras que pertenecen al museo:</html>");

		ImagePanel img = new ImagePanel("images/fondos/prado.jpg");
		
		setJMenuBar(menuBar);

		panel.add(panelIzqda);
		panel.add(img);
		
		panelIzqda.add(label, BorderLayout.NORTH);
		panelIzqda.add(scrollPane, BorderLayout.CENTER);
		
		add(panel);
		
		menuBar.add(menuLogin);
		menuBar.add(menuRegistro);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Bienvenido");
		setSize(650, 415);
		setResizable(false);
		setVisible(true);

	}

	public static void main(String[] args) {
		new VentanaPrincipal();

	}

}
