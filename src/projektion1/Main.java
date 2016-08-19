package projektion1;

import java.applet.Applet;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Main extends Applet implements MouseListener, MouseWheelListener, MouseMotionListener, ActionListener {

	private static final long serialVersionUID = 1L;

	// Breite und Höhe des widget
	protected static int breite, hoehe;

	// Mauskoordinaten
	int mx, my;

	// Widgets
	Image bild, achsen;
	Graphics grafik;
	Graphics2D projektion;

	// Körper
	Koerper koerper;
	Koerper[] xyz = { new X(), new Y(), new Z() };

	// Checkboxen
	CheckboxGroup gruppe;
	Checkbox[] checkboxen = new Checkbox[8];

	public boolean x = true, y = true, z = true;

	// Beobachterposition (Ausgangsposition, verändert sich mit MouseDragged
	// event)
	protected static int rotation = 30, erhebung = 35;

	protected static int skalierung;
	protected final static double naehe = 3; // Distanz von Sicht zur Seite des
												// Objekts
	protected static double naeheZuObj = 0.2; // Distanz von der Seite des
												// Objekts zur Mitte

	@Override
	public void init() {
		setSize(800, 500);

		setLayout(null);

		gruppe = new CheckboxGroup();

		checkboxen[0] = new Checkbox("Tetraeder", gruppe, true);
		checkboxen[1] = new Checkbox("Hexaeder", gruppe, false);
		checkboxen[2] = new Checkbox("Oktaeder", gruppe, false);
		checkboxen[3] = new Checkbox("Dodekaeder", gruppe, false);
		checkboxen[4] = new Checkbox("Ikosaeder", gruppe, false);
		checkboxen[5] = new Checkbox("X Achse", true);
		checkboxen[6] = new Checkbox("Y Achse", true);
		checkboxen[7] = new Checkbox("Z Achse", true);

		breite = getSize().width;
		hoehe = getSize().height;
		breite = 500;
		hoehe = 500;
		skalierung = breite / 4;

		bild = createImage(breite, hoehe);
		grafik = bild.getGraphics();
		achsen = getImage(getCodeBase(), "xyz.gif");

		projektion = (Graphics2D) grafik;

		projektion.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		koerper = new Tetraeder();

		for (int i = 0; i < 8; i++) {
			checkboxen[i].setVisible(true);
		}
		checkboxen[0].addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent ie) {

				System.out.println("" + ie.getStateChange());
				if (ie.getStateChange() == 1) {
					System.out.println("Tetraeder");
					koerper = new Tetraeder();
					zeichne(projektion);
					repaint();
				}

			}

		});
		checkboxen[1].addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent ie) {

				System.out.println("" + ie.getStateChange());
				if (ie.getStateChange() == 1) {
					System.out.println("Hexaeder");
					koerper = new Wuerfel();
					zeichne(projektion);
					repaint();
				}

			}

		});
		checkboxen[2].addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent ie) {

				System.out.println("" + ie.getStateChange());
				if (ie.getStateChange() == 1) {
					System.out.println("Oktaeder");
					koerper = new Octaeder();
					zeichne(projektion);
					repaint();
				}

			}

		});
		checkboxen[3].addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent ie) {

				System.out.println("" + ie.getStateChange());
				if (ie.getStateChange() == 1) {
					System.out.println("Dodekaeder");
					koerper = new Dodekaeder();
					zeichne(projektion);
					repaint();
				}

			}

		});
		checkboxen[4].addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent ie) {

				System.out.println("" + ie.getStateChange());
				if (ie.getStateChange() == 1) {
					System.out.println("Ikosaeder");
					koerper = new Icosaeder();
					zeichne(projektion);
					repaint();
				}

			}

		});

		checkboxen[5].addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == 1) {
					System.out.println("x an");
					x = true;
					zeichne(projektion);
					repaint();
				} else {
					System.out.println("x aus");
					x = false;
					zeichne(projektion);
					repaint();
				}
			}
		});

		checkboxen[6].addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					System.out.println("y an");
					y = true;
					zeichne(projektion);
					repaint();
				} else {
					System.out.println("y aus");
					y = false;
					zeichne(projektion);
					repaint();
				}

			}
		});
		checkboxen[7].addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					System.out.println("z an");
					z = true;
					zeichne(projektion);
					repaint();
				} else {
					System.out.println("z aus");
					z = false;
					zeichne(projektion);
					repaint();
				}

			}

		});

		checkboxen[0].setBounds(510, 100, 100, 15);
		checkboxen[1].setBounds(510, 130, 100, 15);
		checkboxen[2].setBounds(510, 160, 100, 15);
		checkboxen[3].setBounds(510, 190, 100, 15);
		checkboxen[4].setBounds(510, 220, 100, 15);
		checkboxen[5].setBounds(630, 100, 100, 15);
		checkboxen[6].setBounds(630, 130, 100, 15);
		checkboxen[7].setBounds(630, 160, 100, 15);

		for (int i = 0; i < 8; i++) {
			add(checkboxen[i]);
		}

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

		if (x) {
			g.setColor(Color.red);
			xyz[0].zeichne(g);
		}
		if (!x) {

		}
		if (y) {
			g.setColor(Color.green);
			xyz[1].zeichne(g);
		}
		if (!y) {

		}
		if (z) {
			g.setColor(Color.blue);
			xyz[2].zeichne(g);
		}
		if (!z) {

		}

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

		zeichne(projektion);

		// Mausposition fÃ¼r die nÃ¤chste Anpassung puffern
		mx = neu_mx;
		my = neu_my;

		// Neu zeichnen und Mausevent abschlieÃŸen
		repaint();
		e.consume();
	}

	@Override
	/**
	 * MousePressed setzt die aktuelle Mausposition als Ausgangspunkt fÃ¼r MouseDragged events
	 */
	public void mousePressed(MouseEvent e) {

		System.out.println("gedrückt!");
		mx = e.getX();
		my = e.getY();
		e.consume();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void update(Graphics g) {
		g.drawImage(bild, 0, 0, this);
		g.drawImage(achsen, 5, 400, this);
		showStatus("Rotation: " + rotation + "°, \t Erhebung: " + erhebung + "°, Nähe: " + naeheZuObj);
	}

	@Override
	public void paint(Graphics g) {
		update(g);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		double umdrehungen = e.getWheelRotation();

		if (umdrehungen < 0) {
			naeheZuObj = naeheZuObj - 1;
			zeichne(projektion);
			repaint();
		}
		if (umdrehungen > 0) {
			naeheZuObj = naeheZuObj + 1;
			zeichne(projektion);
			repaint();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}