package astre;

import coord.Vect2D;
import coord.except.BodyCollisionException;

import static universe.Omega.GRAV;

public class Planet {
	private Vect2D position = new Vect2D();
	private Vect2D vitesse = new Vect2D();
	private int weigh;
	private int radius;
	private Vect2D accel = new Vect2D();
	
	
	
	public Planet(int weigh, double x, double y) {
		this.weigh = weigh;
		this.setPosition(x, y);
	}
	
	public Planet(int weigh, double x, double y, Vect2D speed) {
		this(weigh,x,y);
		this.setVitesse(speed);
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
	
	public void mutualAttract(Planet p) {
		Vect2D dVect = null;

		try {
			dVect = this.position.relativeDistTo(p.position);
			double hypo = Math.hypot(dVect.getX(),dVect.getY());
			double invHypo = 1.0 / hypo;
			double forceG = GRAV * invHypo * invHypo;
			
			double selfXA = 0;
			double selfYA = 0;
			double otherXA = 0; 
			double otherYA = 0;
			
			if (dVect.getX() > 0 ) {
				selfXA = forceG * p.getWeigh() * dVect.getX() * invHypo;
				otherXA = - forceG * this.getWeigh()* dVect.getX() * invHypo;
			} else {
				selfXA = - forceG * p.getWeigh() * dVect.getX() * invHypo;
				otherXA = forceG * this.getWeigh()* dVect.getX() * invHypo;
			}
			
			if (dVect.getY() > 0) {
				selfYA =  forceG * p.getWeigh() * dVect.getY() * invHypo;
				otherYA = - forceG * this.getWeigh()* dVect.getY() * invHypo;
			} else {
				selfYA =  - forceG * p.getWeigh() * dVect.getY() * invHypo;
				otherYA = forceG * this.getWeigh()* dVect.getY() * invHypo;
			}
				
			this.accel = new Vect2D(selfXA,selfYA);
			p.accel = new Vect2D(otherXA,otherYA);
		
			this.updateVitess();
			this.updatePosition();
		
			p.updateVitess();
			p.updatePosition();
			
			
		} catch (BodyCollisionException e) {
			collFusion(this, p);
			System.out.println("Except");
		}
	
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("planet--");
		sb.append("weigh: "+weigh+" -- ");
		sb.append("position: "+position.toString()+" -- ");
		return sb.toString();
	}
	
	public static <T extends Planet> void collFusion(T corps1,T corps2) {
		corps1.setVitesse(Vect2D.addVectStat(corps1.getVitesse(), corps2.getVitesse()));
		corps1.setWeigh(corps2.getWeigh()+corps1.getWeigh());
		corps2.setWeigh(0);
	}

}
