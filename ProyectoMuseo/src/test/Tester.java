package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import BD.BD;

import org.junit.jupiter.api.Test;

import clases.Obra;

class Tester {
	
	@Test
	public void obras() {
		List<Obra> obrasEsperado = new ArrayList<Obra>();
		List<Obra> obrasRealidad = new BD().obras();
		obrasEsperado.add(new Obra(1, "Conversion San Pedro", "Está realizado al óleo sobre lienzo y tiene unas dimensiones de 230 centímetros de alto por 175 de ancho. Fue pintada para la capilla Cerasi de la iglesia de Santa María del Popolo de Roma, Italia.", "Romana", "Caravaggio", "1600", "images/obras/obrasRomanas/conversionSP.jpg", 200, 64));
		obrasEsperado.add(new Obra(2, "Crucifixion San Pedro", "Está realizado al óleo sobre lienzo y tiene unas dimensiones de 230 centímetros de alto por 175 de ancho. Fue pintada para la capilla Cerasi de la iglesia de Santa María del Popolo de Roma, Italia.", "Romana", "Caravaggio", "1601", "images/obras/obrasRomanas/crucifixionSP.jpg", 250, 64));
		obrasEsperado.add(new Obra(3, "Martirio San Mateo", "Es el primer cuadro de la etapa romana del pintor y de una serie dedicada a San Mateo Evangelista, la cual se conserva por completo en la Capilla Contarelli, San Luis de los Franceses, Roma.", "Romana", "Caravaggio", "1599–1600", "images/obras/obrasRomanas/martirioSanMateo.jpg", 300, 64));
		obrasEsperado.add(new Obra(4, "Triunfo Galatea", "Fresco pintado en la Villa Farnesina, en el barrio de Trastévere de Roma.", "Romana", "Rafael Sanzio", "1514", "images/obras/obrasRomanas/triunfoGalatea.jpg", 180, 120));
		obrasEsperado.add(new Obra(5, "Vocación San Mateo", "Está realizado al óleo sobre lienzo. Pertenece al ciclo de la Vida de san Mateo que le fue encargada para decorar la Capilla Contarelli en la iglesia romana de San Luis de los Franceses, ​ donde aún se conserva.", "Romana", "Caravaggio", "1601", "images/obras/obrasRomanas/vocacionSanMateo.jpg", 180, 170));
		obrasEsperado.add(new Obra(6, "Bosque Vetusto", "Pintado en oleo", "Griega", "Georgios Roilos", "1678", "iimages/obras/obrasGriegas/bosqueVetusto.jpg", 125, 300));
		obrasEsperado.add(new Obra(7, "Delphi", "Was created in Post-Impressionism style", "Griega", "Konstantinos Maleas", "1720", "images/obras/obrasGriegas/delphi.jpg", 170, 365));
		obrasEsperado.add(new Obra(8, "La Guerrilla", "Pintado en oleo", "Griega", "Georgios Roilos", "1678", "images/obras/obrasGriegas/laGuerrilla.jpg", 270, 365));
		obrasEsperado.add(new Obra(9, "Los Poetas", "Pintado en oleo", "Griega", "Georgios Roilos", "1679", "images/obras/obrasGriegas/losPoetas.jpg", 370, 365));
		obrasEsperado.add(new Obra(10, "Piezas de Fruta", "Pintado en oleo", "Griega", "Georgios Roilos", "1680", "images/obras/obrasGriegas/piezasFruta.jpg", 200, 270));
		obrasEsperado.add(new Obra(11, "Clara oscuridad", "Con este cuadro, Essam quiso representar la poderosa oscuridad, tratando de apagar la luz de la madre naturaleza", "Zona Egipcia", "Essam Marouf", "Año 1958", "images/obras/obrasEgipcias/EM1.jpg", 520, 40));
		obrasEsperado.add(new Obra(12, "Personalidades", "Representación de las diferentes personalidades de una persona con problemas", "Zona Egipcia", "Essam Marouf", "Año 1958", "images/obras/obrasEgipcias/EM2.jpg", 580, 40));
		obrasEsperado.add(new Obra(13, "Evolución personal", "Se muestra el progreso de una mujer a lo largo de su vida", "Zona Egipcia", "Essam Marouf", "Año 1959", "images/obras/obrasEgipcias/EM3.jpg", 640, 40));
		obrasEsperado.add(new Obra(14, "Virgen pálida", "En este cuadro, Essam Marouf quiso representar a una conocida vírgen originaria de Egipto", "Zona Egipcia", "Essam Marouf", "Año 1959", "images/obras/obrasEgipcias/EM4.jpg", 700, 40));
		obrasEsperado.add(new Obra(15, "Naturaleza humana", "Se observa una silueta representando una hoja, la cual tiene inscrita el rostro de una mujer", "Zona Egipcia", "Essam Marouf", "Año 1958", "images/obras/obrasEgipcias/EM5.jpg", 755, 110));
		obrasEsperado.add(new Obra(16, "El cargador de flores", "Representación de un hombre, llevando encima una gran cesta con flores", "Zona Latina", "Diego Rivera", "Año 1935", "images/obras/obrasLatinas/elCargadorDeFlores.jpg", 745, 270));
		obrasEsperado.add(new Obra(17, "Murales de la Industria de Detroit", " de veintisiete paneles que representan la industria de Ford Motor Company en Detroit", "Zona Latina", "Diego Rivera", "Año 1933", "images/obras/obrasLatinas/muralesIndustriaDetroit.jpg", 745, 330));
		obrasEsperado.add(new Obra(18, "La columna rota", "Obra que representa a una mujer con su columna vertebral quebrantada", "Zona Latina", "Frida Kahlo", "Año 1944", "images/obras/obrasLatinas/laColumnaRota.jpg", 630, 390));
		obrasEsperado.add(new Obra(19, "Las dos Fridas", "La artista quiso representarse a ella misma, en dos etapas diferentes de su vida", "Zona Latina", "Frida Kahlo", "Año 1939", "images/obras/obrasLatinas/lasDosFridas.jpg", 700, 390));
		obrasEsperado.add(new Obra(20, "Las sandías", "Diego Rivera haciendo un cuadro de Arte moderno o Realismo social", "Zona Latina", "Diego Rivera", "Año 1957", "images/obras/obrasLatinas/lasSandias.jpg", 580, 320));
		boolean iguales = (obrasEsperado).equals(obrasRealidad);
		assertTrue(iguales);
	}
}
