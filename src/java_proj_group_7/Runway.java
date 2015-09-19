package java_proj_group_7;

public class Runway {
	
	private boolean isEmpty = true;
	private int nextAvailible = 0;
	
	public boolean isEmpty() {
		return isEmpty;
	} 
	
	public void occupyRunway(int time) { 
		this.isEmpty = false;  
		this.nextAvailible = time;
		
	} 
	
	public void clearRunway() {
		this.isEmpty = true;
	}

	public int getNextAvailible() {
		return nextAvailible;
	}

}
