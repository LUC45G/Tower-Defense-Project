package gameObjects.Personaje.Enemigo;

import java.awt.Rectangle;
import java.io.IOException;
import javax.imageio.ImageIO;
import logic.Mapa;

public class Enemigo1 extends Enemigo {

	public Enemigo1(int x, int y, Mapa m) {
		super(x, y, m);
		
		try {
			img = ImageIO.read(getClass().getResource("/images/s.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int w = img.getWidth(null);
		int h = img.getHeight(null);
		//y fijo, altura fijo, anchura fijo, solo cammbia la coordenada x
		rectangulo = new Rectangle (0,0,-w,-h);//x,y,widht,height
	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void eliminar() {
		super.eliminar();
		// Delega a Personaje que lo elimine del mapa,
		// despues calcula si tiene que dropear item, oro o lo que sea
	}

	@Override
	public void notificar() {
		// TODO Auto-generated method stub
		
	}

	
}
