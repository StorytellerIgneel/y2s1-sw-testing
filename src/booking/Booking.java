package booking;

import account.Account;
import java.util.UUID;
import java.util.ArrayList;
import movie.Movie;
import showtime.Showtime;
import validation.Validation;


/**
 * This class represents a booking made by a user.
 * 
 */
public class Booking {
    private String bookingId;
    private Account account;
    private Movie movie;
    private Showtime showtime;
    private int quantityAdult;
    private int quantityOKU;
    private int quantitySenior;
    private int quantityStudent;
    private int quantityChildren;
    private int totalNumberOfSeats;
    private double totalPrice;
    private String status;

    /* Constructor */
    /**
     * This constructor creates a new booking.
     * 
     * @param movie
     * @param cinema
     * @param showtime
     * @param quantityAdult
     * @param quantityChildren
     */
    public Booking(String bookingID, Account account, Movie movie, Showtime showtime, int quantityAdult, int quantityOKU, int quantitySenior, int quantityStudent, int quantityChildren) {
        this.bookingId = bookingID;
        this.account = account;
        this.movie = movie;
        this.showtime = showtime;
        this.quantityAdult = quantityAdult;
        this.quantityChildren = quantityChildren;
        this.quantityOKU = quantityOKU;
        this.quantitySenior = quantitySenior;
        this.quantityStudent = quantityStudent;
        this.totalNumberOfSeats = quantityAdult + quantityOKU + quantitySenior + quantityStudent + quantityChildren;
        this.totalPrice = calculateTotalPrice();
        this.status = "Booked";
    }

    public Booking createBooking(String bookingID, Account account, Movie movie, Showtime showtime, int quantityAdult, int quantityOKU, int quantitySenior, int quantityStudent, int quantityChildren){
        if (!movie.getShowtimes().contains(showtime)) {
            System.out.println("Selected showtime not available for this movie.");
            return null;
        }
        if ((quantityAdult + quantityChildren + quantityOKU + quantitySenior + quantityStudent) == 0){
            System.out.println("No tickets booked.");
            return null;
        }
        if (!Validation.isRegisteredUser(account.getName())){
            System.out.println("User not registered");
            return null;
        }
        return new Booking(bookingID, account, movie, showtime, quantityAdult, quantityOKU, quantitySenior, quantityStudent, quantityChildren);
    }

    /* Accessors */
    public String getBookingId() {
        return bookingId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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

    public void setShowtime(Showtime showtime) {
        if (!movie.getShowtimes().contains(showtime)) {
            throw new IllegalArgumentException("Selected showtime not available for this movie.");
        }
        this.showtime = showtime;
    }

    // Getter and Setter for quantityOKU
    public int getQuantityOKU() {
        return quantityOKU;
    }

    public void setQuantityOKU(int quantityOKU) {
        this.quantityOKU = quantityOKU;
    }

    // Getter and Setter for quantitySenior
    public int getQuantitySenior() {
        return quantitySenior;
    }

    public void setQuantitySenior(int quantitySenior) {
        this.quantitySenior = quantitySenior;
    }

    // Getter and Setter for quantityStudent
    public int getQuantityStudent() {
        return quantityStudent;
    }

    public void setQuantityStudent(int quantityStudent) {
        this.quantityStudent = quantityStudent;
    }

    // Getter and Setter for quantityChildren
    public int getQuantityChildren() {
        return quantityChildren;
    }

    public void setQuantityChildren(int quantityChildren) {
        this.quantityChildren = quantityChildren;
    }

    // Getter and Setter for totalNumberOfSeats
    public int getTotalNumberOfSeats() {
        return totalNumberOfSeats;
    }

    public void setTotalNumberOfSeats(int totalNumberOfSeats) {
        this.totalNumberOfSeats = totalNumberOfSeats;
    }

    // Getter and Setter for totalPrice
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


    public String getStatus(){
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * This method returns the total price of the booking.
     * Serves as the core of the entire system
     * @return double
     */
    public double calculateTotalPrice() {
        int sumTicket = quantityAdult + quantityChildren + quantityOKU + quantitySenior + quantityStudent;

        double addOn = (movie.isExpensive()? 1: 0) * 4;
        //validate account
        ///if ()

        if (accountRegistered()){
            if (showtime.showtimeAvailable(sumTicket))
                return (calculateAdultTicketPrice(addOn) + calculateOKUTicketPrice(addOn) + calculateSeniorTicketPrice(addOn) + calculateStudentTicketPrice(addOn) + calculateChildrenTicketPrice(addOn));
            else
                return 0;
        }
        else{
            System.out.println("Account not registered");
            return 0;
        }
        //validate showtime (inside showtime validate the hallnumber ardy)
        
    }

    public double calculateAdultTicketPrice(double addOn){
        return (quantityAdult * showtime.getNormalTicketPrice() + addOn);
    }

    public double calculateOKUTicketPrice(double addOn){
        return (quantityOKU * showtime.getNormalTicketPrice() * 0.95 + addOn);
    }

    public double calculateSeniorTicketPrice(double addOn){
        return (quantityAdult * ((showtime.getNormalTicketPrice() > 9)? 9 : showtime.getNormalTicketPrice()) + addOn);
    }

    public double calculateStudentTicketPrice(double addOn){
        return (quantityStudent * ((showtime.getTime().getHour() < 18)? 9 : showtime.getNormalTicketPrice()) + addOn);
    }

    public double calculateChildrenTicketPrice(double addOn){
        return (quantityChildren * ((showtime.getNormalTicketPrice() > 9)? 9 : showtime.getNormalTicketPrice()) + addOn);
    }
}
