package rest.automation.netflix;

public class Movie {
	int unit;
	int show_id;
	String show_title;
	String release_year;
	String rating;
	String category;
	String show_cast;
	String director;
	String summary;
	String poster;
	int mediatype;
	String runtime;
	
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(int unit, int show_id, String show_title, String release_year,
			String rating, String category, String show_cast, String director,
			String summary, String poster, int mediatype, String runtime) {
		super();
		this.unit = unit;
		this.show_id = show_id;
		this.show_title = show_title;
		this.release_year = release_year;
		this.rating = rating;
		this.category = category;
		this.show_cast = show_cast;
		this.director = director;
		this.summary = summary;
		this.poster = poster;
		this.mediatype = mediatype;
		this.runtime = runtime;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public int getShow_id() {
		return show_id;
	}
	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}
	public String getShow_title() {
		return show_title;
	}
	public void setShow_title(String show_title) {
		this.show_title = show_title;
	}
	public String getRelease_year() {
		return release_year;
	}
	public void setRelease_year(String release_year) {
		this.release_year = release_year;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getShow_cast() {
		return show_cast;
	}
	public void setShow_cast(String show_cast) {
		this.show_cast = show_cast;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public int getMediatype() {
		return mediatype;
	}
	public void setMediatype(int mediatype) {
		this.mediatype = mediatype;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	
	
	

}

