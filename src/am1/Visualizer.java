package am1;

import java.applet.Applet;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Dimension;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Collection;

public class Visualizer extends Applet implements MouseListener,
		MouseMotionListener {

	Dimension groesse;
	
	public void init () {
		groesse = getSize();
		
		Punkt3D_G[] eckpunkt;
		
		// Würfel
		eckpunkt = new Punkt3D_G[8];
		eckpunkt[0] = new Punkt3D_G(-1, -1, -1);
		eckpunkt[1] = new Punkt3D_G(-1, -1, 1);
		eckpunkt[2] = new Punkt3D_G(-1, 1, -1);
		eckpunkt[3] = new Punkt3D_G(-1, 1, 1);
		eckpunkt[4] = new Punkt3D_G(1, -1, -1);
		eckpunkt[5] = new Punkt3D_G(1, -1, 1);
		eckpunkt[6] = new Punkt3D_G(1, 1, -1);
		eckpunkt[7] = new Punkt3D_G(1, 1, 1);
		
		Collection<Kante_G> kanten = new ArrayList<Kante_G>();
		
		kanten.add(new Kante_G(eckpunkt[0], eckpunkt[1]));
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
		
		Koerper Würfel = new Koerper(kanten);
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
