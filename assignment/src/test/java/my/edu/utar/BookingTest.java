package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertSame;
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

@RunWith(JUnitParamsRunner.class)
public class BookingTest {
	 
    private Account mockAccount;
    private Account mockUnregisteredAccount;
    private Movie mockMovie;
    private Showtime mockShowtime;
    private Booking mockBooking;
    private CinemaHall mockCinemaHall;
    private Showtime showtimeWithMockMovie;
    private Account account;
    private Movie movie;
    private Showtime showtime;
    private CinemaHall hall;
    private LocalTime time;
    private Booking bookingSpy;
    

    @Before
    public void setUp() {
        // Create mocks
        mockAccount = mock(Account.class);
        mockMovie = mock(Movie.class);
        mockShowtime = mock(Showtime.class);
        mockBooking = mock(Booking.class);
        mockCinemaHall = mock(CinemaHall.class);
        mockUnregisteredAccount = mock(Account.class);
        
        bookingSpy = spy(new Booking());
        
        //Real implementation
        account = new Account("Kira Yamato","kira.yamato@gundamseed.com",2004,4,15);

        movie = new Movie("Example Movie","Normal",18.50);
       	hall = new CinemaHall(1,50);
       	showtime = new Showtime (movie, mockCinemaHall, "Available", LocalTime.of(13, 00), 2024,5,1);
       	showtimeWithMockMovie = new Showtime (mockMovie, mockCinemaHall, "Available", LocalTime.of(13, 00), 2024,5,1);

        // Mock expected behaviors
       	when(mockUnregisteredAccount.getName()).thenReturn("UnregisteredName");
        when(mockAccount.getName()).thenReturn("Kira Yamato");
        when(mockMovie.isExpensive()).thenReturn(false);
        when(mockShowtime.getNormalTicketPrice()).thenReturn(10.0);
        when(mockShowtime.getMovie()).thenReturn(mockMovie);
        when(mockShowtime.determineTicketPrice(0)).thenReturn(18.50);
    }
    
    // BOOK_TC1_V001
 	// Test method to test Booking constructor with valid inputs
    private Object[] getParamForBookingConstructorIntegrationTest() {
        return new Object[] {
            new Object[] {"B001",4,2,1,0,5,12,95.2,"Booked"},
        };
    }
    
    @Test
    public void testBookingConstructor(){
    	
    }
    

    //Integration test method to test Booking constructor
    @Test
    @Parameters(method = "getParamForBookingConstructorIntegrationTest")
    public void BookingConstructorIntegrationTest(String bookingID,int quantityAdult, int quantityOKU, 
    		int quantitySenior, int quantityStudent, int quantityChildren, int totalSeats, double totalPrice,String status) {
       	Movie movie1 = new Movie("Example Movie","Normal",18.50);
       	CinemaHall hall1 = new CinemaHall(1,50);
       	Showtime showtime1 = new Showtime (movie1, hall1, "Available", LocalTime.of(13, 00), 2024,5,1);
       	Account account1 = new Account("AhHuAT", "HUAT@gmail.com", 2000, 1, 1);
       	// Create the Booking instance with real constructor
       	Booking booking = new Booking(bookingID, account1, movie1, showtime1,
	           quantityAdult, quantityOKU, quantitySenior, 
	           quantityStudent, quantityChildren);

        // Verify state of the booking
        assertNotNull(booking);
        assertEquals(bookingID, booking.getBookingId());
        assertEquals(account1, booking.getAccount());
        assertEquals(movie1, booking.getMovie());
        assertEquals(showtime1, booking.getShowtime());
        assertEquals(quantityAdult, booking.getQuantityAdult());
        assertEquals(quantityOKU, booking.getQuantityOKU());
        assertEquals(quantitySenior, booking.getQuantitySenior());
        assertEquals(quantityStudent, booking.getQuantityStudent());
        assertEquals(quantityChildren, booking.getQuantityChildren());
        assertEquals(totalSeats, booking.getTotalNumberOfSeats());
        assertEquals(totalPrice, booking.getTotalPrice(), 0.0);
        assertEquals(status, booking.getStatus());
    }
    
