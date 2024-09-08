package my.edu.utar;


import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Showtime {
    private Movie movie;
    private String status; //Available, Not Available, Fully Booked, Cancelled
    private CinemaHall hallNumber;
    private LocalTime time;
    private int year;
    private int month;
    private int day;
    private double normalTicketPrice;

    public Showtime(Movie movie, CinemaHall hallNumber, String status, LocalTime time, LocalDate date){
        this.movie = movie;
        this.hallNumber = hallNumber;
        this.time = time;
        this.date = date;
        this.status = status; 
        this.normalTicketPrice = determineTicketPrice(movie.getNormalPrice());
    }

    public Showtime() {
		// TODO Auto-generated constructor stub
	}
    
    public static void isValidDate(int year, int month, int day) {    
        LocalDate birthday;    
        
        //need to check for valid year
        if (year < 1900 || year > LocalDate.now().getYear())
            throw new IllegalArgumentException("Invalid year");
        
        // Check for valid month
        if (month < 1 || month > 12)
            throw new IllegalArgumentException("Invalid month");
        
        // Check for valid day in the given month and year
        YearMonth yearMonth = YearMonth.of(year, month);
        if (day <= 0 && day > yearMonth.lengthOfMonth())
            throw new IllegalArgumentException("Invalid day");
        
        try {
            birthday = LocalDate.of(year, month, day); // This may throw DateTimeException
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("Invalid date value");
        }

        return;
    }

	public static Showtime createShowtime(Movie movie, CinemaHall hallNumber, LocalTime time, int year, int month, int day){
        Validation.isNull(movie, hallNumber, time, year, month, day);
        isValidDate(year, month, day);
        return new Showtime(movie, hallNumber, "available", time, year, month ,day);
    }

    //Getter and Setter for movie
    public Movie getMovie() {
        return movie;
    }

    // Getter and Setter for status
    public String getStatus() {
        return status;
    }

    // Getter and Setter for hallNumber
    public CinemaHall getHallNumber() {
        return hallNumber;
    }

    // Getter and Setter for time
    public LocalTime getTime() {
        return time;
    }
    
    public int getYear() {
    	return year;
    }
    
    public int getMonth() {
        return month;
    }
    
    public int getDay() {
        return day;
    }
    

    // Getter and Setter for date
    public void setYear(int year) {
    	this.year = year;
    }
    
    public void setMonth(int month) {
        this.month = month;
    }
    
    public void setDay(int day) {
        this.day = day;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setHallNumber(CinemaHall hallNumber) {
        this.hallNumber = hallNumber;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    // Getter and Setter for normalTicketPrice
    public double getNormalTicketPrice() {
        return normalTicketPrice;
    }

    public void setNormalTicketPrice(double normalTicketPrice) {
        this.normalTicketPrice = normalTicketPrice;
    }

    double determineTicketPrice(double normalTicketPrice) {
        // Validate the normalTicketPrice is not negative
        Validation.isNegativeNum(normalTicketPrice);

        // Create a list of weekdays
        List<DayOfWeek> weekdays = Arrays.asList(
            DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY,
            DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY,
            DayOfWeek.FRIDAY
        );

        // Check if the current date is a weekend
        if (!weekdays.contains(date.getDayOfWeek())) {
            normalTicketPrice += 2;
        } else if (date.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
            normalTicketPrice = 8;
        } else if (time.getHour() < 13 && weekdays.contains(date.getDayOfWeek())) {
            normalTicketPrice = 9;
        }

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

