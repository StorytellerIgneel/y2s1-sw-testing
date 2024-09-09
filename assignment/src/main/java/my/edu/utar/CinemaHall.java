package my.edu.utar;

import java.util.ArrayList;
import java.util.Arrays;

public class CinemaHall {
    private int hallNumber;
    private int seats;
    private int availableSeats;
    private int bookedSeats;
    private String hallStatus;

    public CinemaHall(int hallNumber, int seats, int availableSeats, int bookedSeats) {
        this.hallNumber = hallNumber;
        this.seats = seats;
        this.availableSeats = availableSeats;
        this.bookedSeats = bookedSeats;
        this.hallStatus = "Available"; //Fully Booked, Available, Not Available, Repair 
    }

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
        if (hallNumber <= 0 || seats <= 0)
            throw new IllegalArgumentException("Hall number and seats must be more than 0");
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
        if (number <= 0)
            throw new IllegalArgumentException("Hall number must be more than 1");
        this.hallNumber = number;
    }
    
    public void setHallStatus(String hallStatus) {
        if (!(hallStatus.equals("FullyBooked") || hallStatus.equals("Available") || hallStatus.equals("NotAvailable") || hallStatus.equals("Repair")))
            throw new IllegalArgumentException("Invalid hall status");
        if (hallStatus == null || hallStatus == "")
            throw new IllegalArgumentException("Invalid hall status");
        this.hallStatus = hallStatus;
    }

    public void setSeats (int number) {
        if (number < 0)
            throw new IllegalArgumentException("Negative value passed for avaiable seats");
        if (number < 50)
            throw new IllegalArgumentException("Seat number cannot be less than 50");
        this.seats = number;
    }

    public void setAvailableSeats (int number) {
        if (number < 0)
            throw new IllegalArgumentException("Negative value passed for avaiable seats");
        if (number > getSeats())
            throw new IllegalArgumentException("Available seats cannot be more than seats");
        this.availableSeats = number;
    }

    public void setBookedSeats (int number) {
        if (number < 0)
            throw new IllegalArgumentException("Negative value passed for avaiable seats");
        if (number > getSeats())
            throw new IllegalArgumentException("booked seats cannot be more than seats");
        this.bookedSeats = number;
    }

    //Methods
    public boolean checkOversell(int newTickets) {
        if (newTickets < 0) {
            throw new IllegalArgumentException("Negative value passed");
        }
        if (newTickets == 0) {
            throw new IllegalArgumentException("New ticket value is 0");
        }
    
        int availableSeats = getAvailableSeats(); // Call once
        int totalSeats = getSeats();
    
        if (newTickets > totalSeats) {
            throw new IllegalArgumentException("Ticket more than original");
        } else if (newTickets <= availableSeats) {
            if (newTickets == availableSeats) {
                setHallStatus("FullyBooked");
            }
            setAvailableSeats(availableSeats - newTickets);
            setBookedSeats(getBookedSeats() + newTickets);
            return false; 
        } else {
            return true; // Oversell detected
        }
    }
    

    public boolean hallAvailable(int totalTicketQuantity){
        ArrayList<String> rejectList = new ArrayList<>(Arrays.asList("FullyBooked", "NotAvailable", "Repair"));
        if (rejectList.contains(this.getHallStatus()))
            return false;
        else if (checkOversell(totalTicketQuantity))
            return false;
        else
            return true;
    }
}
