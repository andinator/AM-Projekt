package projektion1;

import java.awt.Graphics2D;

public class Kante {
	Punkt s, e;

	public Kante(Punkt s, Punkt e) {
		this.s = s;
		this.e = e;
	}

	public void zeichne(Graphics2D leinwand) {
		leinwand.drawLine(s.px, s.py, e.px, e.py);
	}

}
