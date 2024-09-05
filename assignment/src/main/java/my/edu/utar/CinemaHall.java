package my.edu.utar;

import java.util.ArrayList;
import java.util.Arrays;

import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal;

public class CinemaHall {
    private int hallNumber;
    private int seats;
    private int availableSeats;
    private int bookedSeats;
    private String hallStatus;

    public CinemaHall(int hallNumber, int seats) {
        this.hallNumber = hallNumber;
        this.seats = seats;
        this.availableSeats = seats;
        this.bookedSeats = 0;
        this.hallStatus = "Available"; //Fully Booked, Available, Not Available, Repair 
    }

    public static CinemaHall createCinemaHall(int hallNumber, int seats){
        Validation.isNull(hallNumber,seats);
        Validation.isNegativeNum(hallNumber);
        Validation.isNegativeNum(seats);
        if (seats < 50)
            throw new IllegalArgumentException("Seat number cannot be less than 50");
        else
            return new CinemaHall(hallNumber, seats);
    }

    //Getters
    public int getHallNumber() {
        return hallNumber;
    }

    public int getSeats() {
        return seats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public String getHallStatus() {
        return hallStatus;
    }

    //Setters
    public void setHallStatus(String hallStatus) {
        Validation.isHalltimeHallstatus(hallStatus);
        this.hallStatus = hallStatus;
    }
    
    //Methods
    public boolean checkOversell(int newTickets){
        Validation.isNegativeNum(newTickets);
        return (newTickets > getAvailableSeats()); 
    }

    public boolean hallAvailable(int totalTicketQuantity){
        ArrayList<String> rejectList = new ArrayList<>(Arrays.asList("Fully Booked", "Not Available", "under repair"));
        if (rejectList.contains(this.getHallStatus()))
            throw new IllegalArgumentException("Sorry, the hall is currently " + this.getHallStatus());
        else if (checkOversell(totalTicketQuantity))
            throw new IllegalArgumentException("The hall only has " + this.getAvailableSeats() + " seats left.");
        return true;
    }
}
