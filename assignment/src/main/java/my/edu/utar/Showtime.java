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
    
    public Showtime(Movie movie, CinemaHall hallNumber, String status, LocalTime time, int year, int month, int day){
        this.movie = movie;
        this.hallNumber = hallNumber;
        this.time = time;
//        this.date = date;
        this.year = year;
        this.month = month;
        this.day = day;
        this.status = status;
        this.normalTicketPrice = 1.1;
        this.normalTicketPrice = determineTicketPrice(movie.getNormalPrice());
    }

    public Showtime() {
		// TODO Auto-generated constructor stub
	}
    
    public static void isValidDate(int year, int month, int day) {    
       
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
            LocalDate.of(year, month, day); // This may throw DateTimeException
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("Invalid date value");
        }

        return;
    }

    public static Showtime createShowtime(Movie movie, CinemaHall hallNumber, LocalTime time, int year, int month, int day) {
        // Check if any of the inputs are null
        if (movie == null || hallNumber == null || time == null || year == 0 || month == 0 || day == 0) {
            throw new IllegalArgumentException("Null or invalid parameter passed.");
        }

        // Validate the date
        if (year < 1900 || year > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Invalid year");
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month");
        }
        YearMonth yearMonth = YearMonth.of(year, month);
        if (day <= 0 || day > yearMonth.lengthOfMonth()) {
            throw new IllegalArgumentException("Invalid day");
        }

        // If all validations pass, create and return a new Showtime instance
        return new Showtime(movie, hallNumber, "available", time, year, month, day);
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
        //need to check for valid year
        if (year < 1900 || year > LocalDate.now().getYear())
            throw new IllegalArgumentException("Invalid year");
        else
        	this.year = year;
    }
    
    public void setMonth(int month) {
        // Check for valid month
        if (month < 1 || month > 12)
            throw new IllegalArgumentException("Invalid month");
        else
        	this.month = month;
    }
    
    public void setDay(int day) {
        // Check for valid day in the given month and year
        YearMonth yearMonth = YearMonth.of(year, month);
        if (day <= 0 && day > yearMonth.lengthOfMonth())
            throw new IllegalArgumentException("Invalid day");
        else
        	this.day = day;
    }

    public void setMovie(Movie movie) {
    	if(movie == null)
    		throw new IllegalArgumentException("Null param passed");
        this.movie = movie;
    }

    public void setStatus(String status) {
    	if(status == null)
    		throw new IllegalArgumentException("Null param passed");
    	if(!status.equals("Available")&&!status.equals("Not Available")&&!status.equals("Fully Booked")&&!status.equals("Cancelled"))
    		throw new IllegalArgumentException("Invalid param passed");

    	this.status = status;
    }
    
    public void setHallNumber(CinemaHall hallNumber) {
    	if(hallNumber == null)
    		throw new IllegalArgumentException("Null param passed");
        this.hallNumber = hallNumber;
    }

    public void setTime(LocalTime time) {
    	if(time == null)
    		throw new IllegalArgumentException("Null param passed");
    	this.time = time;
    }

    // Getter and Setter for normalTicketPrice
    public double getNormalTicketPrice() {
        return normalTicketPrice;
    }

    public void setNormalTicketPrice(double normalTicketPrice) {
    	if (normalTicketPrice < 0)
    		throw new IllegalArgumentException("Negative num param passed");

        this.normalTicketPrice = normalTicketPrice;
    }

//    private double determineTicketPrice(double normalTicketPrice){
//        Validation.isNegativeNum(normalTicketPrice);
//        ArrayList<DayOfWeek> weekdays = new ArrayList<>(new ArrayList<>(List.of(DayOfWeek.values())).subList(0, 4)); //returns weekedays
//        if (!weekdays.contains(date.getDayOfWeek())) //weekends
//            normalTicketPrice += 2;
//        else if (date.getDayOfWeek().equals("WEDNESDAY"))
//            normalTicketPrice = 8;
//        else if (time.getHour() < 13 && weekdays.contains(date.getDayOfWeek())) //1pm weekedays
//            normalTicketPrice = 9;  
//
//        return normalTicketPrice;
//    }
    
    public double determineTicketPrice(double normalTicketPrice) {
        // Check if the ticket price is negative
        if (normalTicketPrice < 0) {
            throw new IllegalArgumentException("Ticket price cannot be negative.");
        }

        // Create a LocalDate object using the year, month, and day fields
        LocalDate showDate = LocalDate.of(getYear(), getMonth(), getDay());
        DayOfWeek dayOfWeek = showDate.getDayOfWeek();
        int hour = getTime().getHour();

        // Check if it's a weekend (Saturday or Sunday)
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            normalTicketPrice += 2;
        }
        // Check if it's Wednesday for a special price
        else if (dayOfWeek == DayOfWeek.WEDNESDAY) {
            normalTicketPrice = 8;
        }
        // Check if it's a weekday (Monday to Thursday) before 1pm
        else if ((dayOfWeek == DayOfWeek.MONDAY || dayOfWeek == DayOfWeek.TUESDAY ||
                  dayOfWeek == DayOfWeek.THURSDAY || dayOfWeek == DayOfWeek.FRIDAY) && hour < 13) {
            normalTicketPrice = 9;
        }

        return normalTicketPrice;
    }




    public boolean showtimeAvailable(int totalTicketQuantity){
    	if(totalTicketQuantity < 0)
    		throw new IllegalArgumentException("Invalid totalTicketQuantity");
    	
        if (getHallNumber().hallAvailable(totalTicketQuantity)){
            ArrayList<String> rejectList = new ArrayList<>(Arrays.asList("Not Available", "Fully Booked", "Cancelled"));
            if (rejectList.contains(getStatus())){ //hall available but showtime not available
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


