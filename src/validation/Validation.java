package validation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import account.Account;

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

    public static boolean isBack(String value) {
        return (value.equals(":b") || value.equals(":B"));
    }

    public static boolean isQuit(String value) {
        return (value.equals(":q") || value.equals(":Q"));
    }
    
    public static boolean isNull(String value) {
        return (value.equals(null) || value.equals(""));
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
        //ArrayList<Account> userList = Account.getName();
        for(Account user : userList)
        {
            if(user.getName().equals(username))
                return true;
        }
        return false;
    }
    */
}
