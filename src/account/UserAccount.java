package account;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.lang.reflect.Type;
import java.io.*;

import booking.Booking;
import util.SystemMessage;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UserAccount extends Account{
  //instance variables
 private ArrayList<Booking> bookings;
 public ArrayList<Booking> getBookings()
 {
  return bookings;
 }

 public void setBookings(ArrayList<Booking> bookings)
 {
  this.bookings = bookings;
 }
 
 //overloaded constructor
 public UserAccount(String accountId, String name, String password, String registerDate) {
    super(accountId, name, password, registerDate);
    this.bookings = new ArrayList<Booking>();
 }

 public UserAccount(String accountId, String name, String password, String registerDate, ArrayList<Booking> bookings) {
  super(accountId, name, password, registerDate);
  setBookings(bookings);
}

 //static methods
 public static void login(ArrayList<Account> accounts)
 {
   boolean success = false;
   do
   {
    //entering details
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your account ID: ");
    String id = input.next();
    System.out.println("Enter your password: ");
    String pass = input.next();

    success = verifyLogin(accounts, id, pass);
    if (!success)
      SystemMessage.errorMessage(5);
    else
      SystemMessage.successMessage(4);

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

   //generating simple date formate in string
   Date date = new Date();
   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
   String dateString = simpleDateFormat.format(date);

   UserAccount user = new UserAccount(id, username, pass, dateString);

   return user;
 }

 public static ArrayList<UserAccount> getUsers()
 {
    Gson gson = new Gson();
    Type type = new TypeToken<ArrayList<UserAccount>>() {}.getType();

    String line = "";
    try
    {
      File inFile = new File("src\\resources\\user.json");
      Scanner inputFile = new Scanner(inFile);
      while(inputFile.hasNextLine())
      {
        line = inputFile.nextLine();
      }
      inputFile.close();
    }catch(IOException e)
    {
      SystemMessage.errorMessage(4);
    }

    ArrayList<UserAccount> userList = gson.fromJson(line, type);
    if (userList == null) {
        userList = new ArrayList<UserAccount>();
    }
   return userList;
 }

 public static void saveUsers(ArrayList<UserAccount> users)
 {
   Gson gson = new Gson();
   String toWrite = gson.toJson(users);

   try
   {
     File outFile = new File("src\\resources\\user.json");
     PrintWriter outputFile = new PrintWriter(outFile);
     outputFile.println(toWrite);
     outputFile.close();
   }catch(FileNotFoundException error)
   {
     SystemMessage.errorMessage(4);
   }

 }
}
