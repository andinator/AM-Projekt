package am1;

import java.applet.Applet;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;
import java.awt.Image;

public class Visualizer extends Applet implements MouseListener, MouseMotionListener {

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

		wuerfel.zeichneKoerper(bild, getSize().width, getSize().height);
		addMouseListener(this);
		addMouseMotionListener(this);

	}

	public void mouseDragged(MouseEvent e) { 
	      // letzte Mausposition
	      int neu_mx = e.getX();
	      int neu_my = e.getY();
	      // winkel anpassen zur Veränderung der Mausposition
	      seite -= neu_mx - mx;
	      hoch += neu_my - my;
	      
	      System.out.println(neu_mx+" "+neu_my);
	      // update buffer
	      wuerfel.zeichneKoerper(bild, getSize().width, getSize().height);
	      // update Mausposition
	      mx = neu_mx;
	      my = neu_my;
	      repaint();
	      e.consume();
	   }
	public void mouseMoved(MouseEvent e) { }
	public void mouseClicked(MouseEvent e) {
	      mx = e.getX();
	      my = e.getY();
	      e.consume();
	    }
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }

}
