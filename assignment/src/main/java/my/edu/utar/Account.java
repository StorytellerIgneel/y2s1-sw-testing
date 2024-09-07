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
  public Account(String name, String email,  Integer year, Integer month, Integer day ) {
    this.name = name;
    this.email = email;
    this.birthday = LocalDate.of(year, month, month);
  }

  public Account() {
	  //empty constructor
  }

  public Account() {
	  //empty constructor
  }

  public static Account createAccount(String name, String email, Integer year, Integer month, Integer day) {
    Validation.isNull(name, email, year, month, day);
    Validation.isNegativeNum(year, month, day); //redundant
    Validation.isValidDate(year, month, day);
    Validation.isAlphaNumerical(name);
    Validation.isValidEmail(email);
    Validation.isInteger(year, month, day);
    return new Account(name, email, year, month, day);
  }

  // setter methoids
  public void setName(String name) {
	  if (name == null || name.isEmpty())
	      throw new IllegalArgumentException("Null param passed");
	  if (name.equals(""))
	      throw new IllegalArgumentException("Empty String passed");
	  if (!name.matches("^[a-zA-Z0-9()\\s]+$"))
	      throw new IllegalArgumentException("Only alphanumerical value allowed");
	  this.name = name;
  }

  public void setEmail(String email) {
	  if (email == null || email.isEmpty())
	      throw new IllegalArgumentException("Null param passed");
	  if (email.equals(""))
	      throw new IllegalArgumentException("Empty String passed");
	  // Email regular expression pattern
      String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

      // Compile the regular expression pattern
      Pattern pattern = Pattern.compile(emailRegex);

      // Create a Matcher object
      Matcher matcher = pattern.matcher(email);

      // Return true if the email matches the pattern, otherwise false
      if (!matcher.matches())
          throw new IllegalArgumentException("Invalid email");
      this.email = email;
  }

  
  public void setBirthDay(int year, int month, int day) {
	LocalDate birthday;
	
	// Check for valid year
	if (year < 1900 || year > LocalDate.now().getYear())
	    throw new IllegalArgumentException("Invalid year");
	
	// Check for valid month
	if (month < 1 || month > 12)
	    throw new IllegalArgumentException("Invalid month");
	
	// Check for valid day in the given month and year
	YearMonth yearMonth = YearMonth.of(year, month);
	if (day <= 0 || day > yearMonth.lengthOfMonth())
	    throw new IllegalArgumentException("Invalid day");
	
	try {
	    birthday = LocalDate.of(year, month, day); // This may throw DateTimeException
	} catch (DateTimeException e) {
	    throw new IllegalArgumentException("Invalid date value");
	}
	
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
