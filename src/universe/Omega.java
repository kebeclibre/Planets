package universe;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

import astre.Planet;
import coord.except.DivByZeroException;

public class Omega extends Thread {
	public static final double GRAV = 6.6E-11;
	private double size;
	private Vector<Planet> planets = new Vector<Planet>();
	public void addPlanet(Planet p){
		this.planets.add(p);
	}
	@Override
	public void run() {
		while (true) {
		Iterator<Planet> it = planets.iterator();
		Planet prev = it.next();
		Planet current = it.next();
		while (it.hasNext()) {
			try {
				prev.mutualAttract(current);
			} catch (DivByZeroException e1) {
				
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println(planets.toString());
		}
	}
			
}
	
