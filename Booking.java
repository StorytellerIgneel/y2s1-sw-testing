import java.util.Date;
import java.util.UUID;

public class Booking
{
    private String bookingId;
    private String movieId;
    private String cinemaName;
    private String cinemaLocation;
    private String accountId;
    private int quantityAdult;
    private int quantityChildren;
    private double priceAdult = 12.90;
    private double priceChildren = 6.90;
    private String time;
    private Date date;

    // public constructor booking
    public Booking(
        String movieId,
        String accountId,
        String cinemaLocation, 
        int quantityAdult, 
        int quantityChildren)
    {   
        this.bookingId = UUID.randomUUID().toString();
        this.movieId = movieId;
        this.cinemaLocation = cinemaLocation;
        this.quantityAdult = quantityAdult;
        this.quantityChildren = quantityChildren;
    }

    // public cancel method
    public void cancel()
    {

    }
}