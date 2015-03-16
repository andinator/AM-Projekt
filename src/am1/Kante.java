package am1;

public class Kante {
	Punkt3D_G s, e;

	public Kante(Punkt3D_G s, Punkt3D_G e) {
		this.s = s;
		this.e = e;
	}
	
	public Kante addOrigin(double x, double y, double z) {
		return new Kante (this.s.addOrigin(x, y, z), this.e.addOrigin(x, y, z));
	}
}
