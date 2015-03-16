package am1;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collection;

public class Koerper {
	Collection<Kante> kanten;

	public Koerper(Collection<Kante> kanten) {
		this.kanten = kanten;
	}

	public Collection<Kante> getKanten() {
		return kanten;
	}

	public Koerper addOrigin(double x, double y, double z) {
		Collection<Kante> kantenNeu = new ArrayList<Kante>();
		for (Kante k : kanten)
			kantenNeu.add(k.addOrigin(x, y, z));
		return new Koerper(kantenNeu);
	}

	public void moveByVector(double x, double y, double z) {
		for (Kante k : kanten)
			k.moveByVector(x, y, z);
	}

	public void reset() {
		for (Kante k : kanten)
			k.reset();
	}

	public void zeichneKoerper(Graphics2D leinwand, int breite, int hoehe) {
		for (Kante k : kanten)
			k.zeichneKante(leinwand, breite, hoehe);
	}
}