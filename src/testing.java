import CinemaHall.CinemaHall;
import account.Account;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import movie.Movie;
import showtime.Showtime;
import validation.Validation;
import booking.*;

public class testing {
    public static void main(String[] args) {
        Account kira = new Account("Kira Yamato", "kira.yamato@gundamseed.com", LocalDate.of(2004, 5, 18));
        CinemaHall cinemaHall = CinemaHall.createCinemaHall(1,100);

        ArrayList<Showtime> shows = new ArrayList<>();
        Movie movie = Movie.createBooking("SEED Freedom", "IMAX", shows, 10);
        Showtime showtime = Showtime.createShowtime(movie, cinemaHall, LocalTime.of(15, 0, 0), LocalDate.of(2024, 4, 23));
    
        Booking book = Booking.createBooking("123", kira, movie, showtime, 1, 0, 0, 0, 0);
        //System.out.println(book.calculateSeniorTicketPrice(4));
        System.out.println(book.getTotalPrice());
    }
}