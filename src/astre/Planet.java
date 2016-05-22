package astre;

import astre.iface.Gravitable;
import coord.Vect2D;
import coord.except.DivByZeroException;

import static universe.Omega.GRAV;

public class Planet implements Gravitable<Planet> {
	private Vect2D position = new Vect2D();
	private Vect2D vitesse = new Vect2D();
	private int weigh;
	private int radius;
	private final Vect2D accel = new Vect2D();
	private Vect2D newAccel = new Vect2D();
	
	
	
	public Planet(int weigh, double x, double y) {
		this.weigh = weigh;
		this.setPosition(x, y);
	}
	
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
	
	public void updateVitess() {
		this.vitesse.addVectAccel(accel);
	}
	
	@Override
	public void mutualAttract(Planet p) {
		Vect2D dist = null;
		double hypo = 0;
		try {
			dist = this.position.relativeDistTo(p.position);
			hypo = Math.hypot(dist.getX(), dist.getY());			
		} catch (DivByZeroException e) {
			hypo = 1;
			dist = new Vect2D(0,0);
		}
		double force = GRAV * this.getWeigh()*p.getWeigh() / hypo;
		newAccel = dist.composeXY(force);
		accel.setX(newAccel.getX());
		accel.setY(newAccel.getY());
		this.updateVitess();
		this.updatePosition();
		//System.out.println(vitesse);
		
		
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("planet--");
		sb.append("weigh: "+weigh+" -- ");
		sb.append("position: "+position.toString()+" -- ");
		return sb.toString();
	}
	
	

}
