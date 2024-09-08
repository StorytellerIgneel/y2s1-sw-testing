package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;

@RunWith(JUnitParamsRunner.class)
public class ShowtimeTest {
//    private Object[] getParamsFordetermineTicketPriceValidTest(){
//        return new Object[] {
//            "$%^&*()"
//        };
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    @Parameters(method = "getParamsFordetermineTicketPriceValidTest")
//    public void determineTicketPriceValidTest(String test){
//        Validation.isAlphaNumerical(test);
//    }

    // private Object[] getParamsForShowtimeAvailableInValidTest(){
    //     return new Object[] {
    //         "$%^&*()"
    //     };
    // }

    // @Test(expected = IllegalArgumentException.class)
    // @Parameters(method = "getParamsForShowtimeAvailableValidTest")
    // public void ShowtimeAvailableValidTest(String test){
    //     Movie movieMock = mock(Movie.class);
    //     Showtime showtime = new Showtime(movieMock, null, null, null)
    //     Validation.isAlphaNumerical(test);
    // }

//    private Object[] getParamsForDetermineTicketPriceValidTest(){
//        return new Object[] {
//            "$%^&*()"
//        };
//    }
//
//    @Test
//    @Parameters(method = "getParamsForDetermineTicketPriceValidTest")
//    public void determineTicketPriceValidTest(double normalTicketPrice, double ER){
//        Showtime showtime  = new Showtime(null, null, null, null, null)
//        Showtime showtimeSpy = spy()
//    }
	

    private Showtime showtimeSpy;
    private Account mockAccount;
    private Movie mockMovie;
    private Showtime mockShowtime;
    private Booking mockBooking;
    private Account account;
    private Movie movie;
    private Showtime showtime;
    private LocalTime time;
    private Booking bookingSpy;
    private CinemaHall mockHallNumber;
    
	 @Before
	    public void setUp() {
	        // Create mocks
	        showtimeSpy = spy(new Showtime());   
	        
	        mockAccount = mock(Account.class);
	        mockMovie = mock(Movie.class);
	        mockShowtime = mock(Showtime.class);
	        mockBooking = mock(Booking.class);
	        mockHallNumber = mock(CinemaHall.class);
	        bookingSpy = spy(new Booking());

	        // Mock expected behaviors
	        when(mockAccount.getName()).thenReturn("Kira Yamato");
	        when(mockMovie.isExpensive()).thenReturn(false);
	        when(mockShowtime.getNormalTicketPrice()).thenReturn(10.0);
	        when(mockShowtime.getMovie()).thenReturn(mockMovie);
	    }


	    // Test for getMovie()
	    @Test
	    @Parameters("Avatar")
	    public void testGetMovie(String movieTitle) {
	        try {
	            Field movieField = Showtime.class.getDeclaredField("movie");
	            movieField.setAccessible(true);

	            Movie mockMovie = new Movie();
	            mockMovie.setTitle(movieTitle);
	            movieField.set(showtimeSpy, mockMovie);

	            movieField.setAccessible(false);
	        } catch (NoSuchFieldException | IllegalAccessException e) {
	            e.printStackTrace();
	        }
	        assertEquals(movieTitle, showtimeSpy.getMovie().getTitle());
	    }

	    // Test for getStatus()
	    @Test
	    @Parameters("Available")
	    public void testGetStatus(String status) {
	        try {
	            Field statusField = Showtime.class.getDeclaredField("status");
	            statusField.setAccessible(true);

	            statusField.set(showtimeSpy, status);

	            statusField.setAccessible(false);
	        } catch (NoSuchFieldException | IllegalAccessException e) {
	            e.printStackTrace();
	        }
	        assertEquals(status, showtimeSpy.getStatus());
	    }

	    // Test for getHallNumber()
	    @Test
	    @Parameters("5")
	    public void testGetHallNumber(int hallNumber) {
	        try {
	            Field hallNumberField = Showtime.class.getDeclaredField("hallNumber");
	            hallNumberField.setAccessible(true);

	            CinemaHall mockHall = new CinemaHall();
	            mockHall.setHallNumber(hallNumber);
	            hallNumberField.set(showtimeSpy, mockHall);

	            hallNumberField.setAccessible(false);
	        } catch (NoSuchFieldException | IllegalAccessException e) {
	            e.printStackTrace();
	        }
	        assertEquals(hallNumber, showtimeSpy.getHallNumber().getHallNumber());
	    }

