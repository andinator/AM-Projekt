package projektion1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Roboter implements Runnable{
	public Robot roboter = null;
	int x=100,y=200;
	
	Main main = new Main();
	
	public void init(){
		
		
	}
	
	public void rechts(){

		try {
			roboter = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		

		roboter.mouseMove(x, y);

		roboter.mousePress(InputEvent.BUTTON1_MASK);
		roboter.mouseMove(x=x+30, y);
		roboter.mouseRelease(InputEvent.BUTTON1_MASK);
		
		//main.repaint();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}