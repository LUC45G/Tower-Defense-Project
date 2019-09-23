package gameObjects.Personaje.Aliado;

import java.io.IOException;

import javax.imageio.ImageIO;

import gameObjects.Personaje.Rango;

public class Aliado1 extends Aliado{
	
	/* Constructor */

	public Aliado1() {
		vida = 100;
		damage = 1;
		costo = 750500;
		rango=new Rango(proyectil,this);
		
		try {
			img = ImageIO.read(getClass().getResource("/images/p1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void atacar() {
		
	}
	
	
}
