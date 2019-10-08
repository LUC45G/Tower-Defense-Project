package gameObjects;
import Observer.*;
import logic.*;

public class Morirse implements IObserver{
	protected Mapa map;
	
	public Morirse() {
		map = Mapa.getMapa();
	}
	
	public void update(ObjetoDelJuego obj) {
		map.EliminarObjetoDelJuego(obj);
	}
}
