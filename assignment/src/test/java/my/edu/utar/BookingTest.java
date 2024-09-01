package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;

public class BookingTest{
    private void createBookingTest(){
        Account accountMock = mock(Account.class);
        Movie movieMock = mock(Movie.class);
        Showtime showtimeMock = mock(Showtime.class);

        ArrayList<Showtime> mockShowtimeArrayList = new ArrayList<Showtime>();
        mockShowtimeArrayList.add(showtimeMock);
        when(accountMock.getName()).thenReturn("Kira Yamato");
        when(movieMock.getShowtimes()).thenReturn(mockShowtimeArrayList);
    }
}