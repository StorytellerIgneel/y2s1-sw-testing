package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.time.LocalTime;


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
	 
	//ST_TC1_V001
    private Object[] getParamForCreateShowtimeValid() {
        return new Object[] {
            new Object[] {1900,1,1},	// BVA year lower bound
            new Object[] {2024,1,1},	// BVA year upper bound
            new Object[] {1962,1,1},	// EP year
            new Object[] {1962,1,1},	// BVA month lower bound
            new Object[] {1962,12,1},	// BVA month upper bound
			new Object[] {1962,6,1},	// EP month
            new Object[] {1962,1,1},	// BVA day lower bound
            new Object[] {1962,1,31},	// BVA day upper bound at month with 31 days       
            new Object[] {1962,4,30},	// BVA day upper bound at month with 30 days 
            new Object[] {2023,2,28},	// BVA day upper bound at month with 28 days 
            new Object[] {2024,2,29},	// BVA day upper bound at month with 29 days 
            new Object[] {1962,1,15}	// EP day 
        };
    }
    @Test
    @Parameters(method="getParamForCreateShowtimeValid")
    public void testCreateShowtime(int year, int month, int day) {
    	Showtime showtime = Showtime.createShowtime(mockMovie, mockHallNumber, time, year,month,day);
    	assertNotNull(showtime);
    	assertEquals(year, showtime.getYear());
        assertEquals(month, showtime.getMonth());
        assertEquals(day, showtime.getDay());
        assertEquals(time, showtime.getTime());
        assertEquals(mockMovie, showtime.getMovie());
        assertEquals(mockHallNumber, showtime.getHallNumber());
    }
    
    //ST_ITC_V001 - integration test
    private Object[] getParamForCreateShowtimeIntegrationTestValid() {
        return new Object[] {
            new Object[] {new Movie("Example Movie","Normal",18.00),new CinemaHall(50,50),LocalTime.of(13, 0),1900,1,1},	// BVA year lower bound
            new Object[] {new Movie("Example Movie","Normal",18.00),new CinemaHall(50,50),LocalTime.of(13, 0),2024,1,1},	// BVA year upper bound
            new Object[] {new Movie("Example Movie","Normal",18.00),new CinemaHall(50,50),LocalTime.of(13, 0),1962,1,1},	// EP year
            new Object[] {new Movie("Example Movie","Normal",18.00),new CinemaHall(50,50),LocalTime.of(13, 0),1962,1,1},	// BVA month lower bound
            new Object[] {new Movie("Example Movie","Normal",18.00),new CinemaHall(50,50),LocalTime.of(13, 0),1962,12,1},	// BVA month upper bound
            new Object[] {new Movie("Example Movie","Normal",18.00),new CinemaHall(50,50),LocalTime.of(13, 0),1962,1,1},	// BVA day lower bound
            new Object[] {new Movie("Example Movie","Normal",18.00),new CinemaHall(50,50),LocalTime.of(13, 0),1962,1,31},	// BVA day upper bound at month with 31 days       
            new Object[] {new Movie("Example Movie","Normal",18.00),new CinemaHall(50,50),LocalTime.of(13, 0),1962,4,30},	// BVA day upper bound at month with 30 days 
            new Object[] {new Movie("Example Movie","Normal",18.00),new CinemaHall(50,50),LocalTime.of(13, 0),2023,2,28},	// BVA day upper bound at month with 28 days 
            new Object[] {new Movie("Example Movie","Normal",18.00),new CinemaHall(50,50),LocalTime.of(13, 0),2024,2,29},	// BVA day upper bound at month with 29 days 
            new Object[] {new Movie("Example Movie","Normal",18.00),new CinemaHall(50,50),LocalTime.of(13, 0),1962,1,15},	// EP day 
        };
    }
    @Test
    @Parameters(method="getParamForCreateShowtimeIntegrationTestValid")
    public void testCreateShowtimeIntegration(Movie movie, CinemaHall hall, LocalTime time, int year, int month, int day) {
    	Showtime showtime = Showtime.createShowtime(movie, hall, time, year,month,day);
    	assertNotNull(showtime);
    	assertEquals(year, showtime.getYear());
        assertEquals(month, showtime.getMonth());
        assertEquals(day, showtime.getDay());
        assertEquals(time, showtime.getTime());
        assertEquals(movie, showtime.getMovie());
        assertEquals(hall, showtime.getHallNumber());
    }
    
    //ST_TC1_INV001
    private Object[] getParamForCreateShowtimeInvalid() {
        return new Object[] {
            new Object[] {1899,1,1},	// BVA year lower bound
            new Object[] {2025,1,1},	// BVA year upper bound
            new Object[] {100,1,1},		// EP year
            new Object[] {3000,1,1},	// EP year
            new Object[] {1962,0,1},	// BVA month lower bound
            new Object[] {1962,13,1},	// BVA month upper bound
            new Object[] {1962,1,0},	// BVA day lower bound
            new Object[] {1962,1,32},	// BVA day upper bound at month with 31 days       
            new Object[] {1962,4,31},	// BVA day upper bound at month with 30 days 
            new Object[] {2023,2,29},	// BVA day upper bound at month with 28 days 
            new Object[] {2024,2,30},	// BVA day upper bound at month with 29 days 
            new Object[] {1962,1,-100},	// EP day 
            new Object[] {1962,1,100},	// EP day 

        };
    }
   
	@Test(expected = IllegalArgumentException.class)
    @Parameters(method="getParamForCreateShowtimeInvalid")
    public void testCreateShowtimeInvalid(int year, int month, int day) {
    	Showtime showtime = Showtime.createShowtime(mockMovie, mockHallNumber, time, year,month,day);
    	assertNotNull(showtime);
    	assertEquals(year, showtime.getYear());
        assertEquals(month, showtime.getMonth());
        assertEquals(day, showtime.getDay());
        assertEquals(time, showtime.getTime());
        assertEquals(mockMovie, showtime.getMovie());
        assertEquals(mockHallNumber, showtime.getHallNumber());
    }
	
	//ST_ITC1_INV001 - integration test
	 private Object[] getParamForCreateShowtimeInvalidIntegration() {
	        return new Object[] {
	            new Object[] {new Movie("Example Movie","Normal",18.00),new CinemaHall(50,50),LocalTime.of(13, 0),1899,1,1},	// BVA year lower bound
	            new Object[] {new Movie("Example Movie","Normal",18.00),new CinemaHall(50,50),LocalTime.of(13, 0),2025,1,1},	// BVA year upper bound
	            new Object[] {new Movie("Example Movie","Normal",18.00),new CinemaHall(50,50),LocalTime.of(13, 0),100,1,1},		// EP year
	            new Object[] {new Movie("Example Movie","Normal",18.00),new CinemaHall(50,50),LocalTime.of(13, 0),3000,1,1},	// EP year
	            new Object[] {new Movie("Example Movie","Normal",18.00),new CinemaHall(50,50),LocalTime.of(13, 0),1962,0,1},	// BVA month lower bound
	            new Object[] {new Movie("Example Movie","Normal",18.00),new CinemaHall(50,50),LocalTime.of(13, 0),1962,13,1},	// BVA month upper bound
	            new Object[] {new Movie("Example Movie","Normal",18.00),new CinemaHall(50,50),LocalTime.of(13, 0),1962,1,0},	// BVA day lower bound
	            new Object[] {new Movie("Example Movie","Normal",18.00),new CinemaHall(50,50),LocalTime.of(13, 0),1962,1,32},	// BVA day upper bound at month with 31 days       
	            new Object[] {new Movie("Example Movie","Normal",18.00),new CinemaHall(50,50),LocalTime.of(13, 0),1962,4,31},	// BVA day upper bound at month with 30 days 
	            new Object[] {new Movie("Example Movie","Normal",18.00),new CinemaHall(50,50),LocalTime.of(13, 0),2023,2,29},	// BVA day upper bound at month with 28 days 
	            new Object[] {new Movie("Example Movie","Normal",18.00),new CinemaHall(50,50),LocalTime.of(13, 0),2024,2,30},	// BVA day upper bound at month with 29 days 
	            new Object[] {new Movie("Example Movie","Normal",18.00),new CinemaHall(50,50),LocalTime.of(13, 0),1962,1,-100},	// EP day 
	            new Object[] {new Movie("Example Movie","Normal",18.00),new CinemaHall(50,50),LocalTime.of(13, 0),1962,1,100},	// EP day 

	        };
	    }
	@Test(expected = IllegalArgumentException.class)
    @Parameters(method="getParamForCreateShowtimeInvalidIntegration")
    public void testCreateShowtimeInvalidIntegration(Movie movie, CinemaHall hall, LocalTime time, int year, int month, int day) {
    	Showtime.createShowtime(movie, hall, time, year,month,day);
    }
	    
	//ST_TC2_V001
	//Test method for setMovie
	@Test
	public void testSetMovie() {
		Showtime showtime = new Showtime();
		Movie mockMovie = mock(Movie.class);
		showtime.setMovie(mockMovie);
		assertSame(mockMovie, showtime.getMovie());
	}
	
	//ST_ITC2_V001
	//Test method for setMovie - integration test
	@Test
	public void testSetMovieIntegration() {
		Showtime showtime = new Showtime();
		Movie movie = new Movie("Example Movie","Normal",18.00);
		showtime.setMovie(movie);
		assertSame(movie, showtime.getMovie());
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
	    CinemaHall mockHall = mock(CinemaHall.class);
	    showtime.setHallNumber(mockHall);
	    assertSame(mockHall, showtime.getHallNumber());
	}
	
	//ST_ITC4_V001
	//Test method for setHallNumber - integration test
	@Test
	public void testSetHallNumberIntegration() {
	    Showtime showtime = new Showtime();
	    CinemaHall hall = new CinemaHall(50,50);
	    showtime.setHallNumber(hall);
	    assertSame(hall, showtime.getHallNumber());
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
	    assertEquals(ER, showtime.getTime());
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
				
				"10,2024,9,23,12,9",	//BVA hour before 1pm + Monday
				"10,2024,9,23,14,10",	//BVA hour after 1 pm Monday
				"10,2024,9,23,19,10",	//EP hour after 1pm + Monday
				"10,2024,9,23,6,9",		//EP hour before 1 pm + Monday
				
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

				// Non-Saturday/Sunday public holidays in 2024
				"10,2024,1,1,12,12",	// New Year's Day
				"10,2024,12,25,14,12"	// Christmas Day
				
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
	
		//ST_ITC8_V001
		//Test method for determineTicketPrice - integration test
		@Test
		@Parameters(
				{
					"10,2024,9,13,12,9",	//BVA hour before 1pm + Friday
					"10,2024,9,13,14,10",	//BVA hour after 1 pm Friday
					"10,2024,9,13,19,10",	//EP hour after 1pm + Friday
					"10,2024,9,13,6,9",		//EP hour before 1 pm + Friday
					
					"10,2024,9,23,12,9",	//BVA hour before 1pm + Monday
					"10,2024,9,23,14,10",	//BVA hour after 1 pm Monday
					"10,2024,9,23,19,10",	//EP hour after 1pm + Monday
					"10,2024,9,23,6,9",		//EP hour before 1 pm + Monday
					
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

					// Non-Saturday/Sunday public holidays in 2024
					"10,2024,1,1,12,12",	// New Year's Day
					"10,2024,12,25,14,12"	// Christmas Day
					
				})
		public void testDetermineTicketPriceIntegration(double price, 
				int year, int month, int day, int hour, 
				double ER) {
			Showtime showtime = new Showtime();
			showtime.setTime(LocalTime.of(hour,30));
			showtime.setYear(year);
			showtime.setMonth(month);
			showtime.setDay(day);
			
		    double AR = showtime.determineTicketPrice(price);
		    assertEquals(ER, AR, 0.001);
		}	
		
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
		//ST_ITC8_INV001
		//Test method for determineTicketPrice - INVALID 
		@Test(expected = IllegalArgumentException.class)
		@Parameters(
				{
					"-0.01,2024,9,19,12,9",	//BVA price less than 0
					"-100,2024,9,19,12,9",	//EP price less than 0
				})
		public void testDetermineTicketPriceInvalidIntegration(double price, 
				int year, int month, int day, int hour, 
				double ER) {
			Showtime showtime = new Showtime();
			showtime.setTime(LocalTime.of(hour,30));
			showtime.setYear(year);
			showtime.setMonth(month);
			showtime.setDay(day);
			
		    double AR = showtime.determineTicketPrice(price);
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
    
    //ST_ITC9_V001
  	//Test method for showtimeAvailable - False - integration
      @Test
      @Parameters({
      	
      	//Hall available, status is in rejectList
      	"Available, Not Available, 1",
      	"Available, Fully Booked, 1",
      	"Available, Cancelled, 1",
      	
      	//Hall not available, status is not in rejectList
      	"FullyBooked, Available, 1",
      	
      	//Hall not available, status is in rejectList
      	"FullyBooked, Not Available, 1",
      	"FullyBooked, Fully Booked, 1",
      	"FullyBooked, Cancelled, 1",

      	//Ticket quantity valid
      	"FullyBooked, Available, 1",//BVA ticket quantity is more than 0
      	"FullyBooked, Available, 100",//EP ticket quantity is more than 0
      	
      //Hall not available, status is not in rejectList
      	"NotAvailable, Available, 1",
      	
      	//Hall not available, status is in rejectList
      	"NotAvailable, Not Available, 1",
      	"NotAvailable, Fully Booked, 1",
      	"NotAvailable, Cancelled, 1",

      	//Ticket quantity valid
      	"NotAvailable, Available, 1",//BVA ticket quantity is more than 0
      	"NotAvailable, Available, 100",//EP ticket quantity is more than 0
      	
      	//Hall not available, status is not in rejectList
      	"Repair, Available, 1",
      	
      	//Hall not available, status is in rejectList
      	"Repair, Not Available, 1",
      	"Repair, Fully Booked, 1",
      	"Repair, Cancelled, 1",

      	//Ticket quantity valid
      	"Repair, Available, 1",//BVA ticket quantity is more than 0
      	"Repair, Available, 100",//EP ticket quantity is more than 0
      	})
      
      public void testShowtimeAvailableReturnFalseIntegration(String hallStatus, String status,int qty) {
          Showtime showtime = new Showtime ();
          CinemaHall hall = new CinemaHall(500,500);
          hall.setHallStatus(hallStatus);
          showtime.setHallNumber(hall);
          showtime.setStatus(status);
          
  	    // Verify that showtimeAvailable returns false
          assertFalse(showtime.showtimeAvailable(qty));
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
    
  //ST_ITC9_V002
  	//Test method for showtimeAvailable - True - integration test
      @Test
      @Parameters({
      	//Hall available, status is not in rejectList
      	"Available, Available, 1",
      	
      	//Ticket quantity valid
      	"Available, Available, 1",//BVA ticket quantity is more than 0
      	"Available, Available, 100",//EP ticket quantity is more than 0
      	})
      
      public void testShowtimeAvailableReturnTrueIntegration(String hallStatus, String status,int qty) {
    	  Showtime showtime = new Showtime ();
          CinemaHall hall = new CinemaHall(500,500);
          hall.setHallStatus(hallStatus);
          showtime.setHallNumber(hall);
          showtime.setStatus(status);
          
  	    // Verify that showtimeAvailable returns true
          assertTrue(showtime.showtimeAvailable(qty));
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


	//ST_TC10_V001
	//Test method for setMonth
	@Test
	@Parameters({
		"1",	//BVA lower bound
		"12",	//BVA upper  bound
		"6",	//EP 
		})
	public void testSetMonth(int month) {
	    Showtime showtime = new Showtime();
	    showtime.setMonth(month);
	    assertEquals(month, showtime.getMonth());
	}
	
	//ST_TC10_INV001
	//Test method for setMonth - INVALID
	@Test(expected = IllegalArgumentException.class)
	@Parameters({
		"-1",	//BVA less than lower bound
		"13",	//BVA more than upper  bound
		"-100",	//EP less than 1
		"100",	//EP more than 12
		})
	public void testSetMonthInvalid(int month) {
	    Showtime showtime = new Showtime();
	    showtime.setMonth(month); // Invalid input (month out of range)
	}

	//ST_TC11_V001
	//Test method for setDay
	@Test
	@Parameters({
        "2024,1,1",		// BVA valid date lower bound 
        "2024,1,31",	// BVA valid date upper bound for month with 31 days
        "2024,4,30",	// BVA valid date upper bound for month with 30 days
        "2024,2,29",	// BVA valid date in February, leap year
        "2021,2,28",	// BVA valid date in February, not a leap year
        "2024,1,15",	// EP valid date
	})
	public void testSetDay(int year, int month, int day) {
		Showtime spyShowtime = Mockito.spy(new Showtime());
        doReturn(year).when(spyShowtime).getYear();
        doReturn(month).when(spyShowtime).getMonth();
        spyShowtime.setDay(day);
	    assertEquals(day, spyShowtime.getDay());
	}
	
	//ST_ITC11_V001
	//Test method for setDay
	@Test
	@Parameters({
        "2024,1,1",		// BVA valid date lower bound 
        "2024,1,31",	// BVA valid date upper bound for month with 31 days
        "2024,4,30",	// BVA valid date upper bound for month with 30 days
        "2024,2,29",	// BVA valid date in February, leap year
        "2021,2,28",	// BVA valid date in February, not a leap year
        "2024,1,15",	// EP valid date
	})
	public void testSetDayIntegration(int year, int month, int day) {
		Showtime showtime = new Showtime();
		showtime.setYear(year);
		showtime.setMonth(month);
		showtime.setDay(day);
	    assertEquals(day, showtime.getDay());
	}

	//ST_TC11_INV001
	//Test method for setDay - INVALID
	@Test(expected = IllegalArgumentException.class)
	@Parameters({
        "2024,1,-1",	// BVA invalid date - less than lower bound
        "2024,1, 32",	// BVA invalid date - more than lower bound for month with 31 days
        "2024,4, 31",	// BVA invalid date - more than lower bound for month with 30 days
        "2021,2, 29",	// BVA invalid date in February, not a leap year
        "2021,2, 30",	// BVA invalid date in February, is a leap year
        "2021,2, 50",	// BVA invalid date in February, is a leap year
        "2021,2, -50",	// BVA invalid date in February, is a leap year
	})
	public void testSetDayInvalid(int year, int month, int day) {
		Showtime spyShowtime = Mockito.spy(new Showtime());
        doReturn(year).when(spyShowtime).getYear();
        doReturn(month).when(spyShowtime).getMonth();
        spyShowtime.setDay(day);
	}
	
	//ST_ITC11_INV001
	//Test method for setDay - INVALID - integration test
	@Test(expected = IllegalArgumentException.class)
	@Parameters({
        "2024,1,-1",	// BVA invalid date - less than lower bound
        "2024,1, 32",	// BVA invalid date - more than lower bound for month with 31 days
        "2024,4, 31",	// BVA invalid date - more than lower bound for month with 30 days
        "2021,2, 29",	// BVA invalid date in February, not a leap year
        "2021,2, 30",	// BVA invalid date in February, is a leap year
        "2021,2, 50",	// BVA invalid date in February, is a leap year
        "2021,2, -50",	// BVA invalid date in February, is a leap year
	})
	public void testSetDayInvalidIntegration(int year, int month, int day) {
		Showtime showtime = new Showtime();
		showtime.setYear(year);
		showtime.setMonth(month);
		showtime.setDay(day);
	}
	    
}
