package am1;

import java.awt.Color;
import java.awt.Graphics;
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

	public void zeichneKoerper(Graphics bild, int breite, int hoehe) {
		bild.setColor(Color.blue);
		bild.fillRect(0, 0, breite, hoehe);
		for (Kante k : kanten)
			k.zeichneKante(bild, breite, hoehe);
	}
}