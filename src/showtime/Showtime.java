package showtime;

import java.time.LocalDate;
import java.time.LocalTime;
import movie.Movie;

public class Showtime {
    private Movie movie;
    private String status;
    private int hallNumber;
    private LocalTime time;
    private LocalDate date;
    
    Showtime(Movie movie, int hallNumber, LocalTime time, LocalDate date){
        this.movie = movie;
        this.hallNumber = hallNumber;
        this.time = time;
        this.date = date;
        this.status = "Available";
    }

    
}
