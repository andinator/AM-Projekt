package projektion1;

import java.awt.Graphics2D;
import java.util.Collection;

public class Koerper {
	Collection<Punkt> punkte;
	Collection<Kante> kanten;

	public Koerper(Collection<Punkt> punkte, Collection<Kante> kanten) {
		this.punkte = punkte;
		this.kanten = kanten;
	}

	public void zeichne(Graphics2D leinwand) {
		Punkt.projektionWerte();
		for (Punkt p : punkte)
			p.projektion();
		for (Kante k : kanten)
			k.zeichne(leinwand);
	}
}
