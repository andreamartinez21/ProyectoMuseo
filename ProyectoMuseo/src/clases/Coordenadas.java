package clases;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JButton;

import ventanas.ImagePanel;
import ventanas.VentanaMapa;

public class Coordenadas {

	public int x;
	public int y;
	
	public Coordenadas(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Coordenadas() {
		this.x = 0;
		this.y = 0;
	}
	
	@Override
	public boolean equals(Object objeto) {
		Coordenadas c = (Coordenadas) objeto;
		return this.x == c.x && this.y == c.y;
	}
}
