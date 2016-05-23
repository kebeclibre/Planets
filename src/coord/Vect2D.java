package coord;

import coord.except.DivByZeroException;

public class Vect2D {
	private double x;
	private double y;
	
	public Vect2D() {}
	
	public Vect2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	public void addVectAccel(Vect2D accel) {
		this.x += accel.x;
		this.y += accel.y;
	}
	
	public void substractVect(Vect2D vect) {
		this.x -= vect.getX();
		this.y -= vect.getY();
	}
	
	public Vect2D relativeDistTo(Vect2D vect) throws DivByZeroException {
		double distX = vect.getX()-this.x;
		double distY = vect.getY() - this.y;
		
		if (distX == 0 && distY == 0) throw new DivByZeroException();
		Vect2D res = new Vect2D(distX,distY);
		return res;
	}
	
	public void scalaireMult(double scal) {
		this.x *= scal;
		this.y *= scal;
	}
	
	public void squaredVect() {
		this.x *= this.x;
		this.y *= this.y;
	}
	
	public void sqrtVect() {
		this.x = Math.sqrt(this.x);
		this.y = Math.sqrt(this.y);
	}
	
	public double hypothenuse(Vect2D vect) {	
		try {
			return Math.sqrt(hypoSquared(vect));
		} catch (DivByZeroException e) {
			return 0;
		}
	}
	
	public double hypoSquared(Vect2D vect) throws DivByZeroException {
		Vect2D temp;
		temp = this.relativeDistTo(vect);
		double tempX = temp.getX();
		double tempY = temp.getY();		
		return tempX*tempX + tempY*tempY;
	}
	
	public String toString() {
		return "[[x = "+x+" -- y = "+y+"]]";
	}
}
