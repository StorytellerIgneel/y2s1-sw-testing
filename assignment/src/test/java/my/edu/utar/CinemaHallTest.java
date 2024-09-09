package my.edu.utar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
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

    private Object[] getParamForTestCreateCinemaHallValid(){
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
    public void testCreateCinemaHallValid(int hallNumber, int seats){
        CinemaHall cinemahall = CinemaHall.createCinemaHall(hallNumber, seats);
        assertNotNull(cinemahall);
        assertEquals(hallNumber, cinemahall.getHallNumber());
        assertEquals(seats, cinemahall.getSeats());
        assertEquals(seats, cinemahall.getAvailableSeats());
        assertEquals(0, cinemahall.getBookedSeats());
        assertEquals("Available", cinemahall.getHallStatus());
    }

    private Object[] getParamForTestCreateCinemaHallInvalid(){
        return new Object[] {
            new Object[] {-25, 100},    //HallNumber EP negative
            new Object[] {0, 100},      //hallNumber 0
            new Object[] {-1, 100},     //hallNumber BVA negative
            new Object[] {1, -25},      //seats EP negative
            new Object[] {1, 25},       //seats EP below 50
            new Object[] {1, 0},        //seats BVA 0
            new Object[] {1, -1},       //seats BVA negative
            new Object[] {1, 49}        //seats BVA not enough
        };
    }
    // CH_TC2_INV001
    // Test method for createCinemaHall (invalid input)
    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getParamForTestCreateCinemaHallInvalid")
    public void createCinemaHallInvalidTest(int hallNumber, int seats){
        CinemaHall.createCinemaHall(hallNumber, seats);
    }

    // GETTERS AND SETTERS
    // CH_TC3_V001
    // Test method for setHallNumber (Valid input)
    private Object[] getParamForTestSetHallNumberValid(){
        return new Object[] {
            new Object[] {25, 25},    //hallNumber EP
            new Object[] {1, 1},      //hallNumber BVA
        };
    }
    
    @Test 
    @Parameters(method = "getParamForSetHallNumberValid")
    public void testSetHallNumberValid(int hallNumber, int ER) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setHallNumber(hallNumber);
        assertEquals(ER, cinemaHall.getHallNumber());
    }
    
    // CH_TC3_INV001
    // Test method for setHallNumber (Invalid input)
    private Object[] getParamForTestSetHallNumberInvalid(){
        return new Object[] {
            new Object[] {-25}, //hallNumber EP negative
            new Object[] {0},   //hallNumber BVA 0 
            new Object[] {-1},  //hallNumber BVA negative
        };
    }
    
    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getParamForTestSetHallNumberInvalid")
    public void testSetHallNumberInvalid(int hallNumber) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setHallNumber(hallNumber);
    }
    
    // CH_TC4_V001
    // Test method for setHallStatus (Valid input)
    private Object[] getParamForTestSetHallStatusValid(){
        return new Object[] {
            new Object[] {"Available", "Available"},
            new Object[] {"FullyBooked", "FullyBooked"},
            new Object[] {"NotAvailable", "NotAvailable"},
            new Object[] {"Repair", "Repair"}
        };
    }
    
    @Test
    @Parameters(method = "getParamForTestSetHallStatusValidTest")
    public void testSetHallStatusValid(String hallStatus, String ER) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setHallStatus(hallStatus);
        assertEquals(ER, cinemaHall.getHallStatus());
    }

    // CH_TC4_INV001
    // Test method for setHallStatus (Invalid input)
    private Object[] getParamForTestSetHallStatusInvalid(){
        return new Object[] {
            new Object[] {"Available", "Available"},
            new Object[] {"FullyBooked", "FullyBooked"},
            new Object[] {"NotAvailable", "NotAvailable"},
            new Object[] {"Repair", "Repair"}
        };
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHallStatusInvalid() {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setHallStatus(null);
    }
    
    // CH_TC5_V001
    // Test method for setAvailableSeats
    private Object[] getParamForTestSetAvailableSeatsValid(){
        return new Object[] {
            new Object[] {-25}, //hallNumber EP negative
            new Object[] {0},   //hallNumber BVA 0 
            new Object[] {-1},  //hallNumber BVA negative
        };
    }
    @Test
    @Parameters(method = "getParamForTestSetAvailableSeatsValid")
    public void testSetAvailableSeatsValid() {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setAvailableSeats(120);
        assertEquals(120, cinemaHall.getAvailableSeats());
    }

    //GETTERS AND SETTERS END
    
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
        CinemaHall HallSpy = spy(CinemaHall.class);
        when(HallSpy.getAvailableSeats()).thenReturn(availableSeats);
        assertEquals(ER, HallSpy.checkOversell(newTickets));
    }

    private Object[] getParamForCheckOversellInvalid(){
        return new Object[] {
            new Object[] {"Fully Booked", false, false},
            new Object[] {"Not Available", false, false},
            new Object[] {"under repair", false, false},
            new Object[] {"Available", true, false},
            new Object[] {"Available", false, false},
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

    private Object[] getParamsForTestHallAvailableInvalid(){
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
    public void testHallAvailableInvalid(String hallStatus, boolean oversell, boolean ER){
        CinemaHall hallSpy = spy(CinemaHall.class);
        when(hallSpy.getHallStatus()).thenReturn(hallStatus);
        when(hallSpy.checkOversell(anyInt())).thenReturn(oversell);
        hallSpy.hallAvailable(1);
    }

    // CH_TC8_IT001
    // Integration test for checkOversell (Valid input)
    @Test
    @Parameters(method = "getParamForCheckOversellValid")
    public void checkOversellIntegrationTest(int newTickets, int availableSeats, boolean ER){
        CinemaHall cinema = new CinemaHall(1, availableSeats);
        assertEquals(ER, cinema.checkOversell(newTickets));
    }

    // CH_TC9_V001
    // Test method for hallAvailable (Valid input)
    @Test
    @Parameters("Available, false, 25")
    public void hallAvailableValidTest(String hallStatus, boolean oversell, int tickets){
        CinemaHall mockHall = mock(CinemaHall.class);
        when(mockHall.getHallStatus()).thenReturn(hallStatus);
        when(mockHall.checkOversell(anyInt())).thenReturn(oversell);
        assertTrue(mockHall.hallAvailable(tickets));
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

    // CH_TC9_IT001
    // Integration Test for hallAvailable (Valid input)
    @Test
    @Parameters("5, 50, 25")
    public void hallAvailableIntegrationTest(int hallNumber, int availableSeats, int tickets){
        CinemaHall cinema = new CinemaHall(hallNumber, availableSeats);
        //hallStatus == "Available" from constructor
        //checkOversell(tickets) should return false because availableSeats > tickets
        cinema.hallAvailable(tickets);
    }
}
