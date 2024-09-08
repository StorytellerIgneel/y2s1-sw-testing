package my.edu.utar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
    @Test
    public void CinemaHallConstructorTest(){
        // 1. Arrange: Create a CinemaHall object with valid data
        int hallNumber = 1;
        int seats = 25;
        CinemaHall cinemahall = new CinemaHall(hallNumber, seats);

        // 2. Act & Assert: Verify the attributes of the CinemaHall object
        assertNotNull(cinemahall);  // Ensure the object is not null
        assertEquals(1, cinemahall.getHallNumber());  // Check hall number
        assertEquals(25, cinemahall.getSeats());  // Check total number of seats
        assertEquals(25, cinemahall.getAvailableSeats());  // Initially, all seats should be available
        assertEquals(0, cinemahall.getBookedSeats());  // Initially, no seats should be booked
        assertEquals("Available", cinemahall.getHallStatus());  // Initial status should be "Available"
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
