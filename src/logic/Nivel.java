package logic;

import java.awt.Image;
import java.util.ArrayList;

import gameObjects.ObjetoDelMapa.*;
import gameObjects.Personaje.Enemigo.*;
import gameObjects.Personaje.Aliado.*;

public class Nivel extends Thread {
	
	private Mapa mapa; // Un solo mapa y muchos niveles o como hacemos ?¿
	private ObjetoDelMapa[] objetos; // Coleccion de objetos aleatorios a poner en el mapa
	private Horda[] hordas; // Almacena las hordas del nivel
	private ArrayList<Enemigo> listaDeEnemigos; // Lista que almacena enemigos para que avancen
	private int dificultad; // La dificultad hace variar la cantidad de enemigos entre otras cosas
	private int nivelActual; // Nivel actual, para saber que horda liberar
	
	public Nivel(Mapa m) {
		mapa = m;
		listaDeEnemigos = new ArrayList<Enemigo>();
		
	}
	
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
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
		
		Celda c = mapa.AgregarEnemigo();
		Enemigo e = new Enemigo1(c.getX(), c.getY(), mapa);
		listaDeEnemigos.add(e);
		mapa.setObjetoEnCelda(c.getX(), c.getY(), e);
		
		for(int i = 0; i < listaDeEnemigos.size(); i++)
			System.out.println(listaDeEnemigos.get(i).toString());
	}
	
	public Image CrearAliado(Image i, int x, int y) {
		Celda c = mapa.AgregarAliado(x, y);
		Aliado a = new Aliado1();
		
		mapa.setObjetoEnCelda(x, y, a);
		
		return i;
	}
	
	public Image[][] GetImagenes(){
		Image[][] arregloDeImagenes = new Image[10][6];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 6; j++) {
				arregloDeImagenes[i][j] = mapa.getImage(i, j); 
			}
		}
		return arregloDeImagenes;
	}
}
