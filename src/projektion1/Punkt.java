package projektion1;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 * 
 * @author georgjung
 *
 *         Die Klasse Punkt speichert dreidimensionale Punkte und ihre jeweilige
 *         Projektion in die zweidimensionale Fläche. Sie braucht dazu die
 *         statischen Variablen rotation, erhebung, hoehe, breite uns skalierung
 *         aus der Klasse Main.
 * 
 *         Die Koeffizienten der Projektion, die auf Winkelfunktionen beruhen,
 *         werden nur bei Änderung des Blickwinkels neu berechnet und für alle
 *         Punkte statisch abgelegt.
 */
public class Punkt{
	// Koeffizienten zur perspektivischen Projektion
	private static double theta = Math.PI * Main.rotation / 180.0;
	private static double phi = Math.PI * Main.erhebung / 180.0;
	private static double cosT = Math.cos(theta), sinT = Math.sin(theta);
	private static double cosP = Math.cos(phi), sinP = Math.sin(phi);
	private static double cosTcosP = cosT * cosP, cosTsinP = cosT * sinP,
			sinTcosP = sinT * cosP, sinTsinP = sinT * sinP;

	// Koordinaten
	double x, y, z;

	// Projektion in 2D
	int px, py;

	
	
	
	/**
	 * 
	 * @param x
	 *            x-Koordinate des Punktes
	 * @param y
	 *            y-Koordinate des Punktes
	 * @param z
	 *            z-Koordinate des Punktes
	 * 
	 * @param    x-, y- und z-Koordinate des Punktes. Die Projektion wird
	 *            automatisch berechnet und bis zur Änderung des Blickwinkels
	 *            abgelegt
	 */
	public Punkt(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;

		this.projektion();
	}

	/**
	 * Statische Berechnung der Projektionskoeffizienten (einmal für alle
	 * Punkte)
	 */
	public static void projektionWerte() {
		theta = Math.PI * Main.rotation / 180.0;
		phi = Math.PI * Main.erhebung / 180.0;
		cosT = Math.cos(theta);
		sinT = Math.sin(theta);
		cosP = Math.cos(phi);
		sinP = Math.sin(phi);
		cosTcosP = cosT * cosP;
		cosTsinP = cosT * sinP;
		sinTcosP = sinT * cosP;
		sinTsinP = sinT * sinP;
		
	}

	public void projektion() {
		// Senkrechte Projektion
		double x1 = cosT * x + sinT * z;
		double y1 = -sinTsinP * x + cosP * y + cosTsinP * z;

		// Fluchtpunktperspektive
		double z1 = cosTcosP * z - sinTcosP * x - sinP * y;
		x1 = x1 * Main.naehe / (z1 + Main.naehe + Main.naeheZuObj);
		y1 = y1 * Main.naehe / (z1 + Main.naehe + Main.naeheZuObj);

		// Addiere 0,5 um beim Integercast eine Rundung zu erhalten
		px = (int) (Main.breite / 2 + Main.skalierung * x1 + 0.5);
		py = (int) (Main.hoehe / 2 - Main.skalierung * y1 + 0.5);
	}
	
}
