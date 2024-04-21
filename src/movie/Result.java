package movie;

import java.util.ArrayList;
import java.time.LocalDateTime;

/**
     * dummy replica Movie class that acts as a recorder for the movie Object during the update and add process
     * ALl of the fields are initialized to either null or an empty array
     * as the movie is added, all the information will be stored in the Result, and the step will increase as it progresses in the add process
     * during update process, only the specific function will be called
     * Result was created due to the wish of not involving the movie object in too many places, and that the step variable isnt relevant in the movie object.
     */
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
    public Integer step = 1;

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

    public Double getPriceAdult() {
        return priceAdult;
    }

    public void setPriceAdult(double priceAdult) {
        this.priceAdult = priceAdult;
    }

    public Double getPriceChildren() {
        return priceChildren;
    }

    public void setPriceChildren(double priceChildren) {
        this.priceChildren = priceChildren;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
