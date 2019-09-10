package gameObjects.Personaje;

import gameObjects.ObjetoDelJuego;

public abstract class Personaje extends ObjetoDelJuego {
	protected int vida;
	protected int damage;
	protected int rango;
	
	public abstract void atacar();
}
