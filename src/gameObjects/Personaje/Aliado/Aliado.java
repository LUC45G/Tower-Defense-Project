package gameObjects.Personaje.Aliado;

import gameObjects.Personaje.Personaje;
import Visitor.*;

public abstract class Aliado extends Personaje {
	
	protected int costo;
	
	
	public void aceptar(Visitor v) {
		v.visitarAliado(this);

	}


	public void recibirAtaque() {
		return;
		
	}

}