package java_proj_group_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.BaseStream;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;
import javax.xml.crypto.Data;

public class Simulator {

	public static void main(String[] args) {

		//TODO: Start timer and shit
		
		//Read information from the airport file and build airport
		InputFileReader inputFileReader = new InputFileReader(); 
		int[] airportData = inputFileReader.readAirport(); 	 
		Airport airport = new Airport(airportData[0], airportData[1]);
		
		//Build runways
		ArrayList<Runway> runwayArray = new ArrayList<Runway>(); 
		for (int i = 0; i < airport.getNumberOfRunways(); i++) { 
			Runway runway = new Runway();  
			runwayArray.add(runway);
		}
		
		//Build parking lots
		ArrayList<ParkingLot> parkingLotLot = new ArrayList<ParkingLot>();
		for (int i = 0; i < airport.getNumberOfParkingLots(); i++) { 
			ParkingLot parkingLot = new ParkingLot();
		}
		
		//Build Airplane Queues 
		ArrayList<Airplane> airplaneQueue = new ArrayList<Airplane>(); 
		ArrayList<Airplane> finishedAirplanes = new ArrayList<Airplane>(); 
		
		//Begin reading input from the command line
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    String message;
		while (!(message = in.nextLine().trim()).equals("END")) {
			
			//TODO: YO VINCE
			//Get the current time 
			Timer time = new Timer(); 
			int currentTime = time.getCurrentTime(); //TODO: Units may be off, make the method, currenttime should be offset from program start
			
			//TODO: Parse incoming plane data  
			//Create plane and add to the queue			
			//TODO: IF THERE IS A NEW PLANE
			if () {	
				Airplane airplane = new Airplane(id, f, fBR, lT, tT, uT, aT); 
				airplaneQueue.add(airplane); 				
			} 
			
			//Get first airplane from queue
			Airplane currentAirplane = airplaneQueue.get(0);
			
			//Scan for empty parking lots and runways
			int currentBestRunway = -1; 
			int currentBestParking = -1; 
			for (int i=0; i<runwayArray.size(); i++) { 
				if (runwayArray.get(i).isEmpty()) { 
					currentBestRunway = i;
				}
			}
			for (int i= 0; i<parkingLotLot.size(); i++) { 
				if (parkingLotLot.get(i).isEmpty()) { 
					currentBestParking = i;
				}
			} 
			
			//Occupy runway and parking lots
			if (currentBestParking != -1 && currentBestRunway != -1) { 
				int runwayCompletion = currentTime + currentAirplane.getLandingTime() + currentAirplane.getTaxingTime(); 	//Calculate time when parking lot will be empty
				currentAirplane.setRunwayCompletionTime(runwayCompletion);													//Pass time when plane finishes burning fuel
				runwayArray.get(currentBestRunway).occupyRunway(runwayCompletion); 
				int parkingLotCompletion = runwayCompletion + currentAirplane.getUnloadTime(); 								//Calculate time when parking lot will be empty
				parkingLotLot.get(currentBestParking).occupyParkingLot(parkingLotCompletion);   							//TODO: This occupies parking lot while theres a guy on runway
				finishedAirplanes.add(airplaneQueue.remove(0)); 															//Removes first plane and puts it into finished  
			} 
			
			//Check if any of the planes are done on the runway
			for (Runway runway : runwayArray) { 
				if (!runway.isEmpty()) {
					if (runway.getNextAvailible() == currentTime) { 
						runway.clearRunway();
					} 
				}
			}  
			
			//Check if any of the planes are done in the parking
			for (ParkingLot parking : parkingLotLot) { 
				if (!parking.isEmpty()) {
					if (parking.getNextAvailible() == currentTime) { 
						parking.clearParkingLot();
					} 
				}
			} 
			//TODO: What if this ends before the last plane leaves.
		in.close();
		}
	
		//Get airplane results and output it to the file	
		for (Airplane airplane : finishedAirplanes) { 
			airplane.calculateResult();  
			airplane.isResult();						
			//TODO: output this to the out file
		}
	} 

}
