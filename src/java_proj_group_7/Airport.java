package java_proj_group_7;

import java.util.ArrayList;

public class Airport {
	private int numberOfRunways; 
	private int numberOfParkingLots; 
	ArrayList<Runway> runwayArray = new ArrayList<Runway>(); 
	ArrayList<ParkingLot> parkingLotLot = new ArrayList<ParkingLot>(); 
	ArrayList<Airplane> airplaneQueue = new ArrayList<Airplane>(); 
	ArrayList<Airplane> finishedAirplaneQueue = new ArrayList<Airplane>();
	
	public Airport(int runways, int parkingLots){ 
		this.numberOfRunways = runways; 
		this.numberOfParkingLots = parkingLots;
	}

	public int getNumberOfRunways() {
		return numberOfRunways;
	}

	public int getNumberOfParkingLots() {
		return numberOfParkingLots;
	} 
	
}
