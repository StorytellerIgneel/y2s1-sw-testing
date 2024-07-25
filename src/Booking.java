package Application;

import java.util.Date;
import java.util.UUID;
import account.Account;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;


/**
 * This class represents a booking made by a user.
 * 
 */
public class Booking {
    private String bookingId;
    private Member member;
    private Movie movie;
    private Showtime showtime;
	private int totalSeat;
    private double totalPrice;
    private String status;
//    
//    enum Status {
//    	BOOKED,
//    	PAYMENT_SUCCESSFUL,
//    	PAYMENT_UNSUCCESSFUL,
//    	STATUS
//    }
    
//    private int quantityAdult;
//    private int quantityOKU;
//    private int quantitySenior;
//    private int quantityStudent;
//    private int quantityChildren;
//    private int totalNumberOfSeats;

    /* Constructor */
    /**
     * This constructor creates a new booking.
     * 
     * @param movie
     * @param member
     * @param showtime
     * @param totalSeat
     * @param totalPrice
     */
    public Booking(Movie movie, Member member, Showtime showtime, String status,int totalSeat,double totalPrice) {
        this.bookingId = UUID.randomUUID().toString();
        this.movie = movie;
        this.showtime = showtime;
        this.status = status;
        this.totalSeat = totalSeat;
        this.totalPrice = totalPrice;
        /*    private String bookingId;
    private Member member;
    private Movie movie;
    private Showtime showtime;
    private int totalSeat;
    private double totalPrice;
    private Status status;*/

//        
//        this.quantityAdult = quantityAdult;
//        this.quantityChildren = quantityChildren;
//        this.quantityOKU = quantityOKU;
//        this.quantitySenior = quantitySenior;
//        this.quantityStudent = quantityStudent;
//        this.totalNumberOfSeats = quantityAdult + quantityOKU + quantitySenior + quantityStudent + quantityChildren;
//        this.totalPrice = calculateTotalPrice();
//        this.status = "booked";
    }

    /* Accessors */
    public String getBookingId() {
        return bookingId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Showtime getShowtime() {
    	return showtime;
    }
    
    public String getStatus() {
    	return status;
    }

    public int getTotalSeat() {
		return totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public void setStatus(String status) {
		this.status = status;
	}

//    public void setShowtime(Showtime showtime) {
//        if (!movie.getShowtimes().contains(showtime)) {
//            throw new IllegalArgumentException("Selected showtime not available for this movie.");
//        }
//        this.showtime = showtime;
//    }

//    // Getter and Setter for quantityOKU
//    public int getQuantityOKU() {
//        return quantityOKU;
//    }
//
//    public void setQuantityOKU(int quantityOKU) {
//        this.quantityOKU = quantityOKU;
//    }
//
//    // Getter and Setter for quantitySenior
//    public int getQuantitySenior() {
//        return quantitySenior;
//    }
//
//    public void setQuantitySenior(int quantitySenior) {
//        this.quantitySenior = quantitySenior;
//    }
//
//    // Getter and Setter for quantityStudent
//    public int getQuantityStudent() {
//        return quantityStudent;
//    }
//
//    public void setQuantityStudent(int quantityStudent) {
//        this.quantityStudent = quantityStudent;
//    }
//
//    // Getter and Setter for quantityChildren
//    public int getQuantityChildren() {
//        return quantityChildren;
//    }
//
//    public void setQuantityChildren(int quantityChildren) {
//        this.quantityChildren = quantityChildren;
//    }
//
//    // Getter and Setter for totalNumberOfSeats
//    public int getTotalNumberOfSeats() {
//        return totalNumberOfSeats;
//    }
//
//    public void setTotalNumberOfSeats(int totalNumberOfSeats) {
//        this.totalNumberOfSeats = totalNumberOfSeats;
//    }
//
//    // Getter and Setter for totalPrice
//    public double getTotalPrice() {
//        return totalPrice;
//    }
//
//    public void setTotalPrice(double totalPrice) {
//        this.totalPrice = totalPrice;
//    }
//
//
//    public String getStatus(){
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
    /**
     * This method returns the total price of the booking.
     * 
     * @return double
     */
    public static double calculateTotalPrice(int quantityAdult,int quantityChild, int quantityOKU,int quantitySenior,
    		int quantityStudent,Showtime showtime, Movie movie) {
    	int totalTicketsNum = quantityAdult+quantityChild+quantityOKU+quantitySenior+quantityStudent;
        double totalPrice = 0;
        double normalTicketPrice = showtime.getNormalTicketPrice();
        double fixedPrice = 0.0;
        
        //check show time
        boolean isWednesday = showtime.getDate().getDayOfWeek().toString().equals("WEDNESDAY");
        boolean before1pm = showtime.getTime().getHour()>0 && showtime.getTime().getHour()<13;
        boolean isWeekend = showtime.getDate().getDayOfWeek().toString().equals("SATURDAY") 
        		&& showtime.getDate().getDayOfWeek().toString().equals("SUNDAY");
        boolean isPublicHoliday = true; //need to work on it
        
        //calculate prices acccording to showtime and movie category
        if (!isWeekend && !isWednesday && before1pm) { //weekdays before 1 pm except wednesday
        	fixedPrice = 9;
        	return fixedPrice*totalTicketsNum;
        }
        else if (isWednesday) {
        	fixedPrice = 8;
        	return fixedPrice*totalTicketsNum;
        }
        else {
        	if(isWeekend || isPublicHoliday)
            	normalTicketPrice += 2;
        	if(movie.getCategory().equals("3D"))
            	normalTicketPrice += 4;
            else if (movie.getCategory().equals("IMAX"))
            	normalTicketPrice += 4;
		           
		    //calculate prices acccording to user category
		    for (int i = 0; i < quantityAdult; i++) {
		        totalPrice += normalTicketPrice;
		    }
		
		    for (int i = 0; i < quantityOKU; i++) {
		        totalPrice += normalTicketPrice * 0.95;
		    }
		
		    for (int i = 0; i < quantitySenior; i++) {
		    	totalPrice += 9;
		    }
		
		    for (int i = 0; i < quantityStudent; i++) {
		        if (showtime.getTime().getHour() < 18) //for movie before 6 pm
		            totalPrice += 9;
		        else
		            totalPrice += showtime.getNormalTicketPrice();
		    }
		
		    for (int i = 0; i < quantityStudent; i++){
		    	totalPrice += 9;
		    }
		    
		    return totalPrice;
		}
    }
}