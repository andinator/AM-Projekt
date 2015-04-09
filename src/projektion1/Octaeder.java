package projektion1;

import java.lang.Math;
import java.util.ArrayList;

public class Octaeder extends Koerper {
	Punkt[] eckpunkt;

	public Octaeder() {
		super(new ArrayList<Punkt>(), new ArrayList<Kante>());

		eckpunkt = new Punkt[]{
				
			new Punkt(-(1/(Math.sqrt(2))), 0 , 0),
			new Punkt(0, 1/(Math.sqrt(2)), 0),
			new Punkt(0, 0, -1/(Math.sqrt(2))),
			new Punkt(0, 0, 1/(Math.sqrt(2))),
			new Punkt(0, -(1/(Math.sqrt(2))), 0),
			new Punkt((1/(Math.sqrt(2))), 0, 0)
		};
		
		for (Punkt p : eckpunkt) 
			punkte.add(p);

		kanten.add(new Kante(eckpunkt[0], eckpunkt[1]));
		kanten.add(new Kante(eckpunkt[0], eckpunkt[2]));
		kanten.add(new Kante(eckpunkt[0], eckpunkt[3]));
		kanten.add(new Kante(eckpunkt[0], eckpunkt[4]));
		kanten.add(new Kante(eckpunkt[1], eckpunkt[2]));
		kanten.add(new Kante(eckpunkt[1], eckpunkt[3]));
		kanten.add(new Kante(eckpunkt[1], eckpunkt[5]));
		kanten.add(new Kante(eckpunkt[2], eckpunkt[4]));
		kanten.add(new Kante(eckpunkt[2], eckpunkt[5]));
		kanten.add(new Kante(eckpunkt[3], eckpunkt[4]));
		kanten.add(new Kante(eckpunkt[3], eckpunkt[5]));
		kanten.add(new Kante(eckpunkt[4], eckpunkt[5]));
	}
}