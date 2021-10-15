package Main;

import java.util.Scanner;

public class keyboardInput {
	// Fields
	private Scanner keyb;
	
	// Constructor
	public keyboardInput(){
		keyb = new Scanner(System.in);
	}

	// Methods
	public String getKeyboardLine(){
		String input = (keyb.nextLine());
		return input;
	}

	public int getKeyboardLineInt(){
		int input = (keyb.nextInt());
		return input;
	}
	
	/* Call this method before you exit the program! Do NOT close the scanner object inside of getKeyboardLine method! */
	public void closeKeyboard(){
		keyb.close();
		// System.out.println("close keyboard");
	}
}
