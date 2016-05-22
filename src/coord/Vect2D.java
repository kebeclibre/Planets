package coord;

public class Vect2D {
	private double x;
	private double y;
	
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
	
	public double distSigned(Vect2D vect) {
		
	}
	
}
