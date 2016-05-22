package launch;

import java.util.Iterator;

import astre.Planet;
import universe.Omega;

public class MainOmega {

	public static void main(String[] args) throws InterruptedException {
		Omega u = new Omega();
		Planet p1 = new Planet(5000000,0,0);
		Planet p2 = new Planet(5000000,5,0);
		
		u.addPlanet(p1);
		u.addPlanet(p2);
		//System.out.println(Omega.GRAV);
		int limit = 5;
		int i = 0;
		System.out.println(u.getSet());
		Iterator<Planet> it = u.getSet().iterator();
		while (true) {
			p1.mutualAttract(p2);
			//p2.mutualAttract(p1);
			System.out.println(p1);
			System.out.println(p2);
			
			//System.out.println(p2);

			Thread.sleep(100);
		

	}
	}
}


