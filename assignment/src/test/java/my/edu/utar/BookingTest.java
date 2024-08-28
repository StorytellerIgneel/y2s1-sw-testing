package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import my.edu.utar.*;
import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal;

import org.junit.Test;
import org.junit.runner.RunWith;

import my.edu.utar.CinemaHall.CinemaHall;
import my.edu.utar.account.Account;
import my.edu.utar.booking.Booking;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Before;

public class BookingTest{
    private void createBookingTest(){
        Account accmock = mock(Account.class);
    }
}