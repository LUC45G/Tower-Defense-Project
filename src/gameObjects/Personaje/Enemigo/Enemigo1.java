package gameObjects.Personaje.Enemigo;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import logic.Celda;
import logic.Mapa;

public class Enemigo1 extends Enemigo {

	public Enemigo1(int x, int y, Mapa m) {
		super(x, y, m);
		
		try {
			img = ImageIO.read(getClass().getResource("/images/s.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}

	
}
