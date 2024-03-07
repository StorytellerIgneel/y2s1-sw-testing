import java.util.Date;
import java.util.UUID;
import java.text.SimpleDateFormat;

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
    private String date;
    private String time;

    // public constructor booking
    public Booking(
        String movieId,
        String accountId,
        String cinemaName,
        String cinemaLocation, 
        int quantityAdult, 
        int quantityChildren)
    {   
        // set variables
        this.bookingId = UUID.randomUUID().toString();
        this.movieId = movieId;
        this.cinemaName = cinemaName;
        this.cinemaLocation = cinemaLocation;
        this.quantityAdult = quantityAdult;
        this.quantityChildren = quantityChildren;
        unformatted_date = new Date();
        this.date = new SimpleDateFormat("HH:mm:ss").format(unformatted_date);
        this.time = new SimpleDateFormat("HH:mm:ss").format(unformatted_date);
    }

    // public cancel method
    public void cancel()
    {

    }
}