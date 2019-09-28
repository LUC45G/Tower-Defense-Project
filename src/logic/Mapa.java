package logic;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import gameObjects.ObjetoDelJuego;
import gameObjects.Personaje.Enemigo.Enemigo1;
import Grafica.Gui;
import gameObjects.Personaje.Aliado.*;

public class Mapa {
	/* El mapa tiene que tener un Singleton, es decir, solo una instancia de mapa a la vez */
	
	
	private static final ArrayList<ObjetoDelJuego> gameObjects = new ArrayList<ObjetoDelJuego>();
	private static Mapa INSTANCE = null; // se asegura de que haya un solo mapa
	private Gui gui;
	
	/* Constructor */
	// El mapa tiene todo null al crearse
	
	public Mapa( Gui g ) {
		if(INSTANCE!= null)
			System.out.println("Error");
		gui = g;
		INSTANCE = this;		
	}
	
	/* Consultas */
	
	/**
	 * @return la instancia de mapa
	 */
	public Mapa getInstance() { return INSTANCE; }
	
	/**
	 * @return una lista con todos los objetos del juego activos al momento
	 */
	public ArrayList<ObjetoDelJuego> getMapa() { return gameObjects; }
	
	/**
	 * @param r el rectangulo del gameObject
	 * @return si puede avanzar o no
	 */
	public boolean PuedoAvanzar(Rectangle r) {
		// Verifica que la siguiente posición esté disponible
		
		
		return false;
	}
	
	/* Comandos */
	
	/**
	 * Avanza al personaje y actualiza la grafica
	 * @param r la hitbox del personaje para poder moverlo
	 */
	public void Avanzar(Rectangle r) {
		// Requiere que se haya verificado que puede avanzar
		r.getBounds().x -= 7;
		gui.ActualizarGrafica();
	}
	
	/**
	 * Agrega un enemigo al final
	 * @return
	 */
	public ObjetoDelJuego AgregarEnemigo() { //retorna el enemigo
		Random r = new Random();
		int y = r.nextInt(6);
		ObjetoDelJuego e = new Enemigo1(9, y, this);
		gui.ActualizarGrafica();
		return e;
	}
	//Crea el aliado y lo retorna
	public ObjetoDelJuego AgregarAliado(int x, int y) { //retorna el aliado
		Aliado a = new Aliado1(x,y,this);
		gui.ActualizarGrafica();
		return a;
		
	}
	
	public void Update() {
		gui.ActualizarGrafica();
	}
	
	
	
	public void limparObjeto(int x, int y) {
		
	}
	
	//En vez de retornar una Image retorna un JLabel con la imagen dentro
	public JLabel getImage() {
		return null;
	}
}
