package gameObjects.Personaje.Aliado;

import java.io.IOException;


import javax.imageio.ImageIO;

import gameObjects.Personaje.Rango;

import logic.Mapa; 
import java.awt.Rectangle;
public class Aliado1 extends Aliado{
	
	/* Constructor */

	public Aliado1(int x, int y, Mapa m) {
		super(x,y,m);
		vida = 100;
		damage = 1;
		costo = 750500;
		rango=new Rango(proyectil,this,1);
		
		try {
			img = ImageIO.read(getClass().getResource("/images/p1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int w = img.getWidth(null);
		int h = img.getHeight(null);
		//y fijo, altura fijo, anchura fijo, solo cammbia la coordenada x
		rectangulo = new Rectangle (0,0,-w,-h);//x,y,widht,height
	}
	
	public void atacar() {
		
	}

	@Override
	public void notificar() {
		// TODO Auto-generated method stub
		
	}
	
	
}
