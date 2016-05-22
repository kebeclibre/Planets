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
	private Vect2D accel = new Vect2D();
	
	
	
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
		Vect2D dVect = null;

		dVect = this.position.relativeDistTo(p.position);
	
		double hypo = Math.hypot(dVect.getX(),dVect.getY());
		double invHypo = 1.0 / hypo;
		double forceG = GRAV * invHypo;
		
		int directionX = (dVect.getX()) < 0 ? -1:1;
		int directionY = (dVect.getY()) < 0 ? -1:1;
		
		double selfXA = forceG * p.getWeigh() * dVect.getX() * invHypo;
		double selfYA = forceG * p.getWeigh() * dVect.getY() * invHypo;
		
		double otherXA = - forceG * this.getWeigh()* dVect.getX() * invHypo;
		double otherYA = - forceG * this.getWeigh()* dVect.getY() * invHypo;
		
		this.accel = new Vect2D(selfXA,selfYA);
		p.accel = new Vect2D(otherXA,otherYA);
		
		this.updateVitess();
		this.updatePosition();
		
		p.updateVitess();
		p.updatePosition();
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("planet--");
		sb.append("weigh: "+weigh+" -- ");
		sb.append("position: "+position.toString()+" -- ");
		return sb.toString();
	}
	
	

}
