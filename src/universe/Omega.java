package universe;

import java.util.HashSet;
import java.util.Set;

import astre.iface.Gravitable;
import astre.Planet;

public class Omega extends Thread {
	public static final double GRAV = 6.6E-11;
	private double size;
	private HashSet<Planet> planets = new HashSet<Planet>();
	public void addPlanet(Planet p){
		this.planets.add(p);
	}
	@Override
	public void run() {
		while (true) {
		Planet init = planets.iterator().next();
		while (planets.iterator().hasNext()) {
			Planet inProcess = planets.iterator().next();
			inProcess.mutualAttract(init);
			init = inProcess;
		}
		System.out.println(planets.toString());
		}
	}
	
	public Set<Planet> getSet() {
		return this.planets;
	}
			
}
	
