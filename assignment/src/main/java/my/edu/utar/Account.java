package my.edu.utar;

// import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
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

  public static Account createAccount(String name, String email, int year, int month, int day) {
    Validation.isNull(name, email, birthday);
    Validation.isNegativeNum(year, month, day);
    Validation.isValidDate(year, month, day);
    Validation.isAlphaNumerical(name);
    Validation.isValidEmail(email);
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

  // setter methoids
  public void setName(String name) {
    Validation.isAlphaNumerical(name);
    this.name = name;
  }

  public void setEmail(String email) {
    Validation.isValidEmail(email);
    this.email = email;
  }

  
  public void setBirthDay(LocalDate birthday){
    this.birthday = birthday;
  }

    // getter methods
  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public LocalDate getBirthday(){
    return birthday;
  }
}
