package java_proj_group_7;

public class Airplane { 
	
	private String id; 
	private int fuel; 
	private int fuelBurnRate; 
	private int landingTime; 
	private int taxingTime; 
	private int unloadTime; 
	private long arrivalTime; 
	private long runwayCompletionTime;  
	private boolean result;
	
	public Airplane(String id, int fuel, int fuelBurnRate, int landingTime, int taxingTime, int unloadTime, long arrivalTime) { 
		this.id = id; 
		this.fuel = fuel; 
		this.fuelBurnRate = fuelBurnRate; 
		this.landingTime = landingTime; 
		this.taxingTime = taxingTime; 
		this.unloadTime = unloadTime; 
		this.arrivalTime = arrivalTime; 
	}

	public void calculateResult() {
		fuel = fuel - ((runwayCompletionTime - arrivalTime) * fuelBurnRate);  
		if (fuel >= 0) { 
			result = true;
		}
	}
	
	public String getId() {
		return id;
	}

	public int getFuel() {
		return fuel;
	}

	public int getFuelBurnRate() {
		return fuelBurnRate;
	}

	public int getLandingTime() {
		return landingTime;
	}

	public int getTaxingTime() {
		return taxingTime;
	}

	public int getUnloadTime() {
		return unloadTime;
	}

	public long getArrivalTime() {
		return arrivalTime;
	}

	public long getRunwayCompletionTime() {
		return runwayCompletionTime;
	} 
	
	public void setRunwayCompletionTime(int completionTime) {
		this.runwayCompletionTime = completionTime;
	} 
	
	public boolean isResult() {
		return result;
	}
	
}
