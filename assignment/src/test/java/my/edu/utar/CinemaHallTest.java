package my.edu.utar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class CinemaHallTest {
	
    // HALL_TC1_V001
    // Test method for setHallNumber (Valid input)
    @Test
    public void testSetHallNumberValid() {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setHallNumber(3);
        assertEquals(3, cinemaHall.getHallNumber());
    }

    // HALL_TC1_INV001
    // Test method for setHallNumber (Invalid input)
    @Test
    public void testSetHallNumberInvalid() {
        CinemaHall cinemaHall = new CinemaHall();
        try {
            cinemaHall.setHallNumber(0);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Hall number must be more than 1", e.getMessage());
        }
    }

    // HALL_TC2_V001
    // Test method for setAvailableSeats (Valid input)
    @Test
    public void testSetAvailableSeatsValid() {
        CinemaHall cinemaHall = new CinemaHall(1, 100);
        cinemaHall.setAvailableSeats(80);
        assertEquals(80, cinemaHall.getAvailableSeats());
    }

    // HALL_TC2_INV001
    // Test method for setAvailableSeats (Invalid input)
    @Test
    public void testSetAvailableSeatsInvalid() {
        CinemaHall cinemaHall = new CinemaHall(1, 100);
        try {
            cinemaHall.setAvailableSeats(-10);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid number of available seats", e.getMessage()); // Adjust the exception message accordingly
        }
    }

    // HALL_TC3_V001
    // Test method for setHallStatus (Valid input)
    @Test
    public void testSetHallStatusValid() {
        CinemaHall cinemaHall = new CinemaHall(1, 100);
        cinemaHall.setHallStatus("Available");
        assertEquals("Available", cinemaHall.getHallStatus());
    }

    // HALL_TC3_INV001
    // Test method for setHallStatus (Invalid input)
    @Test
    public void testSetHallStatusInvalid() {
        CinemaHall cinemaHall = new CinemaHall(1, 100);
        try {
            cinemaHall.setHallStatus("InvalidStatus");
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid hall status", e.getMessage());
        }
    }

    // HALL_TC4_V001
    // Test method for getHallNumber
    @Test
    public void testGetHallNumber() {
        CinemaHall cinemaHall = new CinemaHall(2, 150);
        assertEquals(2, cinemaHall.getHallNumber());
    }

    // HALL_TC5_V001
    // Test method for getAvailableSeats
    @Test
    public void testGetAvailableSeats() {
        CinemaHall cinemaHall = new CinemaHall(3, 120);
        assertEquals(120, cinemaHall.getAvailableSeats());
    }

    // HALL_TC6_V001
    // Test method for getHallStatus
    @Test
    public void testGetHallStatus() {
        CinemaHall cinemaHall = new CinemaHall(4, 200);
        cinemaHall.setHallStatus("NotAvailable");
        assertEquals("NotAvailable", cinemaHall.getHallStatus());
    }
	
    private Object[] getParamForCreateCinemaHallValidTest(){
        return new Object[] {
            new Object[] {10, 50},
            new Object[] {0, 100},
        };
    }

    @Test
    @Parameters(method = "getParamForCreateCinemaHallValidTest")
    public void createCinemaHallValidTest(int hallNumber, int seats){
        assertNotNull(CinemaHall.createCinemaHall(hallNumber, seats));
    }

    private Object[] getParamForCreateCinemaHallInvalidTest(){
        return new Object[] {
            new Object[] {-10, 5},
            new Object[] {5, -10},
            new Object[] {-10, -10},
            new Object[] {null, 10},
            new Object[] {10, null},
            new Object[] {10, 49},
        };
    }

    @Test
    @Parameters(method = "getParamForCreateCinemaHallInvalidTest")
    public void createCinemaHallInvalidTest(int hallNumber, int seats){
        CinemaHall.createCinemaHall(hallNumber, seats);
    }
    
    private Object[] getParamForCheckOversellValid(){
        return new Object[] {
            new Object[] {10, 5, true},
            new Object[] {5, 10, false},
            new Object[] {10, 10, false},
        };
    }

    @Test
    @Parameters(method = "getParamForCheckOversellValid")
    public void checkOversellValid(int newTickets, int availableSeats, boolean ER){
        CinemaHall mockHall = mock(CinemaHall.class);
        when(mockHall.getAvailableSeats()).thenReturn(availableSeats);
        assertEquals(ER, mockHall.checkOversell(newTickets));
    }

    private Object[] getParamsForHallAvailableValidTest(){
        return new Object[] {
            new Object[] {"Fully Booked", false, false},
            new Object[] {"Not Available", false, false},
            new Object[] {"under repair", false, false},
            new Object[] {"Available", true, false},
            new Object[] {"Available", false, false},
        };
    }

    @Test
    @Parameters(method = "getParamsForHallAvailableValidTest")
    public void hallAvailableValidTest(String hallStatus, boolean oversell, boolean ER){
        CinemaHall hallSpy = spy(CinemaHall.class);
        when(hallSpy.getHallStatus()).thenReturn(hallStatus);
        when(hallSpy.checkOversell(anyInt())).thenReturn(oversell);
        assertEquals(hallSpy.hallAvailable(1), ER);
    }

    // private Object[] getParamsForHallAvailableInvalidTest(){
    //     return new Object[] {
    //         new Object[] {"", false, false},
    //         new Object[] {"Not Available", false, false},
    //         new Object[] {"under repair", false, false},
    //         new Object[] {"Available", true, false},
    //         new Object[] {"Available", false, true},
    //     };
    // }

    // @Test(expected = IllegalArgumentException.class)
    // @Parameters(method = "getParamsForHallAvailableInvalidTest")
    // public void hallAvailableInvalidTest(String hallStatus, boolean oversell, boolean ER){
    //     CinemaHall hall = mock(CinemaHall.class);
    //     when(hall.getHallStatus()).thenReturn(hallStatus);
    //     when(hall.checkOversell(anyInt())).thenReturn(oversell);
    //     assertThrows(IllegalArgumentException.class, () -> {
    //         hall.hallAvailable(1);
    //     });
    // }
}
