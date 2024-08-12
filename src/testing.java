import account.Account;
import booking.Booking;
import movie.Movie;
import showtime.Showtime;
import java.time.*;
import java.time.LocalTime;
import java.util.ArrayList;
import CinemaHall.CinemaHall;


public class testing {
    public static void main(String[] args) {
        ArrayList<Showtime> shows = new ArrayList<Showtime>();
        Account account = new Account("Kirito", "blackswordsman@sao.com", LocalDate.of(1990, 1, 1));
        Movie movie = new Movie("SAO", "IMAX", shows, 10.00);
        CinemaHall hall1 = new CinemaHall(1, 100);
        Showtime showtime = new Showtime(movie, hall1, LocalTime.of(18, 0), LocalDate.of(2020, 1, 1), 10.00);
        shows.add(showtime);

        Booking booking = new Booking("123", account, movie, showtime, 1, 0,0,0,0);

        System.out.println(booking.getTotalPrice());
    }
}