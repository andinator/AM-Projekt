package am1;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
public class Main2 extends Applet implements MouseListener, MouseMotionListener {
   int breite, hoehe;
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
      hoehe = getSize().height;
      
      
      
      zwischenBild = createImage( breite, hoehe );
      bild = zwischenBild.getGraphics();
      zeichneKoerper(bild);
      addMouseListener(this);
      addMouseMotionListener(this);
   }
   void zeichneKoerper(Graphics g) {
       
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
      float naehe = 3;  // Distanz von Sicht zur Seite des Objekts
      float naeheZuObj = 1.5f;  // Distanz von der Seite des Objekts zur Mitte
      for ( j = 0; j < eckpunkt.length; ++j ) {
         int x0 = eckpunkt[j].x;
         int y0 = eckpunkt[j].y;
         int z0 = eckpunkt[j].z;
         
         // compute an orthographic projection
         float x1 = cosT*x0 + sinT*z0;
         float y1 = -sinTsinP*x0 + cosP*y0 + cosTsinP*z0;
         // now adjust things to get a perspective projection
         float z1 = cosTcosP*z0 - sinTcosP*x0 - sinP*y0;
         x1 = x1*naehe/(z1+naehe+naeheZuObj);
         y1 = y1*naehe/(z1+naehe+naeheZuObj);
         // the 0.5 is to round off when converting to int
         punkte[j] = new Point(
            (int)(breite/2 + scaleFactor*x1 + 0.5),
            (int)(hoehe/2 - scaleFactor*y1 + 0.5)
         );
      }
      // Zeichne
      
      g2.setColor(Color.blue);
      g2.fillRect(0, 0, breite, hoehe);
     
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
      // winkel anpassen zur Ver�nderung der Mausposition
      seite -= neu_mx - mx;
      hoch += neu_my - my;
      
      System.out.println(neu_mx+" "+neu_my);
      // update buffer
      zeichneKoerper(bild);
      // update Mausposition
      mx = neu_mx;
      my = neu_my;
      repaint();
      e.consume();
   }
   public void update(Graphics g) {
      g.drawImage(zwischenBild, 0, 0, this);
      showStatus("hoehe: "+hoch+" Grad, Seite: "+seite+" Grad");
   }
   public void paint(Graphics g) {
      update(g);
   }
}