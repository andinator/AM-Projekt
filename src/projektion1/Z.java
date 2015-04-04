package projektion1;

import java.util.ArrayList;


public class Z extends Koerper {
	Punkt[] eckpunkt;

	public Z() {
		super(new ArrayList<Punkt>(), new ArrayList<Kante>());

		eckpunkt = new Punkt[] {
				new Punkt(0,0,-3),
				new Punkt(0,0,3)};

		for (Punkt p : eckpunkt)
			punkte.add(p);

		kanten.add(new Kante(eckpunkt[0], eckpunkt[1]));

	}
}
