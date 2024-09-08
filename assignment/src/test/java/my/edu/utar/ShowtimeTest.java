package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
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
	        time = LocalTime.of(14, 0);

	        // Create the Showtime instance
	        showtime = new Showtime();
	        showtime.setHallNumber(mockHallNumber);

	        // Mock expected behaviors
	        when(mockAccount.getName()).thenReturn("Kira Yamato");
	        when(mockMovie.isExpensive()).thenReturn(false);
	        when(mockShowtime.getNormalTicketPrice()).thenReturn(10.0);
	        when(mockShowtime.getMovie()).thenReturn(mockMovie);
	        when(mockHallNumber.checkOversell(0)).thenReturn(false);

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

	    // Test for getYear()
	    @Test
	    @Parameters("2024, 2024")
	    public void testGetYear(int year, int ER) {
	        try {
	            Field yearField = Showtime.class.getDeclaredField("year");
	            yearField.setAccessible(true);

	            yearField.set(showtimeSpy, year);

	            yearField.setAccessible(false);
	        } catch (NoSuchFieldException | IllegalAccessException e) {
	            e.printStackTrace();
	        }
	        assertEquals(year, showtimeSpy.getYear());
	    }
	    
	    //Test for getMonth()
	    @Test
	    @Parameters("1,1")
	     public void testGetMonth(int month, int ER) {
            try {
                Field monthField = Showtime.class.getDeclaredField("month");
                monthField.setAccessible(true);
                
                monthField.set(showtimeSpy, month);
                
                monthField.setAccessible(false);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            assertEquals(month, showtimeSpy.getMonth());
	    }
	    
        // Test for getDay()
        @Test
        @Parameters("20, 20")
        public void testGetDay(int day, int ER) {
            try {
                Field dayField = Showtime.class.getDeclaredField("day");
                dayField.setAccessible(true);
                
                dayField.set(showtimeSpy, day);
                
                dayField.setAccessible(false);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            assertEquals(day, showtimeSpy.getDay());
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
	    public void testSetYear() {
	        showtimeSpy.setYear(1);
	        
	        // Verify that the setDate method was called with the specified date
	        verify(showtimeSpy, times(1)).setYear(1);
	    }
	    
	    @Test
	    public void testSetMonth() {
	        showtimeSpy.setMonth(1);
	        
	        // Verify that the setDate method was called with the specified date
	        verify(showtimeSpy, times(1)).setMonth(1);
	    }
	    
	    @Test
	    public void testSetDay() {
	        showtimeSpy.setDay(1);
	        
	        // Verify that the setDate method was called with the specified date
	        verify(showtimeSpy, times(1)).setDay(1);
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
	    	Showtime showtime = Showtime.createShowtime(mockMovie, mockHallNumber, time, 2000,1,1);
            assertNotNull(showtime);
	    }
	    
	    // Test when hall is available but showtime status is in the reject list
	    @Test
	    public void testShowtimeAvailable_HallAvailable_StatusNotAvailable() {
	        // Mock hall to return available
	        when(mockHallNumber.hallAvailable(anyInt())).thenReturn(true);

	        // Set the showtime status to one of the reject statuses
	        showtime.setStatus("Not Available");

	        // Verify that showtimeAvailable returns false
	        assertFalse(showtime.showtimeAvailable(50)); // Example ticket quantity 50
	    }

	    // Test when hall is available and showtime status is "Available"
	    @Test
	    public void testShowtimeAvailable_HallAvailable_StatusAvailable() {
	        // Mock hall to return available
	        when(mockHallNumber.hallAvailable(anyInt())).thenReturn(true);

	        // Set the showtime status to "Available"
	        showtime.setStatus("Available");

	        // Verify that showtimeAvailable returns true
	        assertTrue(showtime.showtimeAvailable(50)); // Example ticket quantity 50
	    }

	    // Test when hall is not available (regardless of status)
	    @Test
	    public void testShowtimeAvailable_HallNotAvailable() {
	        // Mock hall to return not available
	        when(mockHallNumber.hallAvailable(anyInt())).thenReturn(false);

	        // Set the showtime status to anything
	        showtime.setStatus("Available");

	        // Verify that showtimeAvailable returns false
	        assertFalse(showtime.showtimeAvailable(50)); // Example ticket quantity 50
	    }

	    // Test when hall is available but showtime status is "Fully Booked"
	    @Test
	    public void testShowtimeAvailable_HallAvailable_StatusFullyBooked() {
	        // Mock hall to return available
	        when(mockHallNumber.hallAvailable(anyInt())).thenReturn(true);

	        // Set the showtime status to "Fully Booked"
	        showtime.setStatus("Fully Booked");

	        // Verify that showtimeAvailable returns false
	        assertFalse(showtime.showtimeAvailable(50)); // Example ticket quantity 50
	    }

	    // Test when hall is available but showtime status is "Cancelled"
	    @Test
	    public void testShowtimeAvailable_HallAvailable_StatusCancelled() {
	        // Mock hall to return available
	        when(mockHallNumber.hallAvailable(anyInt())).thenReturn(true);

	        // Set the showtime status to "Cancelled"
	        showtime.setStatus("Cancelled");

	        // Verify that showtimeAvailable returns false
	        assertFalse(showtime.showtimeAvailable(50)); // Example ticket quantity 50
	    }
	    
}
