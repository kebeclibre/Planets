package disp;

import javax.swing.JPanel;
import java.awt.Graphics;

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
		g.fillOval(x, y, 30, 30);
		
			
	}
	
	
		
	public MyPanel() {
		this.setSize(50,50);

	}
	

	

	}
	
	
	

