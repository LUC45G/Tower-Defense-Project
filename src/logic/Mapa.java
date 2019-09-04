package logic;

import gameObjects.ObjetoDelJuego;

public class Mapa {
	/* El mapa tiene que tener un Singleton, es decir, solo una instancia de mapa a la vez */
	
	
	private Celda [][] mapa; // 10x6 Minimo
	
	
	/* Constructor */
	
	/* Consultas */
	
	public boolean PuedoAvanzar(int x, int y) {
		// Verifica que la siguiente celda este disponible
		return mapa[x-1][y].estaDisponible();
	}
	
	/* Comandos */
	
	public void Avanzar(int x, int y) {
		// Requiere que se haya verificado que puede avanzar
		
		ObjetoDelJuego aux = mapa[x][y].getObjetoActual();
		mapa[x][y].EliminarObjetoActual();
		mapa[x-1][y].SetObjetoActual(aux);
	}
	

}
