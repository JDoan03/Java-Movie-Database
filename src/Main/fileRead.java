package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class fileRead {
	// Fields
	private ArrayList<String> lines;
	
	// Constructor
	public fileRead(String filename){
		lines = new ArrayList<>();
		readLine(filename);

		// Open the filename, read in the data into the lines arraylist, and close the file when done...
	}
	
	// Methods
	public int getNumberOfLines(){
		// Returns the number of Lines
		return lines.size();
	}
	
	public String getLine(int index){
		// Return the index of lines
		return lines.get(index);
	}

	private void readLine(String filename) {

		try {
			BufferedReader movieReader = new BufferedReader(new FileReader(filename));

			String line;
			while ((line = movieReader.readLine())!= null) {
				lines.add(line);
			}
			movieReader.close();

		} catch (IOException e) {
			System.out.println("error line");
			e.printStackTrace();
		}
	}

	public ArrayList<String> getLines() {
		return this.lines;
	}



}
