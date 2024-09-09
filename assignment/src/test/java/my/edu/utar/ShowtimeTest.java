package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
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

	        //Real implementation
	        showtime = new Showtime();
	        showtime.setHallNumber(mockHallNumber);

	        // Mock expected behaviors
	        when(mockAccount.getName()).thenReturn("Kira Yamato");
	        when(mockMovie.isExpensive()).thenReturn(false);
	        when(mockMovie.getNormalPrice()).thenReturn(18.5);
	        when(mockShowtime.getNormalTicketPrice()).thenReturn(10.0);
	        when(mockShowtime.getMovie()).thenReturn(mockMovie);
	        when(mockHallNumber.checkOversell(0)).thenReturn(false);

	    }

//	    //BOOK_TC7_V001
//	    //Test method for setQuantityAdult BVA/EP
//	    @Test
//	    @Parameters({"1","100"})
//	    public void testSetQuantityAdult(int quantity) {
//	        Booking booking = new Booking ();
//	        booking.setQuantityAdult(quantity);
//	        assertEquals(quantity, booking.getQuantityAdult());
//	    }
	 
//        //V00
//	    // Test for getMovie()
//	    @Test
//	    @Parameters("Avatar")
//	    public void testSetMovie(String movieTitle) {
//	    	Showtime showtime = new Showtime();
//	    	showtime..setT
//	        assertEquals(movieTitle, showtimeSpy.getMovie().getTitle());
//	    }
//
//	    // Test for getStatus()
//	    @Test
//	    @Parameters("Available")
//	    public void testGetStatus(String status) {
//	        try {
//	            Field statusField = Showtime.class.getDeclaredField("status");
//	            statusField.setAccessible(true);
//
//	            statusField.set(showtimeSpy, status);
//
//	            statusField.setAccessible(false);
//	        } catch (NoSuchFieldException | IllegalAccessException e) {
//	            e.printStackTrace();
//	        }
//	        assertEquals(status, showtimeSpy.getStatus());
//	    }
//
//	    // Test for getHallNumber()
//	    @Test
//	    @Parameters("5")
//	    public void testGetHallNumber(int hallNumber) {
//	        try {
//	            Field hallNumberField = Showtime.class.getDeclaredField("hallNumber");
//	            hallNumberField.setAccessible(true);
//
//	            CinemaHall mockHall = new CinemaHall();
//	            mockHall.setHallNumber(hallNumber);
//	            hallNumberField.set(showtimeSpy, mockHall);
//
//	            hallNumberField.setAccessible(false);
//	        } catch (NoSuchFieldException | IllegalAccessException e) {
//	            e.printStackTrace();
//	        }
//	        assertEquals(hallNumber, showtimeSpy.getHallNumber().getHallNumber());
//	    }
//
//	    // Test for getTime()
//	    @Test
//	    @Parameters("14:30")
//	    public void testGetTime(String timeString) {
//	        try {
//	            Field timeField = Showtime.class.getDeclaredField("time");
//	            timeField.setAccessible(true);
//
//	            LocalTime time = LocalTime.parse(timeString);
//	            timeField.set(showtimeSpy, time);
//
//	            timeField.setAccessible(false);
//	        } catch (NoSuchFieldException | IllegalAccessException e) {
//	            e.printStackTrace();
//	        }
//	        assertEquals(LocalTime.parse(timeString), showtimeSpy.getTime());
//	    }
//
//	    // Test for getYear()
//	    @Test
//	    @Parameters("2024, 2024")
//	    public void testGetYear(int year, int ER) {
//	        try {
//	            Field yearField = Showtime.class.getDeclaredField("year");
//	            yearField.setAccessible(true);
//
//	            yearField.set(showtimeSpy, year);
//
//	            yearField.setAccessible(false);
//	        } catch (NoSuchFieldException | IllegalAccessException e) {
//	            e.printStackTrace();
//	        }
//	        assertEquals(year, showtimeSpy.getYear());
//	    }
//	    
//	    //Test for getMonth()
//	    @Test
//	    @Parameters("1,1")
//	     public void testGetMonth(int month, int ER) {
//            try {
//                Field monthField = Showtime.class.getDeclaredField("month");
//                monthField.setAccessible(true);
//                
//                monthField.set(showtimeSpy, month);
//                
//                monthField.setAccessible(false);
//                } catch (NoSuchFieldException | IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            assertEquals(month, showtimeSpy.getMonth());
//	    }
//	    
//        // Test for getDay()
//        @Test
//        @Parameters("20, 20")
//        public void testGetDay(int day, int ER) {
//            try {
//                Field dayField = Showtime.class.getDeclaredField("day");
//                dayField.setAccessible(true);
//                
//                dayField.set(showtimeSpy, day);
//                
//                dayField.setAccessible(false);
//                } catch (NoSuchFieldException | IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            assertEquals(day, showtimeSpy.getDay());
//        }
//	    
//	    
//
//    	
//	    // Test for getNormalTicketPrice()
//	    @Test
//	    @Parameters("1")
//	    public void testGetNormalTicketPrice(double ticketPrice) {
//	        try {
//	            Field ticketPriceField = Showtime.class.getDeclaredField("normalTicketPrice");
//	            ticketPriceField.setAccessible(true);
//
//	            ticketPriceField.set(showtimeSpy, ticketPrice);
//
//	            ticketPriceField.setAccessible(false);
//	        } catch (NoSuchFieldException | IllegalAccessException e) {
//	            e.printStackTrace();
//	        }
//	        assertEquals(ticketPrice, showtimeSpy.getNormalTicketPrice(), 0.01);
//	    }
//	    
//	    // Test for setMovie()
//	    @Test
//	    public void testSetMovie() {
//	        Movie mockMovie = mock(Movie.class);
//	        showtimeSpy.setMovie(mockMovie);
//	        
//	        // Verify that the setMovie method was called with the specified movie
//	        verify(showtimeSpy, times(1)).setMovie(mockMovie);
//	    }
//
//	    // Test for setStatus()
//	    @Test
//	    public void testSetStatus() {
//	        String status = "Available";
//	        showtimeSpy.setStatus(status);
//	        
//	        // Verify that the setStatus method was called with the specified status
//	        verify(showtimeSpy, times(1)).setStatus(status);
//	    }
//
//	    // Test for setHallNumber()
//	    @Test
//	    public void testSetHallNumber() {
//	        CinemaHall mockHall = mock(CinemaHall.class);
//	        showtimeSpy.setHallNumber(mockHall);
//	        
//	        // Verify that the setHallNumber method was called with the specified hall
//	        verify(showtimeSpy, times(1)).setHallNumber(mockHall);
//	    }
//
//	    // Test for setTime()
//	    @Test
//	    public void testSetTime() {
//	        LocalTime time = LocalTime.of(14, 30);
//	        showtimeSpy.setTime(time);
//	        
//	        // Verify that the setTime method was called with the specified time
//	        verify(showtimeSpy, times(1)).setTime(time);
//	    }
//
//	    // Test for setDate()
//	    @Test
//	    public void testSetYear() {
//	        showtimeSpy.setYear(1);
//	        
//	        // Verify that the setDate method was called with the specified date
//	        verify(showtimeSpy, times(1)).setYear(1);
//	    }
//	    
//	    @Test
//	    public void testSetMonth() {
//	        showtimeSpy.setMonth(1);
//	        
//	        // Verify that the setDate method was called with the specified date
//	        verify(showtimeSpy, times(1)).setMonth(1);
//	    }
//	    
//	    @Test
//	    public void testSetDay() {
//	        showtimeSpy.setDay(1);
//	        
//	        // Verify that the setDate method was called with the specified date
//	        verify(showtimeSpy, times(1)).setDay(1);
//	    }
//
//	    // Test for setNormalTicketPrice()
//	    @Test
//	    public void testSetNormalTicketPrice() {
//	        double ticketPrice = 12.0;
//	        showtimeSpy.setNormalTicketPrice(ticketPrice);
//	        
//	        // Verify that the setNormalTicketPrice method was called with the specified price
//	        verify(showtimeSpy, times(1)).setNormalTicketPrice(ticketPrice);
//	    }

	//ST_TC1_V001
	//Test method for createShowTime
	 
	//ST_TC1_INV001
	//Test method for createShowTime - INVALID
	 
	 
	//ST_TC2_V001
	//Test method for setMovie
	@Test
	public void testSetMovie() {
		Showtime showtime = new Showtime();
		Movie mockMovie = mock(Movie.class);
		showtime.setMovie(mockMovie);
		assertSame(mockMovie, showtime.getMovie());
	}

	//ST_TC2_INV001
	//Test method for setMovie - INVALID
	@Test(expected = IllegalArgumentException.class)
	public void testSetMovieInvalid() {
	    Showtime showtime = new Showtime();
	    showtime.setMovie(null); // Invalid input
	}
	 
	//ST_TC3_V001
	//Test method for setStatus
	@Test
	@Parameters({"Available","Not Available","Fully Booked","Cancelled",})
	public void testSetStatus(String status) {
	    Showtime showtime = new Showtime();
	    showtime.setStatus(status);
	    assertEquals(status, showtime.getStatus());
	}
	//ST_TC3_INV001
	//Test method for setStatus - INVALID: null
	@Test(expected = IllegalArgumentException.class)
	@Parameters({"","OtherInvalidStatus"})
	public void testSetStatusInvalid1(String status) {
	    Showtime showtime = new Showtime();
	    showtime.setStatus(status);
	}
		
	//ST_TC3_INV002
	//Test method for setStatus - INVALID: null
	@Test(expected = IllegalArgumentException.class)
	public void testSetStatusInvalid2() {
	    Showtime showtime = new Showtime();
	    showtime.setStatus(null);
	}
	
	//ST_TC4_V001
	//Test method for setHallNumber
	@Test
	public void testSetHallNumber() {
	    Showtime showtime = new Showtime();
	    CinemaHall mockHall = mock(CinemaHall.class); // Example cinema hall
	    showtime.setHallNumber(mockHall);
	    assertSame(mockHall, showtime.getHallNumber());
	}
	
	//ST_TC4_INV001
	//Test method for setHallNumber - INVALID 
	@Test(expected = IllegalArgumentException.class)
	public void testSetHallNumberInvalid() {
	    Showtime showtime = new Showtime();
	    showtime.setHallNumber(null);
	}
	
	//ST_TC5_V001
	//Test method for setTime		 
	@Test
	public void testSetTime() {
	    Showtime showtime = new Showtime();
	    LocalTime time = LocalTime.of(14, 30); // Example time
	    showtime.setTime(time);
	    assertSame(time, showtime.getTime());
	}
	
	//ST_TC5_INV001
	//Test method for setTime - INVALID 
	@Test(expected = IllegalArgumentException.class)
	public void testSetTimeInvalid() {
	    Showtime showtime = new Showtime();
	    showtime.setTime(null); // Invalid input
	}
	//ST_TC6_V001
	//Test method for setYear
	@Test
	@Parameters(
		{"2024",	//BVA upper bound
		"1900",		//BVA lower bound
		"1962",		//EP btw 1900 - 2024
		})
	public void testSetYear(int year) {
	    Showtime showtime = new Showtime();
	    showtime.setYear(year);
	    assertEquals(year, showtime.getYear());
	}
			 
	//ST_TC6_INV001
	//Test method for setDate - INVALID 
	@Test(expected = IllegalArgumentException.class)
	@Parameters(
			{"2025",	//BVA more than 2024
			"1899",		//BVA less than 1900
			"1500",		//EP less than 1900
			"2500",		//EP more than 2024
			})
	public void testSetYearInvalid(int year) {
	    Showtime showtime = new Showtime();
	    showtime.setYear(year);
	}	
	
	
	//ST_TC7_V001
	//Test method for setNormalTicketPrice
	@Test
	@Parameters(
			{"0",//BVA
			"100"	//EP
			})
	public void testSetNormalTicketPrice(double price) {
	    Showtime showtime = new Showtime();
	    showtime.setNormalTicketPrice(price);
	    assertEquals(price, showtime.getNormalTicketPrice(), 0.001);
	}
		 
	//ST_TC7_INV001
	//Test method for setNormalTicketPrice - INVALID 
	@Test(expected = IllegalArgumentException.class)
	@Parameters(
			{"-0.01",//BVA
			"-100"	//EP
			})
	public void testSetNormalTicketPriceInvalid(double price) {
	    Showtime showtime = new Showtime();
	    showtime.setNormalTicketPrice(price);
	}
	
	//ST_TC8_V001
	//Test method for determineTicketPrice
	@Test
	@Parameters(
			{
				"10,2024,9,13,12,9",	//BVA hour before 1pm + Friday
				"10,2024,9,13,14,10",	//BVA hour after 1 pm Friday
				"10,2024,9,13,19,10",	//EP hour after 1pm + Friday
				"10,2024,9,13,6,9",		//EP hour before 1 pm + Friday
				
				"10,2024,9,16,12,9",	//BVA hour before 1pm + Monday
				"10,2024,9,16,14,10",	//BVA hour after 1 pm Monday
				"10,2024,9,16,19,10",	//EP hour after 1pm + Monday
				"10,2024,9,16,6,9",		//EP hour before 1 pm + Monday
				
				"10,2024,9,17,12,9",	//BVA hour before 1pm + Tuesday
				"10,2024,9,17,14,10",	//BVA hour after 1 pm Tuesday
				"10,2024,9,17,19,10",	//EP hour after 1pm + Tuesday
				"10,2024,9,17,6,9",		//EP hour before 1 pm + Tuesday
				
				"10,2024,9,19,12,9",	//BVA hour before 1pm + Thursday
				"10,2024,9,19,14,10",	//BVA hour after 1 pm Thursday
				"10,2024,9,19,19,10",	//EP hour after 1pm + Thursday
				"10,2024,9,19,6,9",		//EP hour before 1 pm + Thursday
				
				"0,2024,9,19,12,9",		//BVA price more than 0
				"100,2024,9,19,12,9",	//EP price more than 0
				"10,2024,9,14,19,12",	//EP Saturday
				"10,2024,9,15,19,12",	//EP Sunday
				"10,2024,9,18,19,8",	//EP Wednesday
				
			})
	public void testDetermineTicketPrice(double price, 
			int year, int month, int day, int hour, 
			double ER) {
		// Create a spy for the Showtime class
	    Showtime spyShowtime = Mockito.spy(new Showtime());

	    // Mock the return values for year, month, day, and time
	    doReturn(year).when(spyShowtime).getYear();
	    doReturn(month).when(spyShowtime).getMonth();
	    doReturn(day).when(spyShowtime).getDay();
	    doReturn(LocalTime.of(hour, 30)).when(spyShowtime).getTime();

	    // Call the method using the spy
	    double actualPrice = spyShowtime.determineTicketPrice(price);

	    // Compare the actual result to the expected result
	    assertEquals(ER, actualPrice, 0.01);
	}		
	
	//Integration tests
