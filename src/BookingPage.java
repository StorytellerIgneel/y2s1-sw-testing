import booking.Booking;

public class BookingPage {
    private Account user;
    final static String red = "\u001b[31m";
    final static String lime = "\u001b[32m";
    final static String reset = "\u001b[0m";

    // TODO ask team if possible to add Booking Array to user account
    BookingPage(Account user) 
    {
        this.user = user;
    }

    // TODO change booking to Booking Array from user
    public void printBookingDetails(Booking booking)
    {
        System.out.println(red + "1. \tMovie: " + lime + booking.getMovieName());
        System.out.println(red + "\tDate: " + lime + booking.getDate());
        System.out.println(red + "\tTime: " + lime + booking.getTime());
        System.out.println(red + "\tCinema: " + lime + booking.getCinemaName());
        System.out.println(red + "\tLocation: " + lime + booking.getCinemaLocation());
        System.out.println(red + "\tChildren: " + lime + booking.getQuantityChildren());
        System.out.println(red + "\tAdults: " + lime + booking.getQuantityAdult());
        System.out.println(red + "\tTotal Price: " + lime + booking.calculateTotalPrice());
        System.out.print(reset);
    }

    // TODO remove after booking array implemented
    public void display(Booking booking)
    {
        System.out.println(reset + "Welcome, " + user.getName() + "!\n");
        System.out.println(red + "Your Bookings:");
        printBookingDetails(booking);
    }

    // TODO remove test method below
    public static void main(String[] args)
    {
        Account user = new Account("John", "Doe", "password", "01-01-2021");
        Booking booking = new Booking("Avengers: Endgame", "John", "TVG Cheras Selatan", "Cheras", 2, 1);
        BookingPage bookingPage = new BookingPage(user);
        bookingPage.display(booking);
    }
}
