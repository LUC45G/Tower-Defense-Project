package Visitor;
import gameObjects.ObjetoDelMapa.ConVida.ConVida;
import gameObjects.Personaje.Aliado.Aliado;
import gameObjects.Personaje.Enemigo.Enemigo;

public abstract class Visitor{
	public abstract void visitarEnemigo(Enemigo e);
	public abstract void visitarAliado(Aliado a);
	public abstract void visitarObjetoConVida(ConVida cv);
}