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

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;


///havent check w test cases
//not yet finalize
// c c jiu hao 

@RunWith(JUnitParamsRunner.class)
public class BookingTest {
	 

    private Account mockAccount;
    private Movie mockMovie;
    private Showtime mockShowtime;
    private Booking mockBooking;
    private Account account;
    private Movie movie;
    private Showtime showtime;
    private LocalTime time;
    private Booking bookingSpy;

    @Before
    public void setUp() {
        // Create mocks
        mockAccount = mock(Account.class);
        mockMovie = mock(Movie.class);
        mockShowtime = mock(Showtime.class);
        mockBooking = mock(Booking.class);
        
        bookingSpy = spy(new Booking());

        // Mock expected behaviors
        when(mockAccount.getName()).thenReturn("Kira Yamato");
        when(mockMovie.isExpensive()).thenReturn(false);
        when(mockShowtime.getNormalTicketPrice()).thenReturn(10.0);
        when(mockShowtime.getMovie()).thenReturn(mockMovie);
        
       
    }
    
//    @Test
//    @Parameters(method = "provideAccountParams")
//    public void testGetAccount(Account account, Account expectedResult) {
//        try {
//            Field accountField = Booking.class.getDeclaredField("account");
//            accountField.setAccessible(true);  // Make the field accessible to manipulate it
//            
//            accountField.set(bookingSpy, account);  // Set the value for the specific instance 
//            
//            accountField.setAccessible(false);  // Optionally, set it back to inaccessible
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();  // Handle the exception appropriately
//        }
//        assertEquals(expectedResult, bookingSpy.getAccount());
//    }
//    
// // Provide parameters for the test
//    private Object[] provideAccountParams() {
//        Account acc1 = new Account();
//        Account acc2 = new Account();
//
//        // Customize the showtime objects as needed
//        return new Object[]{
//                new Object[]{acc1, acc1},
//                new Object[]{acc2, acc2},
//        };
//    }

    
    
    @Test
    @Parameters("12345, 12345")
    public void testGetBookingId(String bookingId, String expectedResult) {
        try {
            Field bookingIdField = Booking.class.getDeclaredField("bookingId");
            bookingIdField.setAccessible(true);  // Make the field accessible to manipulate it
            
            bookingIdField.set(bookingSpy, bookingId);  // Set the value for the specific instance 
            
            bookingIdField.setAccessible(false);  // Optionally, set it back to inaccessible
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();  // Handle the exception appropriately
        }
        assertEquals(expectedResult, bookingSpy.getBookingId());
    }


    @Test
    @Parameters(method = "provideMovieParams")
    public void testGetMovie(Movie movie, Movie expectedResult) {
        try {
            Field movieField = Booking.class.getDeclaredField("movie");
            movieField.setAccessible(true);  // Make the field accessible to manipulate it
            
            movieField.set(bookingSpy, movie);  // Set the value for the specific instance 
            
            movieField.setAccessible(false);  // Optionally, set it back to inaccessible
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();  // Handle the exception appropriately
        }
        assertEquals(expectedResult, bookingSpy.getMovie());
    }
    
    // Provide parameters for the test
    private Object[] provideMovieParams() {
        Movie movie1 = new Movie();
        Movie movie2 = new Movie();

        // Customize the showtime objects as needed
        return new Object[]{
                new Object[]{movie1, movie1},
                new Object[]{movie2, movie2},
                new Object[]{null, null}
        };
    }

    
    @Test
    @Parameters("4, 4")
    public void testGetQuantityAdult(int numOfAdults, int expectedResult) {
        try {
            Field adultField = Booking.class.getDeclaredField("quantityAdult");
            adultField.setAccessible(true);  // Make the field accessible to manipulate it
            
            adultField.set(bookingSpy, numOfAdults);  // Set the value for the specific instance 
            
            adultField.setAccessible(false);  // Optionally, set it back to inaccessible
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();  // Handle the exception appropriately
        }
        assertEquals(expectedResult, bookingSpy.getQuantityAdult());
    }

    
    @Test
    @Parameters("3, 3")
    public void testGetQuantityChildren(int numOfChildren, int expectedResult) {
        try {
            Field childrenField = Booking.class.getDeclaredField("quantityChildren");
            childrenField.setAccessible(true);  // Make the field accessible to manipulate it
            
            childrenField.set(bookingSpy, numOfChildren);  // Set the value for the specific instance 
            
            childrenField.setAccessible(false);  // Optionally, set it back to inaccessible
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();  // Handle the exception appropriately
        }
        assertEquals(expectedResult, bookingSpy.getQuantityChildren());
    }

    

