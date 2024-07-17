package showtime;

import java.util.ArrayList;
import java.util.List;
import java.time.DayOfWeek;
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
    private double normalTicketPrice;
    
    Showtime(Movie movie, CinemaHall hallNumber, LocalTime time, LocalDate date){
        this.movie = movie;
        this.hallNumber = hallNumber;
        this.time = time;
        this.date = date;
        this.status = "Available";
        this.normalTicketPrice = determineTicketPrice();
    }

    private double determineTicketPrice(){
        ArrayList<DayOfWeek> weekdays = new ArrayList<>(List.of(DayOfWeek.values()));
        if (!weekdays.contains(date.getDayOfWeek()))
            normalTicketPrice += 2;
        else if (date.getDayOfWeek().equals("WEDNESDAY"))
            normalTicketPrice = 8;
        else if (time.getHour() < 13 && weekdays.contains(date.getDayOfWeek())){
            normalTicketPrice = 9;
        }   
        
        //special movie category
        switch (movie.getCategory()) {
            case "2D":
                break;
            case "3D":
                normalTicketPrice += 4;
                break;
            case "IMAX":
                normalTicketPrice += 4;
                break;
            default:
                break;
        }

        return normalTicketPrice;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    // Getter and Setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter and Setter for hallNumber
    public CinemaHall getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(CinemaHall hallNumber) {
        this.hallNumber = hallNumber;
    }

    // Getter and Setter for time
    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    // Getter and Setter for date
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Getter and Setter for normalTicketPrice
    public double getNormalTicketPrice() {
        return normalTicketPrice;
    }

    public void setNormalTicketPrice(double normalTicketPrice) {
        this.normalTicketPrice = normalTicketPrice;
    }
}
