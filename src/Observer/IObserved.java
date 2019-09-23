package Observer;
/**
 * 
 * @author matia
 *
 *	Interfaz que modela objetos Observables por objetos observadores
 */
public interface IObserved {
	/**
	 * Agrega un observador
	 * @param observador elemento encargado de observar al objeto
	 */
	public void agregarObservador(IObserver observador);
	/**
	 * Eliminar un observador
	 * @param observador elemento que se desea eliminar
	 */
	public void eliminarObservador(IObserver observador);
	/**
	 * Metodo que notifica de un cambio en el observado (agregado o eliminacion de observadores)
	 */
	public void notificar();
}
