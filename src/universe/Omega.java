package universe;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

import astre.Planet;
import coord.except.BodyCollisionException;

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

		while (it.hasNext()) {
				Planet first = it.next();
				Planet second = null;
				if (it.hasNext()) {
					second = it.next();
					first.mutualAttract(second);
					cleanZeroWeigh(second, it);
				}
				
				System.out.println(first);
				System.out.println(second);
				

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//System.out.println(planets.toString());
		}
	}
			
	public <T extends Planet> void cleanZeroWeigh(T second,Iterator it) {
		if (second.getWeigh() == 0) {
			it.remove();
		}
	}
}
	
