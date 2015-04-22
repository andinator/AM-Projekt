package projektion1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Roboter {
	public Robot roboter = null;
	int x=100,y=200;
	
	Thread thread = new Thread();
	Main main = new Main();
	
	public void init(){
		
		int nummer = 0;
		for(nummer = 0; nummer<=200;nummer=nummer+50){
			drehen(nummer);
		}
	}
	
	public void drehen(int anzahl){

		try {
			roboter = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		

		roboter.mouseMove(x, y);

		System.out.println(""+anzahl);
		roboter.mousePress(InputEvent.BUTTON1_MASK);
		roboter.mouseMove(x+anzahl, y);
		roboter.mouseRelease(InputEvent.BUTTON1_MASK);
		main.robot();
		//main.repaint();
		try {
			thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
	

