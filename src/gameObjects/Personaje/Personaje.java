package gameObjects.Personaje;

import gameObjects.ObjetoDelJuego;
import Observer.IObserver;
import Visitor.*;
public abstract class Personaje extends ObjetoDelJuego {
	protected int vida;
	protected int damage;
	protected Rango rango;
	protected VisitorDisparo proyectil;
	
	public abstract void atacar();
	
	public void recibirAtaque() {
		vida--;
	}
	
	public void eliminar() {
		// Elimina al personaje del mapa
	}
	
	public ObjetoDelJuego[][] getMapa() {
		return mapa.getMapa();
	}
}
