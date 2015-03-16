package am1;

import java.util.ArrayList;

public class Wuerfel extends Koerper {
	Punkt3D_G[] eckpunkt;

	public Wuerfel () {
		super(new ArrayList<Kante_G>());

		eckpunkt = new Punkt3D_G[8];

		eckpunkt[0] = new Punkt3D_G(-1, -1, -1);
		eckpunkt[1] = new Punkt3D_G(-1, -1, 1);
		eckpunkt[2] = new Punkt3D_G(-1, 1, -1);
		eckpunkt[3] = new Punkt3D_G(-1, 1, 1);
		eckpunkt[4] = new Punkt3D_G(1, -1, -1);
		eckpunkt[5] = new Punkt3D_G(1, -1, 1);
		eckpunkt[6] = new Punkt3D_G(1, 1, -1);
		eckpunkt[7] = new Punkt3D_G(1, 1, 1);
				
		kanten.add(new Kante_G(eckpunkt[0], eckpunkt[1]));
		kanten.add(new Kante_G(eckpunkt[0], eckpunkt[2]));
		kanten.add(new Kante_G(eckpunkt[0], eckpunkt[4]));
		kanten.add(new Kante_G(eckpunkt[1], eckpunkt[3]));
		kanten.add(new Kante_G(eckpunkt[1], eckpunkt[5]));
		kanten.add(new Kante_G(eckpunkt[2], eckpunkt[3]));
		kanten.add(new Kante_G(eckpunkt[2], eckpunkt[6]));
		kanten.add(new Kante_G(eckpunkt[3], eckpunkt[7]));
		kanten.add(new Kante_G(eckpunkt[4], eckpunkt[5]));
		kanten.add(new Kante_G(eckpunkt[4], eckpunkt[6]));
		kanten.add(new Kante_G(eckpunkt[5], eckpunkt[7]));
		kanten.add(new Kante_G(eckpunkt[6], eckpunkt[7]));
	}
}
