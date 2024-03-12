import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class UserAccount extends Account{
 //instance variables
//  private Booking[] bookings;
 private ArrayList<Booking> bookings;

 //constructor
 public UserAccount(String accountId, String name, String password, String registerDate) {
    super(accountId, name, password, registerDate);
    this.bookings = new ArrayList<Booking>();
 }

 //static methods
 public static void login(ArrayList<UserAccount> accounts)
 {
   boolean success;
   do
   {
    //entering details
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your account ID: ");
    String id = input.next();
    System.out.println("Enter your password: ");
    String pass = input.next();
    input.close();
    success = verifyLogin(accounts, id, pass);
   }while (!success);
   
 }

 public static UserAccount register()
 {
   //entering details
   Scanner input = new Scanner(System.in);
   System.out.print("Enter your account ID: ");
   String id = input.next();
   input.nextLine(); //eliminate whitespace
   System.out.print("Enter your name: ");
   String username = input.nextLine();
   System.out.print("Enter your password: ");
   String pass = input.next();
   input.close();

   //generating simple date formate in string
   Date date = new Date();
   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
   String dateString = simpleDateFormat.format(date);

   UserAccount user = new UserAccount(id, username, pass, dateString);

   return user;
 }
}
