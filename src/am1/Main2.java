package am1;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
public class Main2 extends Applet implements MouseListener, MouseMotionListener {
   int breite, höhe;
   int mx, my;  // Mauskoordinaten
   Image zwischenBild;
   Graphics bild;
   int seite = 35, hoch = 30;
   Punkt3D[] eckpunkt;
   Punkt3D[] eckpunkt2;
   Kante[] kante;
   Kante[] kante2;
   public void init() {
      breite = getSize().width;
      höhe = getSize().height;
      
      //Bereechnungen Tetraeder
      eckpunkt2 = new Punkt3D[ 8 ];
      eckpunkt2[0] = new Punkt3D(0, 0, Math.sqrt((2/3))-(1/(2*(Math.sqrt(6)))));
      eckpunkt2[1] = new Punkt3D((-1/(2*(Math.sqrt(3)))), -0.5, (-1/(2*(Math.sqrt(6)))));
      eckpunkt2[2] = new Punkt3D((-1/(2*(Math.sqrt(3)))),  0.5, (-1/(2*(Math.sqrt(6)))));
      eckpunkt2[3] = new Punkt3D((1/(Math.sqrt(3))),  0,  (-1/(2*(Math.sqrt(6)))));
      eckpunkt2[4] = new Punkt3D( 1, -1, -1);
      eckpunkt2[5] = new Punkt3D( 1, -1,  1);
      eckpunkt2[6] = new Punkt3D( 1,  1, -1);
      eckpunkt2[7] = new Punkt3D( 1,  1,  1);
      kante2 = new Kante[12];
      kante2[0] = new Kante(0, 1);
      kante2[1] = new Kante(0, 2);
      kante2[2] = new Kante(0, 4);
      kante2[3] = new Kante(1, 3);
      kante2[4] = new Kante(1, 5);
      kante2[5] = new Kante(2, 3);
      kante2[6] = new Kante(2, 6);
      kante2[7] = new Kante(3, 7);
      kante2[8] = new Kante(4, 5);
      kante2[9] = new Kante(4, 6);
      kante2[10] = new Kante(5, 7);
      kante2[11] = new Kante(6, 7);
      
      
      //Würfel
      eckpunkt = new Punkt3D[ 8 ];
      eckpunkt[0] = new Punkt3D(-1, -1, -1);
      eckpunkt[1] = new Punkt3D(-1, -1,  1);
      eckpunkt[2] = new Punkt3D(-1,  1, -1);
      eckpunkt[3] = new Punkt3D(-1,  1,  1);
      eckpunkt[4] = new Punkt3D( 1, -1, -1);
      eckpunkt[5] = new Punkt3D( 1, -1,  1);
      eckpunkt[6] = new Punkt3D( 1,  1, -1);
      eckpunkt[7] = new Punkt3D( 1,  1,  1);
      kante = new Kante[12];
      kante[0] = new Kante(0, 1);
      kante[1] = new Kante(0, 2);
      kante[2] = new Kante(0, 4);
      kante[3] = new Kante(1, 3);
      kante[4] = new Kante(1, 5);
      kante[5] = new Kante(2, 3);
      kante[6] = new Kante(2, 6);
      kante[7] = new Kante(3, 7);
      kante[8] = new Kante(4, 5);
      kante[9] = new Kante(4, 6);
      kante[10] = new Kante(5, 7);
      kante[11] = new Kante(6, 7);
      
      
      
      zwischenBild = createImage( breite, höhe );
      bild = zwischenBild.getGraphics();
      zeichneKörper(bild);
      addMouseListener(this);
      addMouseMotionListener(this);
   }
   void zeichneKörper(Graphics g) {
       
       Graphics2D g2 = (Graphics2D) g;
       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
          RenderingHints.VALUE_ANTIALIAS_ON);
      // compute coefficients for the projection
      double theta = Math.PI * seite / 180.0;
      double phi = Math.PI * hoch / 180.0;
      float cosT = (float)Math.cos( theta ), sinT = (float)Math.sin( theta );
      float cosP = (float)Math.cos( phi ), sinP = (float)Math.sin( phi );
      float cosTcosP = cosT*cosP, cosTsinP = cosT*sinP, sinTcosP = sinT*cosP, sinTsinP = sinT*sinP;
      // project edge onto the 2D viewport
      Point[] punkte;
      punkte = new Point[eckpunkt.length];
      int j;
      int scaleFactor = breite/4;
      float nähe = 3;  // Distanz von Sicht zur Seite des Objekts
      float näheZuObj = 1.5f;  // Distanz von der Seite des Objekts zur Mitte
      for ( j = 0; j < eckpunkt.length; ++j ) {
         int x0 = eckpunkt[j].x;
         int y0 = eckpunkt[j].y;
         int z0 = eckpunkt[j].z;
         
         // compute an orthographic projection
         float x1 = cosT*x0 + sinT*z0;
         float y1 = -sinTsinP*x0 + cosP*y0 + cosTsinP*z0;
         // now adjust things to get a perspective projection
         float z1 = cosTcosP*z0 - sinTcosP*x0 - sinP*y0;
         x1 = x1*nähe/(z1+nähe+näheZuObj);
         y1 = y1*nähe/(z1+nähe+näheZuObj);
         // the 0.5 is to round off when converting to int
         punkte[j] = new Point(
            (int)(breite/2 + scaleFactor*x1 + 0.5),
            (int)(höhe/2 - scaleFactor*y1 + 0.5)
         );
      }
      // Zeichne
      
      g2.setColor(Color.blue);
      g2.fillRect(0, 0, breite, höhe);
     
      for (j = 0; j < kante.length; ++j) {
          Color farbe = new Color(255,255,255,255);
          g2.setColor(farbe);
         g2.drawLine(
                
            punkte[kante[j].a].x, punkte[ kante[j].a ].y,
            punkte[kante[j].b].x, punkte[ kante[j].b ].y
         );
      }
      
   }
   public void mouseEntered(MouseEvent e) {}
   public void mouseExited(MouseEvent e) {}
   public void mouseClicked(MouseEvent e) {}
   public void mousePressed(MouseEvent e) {
      mx = e.getX();
      my = e.getY();
      e.consume();
   }
   public void mouseReleased( MouseEvent e) { }
   public void mouseMoved(MouseEvent e) { }
   public void mouseDragged(MouseEvent e) {
      // letzte Mausposition
      int neu_mx = e.getX();
      int neu_my = e.getY();
      // winkel anpassen zur Veränderung der Mausposition
      seite -= neu_mx - mx;
      hoch += neu_my - my;
      
      System.out.println(neu_mx+" "+neu_my);
      // update buffer
      zeichneKörper(bild);
      // update Mausposition
      mx = neu_mx;
      my = neu_my;
      repaint();
      e.consume();
   }
   public void update(Graphics g) {
      g.drawImage(zwischenBild, 0, 0, this);
      showStatus("Höhe: "+hoch+" Grad, Seite: "+seite+" Grad");
   }
   public void paint(Graphics g) {
      update(g);
   }
}
class Punkt3D {
       public int x, y, z;
       public Punkt3D( double e, double Y, double d ) {
          x = (int) e;
          y = (int) Y;
          z = (int) d;
       }
    }
    class Kante {
       public int a, b;
       public Kante( int A, int B ) {
          a = A;
          b = B;
       }
    }