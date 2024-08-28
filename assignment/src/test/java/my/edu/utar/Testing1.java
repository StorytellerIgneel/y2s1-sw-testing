package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import my.edu.utar.movie.Movie;
import my.edu.utar.showtime.Showtime;

import org.junit.Test;
import org.junit.runner.RunWith;

import my.edu.utar.CinemaHall.CinemaHall;
import my.edu.utar.account.Account;
import my.edu.utar.booking.Booking;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Before;

@RunWith(JUnitParamsRunner.class)
public class Testing1 {
    @Test
    public void mainTest(){
        Account kira = new Account("Kira Yamato", "kira.yamato@gundamseed.com", LocalDate.of(2004, 5, 18));
        CinemaHall cinemaHall = CinemaHall.createCinemaHall(1,100);

        ArrayList<Showtime> shows = new ArrayList<>();
        Movie movie = Movie.createBooking("SEED Freedom", "IMAX", shows, 10);
        Showtime showtime = Showtime.createShowtime(movie, cinemaHall, LocalTime.of(15, 0, 0), LocalDate.of(2024, 4, 23));
    
        Booking book = Booking.createBooking("123", kira, movie, showtime, 1, 0, 0, 0, 0);
        //System.out.println(book.calculateSeniorTicketPrice(4));
        assertEquals(book.getTotalPrice(), 14, 0.1);
    }
}

