package Application;

import java.util.ArrayList;
import java.util.List;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Showtime {
    private String title;
    private String status;
    private String hallNumber;
    private LocalTime time;
    private LocalDate date;
    private double normalTicketPrice; //not needed

    
    Showtime(String title, String hallNumber, LocalTime time, LocalDate date){
        this.title = title;
        this.hallNumber = hallNumber;
        this.time = time;
        this.date = date;
        this.status = "AVAILABLE";
        this.normalTicketPrice = determineTicketPrice();
    }
    
    public Showtime(String title, String hallNumber, LocalTime time, LocalDate date, String status, double normalTicketPrice){
        this.title = title;
        this.hallNumber = hallNumber;
        this.time = time;
        this.date = date;
        this.status = status;
        this.normalTicketPrice = normalTicketPrice;
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
    public String getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(String hallNumber) {
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
    
    public static void displayShowtimes(ArrayList <Showtime> showtimes, String movieName) {
		int i = 0;
    	for(Showtime showtime:showtimes) {
    		if(showtime.title.equals(movieName)) {
    			i++;
    			System.out.println(Color.YELLOW+ i+". Date: "+showtime.getDate() + "\tTime: " + showtime.getTime()+Color.RESET);
    		}
    	}
    }
    
    public static int getShowtimesCount(ArrayList <Showtime> showtimes, String movieName) {
    	int i = 0;
    	for(Showtime showtime:showtimes) {
    		if(showtime.title.equals(movieName)) {
    			i++;
    		}
    	}
    	return i;
    }
    
    public void viewInformation() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        System.out.println(Color.YELLOW + "Date:" + dateFormatter.format(date) + "\tTime:" + timeFormatter.format(time) + "\tHall Number:" + hallNumber);
        System.out.println("Available seats: " + Color.RESET);
    }
}
