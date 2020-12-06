package main;

public class Movie {
	public String id;
	public String title;
	public String year;
	public String actor;
	public String director;
	public String genre;
	public String language;
	public String country;
	public String avgRating;
	
	Movie(String id, String title, String year, String actor, String director, String genre, String language, String country,String avgRating ){
		this.id = id;
		this.title = title;
		this.year = year;
		this.actor = actor;
		this.director = director;
		this.genre = genre;
		this.language = language;
		this.country = country;
		
		this.avgRating = avgRating;
	}
	

}
