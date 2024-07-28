package showtime;

import CinemaHall.CinemaHall;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Showtime {
    private String title;
    private String status;
    private CinemaHall hallNumber;
    private LocalTime time;
    private LocalDate date;
    private double normalTicketPrice;
    
    public Showtime(String title, CinemaHall hallNumber, LocalTime time, LocalDate date){
        this.title = title;
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

        return normalTicketPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
