package projektion1;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main extends Applet implements MouseListener,MouseWheelListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;

	// Breite und Höhe des widget
	protected static int breite, hoehe;

	// Mauskoordinaten
	int mx, my;

	// Widgets
	Image bild;
	Graphics grafik;
	Graphics2D projektion;

	// Koerper
	Koerper koerper;
	Koerper[] xyz = {new X(),new Y(),new Z()};
	
	

	// Beobachterposition (Ausgangsposition, verändert sich mit MouseDragged
	// event)
	protected static int rotation = 30, erhebung = 35;

	protected static int skalierung;
	protected final static double naehe = 3; // Distanz von Sicht zur Seite des
											 // Objekts
	protected static double naeheZuObj = 0.2; // Distanz von der Seite des
													// Objekts zur Mitte

	public void init() {
		breite = getSize().width;
		hoehe = getSize().height;
		breite = 500;
		hoehe = 500;
		skalierung = (int) breite / 4;

		bild = createImage(breite, hoehe);
		grafik = bild.getGraphics();
		projektion = (Graphics2D) grafik;

		projektion.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		koerper = new Octaeder();
		

		zeichne(projektion);
		
		addMouseWheelListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void zeichne(Graphics2D g) {
		
		
		g.setColor(Color.gray);
		g.fillRect(0, 0, breite, hoehe);
		g.setColor(Color.white);
		koerper.zeichne(g);
		
		g.setColor(Color.red);
		xyz[0].zeichne(g);
		g.setColor(Color.green);
		xyz[1].zeichne(g);
		g.setColor(Color.blue);
		xyz[2].zeichne(g);
	}

	@Override
	/**
	 * MouseDragged verändert die Beobachterposition relativ zur bestehenden
	 */
	public void mouseDragged(MouseEvent e) {
		// Bestimme Mausposition
		int neu_mx = e.getX();
		int neu_my = e.getY();
		// Passe Beobachterposition um Differenz von aktueller zu letzter
		// Position an
		rotation -= neu_mx - mx;
		erhebung += neu_my - my;

		// TODO: Debug-Information entfernen
		// System.out.println(neu_mx + " " + neu_my);

		zeichne(projektion);

		// Mausposition für die nächste Anpassung puffern
		mx = neu_mx;
		my = neu_my;

		// Neu zeichnen und Mausevent abschließen
		repaint();
		e.consume();
	}

	@Override
	/**
	 * MousePressed setzt die aktuelle Mausposition als Ausgangspunkt für MouseDragged events
	 */
	public void mousePressed(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		e.consume();
	}

	public void mouseMoved(MouseEvent e) { }
	public void mouseClicked(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }

	public void update(Graphics g) {
		g.drawImage(bild, 0, 0, this);
		showStatus("Rotation: " + rotation + "�, \t Erhebung: " + erhebung + "�");
	}

	public void paint(Graphics g) {
		update(g);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		double notches = e.getWheelRotation();
		
		if(notches < 0){
			naeheZuObj=naeheZuObj-0.1;
			
			//System.out.println("UP: "+naeheZuObj);
			zeichne(projektion);
			repaint();
		}
		if(notches > 0){
			naeheZuObj=naeheZuObj+0.1;
			
			//System.out.println("DOWN: "+naeheZuObj);
			zeichne(projektion);
			repaint();
		}
		
	}
}
