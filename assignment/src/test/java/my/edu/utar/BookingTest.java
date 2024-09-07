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

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;

@RunWith(JUnitParamsRunner.class)
public class BookingTest {
	 

    private Account mockAccount;
    private Movie mockMovie;
    private Showtime mockShowtime;
    private Booking mockBooking;
    private Account account;
    private Movie movie;
    private Showtime showtime;

    @Before
    public void setUp() {
        // Create mocks
        mockAccount = mock(Account.class);
        mockMovie = mock(Movie.class);
        mockShowtime = mock(Showtime.class);
        mockBooking = mock(Booking.class);

        // Mock expected behaviors
        when(mockAccount.getName()).thenReturn("Kira Yamato");
        when(mockMovie.isExpensive()).thenReturn(false);
        when(mockShowtime.getNormalTicketPrice()).thenReturn(10.0);
        when(mockShowtime.getMovie()).thenReturn(mockMovie);
        
       
    }

	@Test
	public void testSetAccount() {

	    // Call setAccount with a different mock account
	    Account anotherAccount = mock(Account.class);
	    mockBooking.setAccount(anotherAccount);

	    // Verify that setAccount was  called with the newly set mockAccount
	    verify(mockBooking, times(1)).setAccount(anotherAccount);
	}
	
	@Test
	public void testSetMovie() {

	    // Call setAccount with a different mock account
	    Movie anotherMovie = mock(Movie.class);
	    mockBooking.setMovie(anotherMovie);

	    // Verify that setAccount was  called with the newly set mockAccount
	    verify(mockBooking, times(1)).setMovie(anotherMovie);
	}

	@Test
	public void testSetQuantityAdult() {

	    // Call setAccount with a different mock account
	    Movie anotherMovie = mock(Movie.class);
	    mockBooking.setQuantityAdult(100);

	    // Verify that setAccount was  called with the newly set mockAccount
	    verify(mockBooking, times(1)).setQuantityAdult(100);
	}
	
	@Test
	public void testSetQuantityChildren() {

	    // Call setAccount with a different mock account
	    Movie anotherMovie = mock(Movie.class);
	    mockBooking.setQuantityChildren(100);

	    // Verify that setAccount was  called with the newly set mockAccount
	    verify(mockBooking, times(1)).setQuantityChildren(100);
	}
	
	@Test
	public void testSetQuantityOKU() {

	    // Call setAccount with a different mock account
	    Movie anotherMovie = mock(Movie.class);
	    mockBooking.setQuantityOKU(100);

	    // Verify that setAccount was  called with the newly set mockAccount
	    verify(mockBooking, times(1)).setQuantityOKU(100);
	}
	
	@Test
	public void testSetQuantitySenior() {

	    // Call setAccount with a different mock account
	    Movie anotherMovie = mock(Movie.class);
	    mockBooking.setQuantitySenior(100);

	    // Verify that setAccount was  called with the newly set mockAccount
	    verify(mockBooking, times(1)).setQuantitySenior(100);
	}
	
	
	@Test
	public void testSetQuantityStudent() {

	    // Call setAccount with a different mock account
	    Movie anotherMovie = mock(Movie.class);
	    mockBooking.setQuantityStudent(100);

	    // Verify that setAccount was  called with the newly set mockAccount
	    verify(mockBooking, times(1)).setQuantityStudent(100);
	}
	
	@Test 
	public void testSetShowTime() {
		// Call setAccount with a different mock account
        Showtime anotherShowtime = mock(Showtime.class);
        mockBooking.setShowtime(anotherShowtime);
        
        // Verify that setAccount was  called with the newly set mockAccount		
        verify(mockBooking, times(1)).setShowtime(anotherShowtime);
        
	}
	
	@Test 
	public void testStatus() {
		// Call setAccount with a different mock account
        mockBooking.setStatus("Confirmed");
        
        // Verify that setAccount was  called with the newly set mockAccount        
        verify(mockBooking, times(1)).setStatus("Confirmed");
        
	}
	
	@Test
    public void testTotalNumberOfSeats() {
		mockBooking.setTotalNumberOfSeats(1);
		
		// Verify that setAccount was  called with the newly set mockAccount
		verify(mockBooking, times(1)).setTotalNumberOfSeats(1);
	
	}
	
	@Test
    public void testTotalPrice() {
		mockBooking.setTotalPrice(100);
		
		// Verify that setAccount was  called with the newly set mockAccount
		verify(mockBooking, times(1)).setTotalPrice(100);
	}


	 @Test
	    public void testCalculateAdultTicketPrice() {
		 // Initialize the mock object
	        mockShowtime = mock(Showtime.class);


	        Booking booking;

	        // Initialize the Booking object with a mocked showtime
	        booking = new Booking();
	        booking.setShowtime(mockShowtime);
	        booking.setQuantityAdult(2); // Example quantity for testing
	        
	        // Define the behavior of the mock showtime
	        double normalTicketPrice = 15.0;
	        when(mockShowtime.getNormalTicketPrice()).thenReturn(normalTicketPrice);

	        // Test with an add-on value
	        double addOn = 5.0;
	        double expectedPrice = 2 * (normalTicketPrice + addOn); // quantityAdult * (ticketPrice + addOn)

	        // Call the method and capture the result
	        double actualPrice = booking.calculateAdultTicketPrice(addOn);

	        // Assert that the expected and actual values are the same
	        assertEquals(expectedPrice, actualPrice, 0.001);
	    }



	  

}

