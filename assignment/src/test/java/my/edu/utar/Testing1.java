package my.edu.utar;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class Testing1 {
    @Test
    public void mainTest(){
        Account kira = new Account("Kira Yamato", "kira.yamato@gundamseed.com",2004, 5, 18);
        CinemaHall cinemaHall = CinemaHall.createCinemaHall(1,100);

        ArrayList<Showtime> shows = new ArrayList<>();
        Movie movie = Movie.createMovie("SEED Freedom", "IMAX", 10);
        //Showtime showtime = Showtime.createShowtime(movie, cinemaHall, LocalTime.of(15, 0, 0), LocalDate.of(2024, 4, 23));
    
        //Booking book = Booking.createBooking("123", kira, movie, showtime, 1, 0, 0, 0, 0);
        //System.out.println(book.calculateSeniorTicketPrice(4));
        //assertEquals(book.getTotalPrice(), 14, 0.1);
    }
}

