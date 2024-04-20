package movie;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class Result {
    private String movieId;
    private String title;
    private String description;
    private ArrayList<LocalDateTime> showtimes;
    private ArrayList<String> languages;
    private LocalDateTime releaseDate;
    private ArrayList<String> genre;
    private Double priceAdult;
    private Double priceChildren;
    public int step = 1;

    public Result() {
        this.movieId = null;
        this.title = null;
        this.description = null;
        this.showtimes = new ArrayList<>();
        this.languages = new ArrayList<>();;
        this.releaseDate = null;
        this.genre = new ArrayList<>();;
        this.priceAdult = null;
        this.priceChildren = null;
        this.step = 1;
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

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
