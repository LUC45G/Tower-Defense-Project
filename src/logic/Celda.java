package logic;
import java.awt.Image;

import gameObjects.ObjetoDelJuego;

public class Celda {
	
	protected ObjetoDelJuego objetoActual; // El objeto que actualmente esta en la celda
	protected int x, y; // Las coordenadas de la celda
	protected Image img;
	
	/* Constructor */
	
	public Celda(int x, int y ) {
		this.x = x;
		this.y = y;
		img = null;
	}
	
	/* Consultas */
	
	public int getX() { return x; }
	public int getY() { return y; }
	public ObjetoDelJuego getObjetoActual() { return objetoActual; }
	public boolean estaDisponible() { return objetoActual == null; }
	public Image getImagen() {
		if(objetoActual == null) 
			return img;
		else 
			return objetoActual.getImagen();
	}
	
	/* Comandos */
	public void SetObjetoActual(ObjetoDelJuego j) { objetoActual = j; }
	public void EliminarObjetoActual() { objetoActual = null; }
	
	

}
