package my.edu.utar;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Showtime {
    private Movie movie;
    private String status; //Available, Not Available, Fully Booked, Cancelled
    private CinemaHall hallNumber;
    private LocalTime time;
    private LocalDate date;
    private double normalTicketPrice;
    
    public Showtime(Movie movie, CinemaHall hallNumber, String status, LocalTime time, LocalDate date){
        this.movie = movie;
        this.hallNumber = hallNumber;
        this.time = time;
        this.date = date;
        this.status = status;
        this.normalTicketPrice = determineTicketPrice(movie.getNormalPrice());
    }

    public static Showtime createShowtime(Movie movie, CinemaHall hallNumber, LocalTime time, LocalDate date){
        Validation.isNullParams(movie, hallNumber, time, date);
        return new Showtime(movie, hallNumber, "available", time, date);
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

    private double determineTicketPrice(double normalTicketPrice){
        Validation.isNegativeNum(normalTicketPrice);
        ArrayList<DayOfWeek> weekdays = new ArrayList<>(new ArrayList<>(List.of(DayOfWeek.values())).subList(0, 4)); //returns weekedays
        if (!weekdays.contains(date.getDayOfWeek())) //weekends
            normalTicketPrice += 2;
        else if (date.getDayOfWeek().equals("WEDNESDAY"))
            normalTicketPrice = 8;
        else if (time.getHour() < 13 && weekdays.contains(date.getDayOfWeek())) //1pm weekedays
            normalTicketPrice = 9;  

        return normalTicketPrice;
    }

    public boolean showtimeAvailable(int totalTicketQuantity){
        if (hallNumber.hallAvailable(totalTicketQuantity)){
            ArrayList<String> rejectList = new ArrayList<>(Arrays.asList("Not Available", "Fully Booked", "Cancelled"));
            if (rejectList.contains(status)){ //hall available but showtime not available
                System.out.println("Sorry, the showtime is currently " + status);
                return false;
            }
            else
                return true;
        }
        else //hall not available 
            return false; 
    }
}