    @Test
    @Parameters("2, 2")
    public void testGetQuantityOKU(int numOfOKU, int expectedResult) {
        try {
            Field okuField = Booking.class.getDeclaredField("quantityOKU");
            okuField.setAccessible(true);  // Make the field accessible to manipulate it
            
            okuField.set(bookingSpy, numOfOKU);  // Set the value for the specific instance 
            
            okuField.setAccessible(false);  // Optionally, set it back to inaccessible
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();  // Handle the exception appropriately
        }
        assertEquals(expectedResult, bookingSpy.getQuantityOKU());
    }

    
    @Test
    @Parameters("1, 1")
    public void testGetQuantitySenior(int numOfSenior, int expectedResult) {
        try {
            Field seniorField = Booking.class.getDeclaredField("quantitySenior");
            seniorField.setAccessible(true);  // Make the field accessible to manipulate it
            
            seniorField.set(bookingSpy, numOfSenior);  // Set the value for the specific instance 
            
            seniorField.setAccessible(false);  // Optionally, set it back to inaccessible
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();  // Handle the exception appropriately
        }
        assertEquals(expectedResult, bookingSpy.getQuantitySenior());
    }

    
    @Test
    @Parameters("1,1")
    public void testGetQuantityStudent(int numOfStu, int ER){

        // Use reflection to set the private field 'title'
        try {
            Field studentField = Booking.class.getDeclaredField("quantityStudent");
            studentField.setAccessible(true);  // Make the field accessible to manipulate it
        
            studentField.set(bookingSpy, numOfStu);  // Set the value for the specific instance 
        
            studentField.setAccessible(false);  // Optionally, set it back to inaccessible
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();  // Handle the exception appropriately
        }
        assertEquals(ER, bookingSpy.getQuantityStudent());
    }
    
    @Test
    @Parameters(method = "provideShowtimeParams")
    public void testGetShowtime(Showtime showtime, Showtime expectedShowtime) {

        // Use reflection to set the private field 'showtime'
        try {
            Field showTimeField = Booking.class.getDeclaredField("showtime");
            showTimeField.setAccessible(true);  // Make the field accessible to manipulate it

            showTimeField.set(bookingSpy, showtime);  // Set the value for the specific instance 

            showTimeField.setAccessible(false);  // Optionally, set it back to inaccessible
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();  // Handle the exception appropriately
        }

        // Verify the result
        assertEquals(expectedShowtime, bookingSpy.getShowtime());
    }

    // ??? jab i check 
    // Provide parameters for the test
    private Object[] provideShowtimeParams() {
        Showtime showtime1 = new Showtime();
        Showtime showtime2 = new Showtime();

        // Customize the showtime objects as needed
        return new Object[]{
                new Object[]{showtime1, showtime1},
                new Object[]{showtime2, showtime2},
                new Object[]{null, null}
        };
    }
    
    @Test
    @Parameters("booked,booked")
    public void testGetStatus(String status, String ER){

        // Use reflection to set the private field 'title'
        try {
            Field priceField = Booking.class.getDeclaredField("status");
            priceField.setAccessible(true);  // Make the field accessible to manipulate it
        
            priceField.set(bookingSpy, status);  // Set the value for the specific instance 
        
            priceField.setAccessible(false);  // Optionally, set it back to inaccessible
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();  // Handle the exception appropriately
        }
        assertEquals(ER, bookingSpy.getStatus());
    }
    
