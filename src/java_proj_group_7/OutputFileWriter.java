package java_proj_group_7;

import java.io.*;
import java.util.ArrayList;

public class OutputFileWriter {
	private String outputPath;  
	private int caseCount; 			// Keeps track of the case number for output
	
	public OutputFileWriter(String path) { 
		this.outputPath = path;
		caseCount = 1;
	}  
	
	public void writeResults(ArrayList<Airplane> finishedAirplanes) {  	//TODO:
		String currentLine;
		boolean validity = true;

		// If one plane did not land successfully, then the scenario is marked as impossible.
		for (Airplane airplane : finishedAirplanes)
		{ 
			if (airplane.isResult() != true)
			{
				validity = false;
			}
		}

		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(this.outputPath));	// Create new reader for our output path
			BufferedWriter writer = new BufferedWriter(new FileWriter(this.outputPath));	// Create new writer for our output path

			while (currentLine != null)						// Iterate through the file and check existing contents
			{
				currentLine = reader.readLine();

				if (currentLine == null)					// Ignore spacing between cases
				{
					currentLine = reader.readLine();
				}
			}

			writer.write("CASE " + caseCount + ": ");

			if (validity == false)
			{
				writer.write("IMPOSSIBLE");
				writer.newLine();
			}

			else
			{
				writer.write("POSSIBLE");

				for (Airplane airplane : finishedAirplanes)
				{
					writer.write(airplane.getId() + " LANDED AT " + airplane.getRunwayCompletionTime() + " WITH " + airplane.getFuel() + " REMAINING.");
				}

				writer.newLine();
			}
		}

		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}