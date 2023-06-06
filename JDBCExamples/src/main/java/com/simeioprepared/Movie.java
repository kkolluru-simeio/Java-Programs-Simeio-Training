package com.simeioprepared;

public class Movie {
	private String movieName;
	private int movieId;
	private String genre;
	private String language;
	
	public Movie() {
		super();
	}

	public Movie(String movieName, int movieId, String genre, String language) {
		super();
		this.movieName = movieName;
		this.movieId = movieId;
		this.genre = genre;
		this.language = language;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "Movie [movieName=" + movieName + ", movieId=" + movieId + ", genre=" + genre + ", language=" + language
				+ "]";
	}
	
	
	
	
}
