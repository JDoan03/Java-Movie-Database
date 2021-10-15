/* READ THIS!: The idea behind this class is that we save the "writeBuffer" in memory but do not actually write the file to disk until someone calls the 
 * "saveFile" method. The reason for this is for performance and to prevent keeping an open file pointer (which is poor form and risky) */

package Main;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class fileWrite {
	// Fields
	private ArrayList<String> writeBuffer;
	private String filename;
	
	// Constructor
	public fileWrite(String filename){
		this.filename = filename;			// Save filename for later
		writeBuffer = new ArrayList<>();
	}

	public void setWriteBuffer(ArrayList<String> writeBuffer) {
		this.writeBuffer = writeBuffer;
	}

	public ArrayList<String> getWriteBuffer() {
		return this.writeBuffer;
	}
	
	//Methods
	public void writeLine(String newLine){
		// Add the newLine to the writeBuffer...
		writeBuffer.add(newLine);
	}

	public void deleteLine(int deleteLine) {
		// Delete the line from the writeBuffer
		writeBuffer.remove(deleteLine);
		// writeBuffer.remove();
	}
	
	public void saveFile(){
		// Save all of the lines in the writeBuffer to the file (given in filename)
		// Overwriting the whole with what is in memory
		try {
			FileWriter myFileWriter = new FileWriter(filename);
			for (String line : writeBuffer)
			{
				myFileWriter.flush();
				myFileWriter.write(line);
				myFileWriter.write("\n");
			}
			myFileWriter.close();
		} catch (IOException e) {
			System.out.println("Error Saving");
			e.printStackTrace();
		}
	}
}
