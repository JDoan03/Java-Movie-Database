package Main;

import java.util.ArrayList;

public class Database {
	// Fields
	private ArrayList<Movie> movies;

	// Constructor
	public Database(String filename){
		movies = new ArrayList<>();
	}
	
	// Methods
	public static void addEntry(ArrayList<String> myLines, String myFileName){
		// Declaring Fields
		keyboardInput newEntryUserInput = new keyboardInput();
		String newEntry;
		String movieEntry = "";

		// Validating to see if the title is three characters long
		do {
			System.out.print("Enter Title > ");
			newEntry = newEntryUserInput.getKeyboardLine();
			if (newEntry.length() < 3)
				p("Invalid Title. Needs to be at least 3 characters long. Try Again.");
		} while (newEntry.length() < 3);
		movieEntry += newEntry + "*";

		// Validating to see if the year is a number
		boolean yearInputIsInt = false;
		boolean realYear = false;
		do {
			pi("Enter Year > ");
			try {
				newEntry = newEntryUserInput.getKeyboardLine();
				int intValue = Integer.parseInt(newEntry);
				yearInputIsInt = true;
			} catch (NumberFormatException e) {
				p("Invalid year. Please enter a number. Try Again");
			}
		} while (!yearInputIsInt);
		movieEntry += newEntry + "*";

		// Validating to see if the runtime minutes is a number
		boolean runtimeInputIsInt = false;
		do {
			System.out.print("Enter Runtime (minutes) > ");
			try {
				newEntry = newEntryUserInput.getKeyboardLine();
				int intValue = Integer.parseInt(newEntry);
				runtimeInputIsInt = true;
			} catch (NumberFormatException e) {
				p("Invalid runtime. Please enter a number. Try Again");
			}
		} while (!runtimeInputIsInt);
		movieEntry += newEntry + "*";

		do {
			System.out.print("Enter Actor 1 > ");
			newEntry = newEntryUserInput.getKeyboardLine();
			if (newEntry.length() < 1)
				p("Invalid actor name. Needs to be at least 1 characters long. Try Again.");
		} while (newEntry.length() < 1);
		movieEntry += newEntry + "*";

		do {
			System.out.print("Enter Actor 2 > ");
			newEntry = newEntryUserInput.getKeyboardLine();
			if (newEntry.length() < 1)
				p("Invalid actor name. Needs to be at least 1 characters long. Try Again.");
		} while (newEntry.length() < 1);
		movieEntry += newEntry + "*";

		do {
			System.out.print("Enter Director > ");
			newEntry = newEntryUserInput.getKeyboardLine();
			if (newEntry.length() < 1)
				p("Invalid director name. Needs to be at least 1 characters long. Try Again.");
		} while (newEntry.length() < 1);
		movieEntry += newEntry;

		fileWrite myWriteFile = new fileWrite(myFileName);
		myWriteFile.setWriteBuffer(myLines);
		myWriteFile.writeLine(movieEntry);
		myWriteFile.saveFile();
	}

	public static void deleteEntry(String title, ArrayList<String> myLines, ArrayList<Movie> myMovieList) {
		boolean isMatch = false;
		boolean titleHasMovie = false;
		String realTitle = title;

		for (int i = 0; i < myMovieList.size() ; i++) {
			String tempTitle = myMovieList.get(i).getTitle();
			isMatch = realTitle.equalsIgnoreCase(tempTitle);
			if (isMatch) {
				fileWrite myWriteFile = new fileWrite("src/Main/db.txt");
				myWriteFile.setWriteBuffer(myLines);
				myWriteFile.deleteLine(i);
				myWriteFile.saveFile();

				titleHasMovie = true;
			}
		}
		if (!titleHasMovie)
			p("Title not found");
		p("");
	}
	
