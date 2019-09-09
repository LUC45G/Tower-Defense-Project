package logic;
import java.util.*;
import gameObjects.Personaje.Enemigo.*;


public class Horda {
	
	private List<Enemigo> horda; // Coleccion de enemigos a salir en el nivel
	
	public Horda(int q, Mapa m) {
		for(int i = 0; i < q; i++) {
			Celda c = new Celda(10, 1);
			Enemigo e = new Enemigo1(c, m);
			c.SetObjetoActual(e);
			
			m.AgregarEnemigo();
		}
	}

}
