package java_proj_group_7;

public class Airport {
	private int numberOfRunways; 
	private int numberOfParkingLots; 
	
	public Airport(int runways, int parkingLots){ 
		this.numberOfRunways = numberOfRunways; 
		this.numberOfParkingLots = numberOfParkingLots;
	}

	public int getNumberOfRunways() {
		return numberOfRunways;
	}

	public int getNumberOfParkingLots() {
		return numberOfParkingLots;
	} 
	
}
