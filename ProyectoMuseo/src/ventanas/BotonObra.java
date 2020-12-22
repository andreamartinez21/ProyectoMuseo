package ventanas;

import javax.swing.JButton;

import clases.Obra;

public class BotonObra extends JButton {

	private static final long serialVersionUID = 1L;
	private Obra obra;
	
	public BotonObra(Obra o) {
		this.obra = o;
	}

	public Obra getObra() {
		return obra;
	}
}
