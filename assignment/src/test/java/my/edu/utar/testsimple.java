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

public class testsimple {
    @Test
public void simpleTest() {
    assertEquals(2 + 2, 4);
}

}
