package Visitor;

import gameObjects.Item.Obstaculo.Obstaculo;
import gameObjects.ObjetoDelMapa.ConVida.ConVida;
import gameObjects.Personaje.Aliado.Aliado;
import gameObjects.Personaje.Enemigo.Enemigo;

public class VisitorEnemigo extends Visitor {

	@Override
	public void visitarEnemigo(Enemigo e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visitarAliado(Aliado a) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visitarObjetoConVida(ConVida cv) {
		// TODO Auto-generated method stub
	}

	public void visitarObstaculo(Obstaculo obs) {
		obs.recibirAtaque();
	}
	
}
