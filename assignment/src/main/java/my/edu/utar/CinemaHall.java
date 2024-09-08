package my.edu.utar;

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
        this.hallStatus = "Available"; //Fully Booked, Available, Not Available, Repair 
    }

    public CinemaHall() {
		// empty constructor
	}

	public static CinemaHall createCinemaHall(int hallNumber, int seats){
        if (hallNumber < 0 || seats < 0)
            throw new IllegalArgumentException("Negative double passed");
        if (seats < 50)
            throw new IllegalArgumentException("Seat number cannot be less than 50");
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
    
    public void setHallNumber(int number) {
    	this.hallNumber = number;
    }
    
    public void setHallStatus(String hallStatus) {
        if (!(hallStatus.equals("FullyBooked") && hallStatus.equals("Available") && hallStatus.equals("NotAvailable") && hallStatus.equals("Repair")))
            throw new IllegalArgumentException("Invalid hall status");
        this.hallStatus = hallStatus;
    }

    //Methods
    public boolean checkOversell(int newTickets){
        if (newTickets < 0)
            throw new IllegalArgumentException("Negative double passed");
        return (newTickets > getAvailableSeats()); 
    }

    public boolean hallAvailable(int totalTicketQuantity){
        ArrayList<String> rejectList = new ArrayList<>(Arrays.asList("Fully Booked", "Not Available", "under repair"));
        if (rejectList.contains(this.getHallStatus()))
            throw new IllegalArgumentException("Sorry, the hall is currently " + this.getHallStatus());
        else if (checkOversell(totalTicketQuantity))
            throw new IllegalArgumentException("The hall only has " + this.getAvailableSeats() + " seats left.");
        else
            return true;
    }
}
