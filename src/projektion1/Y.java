package projektion1;

import java.util.ArrayList;


public class Y extends Koerper {
	Punkt[] eckpunkt;

	public Y() {
		super(new ArrayList<Punkt>(), new ArrayList<Kante>());

		eckpunkt = new Punkt[] {
				new Punkt(0,-3,0),
				new Punkt(0,3,0)};

		for (Punkt p : eckpunkt)
			punkte.add(p);

		kanten.add(new Kante(eckpunkt[0], eckpunkt[1]));

	}
}
