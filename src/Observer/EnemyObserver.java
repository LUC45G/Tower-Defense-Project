package Observer;

import gameObjects.ObjetoDelJuego;
import logic.Nivel;

public class EnemyObserver implements IObserver {

	protected Nivel nivel;
	
	public EnemyObserver() {
		nivel = Nivel.getNivel();
	}
	@Override
	public void update(ObjetoDelJuego obj) {
		nivel.Eliminar(obj);
	}

}
