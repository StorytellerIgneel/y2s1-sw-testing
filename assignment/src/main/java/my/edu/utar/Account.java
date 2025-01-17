package my.edu.utar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.YearMonth;


public class Account {
  // instance variables to be inherited
  private String name;
  private String email;
  private LocalDate birthday;

  public Account(){}
  
  // constructor
  public Account(String name, String email,  int year, int month, int day ) {
    this.name = name;
    this.email = email;
    this.birthday = LocalDate.of(year, month, month);
  }

  public static Account createAccount(String name, String email, int year, int month, int day) {
	    // Check if any of the inputs are null
	    if (name == null || email == null || year == 0 || month == 0 || day == 0) {
	        throw new IllegalArgumentException("Null or invalid parameter passed.");
	    }

	    // Validate the date
	    if (year < 1900 || year > LocalDate.now().getYear()) {
	        throw new IllegalArgumentException("Invalid year");
	    }
	    if (month < 1 || month > 12) {
	        throw new IllegalArgumentException("Invalid month");
	    }
	    YearMonth yearMonth = YearMonth.of(year, month);
	    if (day <= 0 || day > yearMonth.lengthOfMonth()) {
	        throw new IllegalArgumentException("Invalid day");
	    }

	    // Validate if the name contains only alphanumerical characters
	    if (!name.matches("^[a-zA-Z0-9()\\s]+$")) {
	        throw new IllegalArgumentException("Only alphanumerical value allowed");
	    }

	    // Validate the email format
	    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	    Pattern pattern = Pattern.compile(emailRegex);
	    Matcher matcher = pattern.matcher(email);
	    if (!matcher.matches()) {
	        throw new IllegalArgumentException("Invalid email");
	    }

	    // Return the new account after validation
	    return new Account(name, email, year, month, day);
	}


  // setter methods
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
      String emailRegex = "^[a-zA-Z0-9_+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

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
}