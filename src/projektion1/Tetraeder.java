package projektion1;

import java.lang.Math;
import java.util.ArrayList;

public class Tetraeder extends Koerper {
	Punkt[] eckpunkt;

	public Tetraeder() {
		super(new ArrayList<Punkt>(), new ArrayList<Kante>());

		eckpunkt = new Punkt[8];

		eckpunkt[0] = new Punkt(0, 0, Math.sqrt((2 / 3))
				- (1 / (2 * (Math.sqrt(6)))));
		eckpunkt[1] = new Punkt((-1 / (2 * (Math.sqrt(3)))), -0.5,
				(-1 / (2 * (Math.sqrt(6)))));
		eckpunkt[2] = new Punkt((-1 / (2 * (Math.sqrt(3)))), 0.5,
				(-1 / (2 * (Math.sqrt(6)))));
		eckpunkt[3] = new Punkt((1 / (Math.sqrt(3))), 0,
				(-1 / (2 * (Math.sqrt(6)))));
		eckpunkt[4] = new Punkt(1, -1, -1);
		eckpunkt[5] = new Punkt(1, -1, 1);
		eckpunkt[6] = new Punkt(1, 1, -1);
		eckpunkt[7] = new Punkt(1, 1, 1);

		for (Punkt p : eckpunkt)
			punkte.add(p);

		kanten.add(new Kante(eckpunkt[0], eckpunkt[1]));
		kanten.add(new Kante(eckpunkt[0], eckpunkt[2]));
		kanten.add(new Kante(eckpunkt[0], eckpunkt[4]));
		kanten.add(new Kante(eckpunkt[1], eckpunkt[3]));
		kanten.add(new Kante(eckpunkt[1], eckpunkt[5]));
		kanten.add(new Kante(eckpunkt[2], eckpunkt[3]));
		kanten.add(new Kante(eckpunkt[2], eckpunkt[6]));
		kanten.add(new Kante(eckpunkt[3], eckpunkt[7]));
		kanten.add(new Kante(eckpunkt[4], eckpunkt[5]));
		kanten.add(new Kante(eckpunkt[4], eckpunkt[6]));
		kanten.add(new Kante(eckpunkt[5], eckpunkt[7]));
		kanten.add(new Kante(eckpunkt[6], eckpunkt[7]));
	}
}