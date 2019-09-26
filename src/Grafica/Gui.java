package Grafica;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JPanel panelMapa;
	private Image currentCharacter;
	private Nivel nivel;
	private JLabel[][] labels;
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
		
		nivel = new Nivel( new Mapa(this) );
		nivel.start();
		labels = new JLabel[10][6];
		
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
		
		panelMapa = new JPanel();
		panelMapa.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMapa.setBounds(192, 0, 692, 551);
		panelMapa.setLayout(null);
		frame.getContentPane().add(panelMapa);
		
		JPanel panelScore = new JPanel();
		panelScore.setBounds(0, 338, 141, 213);
		frame.getContentPane().add(panelScore);
		
		lblScore = new JLabel("Score: 0");
		panelScore.add(lblScore);
		
		currentCharacter = null;
		
	}
	
	@SuppressWarnings("serial")
	private void PintarMapaVacio() {
		for(int i = 0; i < 6; i++) {
			for (int j = 0; j<10; j++) {
				
				int auxI = i;
				int auxJ = j;
				
				MyLabel lbl = new MyLabel("lbl"+j+","+i);
				lbl.setBorder(new LineBorder(new Color(0, 0, 0)));
				
				lbl.addActionListener( new AbstractAction("btn"+j+i) {
				    public void actionPerformed(ActionEvent e) {
				    	
				        
				    	if(currentCharacter!=null) {
				    		nivel.CrearAliado(currentCharacter, auxJ, auxI);
				        	if(lbl.getIcon() == null) {
					        	lbl.setIcon( new ImageIcon(currentCharacter));
					        	currentCharacter=null;
					        	}
					        }
					    }
				    
				});
				
				labels[j][i] = lbl;
				panelMapa.add( lbl );
			}
		}
		
	}
	
	
	public void ActualizarGrafica() {
		int current = 1;
		JLabel dibujo;
		for (ObjetoDelJuego pos: nivel.getObjetosDelMapa()) {
				if( pos != null) {
					dibujo = new JLabel();
					System.out.println("Hay " + current++ + " dibujo/s");
					dibujo.setBounds(pos.getHitBox());
					dibujo.setIcon(new ImageIcon(pos.getImagen()));
					panelMapa.add(dibujo);
					System.out.println(dibujo.getBounds().toString());
				}	
			}
		panelMapa.repaint();
	}
	
	private class btn1AL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			try {
				currentCharacter = ImageIO.read(getClass().getResource("/images/s.png"));
				panelMapa.addMouseListener(new Clic());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	private class btn2AL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			nivel.HordaHardcodeada();
			Enemigo e=nivel.CrearEnemigo();
			JLabel dib=new JLabel();
			dib.setBounds(e.getHitBox());
			dib.setIcon(new ImageIcon(e.getImagen()));
			panelMapa.add(dib);
			panelMapa.repaint();
			
		}
	}
	
	private class btn3AL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			nivel.Eliminar(ObjetoDelJuego o);
			panelMapa.repaint();
		}
	}
	private class Clic implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				currentCharacter = ImageIO.read(getClass().getResource("/images/s.png"));
				nivel.CrearAliado(currentCharacter, e.getX(), e.getY());
				panelMapa.repaint();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
