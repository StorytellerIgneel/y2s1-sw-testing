package movie;
import java.util.ArrayList;
import java.util.Date;

public class Movie {
    private String movieId;
    private String title;
    private String description;
    private ArrayList<String> showtimes;
    private ArrayList<String> languages;
    private String releaseDate;
    private ArrayList<String> genre;
    private Double priceAdult;
    private Double priceChildren;

    // Constructor
    public Movie(){};

    public Movie(String movieId, String title, String description, ArrayList<String> showtimes, ArrayList<String> languages, String releaseDate, ArrayList<String> genre, Double priceAdult, Double priceChildren) {
        this.movieId = movieId;
        this.title = title;
        this.description = description;
        this.showtimes = showtimes;
        this.languages = languages;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.priceAdult = priceAdult;
        this.priceChildren = priceChildren;
    }

    // Getter and Setter methods
    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(ArrayList<String> showtimes) {
        this.showtimes = showtimes;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    public double getPriceAdult() {
        return priceAdult;
    }

    public void setPriceAdult(double priceAdult) {
        this.priceAdult = priceAdult;
    }

    public double getPriceChildren() {
        return priceChildren;
    }

    public void setPriceChildren(double priceChildren) {
        this.priceChildren = priceChildren;
    }

    //other methods
    public String viewInformation() {
        StringBuilder movie_info = new StringBuilder();
        movie_info.append("Movie ID: ").append(movieId).append("\n");
        movie_info.append("Title: ").append(title).append("\n");
        movie_info.append("Description: ").append(description).append("\n");
        movie_info.append("Showtimes: ").append(showtimes.toString()).append("\n");
        movie_info.append("Languages: ").append(languages.toString()).append("\n");
        movie_info.append("Release Date: ").append(releaseDate).append("\n");
        movie_info.append("Genre: ").append(genre.toString()).append("\n");
        movie_info.append("Price (Adult): $").append(priceAdult).append("\n");
        movie_info.append("Price (Children): $").append(priceChildren).append("\n");
        return movie_info.toString();
    }
}