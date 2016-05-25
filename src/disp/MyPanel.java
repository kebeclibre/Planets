package disp;

import javax.swing.JPanel;

import astre.Planet;
import coord.Vect2D;
import universe.Omega;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class MyPanel extends JPanel {

	private int x;
	private int y;
	
	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}



	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		
		for (Planet p : Omega.getInstance().getPlanets()) {
			int fact = 5;
			Ellipse2D object = new Ellipse2D.Double();
			Vect2D pos = p.getPosition();
			
			object.setFrameFromCenter(
		            pos.getX()*fact+300,
		            -pos.getY()*fact+100,
		            pos.getX()*fact+10+300,
		            -pos.getY()*fact+100+10);
		        g2.setColor(Color.BLUE);
		        g2.fill(object);
		}
	}
	

	

	}
	
	
	

