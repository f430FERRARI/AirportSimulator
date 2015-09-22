package java_proj_group_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class InputFileReader {
	private String inputPath;  
	
	public InputFileReader(String path) { 
		this.inputPath = path;
	} 
	
	public int[] readAirport() 
	{ 
		int[] airportData = new int[3];//create array to store airport values
		
		String currentLine;
		try
		{
			BufferedReader reader= new BufferedReader(new FileReader(this.inputPath));//create new reader at path specificed in argument
			
			while( (currentLine = reader.readLine()) != null)						//if there is still a line, read from it
			{
				String[] airportValues=currentLine.split("=");						//split line based on equal sign
				
				if(airportValues[0].equals("R") || airportValues[0].equals("r"))	//if this line denotes number of runways, then store in array
				{
						airportData[0]=Integer.parseInt(airportValues[1]);			//store in airport data array index 0
				}
				
				else if(airportValues[0].equals("P") || airportValues[0].equals("p"))	//if line denotes number of parking lots
				{
						airportData[1]=Integer.parseInt(airportValues[1]);			//store in index 1
				}
				
				else if(airportValues[0].equals("T") || airportValues[0].equals("t"))	//if line denotes number of taxis  //TODO: This isn't taxis, i think its time
				{
						airportData[2]=Integer.parseInt(airportValues[1]);			//store in index 2
				}
			}
			
			System.out.println(airportData[0]);
			System.out.println(airportData[1]);
			System.out.println(airportData[2]);
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return airportData;
		
	} 
	
}
