package universe;


import java.util.Iterator;
import java.util.Vector;

import astre.Planet;

public class Omega {
	
	private static Omega instance;
	public static final double GRAV = 10E-10;
	// 6.6E-11;
	private double size;
	private Vector<Planet> planets = new Vector<Planet>();
	private boolean marching = true;
	

	public static Omega getInstance() {
		if (instance == null) {
			return instance = new Omega();
		} else {
			return instance;
		}
	}
	
	public void setMarching(boolean march) {
		this.marching = march;
	}
	
	public synchronized void addPlanet(Planet p){
		this.planets.add(p);
	}
	
	public Vector<Planet> getPlanets() {
		return this.planets;
	}

	public synchronized void launch() {
		
		while (marching) {
			
		Iterator<Planet> it = planets.iterator();
		
		while (it.hasNext()) {
				Planet first = it.next();
				Planet second = null;
				if (it.hasNext()) {
					second = it.next();
					first.mutualAttract(second);
					cleanZeroWeigh(second, it);
					notifyAll();
					Thread.yield();
				}
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(first);
				System.out.println(second);
				Thread.yield();
			
		}
		Thread.yield();
		}
	}
			
	private <T extends Planet> void cleanZeroWeigh(T second,Iterator<T> it) {
		if (second.getWeigh() == 0) {
			it.remove();
		}
	}
}
	
