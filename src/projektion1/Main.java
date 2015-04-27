package projektion1;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Main extends Applet implements MouseListener, MouseWheelListener,
		MouseMotionListener, ActionListener {

	private static final long serialVersionUID = 1L;

	// Breite und Höhe des widget
	protected static int breite, hoehe;

	// Mauskoordinaten
	int mx, my;

	// Widgets
	Image bild, achsen;
	Graphics grafik;
	Graphics2D projektion;

	// Koerper
	Koerper koerper;
	Koerper[] xyz = { new X(), new Y(), new Z() };

	// Checkboxen
	CheckboxGroup gruppe;

	Checkbox box1;
	Checkbox box2;
	Checkbox box3;
	Checkbox box4;
	Checkbox box5;
	Checkbox box6;
	Checkbox box7;
	Checkbox box8;
	Checkbox roboter;

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

		box1 = new Checkbox("Tetraeder", gruppe, true);
		box2 = new Checkbox("Hexaeder", gruppe, false);
		box3 = new Checkbox("Oktaeder", gruppe, false);
		box4 = new Checkbox("Dodekaeder", gruppe, false);
		box5 = new Checkbox("Ikosaeder", gruppe, false);
		box6 = new Checkbox("X Achse", true);
		box7 = new Checkbox("Y Achse", true);
		box8 = new Checkbox("Z Achse", true);
		roboter = new Checkbox("Automatisch ", false);

		breite = getSize().width;
		hoehe = getSize().height;
		breite = 500;
		hoehe = 500;
		skalierung = breite / 4;

		bild = createImage(breite, hoehe);
		grafik = bild.getGraphics();
		achsen = getImage(getCodeBase(), "xyz.gif");

		// g.drawImage( bild, 5, 400, this );
		projektion = (Graphics2D) grafik;

		projektion.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		koerper = new Tetraeder();

		// gruppe.add(box1);

		box1.setVisible(true);
		box2.setVisible(true);
		box3.setVisible(true);
		box4.setVisible(true);
		box5.setVisible(true);
		box6.setVisible(true);
		box7.setVisible(true);
		box8.setVisible(true);
		roboter.setVisible(true);

		box1.addItemListener(new ItemListener() {

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
		box2.addItemListener(new ItemListener() {

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
		box3.addItemListener(new ItemListener() {

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
		box4.addItemListener(new ItemListener() {

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
		box5.addItemListener(new ItemListener() {

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

		box6.addItemListener(new ItemListener() {

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

		box7.addItemListener(new ItemListener() {

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
		box8.addItemListener(new ItemListener() {

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

		roboter.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					System.out.println("Automatik");
					final Roboter roboter = new Roboter();

					for (int i = 0; i < 6; i++) {

						
								roboter.rechts();
						
						

						zeichne(projektion);

						
						repaint();

						try {
							Thread.sleep(100);
						} catch (InterruptedException e1) {
							
							e1.printStackTrace();
						}
					}

				}
			}
		});


		box1.setBounds(510, 100, 100, 15);
		box2.setBounds(510, 130, 100, 15);
		box3.setBounds(510, 160, 100, 15);
		box4.setBounds(510, 190, 100, 15);
		box5.setBounds(510, 220, 100, 15);
		box6.setBounds(630, 100, 100, 15);
		box7.setBounds(630, 130, 100, 15);
		box8.setBounds(630, 160, 100, 15);
		roboter.setBounds(510, 270, 100, 15);

		add(box1);
		add(box2);
		add(box3);
		add(box4);
		add(box5);
		add(box6);
		add(box7);
		add(box8);
		add(roboter);

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
		System.out.println("gedr�ckt!");
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
		showStatus("Rotation: " + rotation + "�, \t Erhebung: " + erhebung + "�, N�he: " + naeheZuObj);
	}

	@Override
	public void paint(Graphics g) {
		update(g);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		double umdrehungen = e.getWheelRotation();

		if (umdrehungen < 0) {
			naeheZuObj = naeheZuObj - 0.1;

			// System.out.println("UP: "+naeheZuObj);
			zeichne(projektion);
			repaint();
		}
		if (umdrehungen > 0) {
			naeheZuObj = naeheZuObj + 0.1;

			// System.out.println("DOWN: "+naeheZuObj);
			zeichne(projektion);
			repaint();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}