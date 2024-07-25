package Application;

public class CinemaHall {
    private String hallNumber;
    private int seats;
    private int availableSeats;
    private int bookedSeats;
    private String hallStatus;
    
    public CinemaHall(String hallNumber, int seats, String hallStatus) {
        this.hallNumber = hallNumber;
        this.seats = seats;
        this.availableSeats = seats;
        this.bookedSeats = 0;
        this.hallStatus = hallStatus;
    }

    //Getters
    public String getHallNumber() {
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
