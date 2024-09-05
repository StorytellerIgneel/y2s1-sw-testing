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
  public Account(String name, String email,  int year, int month, int day ) {
    this.name = name;
    this.email = email;
    this.birthday = LocalDate.of(year, month, month);
  }

  public static Account createAccount(String name, String email, int year, int month, int day) {
    Validation.isNull(name, email, year, month, day);
    Validation.isNegativeNum(year, month, day);
    Validation.isValidDate(year, month, day);
    Validation.isAlphaNumerical(name);
    Validation.isValidEmail(email);
    return new Account(name, email, year, month, day);
  }

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