    // BOOK_TC2_V001
    // test method for createBooking valid
    public void testCreateBooking() {
        // Arrange
        String bookingID = "B002";
       
        int quantityAdult = 4;
        int quantityOKU = 2;
        int quantitySenior = 1;
        int quantityStudent = 0;
        int quantityChildren = 5;

        // Act
        Booking result = Booking.createBooking(bookingID, mockAccount, movie, showtime, 
        		quantityAdult, quantityOKU, quantitySenior, quantityStudent, quantityChildren);

        // Assert       
        assertNotNull(result);
        assertEquals(bookingID, result.getBookingId());
        assertEquals(mockAccount, result.getAccount());
        assertEquals(movie, result.getMovie());
        assertEquals(showtime, result.getShowtime());
        assertEquals(12, result.getTotalNumberOfSeats());  // Total seats should be correct
        assertEquals(quantityAdult, result.getQuantityAdult());
        assertEquals(quantityOKU, result.getQuantityOKU());
        assertEquals(quantitySenior, result.getQuantitySenior());
        assertEquals(quantityStudent, result.getQuantityStudent());
        assertEquals(quantityChildren, result.getQuantityChildren());
        assertEquals(95.2, result.getTotalPrice(), 0.0);
        assertEquals("Booked", result.getStatus());
    }
    
    public void testCreateBookingIntegrationTest() {
    	
        // Arrange
        String bookingID = "B002";
       
        int quantityAdult = 4;
        int quantityOKU = 2;
        int quantitySenior = 1;
        int quantityStudent = 0;
        int quantityChildren = 5;
        // Arrange
    	Movie movie1 = new Movie("Example Movie","Normal",18.50);
       	CinemaHall hall1 = new CinemaHall(1,50);
       	Showtime showtime1 = new Showtime (movie1, hall1, "Available", LocalTime.of(13, 00), 2024,5,1);
       	Account account1 = new Account("AhHuAT", "HUAT@gmail.com", 2000, 1, 1);
       	// Create the Booking instance with real constructor
       	Booking booking = new Booking(bookingID, account1, movie1, showtime1,quantityAdult, quantityOKU, quantitySenior, quantityStudent, quantityChildren);

        // Act
        Booking result = Booking.createBooking(bookingID, account1, movie, showtime, 
        		quantityAdult, quantityOKU, quantitySenior, quantityStudent, quantityChildren);

        // Assert       
        assertNotNull(result);
        assertEquals(bookingID, result.getBookingId());
        assertEquals(account1, result.getAccount());
        assertEquals(movie1, result.getMovie());
        assertEquals(showtime1, result.getShowtime());
        assertEquals(12, result.getTotalNumberOfSeats());  // Total seats should be correct
        assertEquals(quantityAdult, result.getQuantityAdult());
        assertEquals(quantityOKU, result.getQuantityOKU());
        assertEquals(quantitySenior, result.getQuantitySenior());
        assertEquals(quantityStudent, result.getQuantityStudent());
        assertEquals(quantityChildren, result.getQuantityChildren());
        assertEquals(95.2, result.getTotalPrice(), 0.0);
        assertEquals("Booked", result.getStatus());
    }
    
