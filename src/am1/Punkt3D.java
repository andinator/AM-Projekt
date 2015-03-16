package am1;

import java.awt.Point;

public class Punkt3D {
	double xOrig, yOrig, zOrig;
	double x, y, z;

	public Punkt3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		xOrig = x;
		yOrig = y;
		zOrig = z;
	}

	public Punkt3D addOrigin(double x, double y, double z) {
		return new Punkt3D(this.x + x, this.y + y, this.z + z);
	}

	public void moveByVector(double x, double y, double z) {
		this.x += x;
		this.y += y;
		this.z += z;
	}

	public void reset() {
		x = xOrig;
		y = yOrig;
		z = zOrig;
	}
	
	public Point project (int breite, int hoehe) {
	    int scaleFactor = breite/4;
		
	    double theta = Math.PI * Visualizer.seite / 180.0;
		double phi = Math.PI * Visualizer.hoch / 180.0;
		float cosT = (float)Math.cos( theta ), sinT = (float)Math.sin( theta );
		float cosP = (float)Math.cos( phi ), sinP = (float)Math.sin( phi );
		float cosTcosP = cosT*cosP, cosTsinP = cosT*sinP, sinTcosP = sinT*cosP, sinTsinP = sinT*sinP;
		
	    float naehe = 3;  // Distanz von Sicht zur Seite des Objekts
	    float naeheZuObj = 1.5f;  // Distanz von der Seite des Objekts zur Mitte
	    
		double x2d = cosT*x + sinT*z;
        double y2d = -sinTsinP*x + cosP*y + cosTsinP*z;

        // now adjust things to get a perspective projection
        double zTmp = cosTcosP*z - sinTcosP*x - sinP*y;
        x2d = x2d*naehe/(zTmp+naehe+naeheZuObj);
        y2d = y2d*naehe/(zTmp+naehe+naeheZuObj);
        
        // the 0.5 is to round off when converting to int
        return new Point(
           (int)(breite/2 + scaleFactor*x2d + 0.5),
           (int)(hoehe/2 - scaleFactor*y2d + 0.5)
        );
	}

}
