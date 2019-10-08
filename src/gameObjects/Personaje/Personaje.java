package gameObjects.Personaje;

import gameObjects.ObjetoDelJuego;
import Observer.IObserver;
import Visitor.*;
public abstract class Personaje extends ObjetoDelJuego {
	protected int vida;
	protected int damage;
	protected Rango rango;
	protected VisitorDisparo proyectil;
	protected IObserver eliminar;
	
	public abstract void atacar();
	
	public void recibirAtaque() {
		vida--;
	}
	
	public ObjetoDelJuego[][] getMapa() {
		return null; //return mapa.getMapa();
	}
	
	public void notificar() {}
}
