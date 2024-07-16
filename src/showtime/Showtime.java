package showtime;

import java.time.LocalDate;
import java.time.LocalTime;
import CinemaHall.CinemaHall;
import movie.Movie;

public class Showtime {
    private Movie movie;
    private String status;
    private CinemaHall hallNumber;
    private LocalTime time;
    private LocalDate date;
    
    Showtime(Movie movie, CinemaHall hallNumber, LocalTime time, LocalDate date){
        this.movie = movie;
        this.hallNumber = hallNumber;
        this.time = time;
        this.date = date;
        this.status = "Available";
    }

    
}
