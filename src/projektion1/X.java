package projektion1;

import java.util.ArrayList;


public class X extends Koerper {
	Punkt[] eckpunkt;

	public X() {
		super(new ArrayList<Punkt>(), new ArrayList<Kante>());

		eckpunkt = new Punkt[] {
				new Punkt(-3,0,0),
				new Punkt(3,0,0)};

		for (Punkt p : eckpunkt)
			punkte.add(p);

		kanten.add(new Kante(eckpunkt[0], eckpunkt[1]));

	}
}
