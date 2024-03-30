package booking;

import java.util.Date;
import java.util.UUID;
import java.text.SimpleDateFormat;

/** 
 * This class represents a booking made by a user.
 * 
 */
public class Booking
{
    public final static double priceAdult = 12.90;
    public final static double priceChildren = 6.90;
    public final String bookingId;
    public final String movieName;
    private String cinemaName;
    private String cinemaLocation;
    private int quantityAdult;
    private int quantityChildren;
    private String showtime;
    private String date;
    private String time;

    /* Constructor */
    /**
     * This constructor creates a new booking.
     * @param movieName
     * @param cinemaName
     * @param cinemaLocation
     * @param quantityAdult
     * @param quantityChildren
     */
    public Booking(
        String movieName,
        String cinemaName,
        String cinemaLocation,
        int quantityAdult, 
        int quantityChildren,
        String showtime
        )
    {   
        this.bookingId = UUID.randomUUID().toString();
        this.movieName = movieName;
        this.cinemaName = cinemaName;
        this.cinemaLocation = cinemaLocation;
        this.quantityAdult = quantityAdult;
        this.quantityChildren = quantityChildren;
        this.showtime = showtime;
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
        return movieName;
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
        return cinemaName;
    }

    public String getCinemaLocation()
    {
        return cinemaLocation;
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

    /** 
     * This method returns the total price of the booking.
     * 
     * @return double
     */
    public double calculateTotalPrice()
    {
        return quantityAdult * priceAdult + quantityChildren * priceChildren;
    }
}