import account.Account;
import booking.Booking;
import color.Color;

public class BookingPage {
    private Account user;

    // TODO ask team if possible to add Booking Array to user account
    BookingPage(Account user) 
    {
        this.user = user;
    }

    // TODO change booking to Booking Array from user
    public void printBookingDetails(Booking booking)
    {
        System.out.println(Color.red + "1. \tMovie: " + Color.lime + booking.getMovieName());
        System.out.println(Color.red + "\tShowtime: " + Color.lime + booking.getShowtime());
        System.out.println(Color.red + "\tCinema: " + Color.lime + booking.getCinemaName());
        System.out.println(Color.red + "\tLocation: " + Color.lime + booking.getCinemaLocation());
        System.out.println(Color.red + "\tChildren: " + Color.lime + booking.getQuantityChildren());
        System.out.println(Color.red + "\tAdults: " + Color.lime + booking.getQuantityAdult());
        System.out.println(Color.red + "\tTotal Price: " + Color.lime + "RM " + booking.calculateTotalPrice());
    }

    // TODO remove after booking array implemented
    public void display(Booking booking)
    {   
        CommonIcon.printHeader();
        System.out.println(Color.reset + "Welcome, " + user.getName() + "!\n");
        System.out.println(Color.red + "Your Bookings:");
        printBookingDetails(booking);
        System.out.println("\n");
        System.out.println(Color.lime + "What would you like to do with your bookings?"); // TODO add booking controller
        System.out.print(Color.reset);
    }

    // TODO remove test method below
    public static void main(String[] args)
    {
        Account user = new Account("John", "Doe", "password", "01-01-2021");
        Booking booking = new Booking("Avengers: Endgame", "John", "TVG Cheras Selatan", "Cheras", 2, 1, "03-01-2024 10:00:00");
        BookingPage bookingPage = new BookingPage(user);
        bookingPage.display(booking);
    }
}
