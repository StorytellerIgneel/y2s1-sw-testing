package booking;

import account.Account;
import java.util.UUID;
import movie.Movie;
import showtime.Showtime;


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
        if (!movie.getShowtimes().contains(showtime)) {
            throw new IllegalArgumentException("Selected showtime not available for this movie.");
        }
        this.showtime = showtime;
        this.quantityAdult = quantityAdult;
        this.quantityChildren = quantityChildren;
        this.quantityOKU = quantityOKU;
        this.quantitySenior = quantitySenior;
        this.quantityStudent = quantityStudent;
        this.totalNumberOfSeats = quantityAdult + quantityOKU + quantitySenior + quantityStudent + quantityChildren;
        this.totalPrice = calculateTotalPrice();
        this.status = "CONFIRMED";
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
     * 
     * @return double
     */
    public double calculateTotalPrice() {
        double sum = 0;
        
        for (int i = 0; i < quantityAdult; i++) {
            sum += showtime.getNormalTicketPrice();
        }

        for (int i = 0; i < quantityOKU; i++) {
            sum += showtime.getNormalTicketPrice() * 0.95;
        }

        for (int i = 0; i < quantitySenior; i++) {
            if (showtime.getDate().getDayOfWeek().toString().equals("WEDNESDAY"))
                sum += 8;
            else
                sum += 9;
        }

        for (int i = 0; i < quantityStudent; i++) {
            if (showtime.getTime().getHour() < 18)
                sum += 9;
            else
                sum += showtime.getNormalTicketPrice();
        }

        for (int i = 0; i < quantityStudent; i++){
            if (showtime.getDate().getDayOfWeek().toString().equals("WEDNESDAY"))
                sum += 8;
            else
                sum += 9;
        }

        return sum;
    }
}