    // BOOK_TC2_INV001
    // test method for createBooking invalid
    private Object[] getParamForCreateBookingInvalid() {
        return new Object[] {
        	//null bookingID
            new Object[] {null, mockAccount, movie, showtime, 4,2,1,0,5,12,95.2,"Booked"},	 
            
            //empty String bookingID
            new Object[] {"", mockAccount, movie, showtime, 4,2,1,0,5,12,95.2,"Booked"},	
			
            //null account
            new Object[] {"B001", null, movie, showtime, 4,2,1,0,5,12,95.2,"Booked"},	

            //null movie
            new Object[] {"B001", mockAccount, null, showtime, 4,2,1,0,5,12,95.2,"Booked"},	

            //null showtime
            new Object[] {"B001", mockAccount, movie, null, 4,2,1,0,5,12,95.2,"Booked"},	
            
            //showtime doesn't contain the particular movie
            new Object[] {"B001", mockAccount, movie, showtimeWithMockMovie, 4,2,1,0,5,12,95.2,"Booked"},	 

            // total tickets is 0
            new Object[] {"B001", mockAccount, movie, showtime, 0,0,0,0,0,0,0,"Booked"},	 

            //ticket quantity is negative BVA
            new Object[] {"B001", mockAccount, movie, showtime, -1,2,1,0,5,12,95.2,"Booked"},	
            new Object[] {"B001", mockAccount, movie, showtime, 4,-1,1,0,5,12,95.2,"Booked"},	
            new Object[] {"B001", mockAccount, movie, showtime, 4,2,-1,0,5,12,95.2,"Booked"},	
            new Object[] {"B001", mockAccount, movie, showtime, 4,2,1,-1,5,12,95.2,"Booked"},	
            new Object[] {"B001", mockAccount, movie, showtime, 4,2,1,0,-1,12,95.2,"Booked"},	

            //ticket quantity is negative EP
            new Object[] {"B001", mockAccount, movie, showtime, -100,2,1,0,5,12,95.2,"Booked"},	
            new Object[] {"B001", mockAccount, movie, showtime, 4,-100,1,0,5,12,95.2,"Booked"},	
            new Object[] {"B001", mockAccount, movie, showtime, 4,2,-100,0,5,12,95.2,"Booked"},	
            new Object[] {"B001", mockAccount, movie, showtime, 4,2,1,-100,5,12,95.2,"Booked"},	
            new Object[] {"B001", mockAccount, movie, showtime, 4,2,1,0,-100,12,95.2,"Booked"},	
            
            //user is not registered
            new Object[] {"B001", mockUnregisteredAccount, movie, showtime, 4,2,1,0,5,12,95.2,"Booked"},	
        };
    }

    @Test (expected = IllegalArgumentException.class)
    @Parameters(method = "getParamForCreateBookingInvalid")
    public void createBookingInvalidTest(String bookingID, Account account,Movie movie, Showtime showtime,
    		int quantityAdult, int quantityOKU, int quantitySenior, int quantityStudent, int quantityChildren, int totalSeats, double totalPrice,String status){
    	// Act
        Booking result = Booking.createBooking(bookingID, account, movie, showtime, 
        		quantityAdult, quantityOKU, quantitySenior, quantityStudent, quantityChildren);
        // Assert       
        assertNull(result);
    }
    
    //BOOK_TC3_V001
    //Test method for setBookingId
    @Test
    @Parameters("B001, B001")
    public void testSetBookingId(String bookingId, String expectedResult) {
        Booking booking = new Booking ();
        booking.setBookingId(bookingId);
        assertEquals(expectedResult, booking.getBookingId());
    }
       
    //BOOK_TC3_INV001
    //Test method for setBookingId
    @Test (expected = IllegalArgumentException.class)
    public void testSetBookingIdInvalid(String bookingId) {
        Booking booking = new Booking ();
        booking.setBookingId("");
    }
    //BOOK_TC3_INV002
    //Test method for setBookingId
    @Test (expected = IllegalArgumentException.class)
    public void testSetBookingIdInvalid2( ) {
        Booking booking = new Booking ();
        booking.setBookingId(null);
    }
    
    //BOOK_TC4_V001
    //Test method for setAccount
    @Test
    public void testSetAccount() {
        Booking booking = new Booking ();
        booking.setAccount(mockAccount);
        assertSame(mockAccount, booking.getAccount());
    }
    //BOOK_TC4_INV001
    //Test method for setAccount - invalid
    @Test (expected = IllegalArgumentException.class)
    public void testSetAccountInvalid () {
        Booking booking = new Booking ();
        booking.setAccount(null);
    }
        
    //BOOK_TC5_V001
    //Test method for setMovie
    @Test
    public void testSetMovie() {
        Booking booking = new Booking ();
        booking.setMovie(mockMovie);
        assertSame(mockMovie, booking.getMovie());
    }
    
