//package my.edu.utar;
//
//import junitparams.JUnitParamsRunner;
//import junitparams.Parameters;
//import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.ArrayList;
//
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.*;
//
//import org.junit.Before;
//
//@RunWith(JUnitParamsRunner.class)
//public class BookingTest{
//    private Object[] getParamsForIsExpensive(){
//        return new Object[] {
//            new Object[] {"3D", true},
//            new Object[] {"IMAX", true},
//            new Object[] {"Normal", false},
//        };
//    }
//
//    @Test
//    private void createBookingTest(){
//        Account accountMock = mock(Account.class);
//        Movie movieMock = mock(Movie.class);
//        Showtime showtimeMock = mock(Showtime.class);
//
//        ArrayList<Showtime> mockShowtimeArrayList = new ArrayList<Showtime>();
//        mockShowtimeArrayList.add(showtimeMock);
//        when(accountMock.getName()).thenReturn("Kira Yamato");
//
//        assertNotNull(Booking.createBooking("1", accountMock, movieMock, showtimeMock, 0, 0, 0, 0, 0));
//    }
//}

package my.edu.utar;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import my.edu.utar.Booking;
import my.edu.utar.Movie;
import my.edu.utar.Showtime;
import my.edu.utar.Account;

public class BookingTest {

    @Test
    public void testCalculateAdultTicketPrice() {
    	
        // Create mock objects
        Showtime showtimeMock = mock(Showtime.class);
        Movie movieMock = mock(Movie.class);
        Account accountMock = mock(Account.class);

        // Stub methods of the mock objects
        when(showtimeMock.getNormalTicketPrice()).thenReturn(12.0);
        when(movieMock.isExpensive()).thenReturn(true);

        // Create a Booking object using the mock objects
        Booking booking = new Booking("B001", accountMock, movieMock, showtimeMock, 2, 0, 0, 0, 0);

        // Invoke the method under test and assert results
        double addOn = movieMock.isExpensive() ? 4 : 0;
        double result = booking.calculateAdultTicketPrice(addOn);

        assertEquals(16.0, result, 0.01);
    }

    @Test
    public void testCalculateTotalPrice() {
        System.out.println("\nDoing testCalculateTotalPrice");

        // Create mock objects
        Showtime showtimeMock = mock(Showtime.class);
        Movie movieMock = mock(Movie.class);
        Account accountMock = mock(Account.class);

        // Stub methods of the mock objects
        when(showtimeMock.getNormalTicketPrice()).thenReturn(10.0);
        when(movieMock.isExpensive()).thenReturn(false);

        // Create a Booking object using the mock objects
        Booking booking = new Booking("B002", accountMock, movieMock, showtimeMock, 2, 1, 1, 0, 0);

        // Invoke the method under test and assert results
        double result = booking.calculateTotalPrice();

        assertEquals(37.0, result, 0.01);
    }

//    @Test
//    public void testNumTimesCalled() {
//        System.out.println("\nDoing testNumTimesCalled");
//
//        // Create mock objects
//        Showtime showtimeMock = mock(Showtime.class);
//        Movie movieMock = mock(Movie.class);
//        Account accountMock = mock(Account.class);
//
//        Booking booking = new Booking("B003", accountMock, movieMock, showtimeMock, 1, 0, 0, 1, 0);
//
//        // Call the method multiple times
//        booking.calculateTotalPrice();
//        booking.calculateTotalPrice();
//        booking.calculateTotalPrice();
//
//        // Verify the number of times the method is called with specific arguments
//        verify(showtimeMock, times(3)).getNormalTicketPrice();
//        verify(movieMock, atLeastOnce()).isExpensive();
//        verify(movieMock, never()).getMovieTitle();
//    }
//
//    @Test
//    public void testDemoArgumentMatchers() {
//        System.out.println("\nDoing testDemoArgumentMatchers");
//
//        // Create mock objects
//        Showtime showtimeMock = mock(Showtime.class);
//
//        // Stub method with argument matchers
//        when(showtimeMock.getTicketPriceWithDiscount(anyInt(), anyString(), anyString())).thenReturn(10.0);
//        when(showtimeMock.getTicketPriceWithDiscount(eq(5), eq("student"), anyString())).thenReturn(8.0);
//
//        // Call the method and assert results
//        double result1 = showtimeMock.getTicketPriceWithDiscount(4, "adult", "weekday");
//        double result2 = showtimeMock.getTicketPriceWithDiscount(5, "student", "weekend");
//
//        assertEquals(10.0, result1, 0.01);
//        assertEquals(8.0, result2, 0.01);
//    }
}

