package my.edu.utar;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    /**
     * Checks if a given string is a number.
     * 
     * @param value the string to be checked
     * @return true if the string is a number, false otherwise
     */
    public static void isInteger(Object... values) {
        for (Object value : values) {
            if (!(value instanceof Integer))
                throw new IllegalArgumentException("The parameter passed should be strictly an Integer");
        }
    }

    public static void isAlphaNumerical(String value) {
        if (!value.matches("^[a-zA-Z0-9()\\s]+$"))
            throw new IllegalArgumentException("Only alphanumerical value allowed");
    }

    public static void isValidMovieName(String value) {
        if (!value.matches("[ '.,\\:\\-a-zA-Z0-9()\\s]+$"))
            throw new IllegalArgumentException("Invalid movie name");
    }
    
    public static void isNull(String value) {
        if (value == null || value.isEmpty())
            throw new IllegalArgumentException("Null param passed");
    }

    public static void isNull(Object... params) {
        for (Object param : params) {
            if (param == null) 
                throw new IllegalArgumentException("Null parameter passed.");
        }
    }

    public static void isWhiteSpace(String value) {
        if (value.matches("^[\\s]+$"))
            throw new IllegalArgumentException("Only whitespace characters passed");
    }

    public static void isNegativeNum (Double value) {
        if (value < 0)
            throw new IllegalArgumentException("Negative double passed");
    }

    //overload
    public static void isNegativeNum (int value) {
        if (value < 0)
            throw new IllegalArgumentException("Negative integer passed");
    }

    //overload again
    public static void isNegativeNum (int... values) {
        for (int value : values) {
            if (value < 0) 
                throw new IllegalArgumentException("Negative param passed.");
        }
    }

    public static void comboValidString(String value){
        Validation.isAlphaNumerical(value);
        Validation.isNull(value);
        Validation.isWhiteSpace(value);
    }

    public static void comboValidMovie(String value){
        Validation.isValidMovieName(value);
        Validation.isNull(value);
        Validation.isWhiteSpace(value);
    }

    public static void isRegisteredUser (String name) {
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
            if (accounts.get(i).getName().equals(name))
                userIsRegistered = true;
        }
        if (userIsRegistered == false)
            throw new IllegalArgumentException("User not registered");
    }

    public static void isMovieCategory (String category){
        if(!category.equals("Normal") && !category.equals("3D") && !category.equals("IMAX"))
            throw new IllegalArgumentException("Invalid movie category");
    }

    public static void isShowtimeStatus(String status) {
        if (!status.equals("Available") && !status.equals("NotAvailable") && !status.equals("FullyBooked") && !status.equals("Cancelled")) {
            throw new IllegalArgumentException("Invalid showtime status");
        }
    }
    
    public static void isHalltimeHallstatus(String hallstatus) {
        if (!hallstatus.equals("FullyBooked") && !hallstatus.equals("Available") && !hallstatus.equals("NotAvailable") && !hallstatus.equals("Repair")) {
            throw new IllegalArgumentException("Invalid hall status");
        }
    }

    public static void isValidEmail(String email) {
        // Email regular expression pattern
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Compile the regular expression pattern
        Pattern pattern = Pattern.compile(emailRegex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(email);

        // Return true if the email matches the pattern, otherwise false
        if (!matcher.matches())
            throw new IllegalArgumentException("Invalid email");
    }

    public static void isValidDate(int year, int month, int day) {    
        LocalDate birthday;    
        // Check for valid month
        if (month < 1 || month > 12)
            throw new IllegalArgumentException("Invalid month");
        
        // Check for valid day in the given month and year
        YearMonth yearMonth = YearMonth.of(year, month);
        if (day <= 0 || day > yearMonth.lengthOfMonth())
            throw new IllegalArgumentException("Invalid day");
        
        try { //this is somewhat redundant but ill just leave it
            birthday = LocalDate.of(year, month, day); // This may throw DateTimeException
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("Invalid date value");
        }

        return;
    }
}