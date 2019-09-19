package gameObjects.ObjetoDelMapa.ConVida;

import gameObjects.ObjetoDelMapa.ObjetoDelMapa;

public abstract class ConVida extends ObjetoDelMapa {
	protected int vida;
	public void recibirAtaque() {
		vida--;
	}

}
