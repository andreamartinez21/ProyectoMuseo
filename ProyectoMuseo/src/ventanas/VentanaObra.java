package ventanas;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import BD.BD;
import clases.Obra;

public class VentanaObra extends JFrame{
	
	JScrollPane scroll;
	JPanel panel;
	ImagePanel imgObra;
	JTable tablaDatosObra;
	JLabel descripcionExt;
	Insets insets;
	Dimension sizeImg;
	Dimension sizeTabla;
	Dimension sizeLabel;
	Container cp;
	List<Obra> listaObras;
	
	public VentanaObra(Obra obra) {
		
		BD bd = new BD();
		listaObras = new ArrayList<Obra>(bd.obras());
		descripcionExt = new JLabel();
		
		for(int i = 0; i < listaObras.size(); i++) {
			imgObra = new ImagePanel(listaObras.get(i).getImagen());
			descripcionExt.setText(listaObras.get(i).getDescripcion());
			
		}
		
		
		cp = this.getContentPane();
		this.setPreferredSize(new Dimension(900, 600));
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(800, 900));
		panel.setLayout(new GridLayout(3, 1));
		
		insets = panel.getInsets();
		sizeImg = imgObra.getPreferredSize();		
		
		// Datos de prueba, se hará un método en BD() para leer estos datos de la BD.
		
		String datos[][] = { {"ARTISTA", "AÑO", "ZONA"},
				{"d", "e", "f"},
				{"g", "h", "i"}};
		
		String columnas[] = {"c1", "c2", "c3"};
		
		TableModel modelo = new DefaultTableModel(datos, columnas) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int fila, int columna) {	
		      return false;
		    }
		  };
		  
		tablaDatosObra = new JTable(modelo); 
		
		scroll = new JScrollPane();

		panel.add(imgObra);
		panel.add(tablaDatosObra);
		panel.add(descripcionExt);
		
		cp.add(scroll);
		scroll.setViewportView(panel);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Museo - Mapa");
		setSize(900, 800);
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
