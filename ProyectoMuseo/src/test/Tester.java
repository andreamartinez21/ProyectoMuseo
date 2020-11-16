package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import BD.BD;

import org.junit.jupiter.api.Test;

import clases.Coordenadas;

class Tester {
	
	@Test
	public void coords() {
		Coordenadas[] coordenadasEsperado = new Coordenadas[20];
		Coordenadas[] coordenadasRealidad = new BD().coords();
		coordenadasEsperado[0] = new Coordenadas(200, 64);
		coordenadasEsperado[1] = new Coordenadas(250, 64);
		coordenadasEsperado[2] = new Coordenadas(300, 64);
		coordenadasEsperado[3] = new Coordenadas(180, 120);
		coordenadasEsperado[4] = new Coordenadas(180, 170);
		coordenadasEsperado[5] = new Coordenadas(125, 300);
		coordenadasEsperado[6] = new Coordenadas(170, 365);
		coordenadasEsperado[7] = new Coordenadas(270, 365);
		coordenadasEsperado[8] = new Coordenadas(370, 365);
		coordenadasEsperado[9] = new Coordenadas(200, 270);
		coordenadasEsperado[10] = new Coordenadas(520, 40);
		coordenadasEsperado[11] = new Coordenadas(580, 40);
		coordenadasEsperado[12] = new Coordenadas(640, 40);
		coordenadasEsperado[13] = new Coordenadas(700, 40);
		coordenadasEsperado[14] = new Coordenadas(755, 110);
		coordenadasEsperado[15] = new Coordenadas(745, 270);
		coordenadasEsperado[16] = new Coordenadas(745, 330);
		coordenadasEsperado[17] = new Coordenadas(630, 390);
		coordenadasEsperado[18] = new Coordenadas(700, 390);
		coordenadasEsperado[19] = new Coordenadas(580, 320);
		boolean iguales = Arrays.equals(coordenadasEsperado, coordenadasRealidad);
		assertTrue(iguales);
	}
}
