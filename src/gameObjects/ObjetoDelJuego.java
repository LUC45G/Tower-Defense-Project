package gameObjects;

import java.awt.Image;

import Visitor.Visitor;
import logic.Mapa;

public abstract class ObjetoDelJuego {
	
	//Como no hay celdas los objetos del juego deberían saber en que posición están
	protected Image img;
	protected int x, y;
	protected Mapa mapa;
	
	public void aceptar(Visitor v) {} //Is this right??
	public Image getImagen() { 
		return img; 
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
