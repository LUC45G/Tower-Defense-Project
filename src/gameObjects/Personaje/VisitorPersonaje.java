package gameObjects.Personaje;
import gameObjects.Personaje.Aliado.Aliado;
import gameObjects.Personaje.Enemigo.Enemigo;

public class VisitorPersonaje extends Visitor{
	public void visitarEnemigo(Enemigo e) {
		e.recibirAtaque(); //que parametro deberia recibir??
	}
	public void visitarAliado(Aliado a) {
		a.recibirAtaque();
	}
}