package am1;

import java.util.ArrayList;
import java.lang.Math;

public class Tetraeder extends Koerper {
	Punkt3D_G[] eckpunkt;

	public Tetraeder() {
		super(new ArrayList<Kante>());

		eckpunkt = new Punkt3D_G[8];
		eckpunkt[0] = new Punkt3D_G(0, 0, Math.sqrt((2 / 3)) - (1 / (2 * (Math.sqrt(6)))));
		eckpunkt[1] = new Punkt3D_G((-1 / (2 * (Math.sqrt(3)))), -0.5, (-1 / (2 * (Math.sqrt(6)))));
		eckpunkt[2] = new Punkt3D_G((-1 / (2 * (Math.sqrt(3)))), 0.5, (-1 / (2 * (Math.sqrt(6)))));
		eckpunkt[3] = new Punkt3D_G((1 / (Math.sqrt(3))), 0, (-1 / (2 * (Math.sqrt(6)))));
		eckpunkt[4] = new Punkt3D_G(1, -1, -1);
		eckpunkt[5] = new Punkt3D_G(1, -1, 1);
		eckpunkt[6] = new Punkt3D_G(1, 1, -1);
		eckpunkt[7] = new Punkt3D_G(1, 1, 1);

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
