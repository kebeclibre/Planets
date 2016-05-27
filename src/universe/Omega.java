package universe;


import java.util.Date;
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
	private boolean ready = true;
	

	public static Omega getInstance() {
		if (instance == null) {
			return instance = new Omega();
		} else {
			return instance;
		}
	}
	public void turnToNotReady() {
		this.ready = false;
	}
	
	public boolean isReady() {
		return ready;
	}
	
	public void setMarching(boolean march) {
		this.marching = march;
	}
	
	public synchronized void addPlanet(Planet p){
		this.planets.add(p);
	}
	
	public Vector<Planet> getPlanets() {
		return planets;
	}
	
	public void updateState() {
		for (Planet p : planets) {
			p.updateVitess();
			p.updatePosition();
		}
	}

	public void launch() {
		//Date now = new Date();
		while (marching) {
			//Date then = new Date();
			if (ready) {
				for (int i = 0; i<planets.size();i++) {
					for (int j = 1;j<planets.size();j++) {
					planets.get(i).mutualAttract(planets.get(j));
					Thread.yield();				
					}
				}
			} 
		}
	}
			
	private <T extends Planet> void cleanZeroWeigh(T second,Iterator<T> it) {
		if (second.getWeigh() == 0) {
			it.remove();
		}
	}
}
	
