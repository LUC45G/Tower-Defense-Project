package gui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Gui {

	private JFrame frame;
	private JPanel panelMapa;
	private ImageIcon currentCharacterImage;
	private Image currentCharacter;

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
		
		currentCharacterImage = null;
		currentCharacter = null;
	}
	
	@SuppressWarnings("serial")
	private void agregarBotones() {
		for(int i = 1; i <= 10; i++) {
			for (int j = 1; j<=6; j++) {
				JButton btn = new JButton( i + "," + j);
				btn.addActionListener( new AbstractAction("btn"+i+j) {
				    public void actionPerformed(ActionEvent e) {
				    	System.out.println("Clicked btn " + btn.getText());
				        if(currentCharacter!=null) {
				        	// currentCharacter = new JLabel(currentCharacterImage);
				        	btn.setText("");
				        	btn.setIcon( new ImageIcon(currentCharacter));
				        	currentCharacter=null;
				        }
				    }
				});
				
				panelMapa.add( btn );
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