    @Test
    @Parameters("1, 1")
    public void testGetTotalNumberOfSeats(int seats, int ER){

        // Use reflection to set the private field 'title'
        try {
            Field seatsField = Booking.class.getDeclaredField("totalNumberOfSeats");
            seatsField.setAccessible(true);  // Make the field accessible to manipulate it
        
            seatsField.set(bookingSpy, seats);  // Set the value for the specific instance 
        
            seatsField.setAccessible(false);  // Optionally, set it back to inaccessible
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();  // Handle the exception appropriately
        }
        assertEquals(ER, bookingSpy.getTotalNumberOfSeats());
    }

    @Test
    @Parameters("1.0, 1.0")
    public void testGetTotalPrice(Double price, Double ER){

        // Use reflection to set the private field 'title'
        try {
            Field priceField = Booking.class.getDeclaredField("totalPrice");
            priceField.setAccessible(true);  // Make the field accessible to manipulate it
        
            priceField.set(bookingSpy, price);  // Set the value for the specific instance 
        
            priceField.setAccessible(false);  // Optionally, set it back to inaccessible
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();  // Handle the exception appropriately
        }
        assertEquals(ER, bookingSpy.getTotalPrice(), 0.01);
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

	 @Test
	    public void testCalculateChildrenTicketPrice() {
		 // Initialize the mock object
	        mockShowtime = mock(Showtime.class);


	        Booking booking;

	        // Initialize the Booking object with a mocked showtime
	        booking = new Booking();
	        booking.setShowtime(mockShowtime);
	        booking.setQuantityChildren(2); // Example quantity for testing
	        
	        // Define the behavior of the mock showtime
	        double normalTicketPrice = 9.0;
	        when(mockShowtime.getNormalTicketPrice()).thenReturn(normalTicketPrice);

	        // Test with an add-on value
	        double addOn = 5.0;
	        double expectedPrice = 2 * (normalTicketPrice + addOn); // quantityAdult * (ticketPrice + addOn)

	        // Call the method and capture the result
	        double actualPrice = booking.calculateChildrenTicketPrice(addOn);

	        // Assert that the expected and actual values are the same
	        assertEquals(expectedPrice, actualPrice, 0.001);
	    }
	 
//	    @Test
//	    public void testCalculateTotalPrice() {
//	    	Booking booking = new Booking();
//	        // Set the mocked movie and showtime in the booking object
//	        booking.setMovie(mockMovie);
//	        booking.setShowtime(mockShowtime);
//	        // Mocking methods to return fixed values
//
//	        when(mockMovie.isExpensive()).thenReturn(true); // Movie is expensive, so add-on is 4
//	        when(mockShowtime.getNormalTicketPrice()).thenReturn(12.0); // Normal ticket price is 12
//	        when(mockShowtime.getTime()).thenReturn(time);
//	        
//	        
//	        // Mocking ticket price calculations
//	        when(booking.calculateAdultTicketPrice(4)).thenReturn(30.0);
//	        when(booking.calculateOKUTicketPrice(4)).thenReturn(20.0);
//	        when(booking.calculateSeniorTicketPrice(4)).thenReturn(15.0);
//	        when(booking.calculateStudentTicketPrice(4)).thenReturn(10.0);
//	        when(booking.calculateChildrenTicketPrice(4)).thenReturn(5.0);
//
//	        // Calculate expected total price
//	        double expectedTotalPrice = 30.0 + 20.0 + 15.0 + 10.0 + 5.0;
//
//	        // Call the method and capture the result
//	        double actualTotalPrice = booking.calculateTotalPrice();
//
//	        // Assert that the expected and actual values are equal
//	        assertEquals(expectedTotalPrice, actualTotalPrice, 0.001);
//	    }
	 

	  

}

