package Main;

public class Movie {
	// Fields
	private String title;
	private String actor1;
	private String actor2;
	private String director;
	private int year;
	private int runtimeMinutes;

	// Constructor
	public Movie(String title, int year, int runtimeMinutes, String actor1, String actor2, String director){
		// TODO
		this.title = title;
		this.year = year;
		this.runtimeMinutes = runtimeMinutes;
		this.actor1 = actor1;
		this.actor2 = actor2;
		this.director = director;
	}
	
	// Methods
	public String getTitle(){
		return this.title;
	}
	
	public String getActor1(){
		return this.actor1;
	}
	
	public String getActor2(){
		return this.actor2;
	}
	
	public String getDirector(){
		return this.director;
	}
	
	public int getYear(){
		return this.year;
	}
	
	public int getRuntime(){
		return this.runtimeMinutes;
	}


	
	// Optional
	public boolean isActorInMovie(String actor){
		return false; // TODO
	}
}
