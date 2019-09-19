package gameObjects;

import java.awt.Image;

public abstract class ObjetoDelJuego {

	protected Image img;
	
	public void aceptar(ObjetoDelJuego gobj) {} //Is this right??
	public Image getImagen() { 
		return img; 
	}
}
