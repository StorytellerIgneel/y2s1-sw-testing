package report;


import java.util.ArrayList;

import account.UserAccount;
import booking.*;

public class Report {
    private String movieId;
    private String movieName;
    private int totalAdult = 0;
    private int totalChildren = 0; 
    private double priceChildren;
    private double priceAdult;

    // constructor
    public Report(String movieId, String movieName, int totalAdult, int totalChildren, double priceAdult, double priceChildren)
    {
        this.movieId = movieId;
        this.movieName = movieName;
        this.totalAdult = totalAdult;
        this.totalChildren = totalChildren;
        this.priceAdult = priceAdult;
        this.priceChildren = priceChildren;
    }

    public static void generateTicketSalesReport(ArrayList<UserAccount> users, ArrayList<Report> data)
    {
        for (UserAccount user : users)
        {
            ArrayList<Booking> bookings = user.getBookings();
            for (Booking booking : bookings)
            {
                String movieId = booking.getMovie().getMovieId();
                boolean movieFound = false;

                // Checks if the movie is in the data list
                for (Report report : data)
                {
                    if (report.getMovieId().equals(movieId))
                    {
                        report.updateQuantities(booking.getQuantityAdult(), booking.getQuantityChildren()); 
                        movieFound = true;
                        break;
                    }
                }
                if (movieFound == false)
                {
                    data.add(new Report(movieId, booking.getMovieName(), booking.getQuantityAdult(), 
                    booking.getQuantityChildren(), booking.getMovie().getPriceAdult(), booking.getMovie().getPriceChildren()));
                }
            }
        }        
    }

    public double calculateTotalRevenue() {
        return getTotalAdult() * getPriceAdult() + getTotalChildren() * getPriceChildren();
    }

    public void updateQuantities(int totalAdult, int totalChildren)
    {
        setTotalAdult(getTotalAdult() + totalAdult);
        setTotalChildren(getTotalChildren() + totalChildren);
    }

    public String getMovieId()
    {
        return movieId;
    }

    public String getMovieName()
    {
        return movieName;
    }

    public int getTotalAdult()
    {
        return totalAdult;
    }

    public int getTotalChildren()
    {
        return totalChildren;
    }

    public double getPriceAdult()
    {
        return priceAdult;
    }

    public double getPriceChildren()
    {
        return priceChildren;
    }

    public void setTotalAdult(int totalAdult)
    {
        this.totalAdult = totalAdult;
    }

    public void setTotalChildren(int totalChildren)
    {
        this.totalChildren = totalChildren;
    }
}
