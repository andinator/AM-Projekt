package projektion1;

import java.util.ArrayList;

public class Dodekaeder extends Koerper {
	Punkt[] eckpunkt;
	
	public Dodekaeder() {
		super(new ArrayList<Punkt>(), new ArrayList<Kante>());
		
		double s = 0.25*(Math.sqrt(5)-1);

		eckpunkt = new Punkt[]{
			new Punkt(0.5,0.5,0.5),
			new Punkt(-0.5,0.5,0.5),
			new Punkt(-0.5,-0.5,0.5),
			new Punkt(0.5,-0.5,0.5),
			new Punkt(0.5,0.5,-0.5),
			new Punkt(-0.5,0.5,-0.5),
			new Punkt(-0.5,-0.5,-0.5),
			new Punkt(0.5,-0.5,-0.5),
			
			new Punkt(s,s+0.5,0),
			new Punkt(-s,s+0.5,0),
			new Punkt(0,s,s+0.5),
			new Punkt(0,-s,s+0.5),
			new Punkt(0.5+s,0,-s),
			new Punkt(0.5+s,0,s),
			new Punkt(-(0.5+s),0,s),
			new Punkt(-(0.5+s),0,-s),
			new Punkt(-s,-(0.5+s),0),
			new Punkt(s,-(0.5+s),0),
			new Punkt(0,s,-(0.5+s)),
			new Punkt(0,-s,-(0.5+s)),
		
		};

		for (Punkt p : eckpunkt) 
			punkte.add(p);
		
		kanten.add(new Kante(eckpunkt[0], eckpunkt[8]));
		kanten.add(new Kante(eckpunkt[4], eckpunkt[8]));
		kanten.add(new Kante(eckpunkt[8], eckpunkt[9]));
		kanten.add(new Kante(eckpunkt[0], eckpunkt[10]));
		kanten.add(new Kante(eckpunkt[10], eckpunkt[11]));
		
		kanten.add(new Kante(eckpunkt[4], eckpunkt[12]));
		kanten.add(new Kante(eckpunkt[12], eckpunkt[13]));
		kanten.add(new Kante(eckpunkt[0], eckpunkt[13]));
		kanten.add(new Kante(eckpunkt[5], eckpunkt[15]));
		kanten.add(new Kante(eckpunkt[14], eckpunkt[15]));
		
		kanten.add(new Kante(eckpunkt[4], eckpunkt[18]));
		kanten.add(new Kante(eckpunkt[5], eckpunkt[18]));
		kanten.add(new Kante(eckpunkt[18], eckpunkt[19]));
		kanten.add(new Kante(eckpunkt[1], eckpunkt[9]));
		kanten.add(new Kante(eckpunkt[1], eckpunkt[10]));
		
		kanten.add(new Kante(eckpunkt[1], eckpunkt[14]));
		kanten.add(new Kante(eckpunkt[5], eckpunkt[9]));
		kanten.add(new Kante(eckpunkt[2], eckpunkt[11]));
		kanten.add(new Kante(eckpunkt[2], eckpunkt[14]));
		kanten.add(new Kante(eckpunkt[6], eckpunkt[19]));
		
		kanten.add(new Kante(eckpunkt[6], eckpunkt[16]));
		kanten.add(new Kante(eckpunkt[6], eckpunkt[15]));
		kanten.add(new Kante(eckpunkt[16], eckpunkt[17]));
		kanten.add(new Kante(eckpunkt[2], eckpunkt[16]));
		kanten.add(new Kante(eckpunkt[7], eckpunkt[17]));
		
		kanten.add(new Kante(eckpunkt[7], eckpunkt[19]));
		kanten.add(new Kante(eckpunkt[7], eckpunkt[12]));
		kanten.add(new Kante(eckpunkt[3], eckpunkt[11]));
		kanten.add(new Kante(eckpunkt[3], eckpunkt[13]));
		kanten.add(new Kante(eckpunkt[3], eckpunkt[17]));
		
		
	}
}