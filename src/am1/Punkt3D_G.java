package am1;

public class Punkt3D_G {
	double x, y, z;

	public Punkt3D_G(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Punkt3D_G addOrigin(double x, double y, double z) {
		return new Punkt3D_G(this.x + x, this.y + y, this.z + z);
	}

}
