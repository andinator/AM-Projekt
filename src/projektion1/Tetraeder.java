package projektion1;

import java.util.ArrayList;

public class Tetraeder extends Koerper {
	Punkt[] eckpunkt;

	public Tetraeder() {
		super(new ArrayList<Punkt>(), new ArrayList<Kante>());

		eckpunkt = new Punkt[] {
				new Punkt(1, 0, -1 / Math.sqrt(2)),
				new Punkt(-1, 0, -1 / Math.sqrt(2)),
				new Punkt(0, 1, 1 / Math.sqrt(2)),
				new Punkt(0, -1, 1 / Math.sqrt(2)) };

		for (Punkt p : eckpunkt)
			punkte.add(p);

		kanten.add(new Kante(eckpunkt[0], eckpunkt[1]));
		kanten.add(new Kante(eckpunkt[0], eckpunkt[2]));
		kanten.add(new Kante(eckpunkt[0], eckpunkt[3]));
		kanten.add(new Kante(eckpunkt[1], eckpunkt[2]));
		kanten.add(new Kante(eckpunkt[1], eckpunkt[3]));
		kanten.add(new Kante(eckpunkt[2], eckpunkt[3]));
	}
}
