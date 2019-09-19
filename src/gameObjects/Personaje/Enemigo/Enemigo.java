package gameObjects.Personaje.Enemigo;
import gameObjects.Item.Premio.Premio;
import gameObjects.Personaje.Personaje;
import gameObjects.Personaje.Visitor;
import logic.Celda;
import logic.Mapa;

public abstract class Enemigo extends Personaje {

	protected Premio premio;
	protected Mapa mapa;
	protected int x, y;
	
	/* Constructor */
	public Enemigo(int a, int b, Mapa m) {
		mapa = m;
		x = a; 
		y = b;
	}
	
	public Enemigo(int a, int b, Mapa m, Premio p) {
		mapa = m;
		x = a; 
		y = b;
		premio = p;
	}
	
	/* Consultas */
	
	/* Comandos */
	public void aceptar(Visitor v) {
		v.visitarEnemigo(this);
	}
	public void Avanzar() {
		
		if ( mapa.PuedoAvanzar(x, y) ) {
			System.out.println("x: "+ x+ " y: " + y);
			mapa.Avanzar(x, y);
			x--;
		}
	}

	public void recibirAtaque() {
		return;
	}
}
