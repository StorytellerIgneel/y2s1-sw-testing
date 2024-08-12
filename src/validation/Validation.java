package validation;

import account.*;
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
    public static boolean isNumber(String value) {
        try {
            Integer valueInt = Integer.parseInt(value);
            if (valueInt >= 0)
                return (true);
            else
                return false;
        } catch (NumberFormatException error) {
            return false;
        }
    }

    public static boolean isDouble(String value) {
        try {
            Double valueDouble = Double.parseDouble(value);
            if (valueDouble >= 0)
                return (true);
            else
                return false;
        } catch (NumberFormatException error) {
            return false;
        }
    }

    public static boolean isAlphaNumerical(String value) {
        return value.matches("^[a-zA-Z0-9()\\s]+$");
    }
    
    public static boolean isNull(String value) {
        return (value.equals(null) || value.equals(""));
    }

    public static boolean isWhiteSpace(String value) {
        return value.matches("^[\\s]+$");
    }

    public static boolean isNegativeNum (String value) {
        try {
            Double valueNegative = Double.parseDouble(value);
            if (valueNegative < 0)
                return (true);
            else
                return false;
        } catch (NumberFormatException error) {
            return false;
        }
    }

    public static boolean isRegisteredUser (ArrayList <Account> accounts, String name) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getName().equals(name))
                return true;
        }
            return false;
    }

    public static boolean isMovieCategory (String category){
        return category.equals("2D") || category.equals("3D") || category.equals("IMAX");
    }

    public static boolean isShowtimeStatus (String status) {
        return status.equals("Available") || status.equals(" NotAvailable") || status.equals("FullyBooked") || status.equals("Cancelled");
    }

    public static boolean isHalltimeHallstatus (String hallstatus) {
        return hallstatus.equals("FullyBooked") || hallstatus.equals("Available") || hallstatus.equals("NotAvailable") || hallstatus.equals("Repair");
    }

    public static boolean isValidEmail(String email) {
        // Email regular expression pattern
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Compile the regular expression pattern
        Pattern pattern = Pattern.compile(emailRegex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(email);

        // Return true if the email matches the pattern, otherwise false
        return matcher.matches();
    }

/*
    public static boolean isDuplicateUsername(String username)
    {
        ArrayList<Account> userList = Account.getName();
        for(Account user : userList)
        {
            if(user.getName().equals(username))
                return true;
        }
        return false;
    }
*/
}
