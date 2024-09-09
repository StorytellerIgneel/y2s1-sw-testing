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
	        when(mockShowtime.getNormalTicketPrice()).thenReturn(10.0);
	        when(mockShowtime.getMovie()).thenReturn(mockMovie);
	        when(mockHallNumber.checkOversell(0)).thenReturn(false);

	    }


	 


	//SHOWTIME_TC1_V001
	//Test method for setTime
	private Object[] getParamFortestSetTimeValid() {
	return new Object[] {
		new Object[] {LocalTime.of(0, 1), LocalTime.of(0, 1)},
		new Object[] {LocalTime.of(23, 59), LocalTime.of(23, 59)},
		
	};
}
	@Test
	@Parameters(method = "getParamFortestSetTimeValid")
	public void testSetTime(LocalTime time, LocalTime ER) {
	    Showtime showtime = new Showtime();
	    showtime.setTime(time);
	    assertSame(ER, showtime.getTime());
	}

	//SHOWTIME_TC1_INV001
	//Test method for setTime - INVALID
	@Test(expected = IllegalArgumentException.class)
	public void testSetTimeInvalid() {
	    Showtime showtime = new Showtime();
	    showtime.setTime(null); // Invalid input
	}

	//SHOWTIME_TC2_V001
	//Test method for setMovie
	@Test
	public void testSetMovie() {
	    Showtime showtime = new Showtime();
	    Movie mockMovie = new Movie("Test Movie", "Action", 15.00); // Example movie
	    showtime.setMovie(mockMovie);
	    assertSame(mockMovie, showtime.getMovie());
	}

	//SHOWTIME_TC2_INV001
	//Test method for setMovie - INVALID
	@Test(expected = IllegalArgumentException.class)
	public void testSetMovieInvalid() {
	    Showtime showtime = new Showtime();
	    showtime.setMovie(null); // Invalid input
	}

	//SHOWTIME_TC3_V001
	//Test method for setStatus
	@Test
	public void testSetStatus() {
	    Showtime showtime = new Showtime();
	    String mockStatus = "Available"; // Example status
	    showtime.setStatus(mockStatus);
	    assertEquals(mockStatus, showtime.getStatus());
	}

	//SHOWTIME_TC3_INV001
	//Test method for setStatus - INVALID
	@Test(expected = IllegalArgumentException.class)
	public void testSetStatusInvalid() {
	    Showtime showtime = new Showtime();
	    showtime.setStatus(null); // Invalid input
	}

	//SHOWTIME_TC4_V001
	//Test method for setHallNumber
	@Test
	public void testSetHallNumber() {
	    Showtime showtime = new Showtime();
	    CinemaHall mockHall = new CinemaHall(1, 100); // Example cinema hall
	    showtime.setHallNumber(mockHall);
	    assertSame(mockHall, showtime.getHallNumber());
	}

	//SHOWTIME_TC4_INV001
	//Test method for setHallNumber - INVALID
	@Test(expected = IllegalArgumentException.class)
	public void testSetHallNumberInvalid() {
	    Showtime showtime = new Showtime();
	    showtime.setHallNumber(null); // Invalid input
	}

	//SHOWTIME_TC5_V001
	//Test method for setYear
	@Test
	public void testSetYear() {
	    Showtime showtime = new Showtime();
	    int mockYear = 2024; // Example year
	    showtime.setYear(mockYear);
	    assertEquals(mockYear, showtime.getYear());
	}

	//SHOWTIME_TC5_INV001
	//Test method for setYear - INVALID
	@Test(expected = IllegalArgumentException.class)
	public void testSetYearInvalid() {
	    Showtime showtime = new Showtime();
	    showtime.setYear(1800); // Invalid input (year out of range)
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

	//SHOWTIME_TC8_V001
	//Test method for setNormalTicketPrice
	@Test
	public void testSetNormalTicketPrice() {
	    Showtime showtime = new Showtime();
	    double mockPrice = 15.00; // Example price
	    showtime.setNormalTicketPrice(mockPrice);
	    assertEquals(mockPrice, showtime.getNormalTicketPrice(), 0.01);
	}

	//SHOWTIME_TC8_INV001
	//Test method for setNormalTicketPrice - INVALID
	@Test(expected = IllegalArgumentException.class)
	public void testSetNormalTicketPriceInvalid() {
	    Showtime showtime = new Showtime();
	    showtime.setNormalTicketPrice(-10.00); // Invalid input (negative price)
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
	    
	
	 	// Test method parameter provider for all valid showtime
	    private Object[] getParamForTestDetermineTicketPriceValid() {
	        return new Object[] {
	            // Parameters: movie, cinemaHall, status, time, year, month, day, expected price
	            new Object[] { //weekend
	                new Movie("Example Movie", "Normal", 18.50),   // Movie object
	                new CinemaHall(1, 50),                         // CinemaHall object
	                "Available",                                   // Showtime status
	                LocalTime.of(19, 30),                          // Time
	                2024, 9, 7,                                    // Year, Month, Day (Saturday)
	                20.50                                          // Expected ticket price (weekend surcharge)
	            },
				new Object[] { //wednesday (special?)
	                new Movie("Example Movie", "Normal", 18.50),
	                new CinemaHall(1, 50),
	                "available",
	                LocalTime.of(19, 30),
	                2024, 9, 4,  // Wednesday
	                8.0          // Expected price for Wednesday
	            },
				new Object[] { //weekday morning
	                new Movie("Test Movie", "Normal", 15.0),
	                new CinemaHall(1, 100),
	                "available",
	                LocalTime.of(11, 0),
	                2024, 9, 5,  // Thursday, before 1 PM
	                9.0          // Special price for weekday morning
	            },
				new Object[] { //weekday afternoon
	                new Movie("Test Movie", "Normal", 15.0),
	                new CinemaHall(1, 100),
	                "available",
	                LocalTime.of(14, 0),
	                2024, 9, 5,  // Thursday, after 1 PM
	                15.0         // Normal price for weekday afternoon
	            }
	        };
	    }

	    @Test
	    @Parameters(method="getParamForTestDetermineTicketPriceValid")
	    public void testDetermineTicketPriceValid(Movie movie, CinemaHall cinemaHall, String status, LocalTime time, int year, int month, int day, double expectedPrice) {
	        // Create a Showtime object using the provided parameters
	        Showtime showtime = new Showtime(movie, cinemaHall, status, time, year, month, day);

	        // Get the ticket price
	        double price = showtime.getNormalTicketPrice();

	        // Assert that the calculated price matches the expected price
	        assertEquals(expectedPrice, price, 0.01);
	    }

	    // Test method parameter provider for invalid ticket price
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
