package ventanas;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
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
			if(obra.getIdArticulo() == listaObras.get(i).getIdArticulo()) {
				imgObra = new ImagePanel(listaObras.get(i).getImagen());
				descripcionExt.setText(listaObras.get(i).getDescripcion());
				break;
			}
		}
		
		
		cp = this.getContentPane();
		this.setPreferredSize(new Dimension(900, 600));
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(800, 900));
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		insets = panel.getInsets();
		sizeImg = new Dimension(470, 320);	
		
		// Datos de prueba, se hará un método en BD() para leer estos datos de la BD.
		
		String datos[][] = { {"ARTISTA", "AÑO", "ZONA"}, {"d", "e", "f"}, {"g", "h", "i"}};
		String columnas[] = {"c1", "c2", "c3"};
		
		TableModel modelo = new DefaultTableModel(datos, columnas) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int fila, int columna) {	
		      return false;
		    }
		  };
		  
		tablaDatosObra = new JTable(modelo);
		tablaDatosObra.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		for (int column = 0; column < tablaDatosObra.getColumnCount(); column++) {
			
		    TableColumn tableColumn = tablaDatosObra.getColumnModel().getColumn(column);
		    int preferredWidth = tableColumn.getMinWidth();
		    int maxWidth = tableColumn.getMaxWidth();
		 
		    for (int row = 0; row < tablaDatosObra.getRowCount(); row++) {
		    	
		        TableCellRenderer cellRenderer = tablaDatosObra.getCellRenderer(row, column);
		        Component c = tablaDatosObra.prepareRenderer(cellRenderer, row, column);
		        int width = c.getPreferredSize().width + tablaDatosObra.getIntercellSpacing().width;
		        preferredWidth = Math.max(preferredWidth, width);
		 
		        if (preferredWidth >= maxWidth) {
		        	
		            preferredWidth = maxWidth;
		            break;
		        }
		    }
		 
		    tableColumn.setPreferredWidth( preferredWidth );
		}
		
		scroll = new JScrollPane();

		panel.add(imgObra);
		panel.add(tablaDatosObra);
		panel.add(descripcionExt);
		
		cp.add(scroll);
		scroll.setViewportView(panel);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Museo - Mapa");
//		setSize(500, 800);
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
