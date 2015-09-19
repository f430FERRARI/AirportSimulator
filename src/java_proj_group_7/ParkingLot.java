package java_proj_group_7;

public class ParkingLot {
	
	private boolean isEmpty = true; 
	private int nextAvailible = 0; 
	
	public boolean isEmpty() {
		return isEmpty;
	}
	
	public void clearParkingLot() { 
		isEmpty = true;
	} 
	
	public void occupyParkingLot(int time) { 
		isEmpty = false; 
		this.nextAvailible = time;
	}

	public int getNextAvailible() {
		return nextAvailible;
	}

	
}
