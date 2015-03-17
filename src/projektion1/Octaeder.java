package projektion1;

import java.lang.Math;
import java.util.ArrayList;

public class Octaeder extends Koerper {
	Punkt[] eckpunkt;

	public Octaeder() {
		super(new ArrayList<Punkt>(), new ArrayList<Kante>());

		eckpunkt = new Punkt[6];
		eckpunkt[0] = new Punkt(-(1/(Math.sqrt(2))), 0 , 0);
		eckpunkt[1] = new Punkt(0, 1/(Math.sqrt(2)), 0);
		eckpunkt[2] = new Punkt(0, 0, -1/(Math.sqrt(2)));
		eckpunkt[3] = new Punkt(0, 0, 1/(Math.sqrt(2)));
		eckpunkt[4] = new Punkt(0, -(1/(Math.sqrt(2))), 0);
		eckpunkt[5] = new Punkt((1/(Math.sqrt(2))), 0, 0);
		
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