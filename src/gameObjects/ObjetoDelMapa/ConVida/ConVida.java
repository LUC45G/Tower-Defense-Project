package gameObjects.ObjetoDelMapa.ConVida;

import Visitor.Visitor;
import gameObjects.ObjetoDelMapa.ObjetoDelMapa;

public abstract class ConVida extends ObjetoDelMapa {
	protected int vida;
	public void recibirAtaque() {
		vida--;
	}
	
	public void aceptar(Visitor v) {
		v.visitarObjetoConVida(this);
	}

}
