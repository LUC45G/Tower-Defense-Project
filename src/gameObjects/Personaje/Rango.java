package gameObjects.Personaje;

import Observer.IObserver;
import Visitor.VisitorDisparo;
/**
 * 
 * @author matia
 *	Clase que modela el rango de vision que tiene un personaje
 */
public class Rango implements IObserver{
	
	//public rectangulo [] alcance;
	public VisitorDisparo tiro;
	public Personaje miPersonaje; //es muy trucho esto?
	/**
	 * Constructor con un visitador de disparo (creo) y un personaje que contenga al rango
	 * @param proyectil visitador que va a "recorrer" el alcance
	 * @param per 	Personaje dueño del rango
	 */
	public Rango(VisitorDisparo proyectil, Personaje per) {
		tiro=proyectil;
		miPersonaje=per;
		//agregar la creacion del alcance
	}
	
	//Comandos
	//ya esta comentado
	public void update() {//puede hacer mas cosas esta en veremos
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
