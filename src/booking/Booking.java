package booking;

import java.util.Date;
import java.util.UUID;
import java.text.SimpleDateFormat;

// TODO Replace cinemaName and cinemaLocation with Cinema object
public class Booking
{
    public final static double priceAdult = 12.90;
    public final static double priceChildren = 6.90;
    public final String bookingId;
    public final String movieId;
    public final String accountId;
    private String cinemaName;
    private String cinemaLocation;
    private int quantityAdult;
    private int quantityChildren;
    private String date;
    private String time;

    /* Constructor */
    public Booking(
        String movieId,
        String accountId,
        String cinemaName,
        String cinemaLocation,
        int quantityAdult, 
        int quantityChildren)
    {   
        this.bookingId = UUID.randomUUID().toString();
        this.movieId = movieId;
        this.accountId = accountId;
        this.cinemaName = cinemaName;
        this.cinemaLocation = cinemaLocation;
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
    
    public int getQuantityAdult()
    {
        return quantityAdult;
    }

    public int getQuantityChildren()
    {
        return quantityChildren;
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