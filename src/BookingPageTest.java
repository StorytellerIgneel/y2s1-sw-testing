import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import account.UserAccount;
import booking.Booking;
import cinema.Cinema;
import movie.Movie;
import ui.booking.BookingPage;

public class BookingPageTest {
    public static void main(String[] args)
    {
        UserAccount user = new UserAccount("John", "Doe", "password", "01-01-2021");
        Movie movie1 = new Movie(
            "avengers-endgame", 
            "Avengers: Endgame", 
            "The Avengers take a final stand against Thanos.",
            new ArrayList<>(Arrays.asList("03-01-2024 10:00:00", "03-01-2024 13:00:00", "03-01-2024 16:00:00")),
            new ArrayList<String>(),
            "26-04-2019",
            new ArrayList<String>(),
            15.00,
            10.00
        );
        Movie movie2 = new Movie(
            "spiderman-far-from-home", 
            "Spider Man: Far From Home",
            "Peter Parker goes on a trip to Europe.",
            new ArrayList<>(Arrays.asList("05-06-2024 22:00:00", "03-01-2024 13:00:00", "03-01-2024 16:00:00")),
            new ArrayList<String>(),
            "02-07-2019",
            new ArrayList<String>(),
            15.00,
            10.00
        );

        Booking booking = new Booking(movie1, Cinema.getCinemaLocation()[0], "03-01-2024 10:00:00", 2, 3);
        Booking booking2 = new Booking(movie2, Cinema.getCinemaLocation()[1], "05-06-2024 22:00:00", 2, 0);
        
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        bookings.add(booking);
        bookings.add(booking2);

        user.setBookings(bookings);
        Scanner scanner = new Scanner(System.in);
        BookingPage bookingPage = new BookingPage(user, scanner);
        bookingPage.display();
    }
}
