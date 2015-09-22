package java_proj_group_7;

import java.io.*;
import java.util.ArrayList;

public class OutputFileWriter {
	private String outputPath;  
	
	public OutputFileWriter(String path) { 
		this.outputPath = path;
	}  
	
	public void writeResults(ArrayList<Airplane> finishedAirplanes, int caseNumber) { 
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
			currentLine = reader.readLine();

			while (currentLine != null)						// Iterate through the file and check existing contents
			{
				currentLine = reader.readLine();

				if (currentLine == null)					// Ignore spacing between cases
				{
					currentLine = reader.readLine();
				}
			}

			writer.write("CASE " + caseNumber + ": ");

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
