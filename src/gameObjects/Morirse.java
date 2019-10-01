package gameObjects;
import Observer.*;
import logic.*;

public class Morirse implements IObserver{
	protected Mapa map;
	protected ObjetoDelJuego objeto;
	
	public void update() {
		map.eliminarObjeto(objeto);
	}
}
