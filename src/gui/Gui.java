package gui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import logic.Mapa;
import logic.Nivel;

import java.awt.Color;

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
		panelPersonajes.setLayout(new GridLayout(5, 1, 2, 2));
		
		JButton btnPersonaje1 = new JButton("Seleccionar aliado");
		btnPersonaje1.addActionListener(new btn1AL()); 
		panelPersonajes.add(btnPersonaje1);
		
		JButton btnPersonaje2 = new JButton("Spawnear enemigo");
		btnPersonaje2.addActionListener(new btn2AL()); // ActionListener temporal para probar al enemigo
		panelPersonajes.add(btnPersonaje2);
		
		JButton btnPersonaje3 = new JButton("Eliminar enemigo");
		panelPersonajes.add(btnPersonaje3);
		
		JButton btnPersonaje4 = new JButton("4");
		panelPersonajes.add(btnPersonaje4);
		
		JButton btnPersonaje5 = new JButton("5");
		panelPersonajes.add(btnPersonaje5);
		
		panelMapa = new JPanel();
		panelMapa.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMapa.setBounds(192, 0, 692, 551);
		panelMapa.setLayout(new GridLayout(6, 10, 0, 0));
		PintarMapaVacio();
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
		Image[][] matrizDeImagenes = nivel.GetImagenes();
		JLabel lbl;
		for (int i  = 0; i < 10; i++) {
			for (int j = 0; j < 6; j++) {
				lbl = labels[i][j];
				
				if( matrizDeImagenes[i][j] != null) {
					lbl.setIcon( new ImageIcon(matrizDeImagenes[i][j]) );
				}
				else {
					lbl.setIcon(null);
					lbl.revalidate();
				}
			}
		}
	}
	
	private class btn1AL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			try {
				currentCharacter = ImageIO.read(getClass().getResource("/images/p1.png"));
				panelMapa.repaint();
				frame.repaint();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	private class btn2AL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			nivel.HordaHardcodeada();
			
			panelMapa.repaint();
			frame.repaint();
			
		}
	}
}
