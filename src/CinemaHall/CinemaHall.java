package CinemaHall;

import java.util.ArrayList;
import java.util.Arrays;
import validation.Validation;

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

    public CinemaHall createCinemaHall(int hallNumber, int seats){
        if (seats < 50){
            System.out.println("Seat number cannot be less than 50");
            return null;
        }
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
        if (Validation.isHalltimeHallstatus(hallStatus))
            this.hallStatus = hallStatus;
        else
            System.out.println("Invalid hall status.");
        return;
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
