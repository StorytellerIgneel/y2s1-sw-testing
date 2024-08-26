package my.edu.utar.account;

// import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import my.edu.utar.booking.Booking;
import my.edu.utar.validation.*;
import java.io.*;
import java.time.LocalDate;


public class Account {
  // instance variables to be inherited
  private String name;
  private String email;
  private LocalDate birthday;

  // constructor
  public Account(String name, String email, LocalDate birthday) {
    this.name = name;
    this.email = email;
    this.birthday = birthday;
  }

  public Account createAccount(String name, String email, LocalDate birthday) {
    if (!Validation.isAlphaNumerical(name))
    {
      System.out.println("Name should only contain alphabets and numbers.");
      return null;
    }
    if (!Validation.isValidEmail(email)){
      System.out.println("Invalid email format.");
      return null;
    }
    return new Account(name, email, birthday);
  }

   // Method to generate a unique account ID
   /*
  public static String generateAccountId() {
      // Generate a random UUID (Universally Unique Identifier)
      // and remove hyphens to make it shorter
      String uuid = UUID.randomUUID().toString().replaceAll("-", "");
      // Extract the first 8 characters to create a shorter ID
      return uuid.substring(0, 8);
  }
      */

  // getter methods
  public String getName() {
    return name;
  }

  // setter methoids
  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public LocalDate getBirthday(){
    return birthday;
  }

  public void setBirthDay(LocalDate birthday){
    this.birthday = birthday;
  }
}
