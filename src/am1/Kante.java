package am1;

import java.awt.Graphics2D;
import java.awt.Point;

public class Kante {
	Punkt3D s, e;

	public Kante(Punkt3D s, Punkt3D e) {
		this.s = s;
		this.e = e;
	}

	public Kante addOrigin(double x, double y, double z) {
		return new Kante(this.s.addOrigin(x, y, z), this.e.addOrigin(x, y, z));
	}

	public void moveByVector(double x, double y, double z) {
		this.s.moveByVector(x, y, z);
		this.e.moveByVector(x, y, z);
	}

	public void reset() {
		s.reset();
		e.reset();
	}

	public void zeichneKante(Graphics2D leinwand, int breite, int hoehe) {
		Point s0 = s.project(breite, hoehe);
		Point e0 = e.project(breite, hoehe);

		leinwand.drawLine(s0.x, s0.y, e0.x, e0.y);
	}
}
