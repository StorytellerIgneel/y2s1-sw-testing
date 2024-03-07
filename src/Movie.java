import java.util.ArrayList;

public class Movie {
    private String title;
    private Duration duration;
    private String genre;
    private ArrayList<String> languages;

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public Duration getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }
}

class Duration {
    private int hours;
    private int minutes;

    // Getters
    public int getHours() {
        return hours;
    }
    
    public int getMinutes() {
        return minutes;
    }

    //setters
    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}
