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
	 * @return la instancia de mapa
	 */
	public static Mapa getMapa( Gui g ) {

		if(INSTANCE == null)
			INSTANCE = new Mapa(g);
		
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
		Rectangle auxRectangle = new Rectangle( r.x-7, r.y, r.height, r.width );
		ArrayList<ObjetoDelJuego> all = (ArrayList<ObjetoDelJuego>) Nivel.getNivel(INSTANCE).getObjetosDelMapa();
		
		System.out.println(all.size());
		
		while ( !colisiona && i < all.size()) {
			if(all.get(i).getHitBox() != r) {
				System.out.println("Es distinto");
				colisiona = auxRectangle.intersects(all.get(i++).getHitBox());
			}
		}
		
		if(colisiona)
			System.out.println("Detecto algo");
		
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
	
	
	
	public void limparObjeto(int x, int y) {
		
	}
	
	//En vez de retornar una Image retorna un JLabel con la imagen dentro
	public JLabel getImage() {
		return null;
	}
}
