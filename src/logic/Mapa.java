package logic;

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
	}
	
	/* Consultas */
	
	public Mapa getInstance() { return INSTANCE; }
	public Celda[][] getMapa() { return MAPA; }
	
	public boolean PuedoAvanzar(int x, int y) {
		// Verifica que la siguiente celda este disponible
		return MAPA[x-1][y].estaDisponible();
	}
	
	/* Comandos */
	
	public void Avanzar(int x, int y) {
		// Requiere que se haya verificado que puede avanzar
		
		ObjetoDelJuego aux = MAPA[x][y].getObjetoActual();
		MAPA[x][y].EliminarObjetoActual();
		MAPA[x-1][y].SetObjetoActual(aux);
	}
	
	public void AgregarEnemigo() {
		Random r = new Random();
		int y = r.nextInt(6);
		gui.AgregarEnemigo(++y);
	}
	
	public void AvanzarEnemigos() {
		gui.AvanzarEnemigos();
	}
	

}
