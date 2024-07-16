package CinemaHall;

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
}
