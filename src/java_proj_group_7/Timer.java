package java_proj_group_7;

public class Timer {

	private int unitOfTime; 
	
	public Timer(int timeUnit)
	{
		this.unitOfTime=timeUnit;	
	}
	
	public long getCurrentTime() 
	{ 

		long currentTime =  System.currentTimeMillis() /1000;  	//Convert the time into seconds and integer 
		currentTime = currentTime/unitOfTime;						//Convert seconds to unit of time
		
		return currentTime;											//Return time in units of time
	}
	
}
