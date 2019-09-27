package gameObjects;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;

import Observer.IObserved;
import Observer.IObserver;
import Visitor.Visitor;
import logic.Mapa;
import java.awt.Rectangle;

public abstract class ObjetoDelJuego implements IObserved{
	
	//Como no hay celdas los objetos del juego deber�an saber en que posici�n est�n
	protected Image img;
	protected Rectangle rectangulo;
	protected int x, y;
	protected Mapa mapa;
	protected ArrayList<IObserver> observadores = new ArrayList<IObserver>();
	public void aceptar(Visitor v) {} //Is this right??
	
	public Image getImagen() {//habria que ver != null 
		return img; 
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
}
