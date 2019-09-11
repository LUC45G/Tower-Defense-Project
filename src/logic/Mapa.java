package logic;

import java.awt.Image;
import java.util.Random;

import gameObjects.ObjetoDelJuego;
import gui.Gui;

public class Mapa {
	/* El mapa tiene que tener un Singleton, es decir, solo una instancia de mapa a la vez */
	
	
	private static final Celda [][] MAPA = new Celda[10][6]; // 10x6 Minimo
	private static Mapa INSTANCE = null; // se asegura de que haya un solo mapa
	private Gui gui;
	
	/* Constructor */
	
	public Mapa( Gui g ) {
		if(INSTANCE!= null)
			System.out.println("Error");
		gui = g;
		INSTANCE = this;
		
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 6; j++)
				MAPA[i][j] = new Celda(i, j);
	}
	
	/* Consultas */
	
	public Mapa getInstance() { return INSTANCE; }
	public Celda[][] getMapa() { return MAPA; }
	
	public boolean PuedoAvanzar(int x, int y) {
		// Verifica que la siguiente celda este disponible
		if(x!=0)
			return MAPA[x-1][y].estaDisponible();
		else 
			return false;
	}
	
	/* Comandos */
	
	public void Avanzar(int x, int y) {
		// Requiere que se haya verificado que puede avanzar
		
		ObjetoDelJuego aux = MAPA[x][y].getObjetoActual();
		MAPA[x][y].EliminarObjetoActual();
		MAPA[x-1][y].SetObjetoActual(aux);
		
		gui.ActualizarGrafica();
	}
	
	public Celda AgregarEnemigo() {
		Random r = new Random();
		int y = r.nextInt(6);
		Celda c = new Celda(9, ++y);
		gui.ActualizarGrafica();
		return c;
	}
	
	public Celda AgregarAliado(int x, int y) {
		Celda c = new Celda(x, y);
		gui.ActualizarGrafica();
		return c;
		
	}
	
	public void setObjetoEnCelda(int x, int y, ObjetoDelJuego e) {
		MAPA[x][y].SetObjetoActual(e);
	}
	
	public Image getImage(int x, int y) {
		return MAPA[x][y].getImagen();
	}
	
	/*public void AvanzarEnemigos() {
		gui.AvanzarEnemigos();
	}*/
	

}
