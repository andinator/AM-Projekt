package projektion1;

import java.lang.Math;
import java.util.ArrayList;

public class Icosaeder extends Koerper {
	Punkt[] eckpunkt;
	
	public Icosaeder() {
		super(new ArrayList<Punkt>(), new ArrayList<Kante>());

		eckpunkt = new Punkt[]{
				
		new Punkt(0, -5/Math.sqrt(50-10*Math.sqrt(5)), 0),
		new Punkt(0, 5/Math.sqrt(50-10*Math.sqrt(5)), 0),
		new Punkt(-Math.sqrt(2/(5-Math.sqrt(5))), (-1/Math.sqrt(10-2*Math.sqrt(5))), 0),
		new Punkt(Math.sqrt(2/(5-Math.sqrt(5))), 1/Math.sqrt(10-2*Math.sqrt(5)), 0),
		new Punkt((1+Math.sqrt(5))/(2*Math.sqrt(10-2*Math.sqrt(5))),-1/Math.sqrt(10-2*Math.sqrt(5)),  /*-1/2*/-0.5),
		new Punkt((1+Math.sqrt(5))/(2*Math.sqrt(10-2*Math.sqrt(5))),-1/Math.sqrt(10-2*Math.sqrt(5)),  /*1/2*/0.5),
		new Punkt(-(1+Math.sqrt(5))/(2*Math.sqrt(10-2*Math.sqrt(5))),1/Math.sqrt(10-2*Math.sqrt(5)),  /*-1/2*/-0.5),
		new Punkt(-(1+Math.sqrt(5))/(2*Math.sqrt(10-2*Math.sqrt(5))),1/Math.sqrt(10-2*Math.sqrt(5)), /*1/2*/0.5),
		new Punkt(-(-1+Math.sqrt(5))/(2*Math.sqrt(10-2*Math.sqrt(5))), -1/Math.sqrt(10-2*Math.sqrt(5)),/*-1/2*/-0.5*Math.sqrt((5+Math.sqrt(5))/(5-Math.sqrt(5)))), 
		new Punkt(-(-1+Math.sqrt(5))/(2*Math.sqrt(10-2*Math.sqrt(5))),-1/Math.sqrt(10-2*Math.sqrt(5)) ,/*1/2*/0.5*Math.sqrt((5+Math.sqrt(5))/(5-Math.sqrt(5)))), 
		new Punkt((-1+Math.sqrt(5))/(2*Math.sqrt(10-2*Math.sqrt(5))), 1/Math.sqrt(10-2*Math.sqrt(5)) ,/*-1/2*/-0.5*Math.sqrt((5+Math.sqrt(5))/(5-Math.sqrt(5)))),
		new Punkt((-1+Math.sqrt(5))/(2*Math.sqrt(10-2*Math.sqrt(5))),1/Math.sqrt(10-2*Math.sqrt(5)) , /*1/2*/0.5*Math.sqrt((5+Math.sqrt(5))/(5-Math.sqrt(5)))) };
				
		for (Punkt p : eckpunkt) 
			punkte.add(p);

		kanten.add(new Kante(eckpunkt[0], eckpunkt[2]));
		kanten.add(new Kante(eckpunkt[0], eckpunkt[4]));
		kanten.add(new Kante(eckpunkt[0], eckpunkt[5]));
		kanten.add(new Kante(eckpunkt[0], eckpunkt[8]));
		kanten.add(new Kante(eckpunkt[0], eckpunkt[9]));
		
		kanten.add(new Kante(eckpunkt[1], eckpunkt[3]));
		kanten.add(new Kante(eckpunkt[1], eckpunkt[6]));
		kanten.add(new Kante(eckpunkt[1], eckpunkt[7]));
		kanten.add(new Kante(eckpunkt[1], eckpunkt[10]));
		kanten.add(new Kante(eckpunkt[1], eckpunkt[11]));
		
		kanten.add(new Kante(eckpunkt[2], eckpunkt[8]));
		kanten.add(new Kante(eckpunkt[2], eckpunkt[9]));
		kanten.add(new Kante(eckpunkt[4], eckpunkt[5]));
		kanten.add(new Kante(eckpunkt[4], eckpunkt[8]));
		kanten.add(new Kante(eckpunkt[5], eckpunkt[9]));
		
		kanten.add(new Kante(eckpunkt[6], eckpunkt[7]));
		kanten.add(new Kante(eckpunkt[3], eckpunkt[10]));
		kanten.add(new Kante(eckpunkt[6], eckpunkt[10]));
		kanten.add(new Kante(eckpunkt[3], eckpunkt[11]));
		kanten.add(new Kante(eckpunkt[7], eckpunkt[11]));
		
		kanten.add(new Kante(eckpunkt[2], eckpunkt[6]));
		kanten.add(new Kante(eckpunkt[2], eckpunkt[7]));
		kanten.add(new Kante(eckpunkt[7], eckpunkt[9]));
		kanten.add(new Kante(eckpunkt[9], eckpunkt[11]));
		kanten.add(new Kante(eckpunkt[5], eckpunkt[11]));
		kanten.add(new Kante(eckpunkt[3], eckpunkt[5]));
		kanten.add(new Kante(eckpunkt[3], eckpunkt[4]));
		kanten.add(new Kante(eckpunkt[4], eckpunkt[10]));
		kanten.add(new Kante(eckpunkt[8], eckpunkt[10]));
		kanten.add(new Kante(eckpunkt[8], eckpunkt[6]));
		
	}
}