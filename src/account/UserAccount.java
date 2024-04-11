package account;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.lang.reflect.Type;
import java.io.*;

import booking.Booking;
import ui.MovieCRUDGeneralPage;
import ui.UserMainMenu;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import util.*;
import color.Color;

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
 public UserAccount(String accountId, String name, String password, String registerDate, String email, String phoneNo) {
    super(accountId, name, password, registerDate, email, phoneNo);
    this.bookings = new ArrayList<Booking>();
 }

 public UserAccount(String accountId, String name, String password, String registerDate, ArrayList<Booking> bookings, String email, String phoneNo) {
  super(accountId, name, password, registerDate, email, phoneNo);
  setBookings(bookings);
}

 //static methods
 public static int login(ArrayList<Account> accounts)
 {
   int index = 0;
   CommonIcon.printHeader();
   System.out.println("Login: \n");
   do
   {
    //entering details
    Scanner input = new Scanner(System.in);
    System.out.print("Enter your username (':b' to back, ':q' to quit): ");
    String name = input.nextLine();

    if(Validation.isBack(name))
      return -1;
    if(Validation.isQuit(name))
      return -2;

    System.out.print("Enter your password (':b' to back, ':q to quit'): ");
    String pass = input.next();

    if(Validation.isBack(pass))
      return -1;
    if(Validation.isQuit(pass))
      return -2;

    index = verifyLogin(accounts, name, pass);
    if (index == -1)
      SystemMessage.errorMessage(5);
    else
      SystemMessage.successMessage(4);

   }while (index == -1);
   
   try
    {
        Util.clearConsole();
    }
    catch(IOException e)
    {
        e.printStackTrace();
    }
    catch(InterruptedException e)
    {
        e.printStackTrace();
    }
    return index; //return the user index for tracking user activities
 }

 public static UserAccount register()
 {
    CommonIcon.printHeader();
    System.out.println("Register: \n");
    //entering details
    Scanner input = new Scanner(System.in);
    System.out.print("Enter your account ID (':b' to back, ':q to quit'): ");
    String id = input.next();

    if(Validation.isBack(id))
      return null;
    if(Validation.isQuit(id))
    {
      try
      {
          Util.clearConsole();
      }
      catch(IOException | InterruptedException e)
      {
          e.printStackTrace();
      }
      CommonIcon.printHeader();
      input.close();
      System.out.print(Color.lime);
      System.out.println("Thank you for using TVG Cinemas.");
      System.out.println("Vist Us Next Time.");
      System.out.print(Color.reset);
      System.exit(0);
    }

    input.nextLine(); //eliminate whitespace
    System.out.print("Enter your name (':b' to back, ':q to quit'): ");
    String username = input.nextLine();

    if(Validation.isBack(username))
      return null;
    if(Validation.isQuit(username))
    {
      try
      {
          Util.clearConsole();
      }
      catch(IOException | InterruptedException e)
      {
          e.printStackTrace();
      }
      CommonIcon.printHeader();
      input.close();
      System.out.print(Color.lime);
      System.out.println("Thank you for using TVG Cinemas.");
      System.out.println("Vist Us Next Time.");
      System.out.print(Color.reset);
      System.exit(0);
    }

    System.out.print("Enter your password (':b' to back, ':q to quit'): ");
    String pass = input.next();

    if(Validation.isBack(pass))
      return null;
    if(Validation.isQuit(pass))
    {
      try
      {
          Util.clearConsole();
      }
      catch(IOException | InterruptedException e)
      {
          e.printStackTrace();
      }
      CommonIcon.printHeader();
      input.close();
      System.out.print(Color.lime);
      System.out.println("Thank you for using TVG Cinemas.");
      System.out.println("Vist Us Next Time.");
      System.out.print(Color.reset);
      System.exit(0);
    }

    System.out.print("Enter your email (':b' to back, ':q to quit'): ");
    String email = input.next();

    if(Validation.isBack(email))
      return null;
    if(Validation.isQuit(email))
    {
      try
      {
          Util.clearConsole();
      }
      catch(IOException | InterruptedException e)
      {
          e.printStackTrace();
      }
      CommonIcon.printHeader();
      input.close();
      System.out.print(Color.lime);
      System.out.println("Thank you for using TVG Cinemas.");
      System.out.println("Vist Us Next Time.");
      System.out.print(Color.reset);
      System.exit(0);
    }

    System.out.print("Enter your phone number (':b' to back, ':q to quit'): ");
    String phoneNo = input.next();

    if(Validation.isBack(phoneNo))
      return null;
    if(Validation.isQuit(phoneNo))
    {
      try
      {
          Util.clearConsole();
      }
      catch(IOException | InterruptedException e)
      {
          e.printStackTrace();
      }
      CommonIcon.printHeader();
      input.close();
      System.out.print(Color.lime);
      System.out.println("Thank you for using TVG Cinemas.");
      System.out.println("Vist Us Next Time.");
      System.out.print(Color.reset);
      System.exit(0);
    }

    //generating simple date formate in string
    Date date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String dateString = simpleDateFormat.format(date);

    UserAccount user = new UserAccount(id, username, pass, dateString, email, phoneNo);

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