//	Showtime showtime = new Showtime();
//	showtime.setTime(LocalTime.of(hour,30));
//	showtime.setYear(year);
//	showtime.setMonth(month);
//	showtime.setDay(day);
//	
//    double AR = showtime.determineTicketPrice(price);
//    assertEquals(ER, AR, 0.001);
	
	//ST_TC8_INV001
	//Test method for determineTicketPrice - INVALID 
	@Test(expected = IllegalArgumentException.class)
	@Parameters(
			{
				"-0.01,2024,9,19,12,9",	//BVA price less than 0
				"-100,2024,9,19,12,9",	//EP price less than 0
			})
	public void testDetermineTicketPriceInvalid(double price, 
			int year, int month, int day, int hour, 
			double ER) {
		// Create a spy for the Showtime class
	    Showtime spyShowtime = Mockito.spy(new Showtime());

	    // Mock the return values for year, month, day, and time
	    doReturn(year).when(spyShowtime).getYear();
	    doReturn(month).when(spyShowtime).getMonth();
	    doReturn(day).when(spyShowtime).getDay();
	    doReturn(LocalTime.of(hour, 30)).when(spyShowtime).getTime();

	    // Call the method using the spy
	     spyShowtime.determineTicketPrice(price);
	}		
	
	//ST_TC9_V001
	//Test method for showtimeAvailable - False
    @Test
    @Parameters({
    	
    	//Hall available, status is in rejectList
    	"true, Not Available, 1",
    	"true, Fully Booked, 1",
    	"true, Cancelled, 1",
    	
    	//Hall not available, status is not in rejectList
    	"false, Available, 1",
    	
    	//Hall not available, status is in rejectList
    	"false, Not Available, 1",
    	"false, Fully Booked, 1",
    	"false, Cancelled, 1",

    	//Ticket quantity valid
    	"false, Available, 1",//BVA ticket quantity is more than 0
    	"false, Available, 100",//EP ticket quantity is more than 0
    	})
    
    public void testShowtimeAvailableReturnFalse(boolean hallAvailability, String status,int qty) {
        // Mock hall to return available
        Showtime spyShowtime = Mockito.spy(new Showtime());
        doReturn(mockHallNumber).when(spyShowtime).getHallNumber();
	    doReturn(status).when(spyShowtime).getStatus();
        when(mockHallNumber.hallAvailable(anyInt())).thenReturn(hallAvailability);

	    // Verify that showtimeAvailable returns false
        assertFalse(spyShowtime.showtimeAvailable(qty));
    }
    
	//ST_TC9_V002
	//Test method for showtimeAvailable - True
    @Test
    @Parameters({
    	//Hall available, status is not in rejectList
    	"true, Available, 1",
    	
    	//Ticket quantity valid
    	"true, Available, 1",//BVA ticket quantity is more than 0
    	"true, Available, 100",//EP ticket quantity is more than 0
    	})
    
    public void testShowtimeAvailableReturnTrue(boolean hallAvailability, String status,int qty) {
    	// Mock hall to return available
        Showtime spyShowtime = Mockito.spy(new Showtime());
        doReturn(mockHallNumber).when(spyShowtime).getHallNumber();
	    doReturn(status).when(spyShowtime).getStatus();
        when(mockHallNumber.hallAvailable(anyInt())).thenReturn(hallAvailability);

	    // Verify that showtimeAvailable returns false
        assertTrue(spyShowtime.showtimeAvailable(qty));
    }
    
	//ST_TC9_INV001
	//Test method for showtimeAvailable - INVALID
	@Test(expected = IllegalArgumentException.class)
    @Parameters({
    	//Ticket quantity valid
    	"true, Available, -1",//BVA ticket quantity is less than 0
    	"true, Available, -100",//EP ticket quantity is less than 0
    	})
    public void testShowtimeAvailableInvalid(boolean hallAvailability, String status,int qty) {
    	// Mock hall to return available
        Showtime spyShowtime = Mockito.spy(new Showtime());
        doReturn(mockHallNumber).when(spyShowtime).getHallNumber();
	    doReturn(status).when(spyShowtime).getStatus();
        when(mockHallNumber.hallAvailable(anyInt())).thenReturn(hallAvailability);

        // Verify that showtimeAvailable returns false
        showtime.showtimeAvailable(qty);
    }


	//SHOWTIME_TC6_V001
	//Test method for setMonth
	@Test
	public void testSetMonth() {
	    Showtime showtime = new Showtime();
	    int mockMonth = 9; // Example month (September)
	    showtime.setMonth(mockMonth);
	    assertEquals(mockMonth, showtime.getMonth());
	}

	//SHOWTIME_TC6_INV001
	//Test method for setMonth - INVALID
	@Test(expected = IllegalArgumentException.class)
	public void testSetMonthInvalid() {
	    Showtime showtime = new Showtime();
	    showtime.setMonth(13); // Invalid input (month out of range)
	}

	//SHOWTIME_TC7_V001
	//Test method for setDay
	@Test
	public void testSetDay() {
	    Showtime showtime = new Showtime();
	    int mockDay = 15; // Example day
	    showtime.setDay(mockDay);
	    assertEquals(mockDay, showtime.getDay());
	}

	//WELP!
	//SHOWTIME_TC7_INV001
	//Test method for setDay - INVALID
	@Test(expected = IllegalArgumentException.class)
	public void testSetDayInvalid() {
	    Showtime showtime = new Showtime();
	    showtime.setDay(32); // Invalid input (day out of range)
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
	    
	    
	  //verify ticket price on Saturday(weekend)
	 // Test method parameter provider
	    private Object[] getParamForTestDetermineTicketPriceOnWeekend() {
	        return new Object[] {
	            // Parameters: movie, cinemaHall, status, time, year, month, day, expected price
	            new Object[] { 
	                new Movie("Example Movie", "Normal", 18.50),   // Movie object
	                new CinemaHall(1, 50),                         // CinemaHall object
	                "Available",                                   // Showtime status
	                LocalTime.of(19, 30),                          // Time
	                2024, 9, 7,                                    // Year, Month, Day (Saturday)
	                20.50                                          // Expected ticket price (weekend surcharge)
	            }
	        };
	    }

	    @Test
	    @Parameters(method="getParamForTestDetermineTicketPriceOnWeekend")
	    public void testDetermineTicketPriceOnWeekend(Movie movie, CinemaHall cinemaHall, String status, LocalTime time, int year, int month, int day, double expectedPrice) {
	        // Set availcreateShowTime able seats for the CinemaHall
	        cinemaHall.setAvailableSeats(50);

	        // Create a Showtime object using the provided parameters
	        Showtime showtime = new Showtime(movie, cinemaHall, status, time, year, month, day);

	        // Get the ticket price
	        double price = showtime.getNormalTicketPrice();

	        // Assert that the calculated price matches the expected price
	        assertEquals(expectedPrice, price, 0.01);
	    }

	    
	    

//	    //verify the ticket prive on wednesday
//	    @Test
//	    public void testDetermineTicketPriceOnWednesday() {
//	    	Movie movie1 = new Movie("Example Movie", "Normal", 18.50);
//	        CinemaHall cinemaHall1 = new CinemaHall(1,50);
//	        cinemaHall1.setAvailableSeats(50);
//	        Showtime showtime = new Showtime(movie1, cinemaHall1, "available", LocalTime.of(19, 30), 2024, 9, 4); // Wednesday
//	        
//	        double price = showtime.getNormalTicketPrice();
//	        assertEquals(8.0, price, 0.01); // Special price for Wednesday
//	    }
//
//	    @Test
//	    public void testDetermineTicketPriceWeekdayMorning() {
//	        Movie movie = new Movie("Test Movie", 15.0); // Normal price is 15
//	        Showtime showtime = new Showtime(movie, new CinemaHall(1, 100), "available", LocalTime.of(11, 0), 2024, 9, 5); // Thursday, before 1 PM
//	        
//	        double price = showtime.getNormalTicketPrice();
//	        assertEquals(9.0, price, 0.01); // Special price for weekday morning
//	    }
//
//	    @Test
//	    public void testDetermineTicketPriceWeekdayAfternoon() {
//	        Movie movie = new Movie("Test Movie", 15.0); // Normal price is 15
//	        Showtime showtime = new Showtime(movie, new CinemaHall(1, 100), "available", LocalTime.of(14, 0), 2024, 9, 5); // Thursday, after 1 PM
//	        
//	        double price = showtime.getNormalTicketPrice();
//	        assertEquals(15.0, price, 0.01); // No change for weekday afternoon
//	    }
//
//	    @Test
//	    public void testNegativeTicketPrice() {
//	        Movie movie = new Movie("Test Movie", -5.0); // Invalid negative price
//	        
//	        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//	            new Showtime(movie, new CinemaHall(1, 100), "available", LocalTime.of(14, 0), 2024, 9, 5);
//	        });
//	        
//	        assertEquals("Negative price is not allowed", exception.getMessage());
//	    }
	    
	 // Test method parameter provider for Wednesday special price
	    private Object[] getParamForTestDetermineTicketPriceOnWednesday() {
	        return new Object[] {
	            new Object[] {
	                new Movie("Example Movie", "Normal", 18.50),
	                new CinemaHall(1, 50),
	                "available",
	                LocalTime.of(19, 30),
	                2024, 9, 4,  // Wednesday
	                8.0          // Expected price for Wednesday
	            }
	        };
	    }

	    // Test method parameter provider for weekday morning price
	    private Object[] getParamForTestDetermineTicketPriceWeekdayMorning() {
	        return new Object[] {
	            new Object[] {
	                new Movie("Test Movie", "Normal", 15.0),
	                new CinemaHall(1, 100),
	                "available",
	                LocalTime.of(11, 0),
	                2024, 9, 5,  // Thursday, before 1 PM
	                9.0          // Special price for weekday morning
	            }
	        };
	    }

	    // Test method parameter provider for weekday afternoon price
	    private Object[] getParamForTestDetermineTicketPriceWeekdayAfternoon() {
	        return new Object[] {
	            new Object[] {
	                new Movie("Test Movie", "Normal", 15.0),
	                new CinemaHall(1, 100),
	                "available",
	                LocalTime.of(14, 0),
	                2024, 9, 5,  // Thursday, after 1 PM
	                15.0         // Normal price for weekday afternoon
	            }
	        };
	    }

	    // Test method parameter provider for negative ticket price
	    private Object[] getParamForTestNegativeTicketPrice() {
	        return new Object[] {
	            new Object[] {
	                new Movie("Test Movie", "Normal", -5.0),  // Invalid negative price
	                new CinemaHall(1, 100),
	                "available",
	                LocalTime.of(14, 0),
	                2024, 9, 5,
	                "Negative price is not allowed"  // Expected exception message
	            }
	        };
	    }

	 // Test for Wednesday special price
	    @Test
	    @Parameters(method="getParamForTestDetermineTicketPriceOnWednesday")
	    public void testDetermineTicketPriceOnWednesday(Movie movie, CinemaHall cinemaHall, String status, LocalTime time, int year, int month, int day, double expectedPrice) {
	        cinemaHall.setAvailableSeats(50);  // Set available seats
	        Showtime showtime = new Showtime(movie, cinemaHall, status, time, year, month, day);
	        
	        double price = showtime.getNormalTicketPrice();
	        assertEquals(expectedPrice, price, 0.01);  // Assert the price for Wednesday
	    }

	    // Test for weekday morning special price
	    @Test
	    @Parameters(method="getParamForTestDetermineTicketPriceWeekdayMorning")
	    public void testDetermineTicketPriceWeekdayMorning(Movie movie, CinemaHall cinemaHall, String status, LocalTime time, int year, int month, int day, double expectedPrice) {
	        Showtime showtime = new Showtime(movie, cinemaHall, status, time, year, month, day);
	        
	        double price = showtime.getNormalTicketPrice();
	        assertEquals(expectedPrice, price, 0.01);  // Assert the price for weekday morning
	    }

	    // Test for weekday afternoon normal price
	    @Test
	    @Parameters(method="getParamForTestDetermineTicketPriceWeekdayAfternoon")
	    public void testDetermineTicketPriceWeekdayAfternoon(Movie movie, CinemaHall cinemaHall, String status, LocalTime time, int year, int month, int day, double expectedPrice) {
	        Showtime showtime = new Showtime(movie, cinemaHall, status, time, year, month, day);
	        
	        double price = showtime.getNormalTicketPrice();
	        assertEquals(expectedPrice, price, 0.01);  // Assert the normal price for weekday afternoon
	    }

//	    // Test for negative ticket price
//	    @Test
//	    @Parameters(method="getParamForTestNegativeTicketPrice")
//	    public void testNegativeTicketPrice(Movie movie, CinemaHall cinemaHall, String status, LocalTime time, int year, int month, int day, String expectedMessage) {
//	        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//	            new Showtime(movie, cinemaHall, status, time, year, month, day);
//	        });
//	        
//	        assertEquals(expectedMessage, exception.getMessage());  // Assert the exception message
//	    }

	    
	    
}
