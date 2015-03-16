package am1;

import java.util.ArrayList;
import java.util.Collection;

public class Koerper {
	Collection<Kante_G> kanten;

	public Koerper(Collection<Kante_G> kanten) {
		this.kanten = kanten;
	}

	public Collection<Kante_G> getKanten() {
		return kanten;
	}
	
	public Koerper addOrigin(double x, double y, double z) {
		Collection<Kante_G> kantenNeu = new ArrayList<Kante_G>();
		for (Kante_G k : kanten) kantenNeu.add(k.addOrigin(x, y, z));
		return new Koerper(kantenNeu);
	}
}