package my.edu.utar;

import java.util.ArrayList;

/**
 * This class represents a booking made by a user.
 * 
 */
public class Booking {
    private String bookingId;
    private Account account;
    private Movie movie;
    private Showtime showtime;
    private int quantityAdult;
    private int quantityOKU;
    private int quantitySenior;
    private int quantityStudent;
    private int quantityChildren;
    private int totalNumberOfSeats;
    private double totalPrice;
    private String status;
    private String paymentStatus;

    public Booking(String bookingID, Account account, Movie movie, Showtime showtime, int quantityAdult, int quantityOKU, int quantitySenior, int quantityStudent, int quantityChildren) {
        this.bookingId = bookingID;
        this.account = account;
        this.movie = movie;
        this.showtime = showtime;
        this.quantityAdult = quantityAdult;
        this.quantityChildren = quantityChildren;
        this.quantityOKU = quantityOKU;
        this.quantitySenior = quantitySenior;
        this.quantityStudent = quantityStudent;
        this.totalNumberOfSeats = quantityAdult + quantityOKU + quantitySenior + quantityStudent + quantityChildren;
        this.totalPrice = calculateTotalPrice();
        this.status = "Booked";
    }

    public Booking() {
		// TODO Auto-generated constructor stub
	}

	public static Booking createBooking(String bookingID, Account account, Movie movie, Showtime showtime, int quantityAdult, int quantityOKU, int quantitySenior, int quantityStudent, int quantityChildren){
		if (bookingID == null || bookingID.isEmpty())
			throw new IllegalArgumentException("Null param passed");
		if (bookingID.equals(""))
			throw new IllegalArgumentException("Null param passed");
		if (account == null)
			throw new IllegalArgumentException("Null param passed");
		if (movie == null)
			throw new IllegalArgumentException("Null param passed");
		if (showtime == null)
			throw new IllegalArgumentException("Null param passed");
        if (!showtime.getMovie().equals(movie))
            throw new IllegalArgumentException("Movie does not contain this showtime");
        if ((quantityAdult + quantityChildren + quantityOKU + quantitySenior + quantityStudent) == 0)
            throw new IllegalArgumentException("No tickets booked.");
        if (quantityAdult < 0 || quantityOKU < 0 || quantitySenior < 0 || quantityStudent < 0 || quantityChildren < 0)
            throw new IllegalArgumentException("Negative double passed");
       
        boolean userIsRegistered = false;

        Account kira = new Account("Kira Yamato", "kira.yamato@gundamseed.com", 2004, 5, 18);
        Account lacus = new Account("Lacus Clyne", "lacus.clyne@gundamseed.com", 2004, 2, 29);
        Account athrun = new Account("Athrun Zala", "athrun.zala@gundamseed.com", 2004, 10, 29);
        Account cagalli = new Account("Cagalli Yula Athha", "cagalli.athha@gundamseed.com", 2004, 11, 18);

        // Add them to an ArrayList
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(kira);
        accounts.add(lacus);
        accounts.add(athrun);
        accounts.add(cagalli);
        
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getName().equals(account.getName()))
                userIsRegistered = true;
        }
        if (userIsRegistered == false)
            throw new IllegalArgumentException("User not registered");
        
        return new Booking(bookingID, account, movie, showtime, quantityAdult, quantityOKU, quantitySenior, quantityStudent, quantityChildren);
    }

    /* Accessors */
    public String getBookingId() {
        return bookingId;
    }

	public void setBookingId(String bookingId) {
		if(bookingId == null)
			throw new IllegalArgumentException("Null param passed");
        if (bookingId.equals("")||bookingId.isEmpty())
        	throw new IllegalArgumentException("Empty string param passed");
		this.bookingId = bookingId;
	}
	
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
    	if(account == null)
    		throw new IllegalArgumentException("Null param passed");
        this.account = account;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
    	if(movie == null)
    		throw new IllegalArgumentException("Null param passed");
        this.movie = movie;
    }

    public Showtime getShowtime() {
            return showtime;
    }

    public void setShowtime(Showtime showtime) {
    	if(showtime == null)
    		throw new IllegalArgumentException("Null param passed");
        this.showtime = showtime;
    }

    //Getter and Setter for quantityAdult
    public int getQuantityAdult() {
        return quantityAdult;
    }

    public void setQuantityAdult(int quantityAdult) {
        if(quantityAdult < 0)
        	throw new IllegalArgumentException("Negative quantity passed");
        this.quantityAdult = quantityAdult;
    }

    // Getter and Setter for quantityOKU
    public int getQuantityOKU() {
        return quantityOKU;
    }

    public void setQuantityOKU(int quantityOKU) {
    	if(quantityOKU < 0)
        	throw new IllegalArgumentException("Negative quantity passed");
        this.quantityOKU = quantityOKU;
    }

    // Getter and Setter for quantitySenior
    public int getQuantitySenior() {
        return quantitySenior;
    }

    public void setQuantitySenior(int quantitySenior) {
    	if(quantitySenior < 0)
        	throw new IllegalArgumentException("Negative quantity passed");
        this.quantitySenior = quantitySenior;
    }

    // Getter and Setter for quantityStudent
    public int getQuantityStudent() {
        return quantityStudent;
    }

    public void setQuantityStudent(int quantityStudent) {
    	if(quantityStudent < 0)
        	throw new IllegalArgumentException("Negative quantity passed");
        this.quantityStudent = quantityStudent;
    }

    // Getter and Setter for quantityChildren
    public int getQuantityChildren() {
        return quantityChildren;
    }

    public void setQuantityChildren(int quantityChildren) {
    	if(quantityChildren < 0)
        	throw new IllegalArgumentException("Negative quantity passed");
        this.quantityChildren = quantityChildren;
    }

    // Getter and Setter for totalNumberOfSeats
    public int getTotalNumberOfSeats() {
        return totalNumberOfSeats;
    }

    public void setTotalNumberOfSeats(int totalNumberOfSeats) {
    	if(totalNumberOfSeats < 0)
        	throw new IllegalArgumentException("Negative quantity passed");
        this.totalNumberOfSeats = totalNumberOfSeats;
    }

    // Getter and Setter for totalPrice
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
    	if(totalPrice < 0)
        	throw new IllegalArgumentException("Negative quantity passed");
        this.totalPrice = totalPrice;
    }


    public String getStatus(){
        return status;
    }

    public void setStatus(String status) {
    	if(status == null)
        	throw new IllegalArgumentException("Null param passed"); 
        if(status.equals(""))
        	throw new IllegalArgumentException("Empty string param passed");
        if(!status.equals("Booked") && 
        		!status.equals("Payment Successful") &&
        		!status.equals("Payment Unsuccessful") &&
        		!status.equals("Cancelled"))
        	throw new IllegalArgumentException ("invalid status passed");
        this.status = status;
    }
    /**
     * This method returns the total price of the booking.
     * Serves as the core of the entire system
     * @return double
     */
    public double calculateTotalPrice() {
        double addOn = (movie.isExpensive()? 1: 0) * 4;
        return (calculateAdultTicketPrice(addOn) + calculateOKUTicketPrice(addOn) + calculateSeniorTicketPrice(addOn) + calculateStudentTicketPrice(addOn) + calculateChildrenTicketPrice(addOn));
    }

    public double calculateAdultTicketPrice(double addOn){
        return (quantityAdult * (showtime.getNormalTicketPrice() + addOn));
    }

    public double calculateOKUTicketPrice(double addOn){
        return (quantityOKU * (showtime.getNormalTicketPrice() * 0.95 + addOn));
    }

    public double calculateSeniorTicketPrice(double addOn){
        return (quantitySenior * (((showtime.getNormalTicketPrice() > 9)? 9 : showtime.getNormalTicketPrice()) + addOn));
    }

    public double calculateStudentTicketPrice(double addOn){
        return quantityStudent * (((showtime.getTime().getHour() < 18)? 9 : showtime.getNormalTicketPrice()) + addOn);
    }

    public double calculateChildrenTicketPrice(double addOn){
        return quantityChildren * (((showtime.getNormalTicketPrice() > 9)? 9 : showtime.getNormalTicketPrice()) + addOn);
    }

    public String updatePaymentStatus (int bookingID, String paymentStatus){
        this.paymentStatus = paymentStatus;
    }

}
