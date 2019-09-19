package Visitor;
import gameObjects.Item.Obstaculo.Obstaculo;
import gameObjects.ObjetoDelMapa.ConVida.ConVida;
import gameObjects.Personaje.Aliado.Aliado;
import gameObjects.Personaje.Enemigo.Enemigo;

public class VisitorDisparo extends Visitor{
	
	public void visitarEnemigo(Enemigo e) { //visita un enemigo
		e.recibirAtaque(); 
	}
	
	public void visitarAliado(Aliado a) {
		a.recibirAtaque();
	}
	
	public void visitarObjetoConVida(ConVida omcv) {
		omcv.recibirAtaque();
	}

	@Override
	public void visitarObstaculo(Obstaculo obs) {
		// TODO Auto-generated method stub
		
	}

}