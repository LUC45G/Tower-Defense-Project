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
	private ArrayList<JLabel> labels;

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
		labels = new ArrayList<JLabel>();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelPersonajes = new JPanel();
		panelPersonajes.setBounds(0, 0, 72, 318);
		frame.getContentPane().add(panelPersonajes);
		panelPersonajes.setLayout(new GridLayout(5, 1, 2, 2));
		
		JButton btnPersonaje1 = new JButton("1");
		btnPersonaje1.addActionListener(new btn1AL()); 
		panelPersonajes.add(btnPersonaje1);
		
		JButton btnPersonaje2 = new JButton("2");
		btnPersonaje2.addActionListener(new btn2AL()); // ActionListener temporal para probar al enemigo
		panelPersonajes.add(btnPersonaje2);
		
		JButton btnPersonaje3 = new JButton("3");
		panelPersonajes.add(btnPersonaje3);
		
		JButton btnPersonaje4 = new JButton("4");
		panelPersonajes.add(btnPersonaje4);
		
		JButton btnPersonaje5 = new JButton("5");
		panelPersonajes.add(btnPersonaje5);
		
		panelMapa = new JPanel();
		panelMapa.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMapa.setBounds(82, 0, 692, 551);
		panelMapa.setLayout(new GridLayout(6, 10, 0, 0));
		agregarBotones();
		frame.getContentPane().add(panelMapa);
		
		currentCharacter = null;
	}
	
	@SuppressWarnings("serial")
	private void agregarBotones() {
		for(int i = 1; i <= 6; i++) {
			for (int j = 1; j<=10; j++) {
				MyLabel lbl = new MyLabel("lbl"+j+","+i);
				lbl.setBorder(new LineBorder(new Color(0, 0, 0)));
				lbl.addActionListener( new AbstractAction("btn"+j+i) {
				    public void actionPerformed(ActionEvent e) {
				    	System.out.println("Clicked " + lbl.getText());
				        if(currentCharacter!=null) {
				        	if(lbl.getIcon() == null) {
					        	lbl.setText("");
					        	lbl.setIcon( new ImageIcon(currentCharacter));
					        	currentCharacter=null;
				        	}
				        }
				    }
				});
				
				labels.add(lbl);
				panelMapa.add( lbl );
			}
		}
		
	}
	
	public void ActualizarGrafica() {
		Image[][] matrizDeImagenes = nivel.GetImagenes();
		JLabel lbl;
		for (int i  = 0; i < 10; i++) {
			for (int j = 0; j < 6; j++) {
				lbl = labels.get(9*j + i );
				
				if( matrizDeImagenes[i][j] != null) {
					lbl.setIcon( new ImageIcon(matrizDeImagenes[i][j]) );
					System.out.println("HayAlgo");
				}
				else 
					lbl.setText("");
			}
		}
	}
	
	private void AgregarEnemigo(int y) {
		Image enemyIcon = null;
		
		try {
			enemyIcon = ImageIO.read(getClass().getResource("/images/p1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JLabel lbl = labels.get(9*y + y - 1);
		
		if (lbl.getIcon()==null)
			lbl.setIcon( new ImageIcon(enemyIcon) );
	}
	
	public void AvanzarEnemigos() {
		for(int i = 0; i < 60; i++) {
			JLabel prevlbl = labels.get(i);
			
			if ( i % 10 == 0 ) {
				if(prevlbl.getIcon()!=null) {
					System.out.println("Perdiste");
				}
			}
			else {
				JLabel nextlbl = labels.get(i-1);
				nextlbl.setIcon( prevlbl.getIcon() );
				prevlbl.setIcon(null);
			}
		}
	}
	
	private class btn1AL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Clicked btn 1");
			
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
			System.out.println("Clicked btn 2");
			
			nivel.HordaHardcodeada();
			
			panelMapa.repaint();
			frame.repaint();
			
		}
	}
	
}
