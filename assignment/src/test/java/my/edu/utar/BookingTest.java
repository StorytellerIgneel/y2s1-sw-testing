package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;

@RunWith(JUnitParamsRunner.class)
public class BookingTest{
    private Object[] getParamsForIsExpensive(){
        return new Object[] {
            new Object[] {"3D", true},
            new Object[] {"IMAX", true},
            new Object[] {"Normal", false},
        };
    }

    @Test
    private void createBookingTest(){
        Account accountMock = mock(Account.class);
        Movie movieMock = mock(Movie.class);
        Showtime showtimeMock = mock(Showtime.class);

        ArrayList<Showtime> mockShowtimeArrayList = new ArrayList<Showtime>();
        mockShowtimeArrayList.add(showtimeMock);
        when(accountMock.getName()).thenReturn("Kira Yamato");
        when(movieMock.getShowtimes().contains(any())).thenReturn(true);

        assertNotNull(Booking.createBooking("1", accountMock, movieMock, showtimeMock, 0, 0, 0, 0, 0));
    }
}