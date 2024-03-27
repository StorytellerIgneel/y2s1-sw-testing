import account.UserAccount;
import booking.Booking;
import ui.BookingPage;

public class BookingPageTest {
    public static void main(String[] args)
    {
        UserAccount user = new UserAccount("John", "Doe", "password", "01-01-2021");
        Booking booking = new Booking("Avengers: Endgame", "John", "TVG Cheras Selatan", "Cheras", 2, 1, "03-01-2024 10:00:00");
        BookingPage bookingPage = new BookingPage(user);
        bookingPage.display(booking);
    }
}
