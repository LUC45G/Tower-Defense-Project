package gameObjects.Personaje.Aliado;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Aliado1 extends Aliado{
	
	/* Constructor */

	public Aliado1() {
		vida = 100;
		damage = 1;
		rango = 3;
		costo = 750500;
		
		try {
			img = ImageIO.read(getClass().getResource("/images/p1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void atacar() {

	}
	
	
}
