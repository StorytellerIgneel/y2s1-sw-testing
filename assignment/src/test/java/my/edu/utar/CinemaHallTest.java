package my.edu.utar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class CinemaHallTest {
    // CH_TC1_V001
    // Test method for CinemaHall constructor
    @Test
    public void CinemaHallConstructorTest(){
        int hallNumber = 1;
        int seats = 50;
        CinemaHall cinemahall = new CinemaHall(hallNumber, seats);

        assertNotNull(cinemahall);
        assertEquals(1, cinemahall.getHallNumber());
        assertEquals(50, cinemahall.getSeats());
        assertEquals(50, cinemahall.getAvailableSeats());
        assertEquals(0, cinemahall.getBookedSeats());
        assertEquals("Available", cinemahall.getHallStatus());
    }

    private Object[] getParamForCreateCinemaHallValidTest(){
        return new Object[] {
            new Object[] {1, 100},  //appropriate valid data
            new Object[] {25, 100}, //hallNumber EP
            new Object[] {1, 100},  //hallNumber BVA
            new Object[] {1, 100},  //seats EP
            new Object[] {1, 50}    //seats BVA
        };
    }
    // CH_TC2_V001
    // Test method for createCinemaHall (valid input)
    @Test
    @Parameters(method = "getParamForCreateCinemaHallValidTest")
    public void createCinemaHallValidTest(int hallNumber, int seats){
        CinemaHall cinemahall = CinemaHall.createCinemaHall(hallNumber, seats);
        assertNotNull(cinemahall);
        assertEquals(hallNumber, cinemahall.getHallNumber());
        assertEquals(seats, cinemahall.getSeats());
        assertEquals(seats, cinemahall.getAvailableSeats());
        assertEquals(0, cinemahall.getBookedSeats());
        assertEquals("Available", cinemahall.getHallStatus());
    }

    private Object[] getParamForCreateCinemaHallInvalidTest(){
        return new Object[] {
            new Object[] {-25, 100},    //hallNumber EP
            new Object[] {0, 100},      //hallNumber BVA
            new Object[] {-1, 100},     //hallNumber BVA
            new Object[] {1, -25},      //seats EP
            new Object[] {1, 25},       //seats EP
            new Object[] {1, 0},        //seats BVA
            new Object[] {1, -1},       //seats BVA
            new Object[] {1, 49}        //seats BVA
        };
    }
    // CH_TC2_INV001
    // Test method for createCinemaHall (invalid input)
    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getParamForCreateCinemaHallInvalidTest")
    public void createCinemaHallInvalidTest(int hallNumber, int seats){
        CinemaHall.createCinemaHall(hallNumber, seats);
    }
    
    private Object[] getParamForSetHallNumberValidTest(){
        return new Object[] {
            new Object[] {25, 25},    //hallNumber EP
            new Object[] {1, 1},      //hallNumber BVA
        };
    }
    // CH_TC3_V001
    // Test method for setHallNumber (Valid input)
    @Test 
    @Parameters(method = "getParamForSetHallNumberValidTest")
    public void testSetHallNumberValid(int hallNumber, int ER) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setHallNumber(hallNumber);
        assertEquals(ER, cinemaHall.getHallNumber());
    }

    private Object[] getParamForSetHallNumberInvalidTest(){
        return new Object[] {
            new Object[] {-25}, //hallNumber EP
            new Object[] {0},   //hallNumber BVA
            new Object[] {-1},  //hallNumber BVA
        };
    }
    // CH_TC3_INV001
    // Test method for setHallNumber (Invalid input)
    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getParamForSetHallNumberInvalidTest")
    public void testSetHallNumberInvalid(int hallNumber) {
        CinemaHall cinemaHall = new CinemaHall();
        try {
            cinemaHall.setHallNumber(hallNumber);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Hall number must be more than 1", e.getMessage());
        }
    }
    
    private Object[] getParamForSetHallStatusValidTest(){
        return new Object[] {
            new Object[] {"Available", "Available"},
            new Object[] {"FullyBooked", "FullyBooked"},
            new Object[] {"NotAvailable", "NotAvailable"},
            new Object[] {"Repair", "Repair"}
        };
    }
    // CH_TC4_V001
    // Test method for setHallStatus (Valid input)
    @Test
    @Parameters(method = "getParamForSetHallStatusValidTest")
    public void testSetHallStatusValid(String hallStatus, String ER) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setHallStatus(hallStatus);
        assertEquals(ER, cinemaHall.getHallStatus());
    }

    // CH_TC4_INV001
    // Test method for setHallStatus (Invalid input)
    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getParamForSetHallStatusInvalidTest")
    public void testSetHallStatusInvalid() {
        CinemaHall cinemaHall = new CinemaHall();
        try {
            cinemaHall.setHallStatus("InvalidStatus");
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid hall status", e.getMessage());
        }
    }
    
    // CH_TC5_V001
    // Test method for getAvailableSeats
    @Test
    public void testSetAvailableSeats() {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setAvailableSeats(120);
        assertEquals(120, cinemaHall.getAvailableSeats());
    }

    // CH_TC6_V001
    // Test method for getSeats
    @Test
    public void testGetSeats() {
        CinemaHall cinemaHall = new CinemaHall(3, 120);
        assertEquals(120, cinemaHall.getSeats());
    }
	
    // CH_TC7_V001
    // Test method for getBookedSeats
    @Test
    public void testGetBookedSeats() {
        CinemaHall cinemaHall = new CinemaHall(5, 150);
        assertEquals(0, cinemaHall.getBookedSeats());
    }

    private Object[] getParamForCheckOversellValid(){
        return new Object[] {
            new Object[] {25, 50, true},
            new Object[] {25, 20, false},
            new Object[] {0, 50, true},
            new Object[] {0, 1, false}
        };
    }
    // CH_TC8_V001
    // Test method for checkOversell (Valid input)
    @Test
    @Parameters(method = "getParamForCheckOversellValid")
    public void checkOversellValid(int newTickets, int availableSeats, boolean ER){
        CinemaHall mockHall = mock(CinemaHall.class);
        when(mockHall.getAvailableSeats()).thenReturn(availableSeats);
        assertEquals(ER, mockHall.checkOversell(newTickets));
    }

    private Object[] getParamForCheckOversellInvalid(){
        return new Object[] {
            new Object[] {-25}, // newTickets EP
            new Object[] {-1}   // newTickets BVA
        };
    }
    // CH_TC8_INV001
    // Test method for checkOversell (Invalid input)
    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getParamForCheckOversellInvalid")
    public void checkOversellInvalid(int newTickets){
        CinemaHall mockHall = mock(CinemaHall.class);
        try {
            mockHall.checkOversell(newTickets);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Negative value passed", e.getMessage());
        }
    }

    // CH_TC9_V001
    // Test method for hallAvailable (Valid input)
    @Test
    @Parameters(method = "getParamsForHallAvailableValidTest")
    public void hallAvailableValidTest(){
        CinemaHall mockHall = mock(CinemaHall.class);
        when(mockHall.getHallStatus()).thenReturn("Available");
        when(mockHall.checkOversell(anyInt())).thenReturn(false);
        assertTrue(mockHall.checkOversell(25));
    }

    private Object[] getParamsForHallAvailableInvalidHallStatusTest(){
        return new Object[] {
            new Object[] {"FullyBooked"},
            new Object[] {"NotAvailable"},
            new Object[] {"Repair"}
        };
    }
    // CH_TC9_INV001
    // Test method for hallAvailable (hallStatus in rejectList)
    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getParamsForHallAvailableInvalidHallStatusTest")
    public void hallAvailableInvalidHallStatusTest(String hallStatus){
        CinemaHall mockHall = mock(CinemaHall.class);
        when(mockHall.getHallStatus()).thenReturn(hallStatus);
        try {
            mockHall.hallAvailable(10);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Sorry, the hall is currently " + mockHall.getHallStatus(), e.getMessage());
        }
    }

    private Object[] getParamsForHallAvailableInvalidOversellTest(){
        return new Object[] {
            new Object[] {200, 50},
            new Object[] {100, 99}
        };
    }
    // CH_TC9_INV002
    // Test method for hallAvailable (checkOversell returns false)
    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getParamsForHallAvailableInvalidOversellTest")
    public void hallAvailableInvalidOversellTest(int newTickets, int availableSeats){
        CinemaHall mockHall = mock(CinemaHall.class);
        when(mockHall.getHallStatus()).thenReturn("Available");
        when(mockHall.getAvailableSeats()).thenReturn(availableSeats);
        try {
            mockHall.hallAvailable(newTickets);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("The hall only has " + mockHall.getAvailableSeats(), e.getMessage());
        }
    }
}
