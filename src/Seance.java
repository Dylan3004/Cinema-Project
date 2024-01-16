
public class Seance {
	private int movieID;
	private int seanceID;
	private String date;
	private String time;
	private Double price;
	private boolean isSeanceActive;
	private String title;
	private String type;
	private String studio;
	private String director;
	private String cast;
	private String description;
	private String year;
	private int age;
	private boolean isMovieActive;

	public Seance(int movieID, int seanceID, String date, String time, Double price, boolean isSeanceActive, String title, String type,
             String studio, String director, String cast, String description, String year, int age,
             boolean isMovieActive) {
	this.movieID = movieID;
	this.seanceID = seanceID;
    this.date = date;
    this.time = time;
    this.price = price;
    this.isSeanceActive = isSeanceActive;
    this.title = title;
    this.type = type;
    this.studio = studio;
    this.director = director;
    this.cast = cast;
    this.description = description;
    this.year = year;
    this.age = age;
    this.isMovieActive = isMovieActive;
	}
	
	public int getMovieID() {
		return movieID;
	}
	
	public int getSeanceID() {
		return seanceID;
	}
	
	public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public Double getPrice() {
        return price;
    }

    public boolean isSeanceActive() {
        return isSeanceActive;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getStudio() {
        return studio;
    }

    public String getDirector() {
        return director;
    }

    public String getCast() {
        return cast;
    }

    public String getDescription() {
        return description;
    }

    public String getYear() {
        return year;
    }

    public int getAge() {
        return age;
    }

    public boolean isMovieActive() {
        return isMovieActive;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setSeanceActive(boolean seanceActive) {
        isSeanceActive = seanceActive;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMovieActive(boolean movieActive) {
        isMovieActive = movieActive;
    }
}
