package CinemaHall;

import java.util.ArrayList;
import java.util.Arrays;

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
        this.hallStatus = "Available";
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
        this.hallStatus = hallStatus;
    }
    
    //Methods
    public boolean checkOversell(int newTickets){
        return (newTickets > availableSeats); 
    }

    public boolean hallAvailable(int totalTicketQuantity){
        ArrayList<String> rejectList = new ArrayList<>(Arrays.asList("Fully Booked", "Not Available", "under repair"));
        if (rejectList.contains(this.getHallStatus())){
            System.out.println("Sorry, the hall is currently " + this.getHallStatus());
            return false;
        }
        else if (checkOversell(totalTicketQuantity)){
            System.out.println("The hall only has " + this.getAvailableSeats() + " seats left.");
            return false;
        }
        return true;
    }
}
