package gameObjects.Personaje.Aliado;

import gameObjects.Personaje.Personaje;
import logic.Mapa;
import Visitor.*;

public abstract class Aliado extends Personaje {
	
	protected int costo;
	
	/* Constructor */
	public Aliado(int xx, int yy, Mapa m) {
		mapa = m;
		x = xx; 
		y = yy;
	}
	
	public void aceptar(Visitor v) {
		v.visitarAliado(this);
	}


	public void recibirAtaque() {
		return;
		
	}

}