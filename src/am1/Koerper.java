package am1;

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
		for (Kante k : kanten) kantenNeu.add(k.addOrigin(x, y, z));
		return new Koerper(kantenNeu);
	}
}