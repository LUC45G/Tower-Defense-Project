package logic;
import gameObjects.ObjetoDelJuego;

public class Celda {
	
	protected ObjetoDelJuego objetoActual; // El objeto que actualmente esta en la celda
	protected int x, y; // Las coordenadas de la celda
	
	/* Constructor */
	
	/* Consultas */
	
	public int getX() { return x; }
	public int getY() { return y; }
	public ObjetoDelJuego getObjetoActual() { return objetoActual; }
	public boolean estaDisponible() { return objetoActual == null; }
	
	/* Comandos */
	public void SetObjetoActual(ObjetoDelJuego j) { objetoActual = j; }
	public void EliminarObjetoActual() { objetoActual = null; }
	
	

}
