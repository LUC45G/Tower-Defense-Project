package gameObjects.Item.Obstaculo;

import gameObjects.Item.Item;

public abstract class Obstaculo extends Item {
	protected int vida;
	public void recibirAtaque() {
		vida--;
	}
}