    //BOOK_TC5_INV001
    //Test method for setMovie - INVALID
    @Test (expected = IllegalArgumentException.class)
    public void testSetMovieInvalid() {
        Booking booking = new Booking ();
        booking.setMovie(null);
    }
    
    //BOOK_TC6_V001
    //Test method for setShowtime
    @Test
    public void testSetShowtime() {
        Booking booking = new Booking ();
        booking.setShowtime(mockShowtime);
        assertSame(mockShowtime, booking.getShowtime());
    }
    
    //BOOK_TC6_INV001
    //Test method for setShowtime - INVALID
    @Test (expected = IllegalArgumentException.class)
    public void testSetShowtimeInvalid() {
        Booking booking = new Booking ();
        booking.setShowtime(null);
    }
    
    //BOOK_TC7_V001
    //Test method for setQuantityAdult BVA/EP
    @Test
    @Parameters({"1","100"})
    public void testSetQuantityAdult(int quantity) {
        Booking booking = new Booking ();
        booking.setQuantityAdult(quantity);
        assertEquals(quantity, booking.getQuantityAdult());
    }
    
    //BOOK_TC7_INV001
    //Test method for setQuantityAdult BVA/EP - invalid
    @Test (expected = IllegalArgumentException.class)
    @Parameters({"-1","-100"})
    public void testSetQuantityAdultInvalid(int quantity) {
        Booking booking = new Booking ();
        booking.setQuantityAdult(quantity);
    }

    //BOOK_TC8_V001
    //Test method for setQuantityOKU BVA/EP
	@Test
	@Parameters({"1","100"})
	public void testSetQuantityOKU(int quantity) {
	    Booking booking = new Booking ();
	    booking.setQuantityOKU(quantity);
	    assertEquals(quantity, booking.getQuantityOKU());
	}
	
    //BOOK_TC8_INV001
    //Test method for setQuantityOKU BVA/EP - invalid
    @Test (expected = IllegalArgumentException.class)
	@Parameters({"-1","-100"})
	public void testSetQuantityOKUInvalid(int quantity) {
	    Booking booking = new Booking ();
	    booking.setQuantityOKU(quantity);
	}

    //BOOK_TC9_V001
    //Test method for setQuantitySenior BVA/EP
	@Test
	@Parameters({"1","100"})
	public void testSetQuantitySenior(int quantity) {
	    Booking booking = new Booking ();
	    booking.setQuantitySenior(quantity);
	    assertEquals(quantity, booking.getQuantitySenior());
	}
	
    //BOOK_TC9_INV001
    //Test method for setQuantitySenior BVA/EP - INVALID
	@Test (expected = IllegalArgumentException.class)
	@Parameters({"-1","-100"})
	public void testSetQuantitySeniorInvalid(int quantity) {
	    Booking booking = new Booking ();
	    booking.setQuantitySenior(quantity);
	}
	 
    //BOOK_TC10_V001
    //Test method for setQuantityStudent BVA/EP
	@Test
	@Parameters({"1","100"})
	public void testSetQuantityStudent(int quantity) {
	    Booking booking = new Booking ();
	    booking.setQuantityStudent(quantity);
	    assertEquals(quantity, booking.getQuantityStudent());
	}
	
	//BOOK_TC10_V001
    //Test method for setQuantityStudent BVA/EP - INVALID
	@Test (expected = IllegalArgumentException.class)
	@Parameters({"-1","-100"})
	public void testSetQuantityStudentInvalid(int quantity) {
	    Booking booking = new Booking ();
	    booking.setQuantityStudent(quantity);
	}
	
    //BOOK_TC11_V001
    //Test method for setQuantityChildren BVA/EP
	@Test
	@Parameters({"1","100"})
	public void testSetQuantityChildren(int quantity) {
	    Booking booking = new Booking ();
	    booking.setQuantityChildren(quantity);
	    assertEquals(quantity, booking.getQuantityChildren());
	}
	
	//BOOK_TC11_INV001
    //Test method for setQuantityChildren BVA/EP - INVALID
	@Test (expected = IllegalArgumentException.class)
	@Parameters({"-1","-100"})
	public void testSetQuantityChildrenInvalid(int quantity) {
	    Booking booking = new Booking ();
	    booking.setQuantityChildren(quantity);
	}
	
