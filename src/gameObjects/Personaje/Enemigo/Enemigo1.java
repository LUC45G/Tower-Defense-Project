package gameObjects.Personaje.Enemigo;

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
