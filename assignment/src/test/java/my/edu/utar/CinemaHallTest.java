package my.edu.utar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
    @Parameters(method = "getParamForTestCreateCinemaHallValid")
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
    @Parameters(method = "getParamForTestSetHallNumberValid")
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
    @Parameters(method = "getParamForTestSetHallStatusValid")
    public void testSetHallStatusValid(String hallStatus, String ER) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setHallStatus(hallStatus);
        assertEquals(ER, cinemaHall.getHallStatus());
    }

    // CH_TC4_INV001
    // Test method for setHallStatus (Invalid input)
    private Object[] getParamForTestSetHallStatusInvalid(){
        return new Object[] {
            //new Object[] {null},
            new Object[] {""},
            new Object[] {"random status"},
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getParamForTestSetHallStatusInvalid")
    public void testSetHallStatusInvalid(String hallStatus) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setHallStatus(hallStatus);
    }
    
    
    

    // CH_TC5_V001
    // Test method for setAvailableSeats
    private Object[] getParamForTestSetAvailableSeatsValid(){
        return new Object[] {
            new Object[] {100, 200, 100}, //available seats EP 
            new Object[] {51, 100, 51},   //available seats BVA
        };
    }
    @Test
    @Parameters(method = "getParamForTestSetAvailableSeatsValid")
    public void testSetAvailableSeatsValid(int availableSeats, int seats, int ER) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setSeats(seats);
        cinemaHall.setAvailableSeats(availableSeats);
        assertEquals(ER, cinemaHall.getAvailableSeats());
    }

    private Object[] getParamForTestSetAvailableSeatsInvalid(){
        return new Object[] {
            new Object[] {-25, 50}, //AvailableSeats EP negative
            //new Object[] {0, 50},   //AvailableSeats BVA 0 
            new Object[] {-1, 50},  //AvailableSeats BVA negative
            new Object[] {50, 25}, //AvailableSeats > 
        };
    }
    @Test (expected = IllegalArgumentException.class)
    @Parameters(method = "getParamForTestSetAvailableSeatsInvalid")
    public void testSetAvailableSeatsInvalid(int availableSeats, int seats) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setSeats(seats);
        cinemaHall.setAvailableSeats(availableSeats);
    }

    //CH_TC6_V001
    //Test method for setSeats (Valid Input)
    private Object[] getParamForTestSetSeatsValid(){
        return new Object[] {
            new Object[] {100, 100}, //available seats EP 
            new Object[] {51, 51},   //available seats BVA
        };
    }
    @Test
    @Parameters(method = "getParamForTestSetSeatsValid")
    public void testSetSeatsValid(int availableSeats, int ER) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setSeats(availableSeats);
        assertEquals(ER, cinemaHall.getSeats());
    }
    
    private Object[] getParamForTestCheckOversellValid(){
        return new Object[] {
            new Object[] {26, 25, 25, 50, true},
            new Object[] {51, 50, 75, 125, true},
            new Object[] {25, 50, 25, 75, false},
            new Object[] {25, 20, 20, 40, true},
            new Object[] {1, 50, 50, 100, false},
            new Object[] {1, 1, 100, 101, false}
        };
    }
    // CH_TC8_V001
    // Test method for checkOversell (Valid input)
    @Test
    @Parameters(method = "getParamForTestCheckOversellValid")
    public void testCheckOversellValid(int newTickets, int availableSeats, int bookedSeats, int totalSeats, boolean ER) {
        CinemaHall HallSpy = spy(CinemaHall.class);
        when(HallSpy.getAvailableSeats()).thenReturn(availableSeats);
        when(HallSpy.getBookedSeats()).thenReturn(bookedSeats);
        when(HallSpy.getSeats()).thenReturn(totalSeats);
        
        boolean oversellSpy = HallSpy.checkOversell(newTickets);
        
        // Verify the expected interactions
        if (newTickets <= availableSeats) {
            if (newTickets == availableSeats) {
                verify(HallSpy).setHallStatus("FullyBooked");
                assertEquals("FullyBooked", HallSpy.getHallStatus());
            }
            verify(HallSpy).setAvailableSeats(availableSeats - newTickets);
            verify(HallSpy).setBookedSeats(bookedSeats + newTickets);
        }
        
        // Verify the number of calls to getAvailableSeats()
        verify(HallSpy, times(1)).getAvailableSeats(); // Adjust the number of times based on your implementation

        assertEquals(ER, oversellSpy);
    }


    private Object[] getParamForTestCheckOversellInvalid(){
        return new Object[] {
            new Object[] {-1, 50, 25, 75},
            new Object[] {0, 20, 20, 100},
            new Object[] {500, 50, 50, 100},
        };
    }
    // CH_TC8_INV001
    // Test method for checkOversell (Invalid input)
    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getParamForTestCheckOversellInvalid")
    public void testCheckOversellInvalid(int newTickets, int availableSeats, int bookedSeats, int totalSeats){
        CinemaHall HallSpy = spy(CinemaHall.class);
        when(HallSpy.getAvailableSeats()).thenReturn(availableSeats);
        when(HallSpy.getBookedSeats()).thenReturn(bookedSeats);
        when(HallSpy.getSeats()).thenReturn(totalSeats);
        HallSpy.checkOversell(newTickets);
    }

    // CH_TC8_IT001
    // Integration test for checkOversell (Valid input)
    // @Test
    @Parameters(method = "getParamForTestCheckOversellValid")
    public void testCheckOversellIntegrationValid(int newTickets, int availableSeats, int bookedSeats, int totalSeats, boolean ER){
        CinemaHall cinema = new CinemaHall(1, availableSeats, bookedSeats, totalSeats);
        assertEquals(ER, cinema.checkOversell(newTickets));
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getParamForTestCheckOversellInvalid")
    public void testCheckOversellIntegrationInvalid(int newTickets, int availableSeats, int bookedSeats, int totalSeats){
        CinemaHall cinema = new CinemaHall(1, availableSeats, bookedSeats, totalSeats);
        cinema.checkOversell(newTickets);
    }

    // //hallAvailable

    // //hall available
    private Object[] getParamsForTestHallAvailableInvalid(){
        return new Object[] {
            new Object[] {"FullyBooked", true},
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getParamsForTestHallAvailableInvalid")
    public void testHallAvailableInvalid(String hallStatus, boolean oversell){
        CinemaHall hallSpy = spy(CinemaHall.class);
        when(hallSpy.getHallStatus()).thenReturn(hallStatus);
        when(hallSpy.checkOversell(anyInt())).thenReturn(oversell);
        hallSpy.hallAvailable(1);
    }

    // CH_TC9_V001
    // Test method for hallAvailable (Valid input)
    private Object[] getParamsForTestHallAvailableValid(){
        return new Object[] {
            new Object[] {"Available", false, true},
            new Object[] {"FullyBooked", false, false},
            new Object[] {"NotAvailable", false, false},
            new Object[] {"Repair", false, false},
        };
    }

    @Test
    @Parameters(method = "getParamsForTestHallAvailableValid")
    public void testHallAvailableValid(String hallStatus, boolean oversell, boolean expected) {
        // Create a spy of CinemaHall
        CinemaHall hallSpy = spy(new CinemaHall());

        // Stub methods to return specific values
        doReturn(hallStatus).when(hallSpy).getHallStatus();
        doReturn(oversell).when(hallSpy).checkOversell(anyInt());

        // Execute the method to test
        assertEquals(expected, hallSpy.hallAvailable(1));
    }


    //CH_TC9_IT001
    //Integration Test for hallAvailable (Valid input)
    private Object[] getParamsForTestHallAvailableIntegrationValid(){
        return new Object[] {
            new Object[] {"Available", 25, 50, 25, 75, true},
            new Object[] {"FullyBooked", 25, 20, 20, 100, false},
            new Object[] {"NotAvailable", 1, 50, 50, 100, false},
            new Object[] {"Repair", 1, 1, 100, 101, false},
        };
    }

    @Test
    @Parameters(method = "getParamsForTestHallAvailableIntegrationValid")
    public void testHallAvailableIntegrationValid(String hallStatus, int newTickets, int availableSeats, int bookedSeats, int totalSeats, boolean ER){
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setHallStatus(hallStatus);
        cinemaHall.setSeats(totalSeats);
        cinemaHall.setAvailableSeats(availableSeats);
        cinemaHall.setBookedSeats(bookedSeats);
        

        assertEquals(ER, cinemaHall.hallAvailable(newTickets));
    }
}
