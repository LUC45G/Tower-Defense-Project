package logic;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import gameObjects.ObjetoDelJuego;
import gameObjects.Personaje.Enemigo.Enemigo1;
import Grafica.Gui;
import gameObjects.Personaje.Aliado.*;

public class Mapa {
	/* El mapa tiene que tener un Singleton, es decir, solo una instancia de mapa a la vez */
	
	
	private static final ObjetoDelJuego [][] MAPA = new ObjetoDelJuego[10][6]; // 10x6 Minimo
	private static Mapa INSTANCE = null; // se asegura de que haya un solo mapa
	private Gui gui;
	
	/* Constructor */
	// El mapa tiene todo null al crearse
	
	public Mapa( Gui g ) {
		if(INSTANCE!= null)
			System.out.println("Error");
		gui = g;
		INSTANCE = this;		
	}
	
	/* Consultas */
	
	public Mapa getInstance() { return INSTANCE; }
	
	public ObjetoDelJuego[][] getMapa() { return MAPA; }
	
	public boolean PuedoAvanzar(int x, int y) {
		// Verifica que la siguiente posición esté disponible
		if(x!=0)
			return MAPA[x-1][y] == null;
		else 
			return false;
	}
	
	/* Comandos */
	
	public void Avanzar(int x, int y) {
		// Requiere que se haya verificado que puede avanzar
		
		ObjetoDelJuego aux = MAPA[x][y];
		MAPA[x][y] = null;
		MAPA[x-1][y] = aux;
		
		gui.ActualizarGrafica();
		
	}
	
	public ObjetoDelJuego AgregarEnemigo() { //retorna el enemigo
		Random r = new Random();
		int y = r.nextInt(6);
		ObjetoDelJuego e = new Enemigo1(9, y, this);
		gui.ActualizarGrafica();
		return e;
	}
	//Crea el aliado y lo retorna
	public ObjetoDelJuego AgregarAliado(int x, int y) { //retorna el aliado
		Aliado a = new Aliado1(x,y,this);
		gui.ActualizarGrafica();
		return a;
		
	}
	
	public void Update() {
		gui.ActualizarGrafica();
	}
	
	public void setObjeto(int x, int y, ObjetoDelJuego e) {
		MAPA[x][y] = e;
	}
	
	public void limparObjeto(int x, int y) {
		MAPA[x][y] = null;
	}
	
	//En vez de retornar una Image retorna un JLabel con la imagen dentro
	public JLabel getImage(int x, int y) {
		if (MAPA[x][y] != null) {
			return new JLabel( new ImageIcon( MAPA[x][y].getImagen() ) );
		}
		return null;
	}
	
	/*public void AvanzarEnemigos() {
		gui.AvanzarEnemigos();
	}*/
	

}
