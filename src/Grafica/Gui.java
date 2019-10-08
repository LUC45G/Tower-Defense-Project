package Grafica;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import gameObjects.ObjetoDelJuego;
import gameObjects.Personaje.Enemigo.Enemigo;
import logic.Mapa;
import logic.Nivel;

import java.awt.Color;

import java.awt.Rectangle;
public class Gui {

	private JFrame frame;
	private JPanelClickeable panelMapa;
	private Image currentCharacter;
	private Nivel nivel;
	private JLabel lblScore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		nivel = Nivel.getNivel( Mapa.getMapa(this) );
		nivel.start();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelPersonajes = new JPanel();
		panelPersonajes.setBounds(0, 0, 141, 318);
		frame.getContentPane().add(panelPersonajes);
		
		JButton btnPersonaje1 = new JButton("Seleccionar aliado");
		btnPersonaje1.addActionListener(new btn1AL()); 
		panelPersonajes.setLayout(new GridLayout(0, 1, 0, 0));
		panelPersonajes.add(btnPersonaje1);
		
		JButton btnPersonaje2 = new JButton("Spawnear enemigo");
		btnPersonaje2.addActionListener(new btn2AL());
		panelPersonajes.add(btnPersonaje2);
		
		JButton btnPersonaje3 = new JButton("Eliminar enemigo");
		btnPersonaje3.addActionListener(new btn3AL());
		panelPersonajes.add(btnPersonaje3);
		
		JButton btnPersonaje4 = new JButton("4");
		panelPersonajes.add(btnPersonaje4);
		
		JButton btnPersonaje5 = new JButton("5");
		panelPersonajes.add(btnPersonaje5);
		panelMapa = new JPanelClickeable();
		panelMapa.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(currentCharacter!=null) {
					nivel.CrearAliado(currentCharacter, 9, 6);
					System.out.println("clikeado");
				}
			}
		});
		panelMapa.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMapa.setBounds(192, 0, 692, 551);
		panelMapa.setLayout(null);
		
		JPanel panelScore = new JPanel();
		panelScore.setBounds(0, 338, 141, 213);
		frame.getContentPane().add(panelScore);
		frame.getContentPane().add(panelMapa);
		
		lblScore = new JLabel("Score: 0");
		panelScore.add(lblScore);
		
		currentCharacter = null;
		
	}
	
	
	public void ActualizarGrafica() {
		JLabel dibujo;
		panelMapa.removeAll();
		for (ObjetoDelJuego pos: nivel.getObjetosDelMapa()) {
				if( pos != null) {
					dibujo = new JLabel();
					//dibujo.setBounds(pos.getHitBox());
					dibujo.setBounds(pos.getX(),pos.getY(),70,70);
					dibujo.setIcon(new ImageIcon(pos.getImagen()));
					panelMapa.add(dibujo);
				}	
			}
		panelMapa.repaint();
	}
	
	private class btn1AL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
			
				currentCharacter = ImageIO.read(getClass().getResource("/images/s.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	private class btn2AL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			Enemigo e=nivel.CrearEnemigo();
			/*nivel.HordaHardcodeada();
			JLabel dib=new JLabel();
			dib.setBounds(e.getHitBox());
			dib.setIcon(new ImageIcon(e.getImagen()));
			panelMapa.add(dib);*/
			panelMapa.repaint();
			
		}
	}
	
	private class btn3AL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			//nivel.Eliminar(ObjetoDelJuego o);
			nivel.EliminarTodosLosEnemigos();
			panelMapa.repaint();
		}
	}
		
		
}
