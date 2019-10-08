package gameObjects;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import Observer.IObserved;
import Observer.IObserver;
import Visitor.Visitor;
import logic.Mapa;

public abstract class ObjetoDelJuego implements IObserved{
	
	//Como no hay celdas los objetos del juego deberían saber en que posición están
	protected Image img;
	protected Rectangle rectangulo;
	protected int x, y;
	protected Mapa mapa;
	protected ArrayList<IObserver> observadores = new ArrayList<IObserver>();
	protected IObserver observer;
	
	public void aceptar(Visitor v) {} //Is this right??
	
	public Image getImagen() {//habria que ver != null 
		if(img == null) {
			System.out.println("NULA IMAGEN");
			return null;
		}
		return img; 
	}
	public void setImagen(Image i) {
		img=i;
	}
	public void agregarObservador(IObserver obs) {
		observadores.add(obs);
	}
	public void eliminarObservador(IObserver obs) {
		Iterator<IObserver> it=observadores.iterator();
		boolean find=false;
		IObserver aux=null;
		int posicionActual=0;
		while(!find && it.hasNext()) {
			aux=it.next();
			if(aux==obs) {
				observadores.remove(posicionActual);
				find=true;
			}
			posicionActual++;
		}
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	//devuelve el rectangulo
	public Rectangle getHitBox() {
		return rectangulo;
	}
	
	public void notificar () {//elimina el personaje del mapa
		observer.update(this);	
	}
}
