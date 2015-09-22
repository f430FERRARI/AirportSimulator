package java_proj_group_7;

import java.util.Timer;
import java.util.TimerTask;

public class Scheduler extends TimerTask {

	@Override
	public void run() {

		//TODO: Start timer and shit
		TimerTask timerTask = new Scheduler(); 												//Running timer as daemon thread
		Timer timer = new Timer(true); 
		timer.scheduleAtFixedRate(timerTask, firstTime, 1000); 								//Start the timer thread//TODO: Get it to start at the next second
		FlightReceiver flightReceiver = new FlightReceiver(); 
		flightReceiver.start(); 															//Start the airplane thread
		
	}
	
}