	public static void searchByTitle(String title, ArrayList<Movie> myMovieList){
		// Display movies of the title or "No titles found for title". Make sure not case sensitive
		// If found print actors, directors, year made, and runtime

		boolean isMatch = false;
		boolean titleHasMovie = false;
		String realTitle = title;

		for (int i = 0; i < myMovieList.size(); i++) {
			String tempTitle = myMovieList.get(i).getTitle();
			isMatch = realTitle.equalsIgnoreCase(tempTitle);
			if (isMatch) {
				p("Actors: " + myMovieList.get(i).getActor1() + ", " + myMovieList.get(i).getActor2());
				p("Director: " + myMovieList.get(i).getDirector());
				p("Year: " + myMovieList.get(i).getYear());
				p("Runtime: " + myMovieList.get(i).getRuntime() + " minutes");
				titleHasMovie = true;
			}
		}
		if (!titleHasMovie)
			p("No movies found with title " + title);
		p("");

	}
	
	public static void searchByActor(String actor, ArrayList<Movie> myMovieList){
		boolean isMatch1 = false;
		boolean isMatch2 = false;
		boolean actorHasMovie1 = false;
		boolean actorHasMovie2 = false;
		String realActor = actor;

		for (int i = 0; i < myMovieList.size(); i++) {
			String tempActor1 = myMovieList.get(i).getActor1();
			isMatch1 = realActor.equalsIgnoreCase(tempActor1);
			if (isMatch1) {
				p(myMovieList.get(i).getTitle());
				actorHasMovie1 = true;
			}

			String tempActor2 = myMovieList.get(i).getActor2();
			isMatch2 = realActor.equalsIgnoreCase(tempActor2);
			if (isMatch2) {
				p(myMovieList.get(i).getTitle());
				actorHasMovie1 = true;
			}
		}
		if (!actorHasMovie1 && !actorHasMovie2)
			p("No titles found for actor " + actor);
		p("");
	}
	
	public static void searchByDirector(String director, ArrayList<Movie> myMovieList){
		// Display movies of the director or "No titles found for director". Make sure not case sensitive

		boolean isMatch = false;
		boolean directorHasMovie = false;
		String realDirector = director;

		for (int i = 0; i < myMovieList.size(); i++) {
			String tempDirector = myMovieList.get(i).getDirector();
			isMatch = realDirector.equalsIgnoreCase(tempDirector);
			if (isMatch) {
				p(myMovieList.get(i).getTitle());
				directorHasMovie = true;
			}
		}
		if (!directorHasMovie)
			p("No titles found for director " + director);
		p("");
	}
	
	public static void searchByYear(int year, ArrayList<Movie> myMovieList) {
		// Search by year only numbers can be entered
		// Display movies of that year or "No titles found for year" and return to main menu

		boolean isMatch = false;
		boolean yearHasMovie = false;
		int realYear = year;

		for (int i = 0; i < myMovieList.size(); i++) {
			int tempYear = myMovieList.get(i).getYear();
			isMatch = realYear == tempYear;
			if (isMatch) {
				p(myMovieList.get(i).getTitle());
				yearHasMovie = true;
			}
		}
		if (!yearHasMovie)
			p("No titles found for year " + year);
		p("");
	}
	
	public static void searchByRuntime(int runtime, ArrayList<Movie> myMovieList){

		// Search by runtimes, only numbers can be entered
		// Display movies of that runtime or "No titles found for runtimes" and return to main menu

		boolean isMatch = false;
		boolean runtimeHasMovie = false;
		int realRuntime = runtime;

		for (int i = 0; i < myMovieList.size(); i++) {
			int tempRuntime = myMovieList.get(i).getRuntime();
			isMatch = realRuntime == tempRuntime;
			if (isMatch) {
				p(myMovieList.get(i).getTitle());
				runtimeHasMovie = true;
			}
		}
		if (!runtimeHasMovie)
			p("No titles found for " + runtime + " minutes");
		p("");
	}

	public static <E> void p(E item){
		System.out.println(item);
	}

	public static <E> void pi(E item){
		System.out.print(item);
	}
}
