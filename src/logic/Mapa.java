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
	private Mapa(Gui g) {
		gui = g;
	}
	
	/* Consultas */
	
	/**
	 * Devuelve la instancia del mapa. Si no esta creada, la crea.
	 * @param g GUI
	 * @return Mapa
	 */
	public static Mapa getMapa( Gui g ) {

		if(INSTANCE == null)
			INSTANCE = new Mapa(g);
		
		return INSTANCE;
	}
	
	/**
	 * Devuelve la instancia del mapa. Asume que ya esta creada
	 * @return Mapa
	 */
	public static Mapa getMapa() {
		return INSTANCE;
	}
	
	
	/**
	 * @return una lista con todos los objetos del juego activos al momento
	 */
	public ArrayList<ObjetoDelJuego> getGameObjects() { return gameObjects; }
	
	/**
	 * @param r el rectangulo del gameObject
	 * @return si puede avanzar o no
	 */
	public boolean PuedoAvanzar(Rectangle r) {
		// Verifica que la siguiente posición esté disponible TODO
		boolean colisiona = false;
		int i = 0;
		Rectangle auxRectangle = new Rectangle( r.x+7, r.y, r.height, r.width );
		ArrayList<ObjetoDelJuego> all = (ArrayList<ObjetoDelJuego>) Nivel.getNivel(INSTANCE).getObjetosDelMapa();
		
		while ( !colisiona && i < all.size()) {
			colisiona = auxRectangle.intersects(all.get(i++).getHitBox());
		}
		
		
		return !colisiona;
	}
	
	/* Comandos */
	
	/**
	 * Avanza al personaje y actualiza la grafica
	 * @param r la hitbox del personaje para poder moverlo
	 */
	public void Avanzar(Rectangle r) {
		// Requiere que se haya verificado que puede avanzar
		r.setBounds(r.getBounds().x - 7, r.getBounds().y, r.getBounds().width, r.getBounds().height);
		gui.ActualizarGrafica();
	}
	
	/**
	 * Agrega un enemigo al final
	 * @return el enemigo agregado
	 */
	public ObjetoDelJuego AgregarEnemigo() { 
		Random r = new Random();
		int y = r.nextInt(6);
		ObjetoDelJuego e = new Enemigo1(600, y*90, INSTANCE);
		// gameObjects.add(e);
		gui.ActualizarGrafica();
		return e;
	}
	
	
	//Crea el aliado y lo retorna
	public ObjetoDelJuego AgregarAliado(int x, int y) { //retorna el aliado
		Aliado a = new Aliado1(x,y,INSTANCE);
		gameObjects.add(a);
		gui.ActualizarGrafica();
		return a;
		
	}
	
	public void Update() {
		gui.ActualizarGrafica();
	}
	
	public void EliminarObjetoDelJuego(ObjetoDelJuego obj) {
		gameObjects.remove(obj);
	}
	
	//En vez de retornar una Image retorna un JLabel con la imagen dentro
	public JLabel getImage() {
		return null;
	}
}
