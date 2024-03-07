import java.util.Date;

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

    public Booking(){

    }

    public void cancel(){
        
    }
}