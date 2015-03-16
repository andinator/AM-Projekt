package am1;

public class Kante_G {
	Punkt3D_G s, e;

	public Kante_G(Punkt3D_G s, Punkt3D_G e) {
		this.s = s;
		this.e = e;
	}
	
	public Kante_G addOrigin(double x, double y, double z) {
		return new Kante_G (this.s.addOrigin(x, y, z), this.e.addOrigin(x, y, z));
	}
}
