package am1;

import java.applet.Applet;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

public class Visualizer extends Applet implements MouseListener,
		MouseMotionListener {

	private static final long serialVersionUID = -3973811292811750174L;
	public static int seite = 35, hoch = 30;

	int mx, my;
	Image zwischenBild;
	Graphics bild;
	Koerper wuerfel;
	Koerper tetraeder;

	public void init() {
		wuerfel = new Wuerfel();
		tetraeder = new Tetraeder();

		zwischenBild = createImage(getSize().width, getSize().height);

		bild = zwischenBild.getGraphics();

		zeichne(wuerfel);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	void zeichne(Koerper k) {
		Graphics2D leinwand = (Graphics2D) bild;
		leinwand.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		leinwand.setColor(Color.blue);
		leinwand.fillRect(0, 0, getSize().width, getSize().height);

		Color farbe = new Color(255, 255, 255, 255);
		leinwand.setColor(farbe);
		k.zeichneKoerper(leinwand, getSize().width, getSize().height);
	}

	public void mouseDragged(MouseEvent e) {
		// letzte Mausposition
		int neu_mx = e.getX();
		int neu_my = e.getY();
		// winkel anpassen zur Veränderung der Mausposition
		seite -= neu_mx - mx;
		hoch += neu_my - my;

		System.out.println(neu_mx + " " + neu_my);
		// update buffer
		zeichne(wuerfel);
		// update Mausposition
		mx = neu_mx;
		my = neu_my;
		repaint();
		e.consume();
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		e.consume();
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
	
	public void update(Graphics g) {
		g.drawImage(zwischenBild, 0, 0, this);
		showStatus("hoehe: " + hoch + " Grad, Seite: " + seite + " Grad");
	}

	public void paint(Graphics g) {
		update(g);
	}

}
