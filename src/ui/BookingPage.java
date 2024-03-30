package ui;
import account.UserAccount;
import booking.Booking;
import color.Color;
import util.CommonIcon;

public class BookingPage {
    private UserAccount user;

    /**
     * Constructor for BookingPage for a user
     * @param user
     */
    public BookingPage(UserAccount user) 
    {
        this.user = user;
    }

    /**
     * Prints the details of a booking
     * @param index
     * @param booking
     */
    public void printBookingDetails(int index, Booking booking)
    {
        System.out.println(Color.red + (index + 1) + ". \tMovie: " + Color.lime + booking.getMovieName());
        System.out.println(Color.red + "\tShowtime: " + Color.lime + booking.getShowtime());
        System.out.println(Color.red + "\tCinema: " + Color.lime + booking.getCinemaName());
        System.out.println(Color.red + "\tLocation: " + Color.lime + booking.getCinemaLocation());
        System.out.println(Color.red + "\tChildren: " + Color.lime + booking.getQuantityChildren());
        System.out.println(Color.red + "\tAdults: " + Color.lime + booking.getQuantityAdult());
        System.out.println(Color.red + "\tTotal Price: " + Color.lime + "RM " + booking.calculateTotalPrice());
    }

    /**
     * Displays the booking page
     */
    public void display()
    {   
        CommonIcon.printHeader();
        System.out.println();
        System.out.println(Color.reset + "Welcome, " + user.getName() + "!\n");
        System.out.println(Color.red + "Your Bookings:");

        // Prints all booking details
        for (int i = 0; i < user.getBookings().size(); i++)
        {
            printBookingDetails(i, user.getBookings().get(i));
        }

        System.out.println();
        System.out.println(Color.reset + "What would you like to do with your bookings?"); // TODO add booking controller
        System.out.println(Color.red + "1. " + Color.lime + "Create Bookings");
        System.out.println(Color.red + "2. " + Color.lime + "Update Bookings");
        System.out.println(Color.red + "3. " + Color.lime + "Delete Bookings");
        System.out.println(Color.red + "4. " + Color.lime + "Back to Main Menu");
        System.out.println();
        System.out.print(Color.reset + "Enter your choice: ");
        System.out.print(Color.reset);
    }    
}
