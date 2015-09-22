package java_proj_group_7;

public class ParkingLot {
	
	private boolean isEmpty = true; 
	private long nextAvailible = 0; 
	
	public boolean isEmpty() {
		return isEmpty;
	}
	
	public void clearParkingLot() { 
		isEmpty = true;
	} 
	
	public void occupyParkingLot(long time) { 
		isEmpty = false; 
		this.nextAvailible = time;
	}

	public long getNextAvailible() {
		return nextAvailible;
	}

	
}
