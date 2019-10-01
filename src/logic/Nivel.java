package logic;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JLabel;

import gameObjects.ObjetoDelMapa.*;
import gameObjects.Personaje.Enemigo.*;
import gameObjects.Personaje.Aliado.*;
import gameObjects.ObjetoDelJuego;
import javax.swing.ImageIcon;


public class Nivel extends Thread {
	
	private Mapa mapa; // Un solo mapa y muchos niveles o como hacemos ?¿
	private ArrayList<ObjetoDelMapa> objetos; // Coleccion de objetos aleatorios a poner en el mapa
	private Horda[] hordas; // Almacena las hordas del nivel
	private ArrayList<Enemigo> listaDeEnemigos; // Lista que almacena enemigos para que avancen
	private int dificultad; // La dificultad hace variar la cantidad de enemigos entre otras cosas
	private int nivelActual; // Nivel actual, para saber que horda liberar
	
	private static Nivel INSTANCE = null;
	
	private Nivel(Mapa m) {
		mapa = m;
		listaDeEnemigos = new ArrayList<Enemigo>();
		dificultad = 1;
		nivelActual = 1;
	}
	
	public static Nivel getNivel(Mapa m) {
		if(INSTANCE == null)
			INSTANCE = new Nivel(m);
		
		return INSTANCE;
	}
	
	public void run() {
		System.out.println("Arranca nivel " + nivelActual);
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(listaDeEnemigos.size() == 0) {
				// System.out.println("cero");
				mapa.Update();
				continue;
			}
			for(int i = 0; i < listaDeEnemigos.size(); i++) 
				listaDeEnemigos.get(i).Avanzar();
		}
	}
	
	/**
	 * Funcion que hardcodea las hordas simplemente para hacer pruebas
	 * Ahora la horda cuenta con un enemigo pero still
	 */
	public void HordaHardcodeada() {
		
		ObjetoDelJuego c = mapa.AgregarEnemigo();
		listaDeEnemigos.add( (Enemigo) c );
		
	}
	
	//El aliado sabe sus coordenadas x,y y conoce al mapa 
	public Image CrearAliado(Image i, int x, int y) {
		ObjetoDelJuego c = mapa.AgregarAliado(x, y);
		
		return i;
	}
	
	/**
	 * Elimina todos los enemigos del juego
	 */
	public void EliminarTodosLosEnemigos() {
		listaDeEnemigos.removeAll(listaDeEnemigos);
	}
	
	/**
	 * Metodo que devuelve un iterable con todos los objetos del mapa actuales
	 * @return un iterable con todos los objetos del juego 
	 */
	@SuppressWarnings("unchecked")
	public Iterable<ObjetoDelJuego> getObjetosDelMapa() {
		
		// Pido al mapa los objetos que no sean enemigos, y le agrego los enemigos que guarda el nivel
		ArrayList<ObjetoDelJuego> it = new ArrayList<ObjetoDelJuego>();	
		it = (ArrayList<ObjetoDelJuego>) mapa.getGameObjects().clone();
		ArrayList<Enemigo> clon = (ArrayList<Enemigo>) listaDeEnemigos.clone();
		it.addAll(clon);
		
		return it;
	}

	public Enemigo CrearEnemigo() {
		ObjetoDelJuego c = mapa.AgregarEnemigo();
		listaDeEnemigos.add( (Enemigo) c );
		return (Enemigo) c;
	}
}
