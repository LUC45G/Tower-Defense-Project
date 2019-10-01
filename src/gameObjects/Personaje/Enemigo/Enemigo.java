package gameObjects.Personaje.Enemigo;
import gameObjects.Item.Premio.Premio;
import gameObjects.Personaje.Personaje;
import logic.Celda;
import logic.Mapa;
import Visitor.*;

public abstract class Enemigo extends Personaje {

	protected Premio premio;
	
	
	/* Constructor */
	public Enemigo(int xx, int yy, Mapa m) {
		mapa = m;
		x = xx; 
		y = yy;
		img = null;
	}
	
	public Enemigo(int xx, int yy, Mapa m, Premio p) {
		mapa = m;
		x = xx; 
		y = yy;
		premio = p;
	}
	
	/* Consultas */
	
	/* Comandos */
	public void aceptar(Visitor v) {
		v.visitarEnemigo(this);
	}
	
	public void Avanzar() {
		if(mapa.PuedoAvanzar(rectangulo) ) {
			mapa.Avanzar(rectangulo);
			System.out.println("Enemigo movido");
		}
	}

	public void recibirAtaque() {
		return;
	}
	
}
