package gameObjects;

import java.awt.Image;

import Visitor.Visitor;

public abstract class ObjetoDelJuego {

	protected Image img;
	
	public void aceptar(Visitor v) {} //Is this right??
	public Image getImagen() { 
		return img; 
	}
}
