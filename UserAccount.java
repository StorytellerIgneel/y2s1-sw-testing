import java.util.ArrayList;
import java.util.Date;

public class UserAccount extends Account{
 //instance variables
//  private Booking[] bookings;
 private ArrayList<Booking> bookings;

 //constructor
 public UserAccount(String accountId, String name, String password, Date registerDate, ArrayList<Booking> bookings) {
    super(accountId, name, password, registerDate);
    this.bookings = new ArrayList<Booking>();
 }

 //instance method
 public void login()
 {

 }

 public void register()
 {

 }
}
