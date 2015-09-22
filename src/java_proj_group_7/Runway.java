package java_proj_group_7;

public class Runway {
	
	private boolean isEmpty = true;
	private long nextAvailible = 0;
	
	public boolean isEmpty() {
		return isEmpty;
	} 
	
	public void occupyRunway(long time) { 
		this.isEmpty = false;  
		this.nextAvailible = time;
		
	} 
	
	public void clearRunway() {
		this.isEmpty = true;
	}

	public long getNextAvailible() {
		return nextAvailible;
	}

}
