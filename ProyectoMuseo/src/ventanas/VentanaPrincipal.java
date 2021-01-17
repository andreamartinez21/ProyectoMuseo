package ventanas;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
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
	private JMenu menu;

	private List<Obra> listaObras;

	public VentanaPrincipal() {
		BD bd = new BD();

		panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));

		panelIzqda = new JPanel();

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