	//BOOK_TC11_V001
    //Test method for setStatus
	@Test
	@Parameters({"Booked","Payment Successful","Payment Unsuccessful","Cancelled"})
	public void testSetStatus(String status) {
	    Booking booking = new Booking ();
	    booking.setStatus(status);
	    assertEquals(status, booking.getStatus());
	}
	
	//BOOK_TC13_INV001
    //Test method for setStatus - INVALID - empty string, invalid status
	@Test (expected = IllegalArgumentException.class)
	@Parameters({"","OtherStatus"})
	public void testSetStatusInvalid(String status) {
	    Booking booking = new Booking ();
	    booking.setStatus(status);
	}
	
	//BOOK_TC13_INV002
    //Test method for setStatus - INVALID - null
	@Test (expected = IllegalArgumentException.class)
	public void testSetStatusInvalidNull(String status) {
	    Booking booking = new Booking ();
	    booking.setStatus(null);
	}
	
	//BOOK_TC14_V001
	//Test method for calculate total price 
	private Object[] getParamForTestCalculateTotalPrice() {
        return new Object[] {
        	//isExpensive return true, all ticket price calculation return 10
            new Object[] {true, 10, 10, 10, 10, 10, 50},
            
          //isExpensive return false, all ticket price calculation return 10
            new Object[] {false, 10, 10, 10, 10, 10, 50},
        };
    }

	@Test
	@Parameters(method = "getParamForTestCalculateTotalPrice")
	public void testCalculateTotalPrice(boolean isExpensive, double adult, double OKU,
	        double senior, double student, double children, double ER) {

	    // Create a spy on the Booking object
	    Booking bookingSpy = spy(new Booking());

	    // Set the mocked movie in the booking object
	    bookingSpy.setMovie(mockMovie);

	    // Mock the movie's isExpensive method based on the test case parameter
	    when(mockMovie.isExpensive()).thenReturn(isExpensive);

	    // Mock the individual ticket price calculations in the spy object
	    doReturn(adult).when(bookingSpy).calculateAdultTicketPrice(anyDouble());
	    doReturn(OKU).when(bookingSpy).calculateOKUTicketPrice(anyDouble());
	    doReturn(senior).when(bookingSpy).calculateSeniorTicketPrice(anyDouble());
	    doReturn(student).when(bookingSpy).calculateStudentTicketPrice(anyDouble());
	    doReturn(children).when(bookingSpy).calculateChildrenTicketPrice(anyDouble());

	    // Call the calculateTotalPrice method on the spy object
	    double actualTotalPrice = bookingSpy.calculateTotalPrice();

	    // Assert the expected total price matches the actual total price
	    assertEquals(ER, actualTotalPrice, 0.001);
	}

	//BOOK_TC15_V001
	//Test method for calculate adult ticket price 
	@Test
	@Parameters({"2,15.00,5,40"})
    public void testCalculateAdultTicketPrice(int quantity, double normalPrice, double addOn, double ER) {
	 // Initialize the mock object
        mockShowtime = mock(Showtime.class);

        Booking booking;

        // Initialize the Booking object with a mocked showtime
        booking = new Booking();
        booking.setShowtime(mockShowtime);
        booking.setQuantityAdult(quantity); // Example quantity for testing
        
        // Define the behavior of the mock showtime
        when(mockShowtime.getNormalTicketPrice()).thenReturn(normalPrice);

        // Call the method and capture the result
        double actualPrice = booking.calculateAdultTicketPrice(addOn);

        // Assert that the expected and actual values are the same
        assertEquals(ER, actualPrice, 0.001);
    }
	
