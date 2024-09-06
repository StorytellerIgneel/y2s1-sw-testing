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

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import my.edu.utar.Booking;
import my.edu.utar.Movie;
import my.edu.utar.Showtime;
import my.edu.utar.Account;

//// havent tally w test cases
public class BookingTest {
	 

	    private Account mockAccount;
	    private Movie mockMovie;
	    private Showtime mockShowtime;
	    private Booking mockBooking;

	  
	  @Before
	    public void setUp() {
	        // Create mocks
	        mockAccount = mock(Account.class);
	        mockMovie = mock(Movie.class);
	        mockShowtime = mock(Showtime.class);
	        mockBooking = mock(Booking.class);

	        when(mockShowtime.getTime()).thenReturn(LocalTime.of(14, 0)); // Mock a valid time
	        when(mockMovie.isExpensive()).thenReturn(false); 
	        when(mockShowtime.getNormalTicketPrice()).thenReturn(10.0); 

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



	  

}

