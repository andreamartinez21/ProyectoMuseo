package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import BD.BD;
import clases.Obra;

public class VentanaObra extends JFrame{
	
	JScrollPane scroll;
	JPanel panel1;
	JPanel panel2;
	ImagePanel imgObra;
	JTable tablaDatosObra;
	JTextArea descripcionExt;
	JMenuBar barraMenu;
	JMenu menu;
	Insets insets;
	Dimension sizeImg;
	Dimension sizeTabla;
	Dimension sizeLabel;
	List<Obra> listaObras;
	String titulo;
	String zona;
	String artista;
	String fecha;
	
	public VentanaObra(Obra obra) {
		
		BD bd = new BD();
		barraMenu = new JMenuBar();
		menu = new JMenu("Atrás");
		barraMenu.add(menu);
		listaObras = new ArrayList<Obra>(bd.obras());
		descripcionExt = new JTextArea();
		
		for(int i = 0; i < listaObras.size(); i++) {
			if(obra.getIdArticulo() == listaObras.get(i).getIdArticulo()) {
				imgObra = new ImagePanel(listaObras.get(i).getImagen());
				descripcionExt.setText("\nDescripción: " + listaObras.get(i).getDescripcion());
				descripcionExt.setLineWrap(true);
				descripcionExt.setEditable(false);
				
				titulo = listaObras.get(i).getNombreArticulo();
				zona = listaObras.get(i).getZona();
				artista = listaObras.get(i).getArtista();
				fecha = listaObras.get(i).getFecha();
				break;
			}
		}
		
		this.setPreferredSize(new Dimension(900, 600));
		
		panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(800, 450));
		panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(800, 200));
		panel1.setLayout(new BorderLayout());
		panel2.setLayout(new BorderLayout());
		
		insets = panel1.getInsets();
		sizeImg = new Dimension(470, 320);	
		
		// Datos de prueba, se hará un método en BD() para leer estos datos de la BD.
		
		String datos[][] = { {"Título:", titulo}, 
							 {"Zona:", zona}, 
							 {"Artista", artista},
							 {"Fecha", fecha} };
		
		String columnas[] = {"c1", "c2"};		
		
		TableModel modelo = new DefaultTableModel(datos, columnas) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int fila, int columna) {	
		      return false;
		    }
		  };
		  
		tablaDatosObra = new JTable(modelo);
		tablaDatosObra.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		menu.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
				try {
					VentanaMapa vm = new VentanaMapa();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			@Override
			public void menuDeselected(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void menuCanceled(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		

		panel1.add(barraMenu, BorderLayout.PAGE_START);
		panel1.add(imgObra, BorderLayout.CENTER);
		panel1.add(tablaDatosObra, BorderLayout.PAGE_END);
		panel2.add(descripcionExt);

		add(panel1, BorderLayout.PAGE_START);
		add(panel2, BorderLayout.CENTER);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Museo - Mapa");
		pack();
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
			}
		});
	}

}
