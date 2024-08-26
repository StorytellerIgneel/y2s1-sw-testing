package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import movie.Movie;
import showtime.Showtime;

import org.junit.Test;
import org.junit.runner.RunWith;

import CinemaHall.CinemaHall;
import account.Account;
import booking.Booking;

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
