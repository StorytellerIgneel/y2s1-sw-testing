package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;

@RunWith(JUnitParamsRunner.class)
public class CinemaHallTest {
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

    @Test (expected = IllegalArgumentException.class)
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
        CinemaHall HallSpy = spy(CinemaHall.class);
        when(HallSpy.getAvailableSeats()).thenReturn(availableSeats);
        assertEquals(ER, HallSpy.checkOversell(newTickets));
    }

    // private Object[] getParamsForHallAvailableValidTest(){
    //     return new Object[] {
    //         new Object[] {"Fully Booked", false, false},
    //         new Object[] {"Not Available", false, false},
    //         new Object[] {"under repair", false, false},
    //         new Object[] {"Available", true, false},
    //         new Object[] {"Available", false, false},
    //     };
    // }

    // @Test
    // @Parameters(method = "getParamsForHallAvailableValidTest")
    // public void hallAvailableValidTest(String hallStatus, boolean oversell, boolean ER){
    //     CinemaHall hallSpy = spy(CinemaHall.class);
    //     when(hallSpy.getHallStatus()).thenReturn(hallStatus);
    //     when(hallSpy.checkOversell(anyInt())).thenReturn(oversell);
    //     assertEquals(hallSpy.hallAvailable(1), ER);
    // }

    private Object[] getParamsForHallAvailableInvalidTest(){
        return new Object[] {
            new Object[] {"", false, false},
            new Object[] {"Not Available", false, false},
            new Object[] {"under repair", false, false},
            new Object[] {"Available", true, false},
            new Object[] {"Available", false, true},
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getParamsForHallAvailableInvalidTest")
    public void hallAvailableInvalidTest(String hallStatus, boolean oversell, boolean ER){
        CinemaHall hallSpy = spy(CinemaHall.class);
        when(hallSpy.getHallStatus()).thenReturn(hallStatus);
        when(hallSpy.checkOversell(anyInt())).thenReturn(oversell);
        hallSpy.hallAvailable(1);
    }
}
