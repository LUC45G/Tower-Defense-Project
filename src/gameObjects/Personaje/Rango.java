package gameObjects.Personaje;

import java.util.ArrayList;

import Observer.IObserver;
import Visitor.VisitorDisparo;
import gameObjects.ObjetoDelJuego;
import logic.Mapa;
/**
 * 
 * @author matia
 *	Clase que modela el rango de vision que tiene un personaje
 */
public class Rango implements IObserver{
	
	protected int vision;
	protected ArrayList<ObjetoDelJuego> alcance;
	protected VisitorDisparo tiro;
	protected Personaje miPersonaje; //es muy trucho esto?
	private ObjetoDelJuego[][] m;
	/**
	 * Constructor con un visitador de disparo (creo) y un personaje que contenga al rango
	 * @param proyectil visitador que va a "recorrer" el alcance
	 * @param per 	Personaje dueño del rango
	 */
	public Rango(VisitorDisparo proyectil, Personaje per, int vision) {
		tiro=proyectil;
		miPersonaje=per;
		//consigo el mapa
		m=miPersonaje.getMapa();
		int x=miPersonaje.getX();
		int y=miPersonaje.getY();
		for(int i=0; i <= vision; i++) {
			
		}
		//agregar la creacion del alcance
	}
	
	//Comandos
	//ya esta comentado
	public void update(ObjetoDelJuego obj) {//puede hacer mas cosas esta en veremos
		reaccionar(miPersonaje);
		
	}
	/**
	 * Reacciona a la entrada de un personaje en el alcance
	 * @param p personaje que se encontro en el alcance
	 */
	public void reaccionar(Personaje p) {
		p.aceptar(tiro);;
	}

}
