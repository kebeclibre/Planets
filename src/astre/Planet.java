package astre;

import astre.iface.Gravitable;
import coord.Vect2D;

public class Planet implements Gravitable {
	private Vect2D position = new Vect2D();
	private Vect2D vitesse = new Vect2D();
	private int weigh;
	private int radius;
	
	public Vect2D getPosition() {
		return position;
	}
	public void setPosition(Vect2D position) {
		this.position = position;
	}
	
	public void setPosition (double x, double y) {
		this.position.setX(x);
		this.position.setY(y);
	}
	
	public Vect2D getVitesse() {
		return vitesse;
	}
	
	public void setVitesse(Vect2D vitesse) {
		this.vitesse = vitesse;
	}

	public void setVitesse(double x, double y) {
		this.vitesse.setX(x);
		this.vitesse.setY(y);
	}
	
	public int getWeigh() {
		return weigh;
	}
	public void setWeigh(int weigh) {
		this.weigh = weigh;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public void updateVitesse(Vect2D accel) {
		this.vitesse.addVectAccel(accel);
		}
	
	public void updatePosition() {
		this.position.addVectAccel(vitesse);
	}
	
	

}
