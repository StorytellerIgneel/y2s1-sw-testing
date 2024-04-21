package report;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import account.UserAccount;
import booking.*;

public class Report {
    private String movieId;
    private String movieName;
    private int totalAdult = 0;
    private int totalChildren = 0;
    private double priceChildren;
    private double priceAdult;

    /**
     * Constructor for Report
     * 
     * @param movieId
     * @param movieName
     * @param totalAdult
     * @param totalChildren
     * @param priceAdult
     * @param priceChildren
     */
    public Report(String movieId, String movieName, int totalAdult, int totalChildren,
            double priceAdult, double priceChildren) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.totalAdult = totalAdult;
        this.totalChildren = totalChildren;
        this.priceAdult = priceAdult;
        this.priceChildren = priceChildren;
    }

    /**
     * Generate ticket sales report
     * 
     * @param users
     * @param data
     */
    public static void generateTicketSalesReport(ArrayList<UserAccount> users,
            ArrayList<Report> data) {
        for (UserAccount user : users) {
            ArrayList<Booking> bookings = user.getBookings();
            for (Booking booking : bookings) {
                String movieId = booking.getMovie().getMovieId();
                boolean movieFound = false;

                // Checks if the movie is in the data list
                for (Report report : data) {
                    if (report.getMovieId().equals(movieId)) {
                        report.updateQuantities(booking.getQuantityAdult(),
                                booking.getQuantityChildren());
                        movieFound = true;
                        break;
                    }
                }
                if (movieFound == false) {
                    if (booking.getShowtime().toLocalDate()
                            .format(DateTimeFormatter.ofPattern("MM-yyyy")).equals(LocalDate.now()
                                    .format(DateTimeFormatter.ofPattern("MM-yyyy")))) {
                        continue;
                    }
                    data.add(new Report(movieId, booking.getMovieName(), booking.getQuantityAdult(),
                            booking.getQuantityChildren(), booking.getMovie().getPriceAdult(),
                            booking.getMovie().getPriceChildren()));
                }
            }
        }
    }

    /**
     * Calculate total revenue
     * 
     * @return total revenue
     */
    public double calculateTotalRevenue() {
        return getTotalAdult() * getPriceAdult() + getTotalChildren() * getPriceChildren();
    }

    /**
     * Update quantities of adult and children tickets
     * 
     * @param totalAdult
     * @param totalChildren
     */
    public void updateQuantities(int totalAdult, int totalChildren) {
        setTotalAdult(getTotalAdult() + totalAdult);
        setTotalChildren(getTotalChildren() + totalChildren);
    }

    /**
     * Get report date
     * 
     * @return formatted date
     */
    public static String getReportDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = currentDate.format(formatter);
        return formattedDate;
    }

    // Accessors
    public String getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getTotalAdult() {
        return totalAdult;
    }

    public int getTotalChildren() {
        return totalChildren;
    }

    public double getPriceAdult() {
        return priceAdult;
    }

    public double getPriceChildren() {
        return priceChildren;
    }

    // Mutators
    public void setTotalAdult(int totalAdult) {
        this.totalAdult = totalAdult;
    }

    public void setTotalChildren(int totalChildren) {
        this.totalChildren = totalChildren;
    }
}
