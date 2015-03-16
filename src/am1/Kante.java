package am1;

import java.awt.Graphics;

public class Kante {
	Punkt3D s, e;

	public Kante(Punkt3D s, Punkt3D e) {
		this.s = s;
		this.e = e;
	}
	
	public Kante addOrigin(double x, double y, double z) {
		return new Kante (this.s.addOrigin(x, y, z), this.e.addOrigin(x, y, z));
	}
	
	public void moveByVector(double x, double y, double z) {
		this.s.moveByVector(x, y, z);
		this.e.moveByVector(x, y, z);
	}
	
	public void reset () {
		s.reset();
		e.reset();
	}
	
	public void zeichneKante(Graphics bild, int breite, int hoehe) {
		
	}
}
