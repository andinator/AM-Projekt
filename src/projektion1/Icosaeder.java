package projektion1;

import java.lang.Math;
import java.util.ArrayList;

public class Icosaeder extends Koerper {
	Punkt[] eckpunkt;

	public Icosaeder() {
		super(new ArrayList<Punkt>(), new ArrayList<Kante>());

		eckpunkt = new Punkt[6];
		eckpunkt[0] = new Punkt(0, 0, -5/Math.sqrt(50-10*Math.sqrt(5)));
		eckpunkt[1] = new Punkt(0, 0, 5/Math.sqrt(50-10*Math.sqrt(5)));
		eckpunkt[2] = new Punkt(-Math.sqrt(2/(5-Math.sqrt(5))), 0, -1/Math.sqrt(10-2*Math.sqrt(5)));
		eckpunkt[3] = new Punkt(Math.sqrt(2/(5-Math.sqrt(5))), 0, 1/Math.sqrt(10-2*Math.sqrt(5)));
		eckpunkt[4] = new Punkt((1+Math.sqrt(5))/(2*Math.sqrt(10-2*Math.sqrt(5))), -1/2, -1/Math.sqrt(10-2*Math.sqrt(5)));
		eckpunkt[5] = new Punkt((1+Math.sqrt(5))/(2*Math.sqrt(10-2*Math.sqrt(5))), 1/2, -1/Math.sqrt(10-2*Math.sqrt(5)));
		
		for (Punkt p : eckpunkt) punkte.add(p);

		kanten.add(new Kante(eckpunkt[0], eckpunkt[1]));
		kanten.add(new Kante(eckpunkt[0], eckpunkt[2]));
		kanten.add(new Kante(eckpunkt[2], eckpunkt[1]));
		kanten.add(new Kante(eckpunkt[0], eckpunkt[3]));
		kanten.add(new Kante(eckpunkt[3], eckpunkt[1]));
		kanten.add(new Kante(eckpunkt[3], eckpunkt[5]));
		kanten.add(new Kante(eckpunkt[5], eckpunkt[1]));
		kanten.add(new Kante(eckpunkt[2], eckpunkt[5]));
		kanten.add(new Kante(eckpunkt[0], eckpunkt[4]));
		kanten.add(new Kante(eckpunkt[2], eckpunkt[4]));
		kanten.add(new Kante(eckpunkt[3], eckpunkt[4]));
		kanten.add(new Kante(eckpunkt[5], eckpunkt[4]));
	}
}