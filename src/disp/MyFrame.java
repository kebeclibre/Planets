package disp;

import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;

import astre.Planet;
import coord.Vect2D;
import universe.Omega;

public class MyFrame extends JFrame {
	private Omega o = Omega.getInstance();
	private MyPanel pan = new MyPanel();
	public MyFrame() {
		setPlanets();
		this.setTitle("Ma première fenêtre Java");
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);

		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(pan);
		pan.setSize(1000,600);
	
		
		
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				Omega.getInstance().launch();
				
			}
		
		}).start();	
		go();
		
	}
	
	public void setPlanets() {
		Planet p1 = new Planet(5000000,0,0);
		Planet p2 = new Planet(10000000,5,0);
		Planet p3 = new Planet(10000000,0,5);
		Vect2D vitesse = new Vect2D(0,0.0001);
		o.addPlanet(p1);
		o.addPlanet(p2);
		p1.setVitesse(vitesse);
	}
	
	private void go() {

		Date now = new Date();
		while (true) {
			Date then = new Date();
			if (now.getTime()-then.getTime() >= 100) {

				pan.repaint(); 
				now = then;
			}
		}
	}
}


