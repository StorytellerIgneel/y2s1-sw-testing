package booking;

import java.util.Date;
import java.util.UUID;
import account.Account;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import cinema.Cinema;
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
    public Booking(Movie movie, Showtime showtime, int quantityAdult, int quantityOKU, int quantitySenior, int quantityStudent, int quantityChildren) {
        this.bookingId = UUID.randomUUID().toString();
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
    }

    /* Accessors */
    public String getBookingId() {
        return bookingId;
    }

    public String getMovieName() {
        return movie.getTitle();
    }

    public Movie getMovie() {
        return movie;
    }

    public int getQuantityAdult() {
        return quantityAdult;
    }

    public int getQuantityChildren() {
        return quantityChildren;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    /* Mutators */
    public void setQuantityAdult(int quantityAdult) {
        this.quantityAdult = quantityAdult;
    }

    public void setQuantityChildren(int quantityChildren) {
        this.quantityChildren = quantityChildren;
    }

    public void setShowtime(Showtime showtime) {
        if (!movie.getShowtimes().contains(showtime)) {
            throw new IllegalArgumentException("Selected showtime not available for this movie.");
        }
        this.showtime = showtime;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    /**
     * This method returns the total price of the booking.
     * 
     * @return double
     */
    public double calculateTotalPrice() {
        return quantityAdult * movie.getPriceAdult() + quantityChildren * movie.getPriceChildren();
    }
}
