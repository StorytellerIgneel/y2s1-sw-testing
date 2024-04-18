package movie;
import java.util.ArrayList;
import java.time.LocalDateTime;
import color.Color;

public class Movie {
    private String movieId;
    private String title;
    private String description;
    private ArrayList<LocalDateTime> showtimes;
    private ArrayList<String> languages;
    private LocalDateTime releaseDate;
    private ArrayList<String> genre;
    private Double priceAdult;
    private Double priceChildren;

    // Constructor
    public Movie(){};

    public Movie(String movieId, String title, String description, ArrayList<LocalDateTime> showtimes, ArrayList<String> languages, LocalDateTime releaseDate, ArrayList<String> genre, Double priceAdult, Double priceChildren) {
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

    public ArrayList<LocalDateTime> getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(ArrayList<LocalDateTime> showtimes) {
        this.showtimes = showtimes;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
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
        movie_info.append(Color.red + "Movie ID: " + Color.lime).append(movieId).append("\n").append(Color.reset);
        movie_info.append(Color.red + "Title: " + Color.lime).append(title).append("\n").append(Color.reset);
        movie_info.append(Color.red + "Description: " + Color.lime).append(description).append("\n").append(Color.reset);
        movie_info.append(Color.red + "Showtimes: " + Color.lime).append(showtimes.toString().substring(1, showtimes.toString().length()-1)).append("\n").append(Color.reset);
        movie_info.append(Color.red + "Languages: " + Color.lime).append(languages.toString().substring(1, languages.toString().length()-1)).append("\n").append(Color.reset);
        movie_info.append(Color.red + "Release Date: " + Color.lime).append(releaseDate).append("\n").append(Color.reset);
        movie_info.append(Color.red + "Genre: " + Color.lime).append(genre.toString().substring(1, genre.toString().length()-1)).append("\n").append(Color.reset);
        movie_info.append(Color.red + "Price (Adult): " + Color.lime + "$").append(priceAdult).append("\n").append(Color.reset);
        movie_info.append(Color.red + "Price (Children): "+ Color.lime +"$").append(priceChildren).append("\n").append(Color.reset);
        return movie_info.toString();
    }
}