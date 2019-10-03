package Observer;
import gameObjects.ObjetoDelJuego;

/**
 * 
 * @author matia
 *
 * Interfaz que modela objetos observadores encargados de observar objetos observados
 * 
 */
public interface IObserver {
	/**
	 * Metodo donde se realizara la operacion designada para el cambio de estado
	 */
	public void update(ObjetoDelJuego obj);
}
