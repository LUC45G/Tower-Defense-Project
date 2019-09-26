package logic;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JLabel;

import gameObjects.ObjetoDelMapa.*;
import gameObjects.Personaje.Enemigo.*;
import gameObjects.Personaje.Aliado.*;
import gameObjects.ObjetoDelJuego;
import javax.swing.ImageIcon;


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
				Thread.sleep(2000);
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
		
		ObjetoDelJuego c = mapa.AgregarEnemigo();
		Enemigo e = new Enemigo1(c.getX(), c.getY(), mapa);
		listaDeEnemigos.add(e);
		mapa.setObjeto(c.getX(), c.getY(), e);
		
	}
	
	//El aliado sabe sus coordenadas x,y y conoce al mapa 
	public Image CrearAliado(Image i, int x, int y) {
		ObjetoDelJuego c = mapa.AgregarAliado(x, y);
		Aliado a = new Aliado1(x,y,mapa);
		
		mapa.setObjeto(x, y, a);
		
		return i;
	}
	
	public void EliminarTodosLosEnemigos() {
		for(int i = 0; i < listaDeEnemigos.size(); i++) { 
			mapa.limparObjeto(listaDeEnemigos.get(i).getX(), listaDeEnemigos.get(i).getY());
			listaDeEnemigos.remove(i);
		}
	}
	
	//Lo ideal sería que mapa.getImage() devuelva un JLabel con una imagen dentro
	public JLabel[][] GetImagenes(){
		JLabel[][] imagenes = new JLabel[10][6];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 6; j++) {
				imagenes[i][j] = mapa.getImage(i, j); //getImage puede retornar null
			}
		}
		return imagenes;
	}
}
