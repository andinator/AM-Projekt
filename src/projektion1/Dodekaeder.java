package projektion1;

import java.lang.Math;
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
		
		//(-Math.sqrt(1+2/Math.sqrt(5)), 0, Math.sqrt(1-20*Math.pow(0.262866,2)+80*Math.pow(0.262866,4)))  //near  x = 0.262866,
		// (Math.sqrt(1+2/Math.sqrt(5)), 0, Math.sqrt(1-20*Math.pow(-0.262866,2)+80*Math.pow(-0.262866,4))) , //near  x = -0.262866
		// (Math.sqrt(1-20*-Math.pow(-0.425325,2)+80*Math.pow(-0.425325,4)) /* near  x = -0.425325*/, 1/4*(-3-Math.sqrt(5)),Math.sqrt(1-20*Math.pow(0.262866,2)+80*Math.pow(0.262866,4 ))),// near  x = 0.262866
		// (Math.sqrt(1-20*Math.pow(-0.425325,2)+80*Math.pow(-0.425325,4))  /*near  x = -0.425325*/, 1/4*(3+Math.sqrt(5)),Math.sqrt(1-20*Math.pow(0.262866,2)+80*Math.pow(0.262866,4))), // near  x = 0.262866,
		// (Math.sqrt(5/8+11/(8*Math.sqrt(5))), 1/4*(-1-Math.sqrt(5)), Math.sqrt(1-20*Math.pow(0.262866,2)+80*Math.pow(0.262866,4))) // near  x = 0.262866,
		// (Math.sqrt(5/8+11/(8*Math.sqrt(5))), 1/4*(1+Math.sqrt(5)),Math.sqrt(1-20*Math.pow(0.262866,2)+80*Math.pow(0.262866,4)) ,//near  x = 0.262866
		 
		// (Math.sqrt(1-20*Math.pow(-0.262866,2)+80*Math.pow(-0.262866,4)) /* near  x = -0.262866*/, 1/4*(-1-Math.sqrt(5)), Math.sqrt(5/8+11/(8*Math.sqrt(5)))),
		// (Math.sqrt(1-20*Math.pow(-0.262866,2)+80*Math.pow(-0.262866,4)) /* near  x = -0.262866*/, 1/4*(1+Math.sqrt(5)), Math.sqrt(5/8+11/(8*Math.sqrt(5)))),
		// (-1/2*Math.sqrt(1+2/Math.sqrt(5)), -1/2, Math.sqrt(1-100*Math.pow(-1.11352,2)+80*Math.pow(-1.11352,4))), //near  x = -1.11352
		// (-1/2*Math.sqrt(1+2/Math.sqrt(5)), 1/2, Math.sqrt(1-100*Math.pow(-1.11352,2)+80*Math.pow(-1.11352,4))), //near  x = -1.11352
		// (Math.sqrt(1/4+1/(2*Math.sqrt(5))), -1/2, Math.sqrt(5/8+11/(8*Math.sqrt(5)))),
		// (Math.sqrt(1/4+1/(2*Math.sqrt(5))), 1/2, Math.sqrt(5/8+11/(8*Math.sqrt(5)))),
		
		// (Math.sqrt(1/10*(5+Math.sqrt(5))), 0, Math.sqrt(1-100*Math.pow(-1.11352,2)+80*Math.pow(-1.11352,4))), //near  x = -1.11352
		// (Math.sqrt(1-100*Math.pow(-1.11352,2)+80*Math.pow(-1.11352,4)) /* near  x = -1.11352*/, 1/4*(-1-Math.sqrt(5)),Math.sqrt(1-20*Math.pow(-0.262866,2)+80*Math.pow(-0.262866,4))), //near  x = -0.262866
		// (Math.sqrt(1-100*Math.pow(-1.11352,2)+80*Math.pow(-1.11352,4)) /* near  x = -1.11352*/, 1/4*(1+Math.sqrt(5)),Math.sqrt(1-20*Math.pow(-0.262866,2)+80*Math.pow(-0.262866,4 ))), //near  x = -0.262866
		// (Math.sqrt(1-5*Math.pow(-0.850651,2)+5*Math.pow(-0.850651,4)) /* near  x = -0.850651*/, 0, Math.sqrt(5/8+11/(8*Math.sqrt(5)))),
		// (Math.sqrt(1-20*Math.pow(0.262866,2)+80*Math.pow(0.262866,4)) /* near  x = 0.262866*/, 1/4*(-1-Math.sqrt(5)),Math.sqrt(1-100*Math.pow(-1.11352,2)+80*Math.pow(-1.11352,4 ))), //near  x = -1.11352
		// (Math.sqrt(1-20*Math.pow(0.262866,2)+80*Math.pow(0.262866,4)) /* near  x = 0.262866*/, 1/4*(1+Math.sqrt(5)),Math.sqrt(1-100*Math.pow(-1.11352,2)+80*Math.pow(-1.11352,4 ))), //near  x = -1.11352
		
		//(Math.sqrt(1/8+1/(8*Math.sqrt(5))), 1/4*(-3-Math.sqrt(5)),Math.sqrt(1-20*Math.pow(-0.262866,2)+80*Math.pow(-0.262866,4 ))), //near  x = -0.262866
		// (Math.sqrt(1/8+1/(8*Math.sqrt(5))), 1/4*(3+Math.sqrt(5)), Math.sqrt(1-20*Math.pow(-0.262866,2)+80*Math.pow(-0.262866,4 ))) //near  x = -0.262866
		
		
		
		
		
		
		for (Punkt p : eckpunkt) 
			punkte.add(p);

		/*kanten.add(new Kante(eckpunkt[0], eckpunkt[0]));
		kanten.add(new Kante(eckpunkt[1], eckpunkt[1]));
		kanten.add(new Kante(eckpunkt[2], eckpunkt[2]));
		kanten.add(new Kante(eckpunkt[3], eckpunkt[3]));
		kanten.add(new Kante(eckpunkt[4], eckpunkt[4]));
		
		kanten.add(new Kante(eckpunkt[5], eckpunkt[5]));
		kanten.add(new Kante(eckpunkt[6], eckpunkt[6]));
		kanten.add(new Kante(eckpunkt[7], eckpunkt[7]));
		kanten.add(new Kante(eckpunkt[8], eckpunkt[8]));
		kanten.add(new Kante(eckpunkt[9], eckpunkt[9]));
		
		kanten.add(new Kante(eckpunkt[10], eckpunkt[10]));
		kanten.add(new Kante(eckpunkt[11], eckpunkt[11]));
		kanten.add(new Kante(eckpunkt[12], eckpunkt[12]));
		kanten.add(new Kante(eckpunkt[13], eckpunkt[13]));
		kanten.add(new Kante(eckpunkt[14], eckpunkt[14]));
		
		kanten.add(new Kante(eckpunkt[15], eckpunkt[15]));
		kanten.add(new Kante(eckpunkt[16], eckpunkt[16]));
		kanten.add(new Kante(eckpunkt[17], eckpunkt[17]));
		kanten.add(new Kante(eckpunkt[18], eckpunkt[18]));
		kanten.add(new Kante(eckpunkt[19], eckpunkt[19]));*/
		
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
		
		/*kanten.add(new Kante(eckpunkt[0], eckpunkt[1]));
		kanten.add(new Kante(eckpunkt[1], eckpunkt[2]));
		kanten.add(new Kante(eckpunkt[2], eckpunkt[3]));
		kanten.add(new Kante(eckpunkt[3], eckpunkt[4]));
		kanten.add(new Kante(eckpunkt[4], eckpunkt[5]));
		
		kanten.add(new Kante(eckpunkt[5], eckpunkt[6]));
		kanten.add(new Kante(eckpunkt[6], eckpunkt[7]));
		kanten.add(new Kante(eckpunkt[7], eckpunkt[8]));
		kanten.add(new Kante(eckpunkt[8], eckpunkt[9]));
		kanten.add(new Kante(eckpunkt[9], eckpunkt[10]));
		
		kanten.add(new Kante(eckpunkt[10], eckpunkt[11]));
		kanten.add(new Kante(eckpunkt[11], eckpunkt[12]));
		kanten.add(new Kante(eckpunkt[12], eckpunkt[13]));
		kanten.add(new Kante(eckpunkt[13], eckpunkt[14]));
		kanten.add(new Kante(eckpunkt[14], eckpunkt[15]));
		
		kanten.add(new Kante(eckpunkt[15], eckpunkt[16]));
		kanten.add(new Kante(eckpunkt[16], eckpunkt[17]));
		kanten.add(new Kante(eckpunkt[17], eckpunkt[18]));
		kanten.add(new Kante(eckpunkt[18], eckpunkt[19]));
		kanten.add(new Kante(eckpunkt[19], eckpunkt[0]));*/
		
		/*kanten.add(new Kante(eckpunkt[2], eckpunkt[6]));
		kanten.add(new Kante(eckpunkt[2], eckpunkt[7]));
		kanten.add(new Kante(eckpunkt[7], eckpunkt[9]));
		kanten.add(new Kante(eckpunkt[9], eckpunkt[11]));
		kanten.add(new Kante(eckpunkt[5], eckpunkt[11]));
		kanten.add(new Kante(eckpunkt[3], eckpunkt[5]));
		kanten.add(new Kante(eckpunkt[3], eckpunkt[4]));
		kanten.add(new Kante(eckpunkt[4], eckpunkt[10]));
		kanten.add(new Kante(eckpunkt[8], eckpunkt[10]));
		kanten.add(new Kante(eckpunkt[8], eckpunkt[6]));*/
		
	}
}