	    // Test for getTime()
	    @Test
	    @Parameters("14:30")
	    public void testGetTime(String timeString) {
	        try {
	            Field timeField = Showtime.class.getDeclaredField("time");
	            timeField.setAccessible(true);

	            LocalTime time = LocalTime.parse(timeString);
	            timeField.set(showtimeSpy, time);

	            timeField.setAccessible(false);
	        } catch (NoSuchFieldException | IllegalAccessException e) {
	            e.printStackTrace();
	        }
	        assertEquals(LocalTime.parse(timeString), showtimeSpy.getTime());
	    }

	    // Test for getDate()
	    @Test
	    @Parameters("2024-12-25")
	    public void testGetDate(String dateString) {
	        try {
	            Field dateField = Showtime.class.getDeclaredField("date");
	            dateField.setAccessible(true);

	            LocalDate date = LocalDate.parse(dateString);
	            dateField.set(showtimeSpy, date);

	            dateField.setAccessible(false);
	        } catch (NoSuchFieldException | IllegalAccessException e) {
	            e.printStackTrace();
	        }
	        assertEquals(LocalDate.parse(dateString), showtimeSpy.getDate());
	    }

	    // Test for getNormalTicketPrice()
	    @Test
	    @Parameters("12.0")
	    public void testGetNormalTicketPrice(double ticketPrice) {
	        try {
	            Field ticketPriceField = Showtime.class.getDeclaredField("normalTicketPrice");
	            ticketPriceField.setAccessible(true);

	            ticketPriceField.set(showtimeSpy, ticketPrice);

	            ticketPriceField.setAccessible(false);
	        } catch (NoSuchFieldException | IllegalAccessException e) {
	            e.printStackTrace();
	        }
	        assertEquals(ticketPrice, showtimeSpy.getNormalTicketPrice(), 0.01);
	    }
	    
	    // Test for setMovie()
	    @Test
	    public void testSetMovie() {
	        Movie mockMovie = mock(Movie.class);
	        showtimeSpy.setMovie(mockMovie);
	        
	        // Verify that the setMovie method was called with the specified movie
	        verify(showtimeSpy, times(1)).setMovie(mockMovie);
	    }

	    // Test for setStatus()
	    @Test
	    public void testSetStatus() {
	        String status = "Available";
	        showtimeSpy.setStatus(status);
	        
	        // Verify that the setStatus method was called with the specified status
	        verify(showtimeSpy, times(1)).setStatus(status);
	    }

	    // Test for setHallNumber()
	    @Test
	    public void testSetHallNumber() {
	        CinemaHall mockHall = mock(CinemaHall.class);
	        showtimeSpy.setHallNumber(mockHall);
	        
	        // Verify that the setHallNumber method was called with the specified hall
	        verify(showtimeSpy, times(1)).setHallNumber(mockHall);
	    }

	    // Test for setTime()
	    @Test
	    public void testSetTime() {
	        LocalTime time = LocalTime.of(14, 30);
	        showtimeSpy.setTime(time);
	        
	        // Verify that the setTime method was called with the specified time
	        verify(showtimeSpy, times(1)).setTime(time);
	    }

	    // Test for setDate()
	    @Test
	    public void testSetDate() {
	        LocalDate date = LocalDate.of(2024, 12, 25);
	        showtimeSpy.setDate(date);
	        
	        // Verify that the setDate method was called with the specified date
	        verify(showtimeSpy, times(1)).setDate(date);
	    }

	    // Test for setNormalTicketPrice()
	    @Test
	    public void testSetNormalTicketPrice() {
	        double ticketPrice = 12.0;
	        showtimeSpy.setNormalTicketPrice(ticketPrice);
	        
	        // Verify that the setNormalTicketPrice method was called with the specified price
	        verify(showtimeSpy, times(1)).setNormalTicketPrice(ticketPrice);
	    }
	    
	    
	    @Test
	    public void testCreateShowtime() {
	    	Showtime showtime = Showtime.createShowtime(mockMovie, mockHallNumber, time, null);
            assertNotNull(showtime);
	    }
}
