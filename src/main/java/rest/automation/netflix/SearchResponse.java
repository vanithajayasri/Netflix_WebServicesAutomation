package rest.automation.netflix;

import java.util.LinkedList;

public class SearchResponse {
	
	private LinkedList<Movie> movieList;

	public SearchResponse() {
		super();
	}

	public SearchResponse(LinkedList<Movie> movieList) {
		super();
		this.movieList = movieList;
	}

	public LinkedList<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(LinkedList<Movie> movieList) {
		this.movieList = movieList;
	}
	
	
	

}
