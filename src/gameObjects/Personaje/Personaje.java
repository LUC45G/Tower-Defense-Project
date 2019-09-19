package gameObjects.Personaje;

import gameObjects.ObjetoDelJuego;
import Visitor.*;
public abstract class Personaje extends ObjetoDelJuego {
	protected int vida;
	protected int damage;
	protected int rango;
	protected Visitor proyectil;
	
	public abstract void atacar();
	public void recibirAtaque() {
		vida--;
	};
}
