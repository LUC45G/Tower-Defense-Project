package gameObjects.Personaje.Enemigo;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import logic.Celda;
import logic.Mapa;

public class Enemigo1 extends Enemigo {

	public Enemigo1(int a, int b, Mapa m) {
		super(a, b, m);
		
		try {
			img = ImageIO.read(getClass().getResource("/images/p1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}

	
}