	//BOOK_TC16_V001
	//Test method for calculate OKU ticket price 
	@Test
	@Parameters({"2,15.00,5,38.5"})
    public void testCalculateOKUTicketPrice(int quantity, double normalPrice, double addOn, double ER) {
	 // Initialize the mock object
        mockShowtime = mock(Showtime.class);

        Booking booking;

        // Initialize the Booking object with a mocked showtime
        booking = new Booking();
        booking.setShowtime(mockShowtime);
        booking.setQuantityOKU(quantity); // Example quantity for testing
        
        // Define the behavior of the mock showtime
        when(mockShowtime.getNormalTicketPrice()).thenReturn(normalPrice);

        // Call the method and capture the result
        double actualPrice = booking.calculateOKUTicketPrice(addOn);

        // Assert that the expected and actual values are the same
        assertEquals(ER, actualPrice, 0.001);
    }
	
	//BOOK_TC17_V001
	//Test method for calculate senior ticket price 
	@Test
	@Parameters(
			{"2,8.99,5,27.98",	//BVA normal price less than 9
			"2,9.01,5,28.00",	//BVA normal price more than 9
			"2,5.00,5,20.00",		//EP normal price less than 9
			"2,50.00,5,28.00"} 	//EP normal price more than 9
			)
    public void testCalculateSeniorTicketPrice(int quantity, double normalPrice, double addOn, double ER) {
	 // Initialize the mock object
        mockShowtime = mock(Showtime.class);

        Booking booking;

        // Initialize the Booking object with a mocked showtime
        booking = new Booking();
        booking.setShowtime(mockShowtime);
        booking.setQuantitySenior(quantity); // Example quantity for testing
        
        // Define the behavior of the mock showtime
        when(mockShowtime.getNormalTicketPrice()).thenReturn(normalPrice);

        // Call the method and capture the result
        double actualPrice = booking.calculateSeniorTicketPrice(addOn);

        // Assert that the expected and actual values are the same
        assertEquals(ER, actualPrice, 0.001);
    }
	
	//BOOK_TC18_V001
	//Test method for calculate student ticket price 
	private Object[] getParamForTestCalculateStudentPrice() {
        return new Object[] {
        		// BVA hour less than 18
        		new Object[] {2, 15.00, 5, LocalTime.of(17, 0), 28.00},
            
        		// BVA hour more than 18
        		new Object[] {2, 15.00, 5, LocalTime.of(19, 0), 40.00},
        		
        		// EP hour less than 18
        		new Object[] {2, 15.00, 5, LocalTime.of(21, 0), 40.00},
            
        		// EP hour more than 18
        		new Object[] {2, 15.00, 5, LocalTime.of(9, 0), 28.00},
        };
    }
	@Test
	@Parameters(method = "getParamForTestCalculateStudentPrice")
    public void testCalculateStudentTicketPrice(int quantity, double normalPrice, double addOn,LocalTime mockTime, double ER) {
	 // Initialize the mock object
        mockShowtime = mock(Showtime.class);

        Booking booking;

        // Initialize the Booking object with a mocked showtime
        booking = new Booking();
        booking.setShowtime(mockShowtime);
        booking.setQuantityStudent(quantity); // Example quantity for testing
        
        when(mockShowtime.getTime()).thenReturn(mockTime);
        when(mockShowtime.getNormalTicketPrice()).thenReturn(normalPrice);

        // Call the method and capture the result
        double actualPrice = booking.calculateStudentTicketPrice(addOn);

        // Assert that the expected and actual values are the same
        assertEquals(ER, actualPrice, 0.001);
    }
	
	//BOOK_TC19_V001
	//Test method for calculate children ticket price 
	@Test
	@Parameters(
			{"2,15.00,5,28.00",
			"2,8.00,5,26.00"})
    public void testCalculateChildrenTicketPrice(int quantity, double normalPrice, double addOn, double ER) {
	 // Initialize the mock object
        mockShowtime = mock(Showtime.class);

        Booking booking;

        // Initialize the Booking object with a mocked showtime
        booking = new Booking();
        booking.setShowtime(mockShowtime);
        booking.setQuantityChildren(quantity); // Example quantity for testing
        
        // Define the behavior of the mock showtime
        when(mockShowtime.getNormalTicketPrice()).thenReturn(normalPrice);

        // Call the method and capture the result
        double actualPrice = booking.calculateChildrenTicketPrice(addOn);

        // Assert that the expected and actual values are the same
        assertEquals(ER, actualPrice, 0.001);
    }
}

