package Visitor;

import gameObjects.Item.Obstaculo.Obstaculo;
import gameObjects.ObjetoDelMapa.ConVida.ConVida;
import gameObjects.Personaje.Aliado.Aliado;
import gameObjects.Personaje.Enemigo.Enemigo;

public class VisitorClick extends Visitor {

	@Override
	public void visitarEnemigo(Enemigo e) {
		e.eliminar(); //implementar metodo eliminar y ver si es mas general
	}

	@Override
	public void visitarAliado(Aliado a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitarObjetoConVida(ConVida cv) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitarObstaculo(Obstaculo obs) {
		// TODO Auto-generated method stub

	}

}
