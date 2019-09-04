package gameObjects;
import logic.Celda;
import logic.Mapa;

public abstract class Enemigo extends Personaje {

	protected Premio premio;
	protected Mapa mapa;
	protected Celda celda;
	
	/* Constructor */
	
	/* Consultas */
	
	/* Comandos */
	
	public void Avanzar() {
		
		if ( mapa.PuedoAvanzar(celda.getX(), celda.getY()) ) {
			mapa.Avanzar(celda.getX(), celda.getY());
		}
	}
}
