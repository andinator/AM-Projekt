package projektion1;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class Main extends Applet implements MouseListener,MouseWheelListener, MouseMotionListener, ActionListener {

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
	
	//Checkboxen
	CheckboxGroup gruppe;
	
	Checkbox box1;
	Checkbox box2;
	Checkbox box3;
	Checkbox box4;
	Checkbox box5;

	// Beobachterposition (Ausgangsposition, verändert sich mit MouseDragged
	// event)
	protected static int rotation = 30, erhebung = 35;

	protected static int skalierung;
	protected final static double naehe = 3; // Distanz von Sicht zur Seite des
											 // Objekts
	protected static double naeheZuObj = 0.2; // Distanz von der Seite des
													// Objekts zur Mitte

	public void init() {
		setSize(600,500);
		
		setLayout(null); 
		
		gruppe = new CheckboxGroup();
		
		box1 = new Checkbox("Tetraeder",true);
		box2 = new Checkbox("Hexaeder",false);
		box3 = new Checkbox("Oktaeder",false);
		box4 = new Checkbox("Dodekaeder",false);
		box5 = new Checkbox("Ikosaeder",false);
		
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

		koerper = new Icosaeder();
		
		//gruppe.add(box1);
		
		box1.setVisible(true);
		box2.setVisible(true);
		box3.setVisible(true);
		box4.setVisible(true);
		box5.setVisible(true);
		
		box1.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent ie) {
				
				System.out.println(""+ie.getStateChange());
				if(ie.getStateChange()==1){
					System.out.println("Tetraeder");
				}
				
			}
			
		});
		box2.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent ie) {
				
				System.out.println(""+ie.getStateChange());
				if(ie.getStateChange()==1){
					System.out.println("Hexaeder");
				}
				
			}
			
		});
		box3.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent ie) {
				
				System.out.println(""+ie.getStateChange());
				if(ie.getStateChange()==1){
					System.out.println("Oktaeder");
				}
				
			}
			
		});
		box4.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent ie) {
				
				System.out.println(""+ie.getStateChange());
				if(ie.getStateChange()==1){
					System.out.println("Dodekaeder");
				}
				
			}
			
		});
		box5.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent ie) {
				
				System.out.println(""+ie.getStateChange());
				if(ie.getStateChange()==1){
					System.out.println("Ikosaeder");
				}
				
			}
			
		});
		
		box1.setBounds(510, 100, 100, 10);
		box2.setBounds(510, 120, 100, 10);
		box3.setBounds(510, 140, 100, 10);
		box4.setBounds(510, 160, 100, 10);
		box5.setBounds(510, 180, 100, 10);
		
        add(box1);
        add(box2);
        add(box3);
        add(box4);
        add(box5);
		
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
		showStatus("Rotation: " + rotation + "�, \t Erhebung: " + erhebung + "�, N�he: " + naeheZuObj);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
