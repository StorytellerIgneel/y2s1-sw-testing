package booking;

import java.util.Date;
import java.util.UUID;
import java.text.SimpleDateFormat;

import cinema.Cinema;
import movie.Movie;


/** 
 * This class represents a booking made by a user.
 * 
 */
public class Booking
{
    public final String bookingId;
    private Movie movie;
    private Cinema cinema;
    private String showtime;
    private int quantityAdult;
    private int quantityChildren;
    private String date;
    private String time;

    /* Constructor */
    /**
     * This constructor creates a new booking.
     * @param movie
     * @param cinema
     * @param showtime
     * @param quantityAdult
     * @param quantityChildren
     */
    public Booking(
        Movie movie,
        Cinema cinema,
        String showtime,
        int quantityAdult, 
        int quantityChildren
        )
    {   
        this.bookingId = UUID.randomUUID().toString();
        this.movie = movie;
        this.cinema = cinema;
        if (!movie.getShowtimes().contains(showtime))
        {
            throw new IllegalArgumentException("Selected showtime not available for this movie.");
        }
        this.showtime = showtime;
        this.quantityAdult = quantityAdult;
        this.quantityChildren = quantityChildren;
        Date unformatted_date = new Date();
        this.date = new SimpleDateFormat("dd-MM-yyyy").format(unformatted_date);
        this.time = new SimpleDateFormat("HH:mm:ss").format(unformatted_date);
    }

    /* Accessors */
    public String getBookingId()
    {
        return bookingId;
    }

    public String getMovieName()
    {
        return movie.getTitle();
    }

    public Movie getMovie()
    {
        return movie;
    }
    
    public int getQuantityAdult()
    {
        return quantityAdult;
    }

    public int getQuantityChildren()
    {
        return quantityChildren;
    }

    public String getCinemaName()
    {
        return cinema.getCinemaName();
    }

    public String getCinemaAddress()
    {
        return cinema.getCinemaAddress();
    }

    public String getShowtime()
    {
        return showtime;
    }

    public String getDate()
    {
        return date;
    }

    public String getTime()
    {
        return time;
    }

    /* Mutators */
    public void setQuantityAdult(int quantityAdult)
    {
        this.quantityAdult = quantityAdult;
    }

    public void setQuantityChildren(int quantityChildren)
    {
        this.quantityChildren = quantityChildren;
    }

    public void setShowtime(String showtime)
    {
        if (!movie.getShowtimes().contains(showtime))
        {
            throw new IllegalArgumentException("Selected showtime not available for this movie.");
        }
        this.showtime = showtime;
    }

    public void setCinema(Cinema cinema)
    {
        this.cinema = cinema;
    }

    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }

    /** 
     * This method returns the total price of the booking.
     * 
     * @return double
     */
    public double calculateTotalPrice()
    {
        return quantityAdult * movie.getPriceAdult() + quantityChildren * movie.getPriceChildren();
    }
}