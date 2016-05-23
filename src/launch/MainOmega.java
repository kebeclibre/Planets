package launch;

import astre.Planet;
import universe.Omega;

public class MainOmega {

	public static void main(String[] args) throws InterruptedException {
		Omega u = new Omega();
		Planet p1 = new Planet(5000000,0,0);
		Planet p2 = new Planet(5000000,5,0);
		Planet p3 = new Planet(10000000,0,5);
		u.addPlanet(p1);
		u.addPlanet(p2);
		u.addPlanet(p3);
		//System.out.println(Omega.GRAV);

		Thread t = new Thread(u);
		t.start();
	}
}


