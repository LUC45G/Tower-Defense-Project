package gameObjects.Item.Obstaculo;

import Visitor.Visitor;
import gameObjects.Item.Item;

public abstract class Obstaculo extends Item {
	protected int vida;
	public void recibirAtaque() {
		vida--;
	}
	public void aceptar(Visitor v) {
		v.visitarObstaculo(this);
	}
}
