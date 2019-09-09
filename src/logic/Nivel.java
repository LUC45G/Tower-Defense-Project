package logic;

import gameObjects.ObjetoDelMapa.*;

public class Nivel extends Thread {
	
	private Mapa mapa; // Un solo mapa y muchos niveles o como hacemos ?¿
	private ObjetoDelMapa[] objetos; // Coleccion de objetos aleatorios a poner en el mapa
	private Horda[] hordas; // Almacena las hordas del nivel
	private int dificultad; // La dificultad hace variar la cantidad de enemigos entre otras cosas
	private int nivelActual; // Nivel actual, para saber que horda liberar
	
	public Nivel(Mapa m) {
		mapa = m;
		
	}
	
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			mapa.AvanzarEnemigos();
		}
	}
	
	/**
	 * Funcion que hardcodea las hordas simplemente para hacer pruebas
	 * Ahora la horda cuenta con un enemigo pero still
	 */
	public void HordaHardcodeada() {
		mapa.AgregarEnemigo();
	}

}
