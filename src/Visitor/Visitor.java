package Visitor;
import gameObjects.Personaje.Aliado.Aliado;
import gameObjects.Personaje.Enemigo.Enemigo;

public abstract class Visitor{
	public abstract void visitarEnemigo(Enemigo e);
	public abstract void visitarAliado(Aliado a);
}