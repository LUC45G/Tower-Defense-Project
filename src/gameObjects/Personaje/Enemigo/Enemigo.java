package gameObjects.Personaje.Enemigo;
import gameObjects.Item.Premio.Premio;
import gameObjects.Personaje.Personaje;
import logic.Celda;
import logic.Mapa;

public abstract class Enemigo extends Personaje {

	protected Premio premio;
	protected Mapa mapa;
	protected Celda celda;
	
	/* Constructor */
	public Enemigo(Celda c, Mapa m) {
		mapa = m;
		celda = c;
	}
	
	public Enemigo(Celda c, Mapa m, Premio p) {
		mapa = m;
		celda = c;
		premio = p;
	}
	
	/* Consultas */
	
	/* Comandos */
	
	public void Avanzar() {
		
		if ( mapa.PuedoAvanzar(celda.getX(), celda.getY()) ) {
			mapa.Avanzar(celda.getX(), celda.getY());
		}
	}
}
