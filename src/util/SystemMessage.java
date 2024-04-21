package util;

import java.util.Scanner;

import color.Color;

/**
 * This class provides static methods for displaying error and success messages to the user. The
 * messages are displayed in red for error and are based on a given error index. The messages are
 * displayed in lime for success and are based on a given success index.
 */
public class SystemMessage {
    /**
     * This method displays an error message based on the given error index. The error messages are
     * defined in the class and are based on a given index. The method displays the message in red
     * and then waits for the user to press enter before returning.
     *
     * @param errorIndex the index of the error message to display
     * @param input the scanner used for waiting for the user to press enter
     */
    public static void errorMessage(int errorIndex, Scanner input) {
        System.out.println();
        System.out.print(Color.RED);
        switch (errorIndex) {
            case 1:
                System.out.println("Please enter a valid number."); // used
                break;
            case 2:
                System.out.println("Please enter a valid index. This index is not available."); // used
                break;
            case 3:
                System.out
                        .println("The file movieData.txt is not present in the current directory."); // used
                break;
            case 4:
                System.out.println("The file user.json is not found.");// used
                break;
            case 5:
                System.out.println("Login failed.");// used
                break;
            case 6:
                System.out.println("No movies found. Please try again.");// used
                break;
            case 7:
                System.out.println("Please enter a valid string of characters.");
                break;
            case 8:
                System.out.println("Please enter a valid time.");
                break;
            case 9:
                System.out.println(
                        "There was an error when attempting to clear the console screen. Please try again.");
                break;
            case 10:
                System.out.println("Null value detected. Please enter something.");
                break;
            case 11:
                System.out.println("Please enter valid input.");
                break;
            case 12:
                System.out.println("Please enter a valid Movie ID (E.g: MOV0000001): ");
                break;
            case 13:
                System.out.println("Please enter a valid showtime.");
                break;
            case 14:
                System.out.println("The month you have entered does not have so many days.");
                break;
            case 15:
                System.out.println(
                        "Sorry, but the system only supports showtime setting for the current year and the following year.");
                break;
            case 16:
                System.out.println("Please enter a valid release date.");
                break;
            case 17:
                System.out.println(
                        "The year entered has already passed, invalid year. Please try again.");
                break;
            case 18:
                System.out.println(
                        "The month entered has already passed, invalid month. Please try again.");
                break;
            case 19:
                System.out.println(
                        "The day entered has already passed, invalid day. Please try again.");
                break;
            case 20:
                System.out.println("The showtime is earlier than the Release Date of the movie. Please try again.");
                break;
            case 21:
                System.out.println("Please enter a valid email format.");
                break;
            case 22:
                System.out.println("Please enter a valid Malaysia Phone Format.");
                break;
            case 23:
                System.out.println("Username already existed. Please try again.");
                break;
            default:
                System.out.println("An error has occurred. Please try again.");
                break;
        }
        Util.waitForEnter(input);
        System.out.print(Color.RESET);
        return;
    }

    /**
     * This method displays a success message based on the given success index. The success messages
     * are defined in the class and are based on a given index. The method displays the message in
     * lime and then waits for the user to press enter before returning.
     *
     * @param successIndex the index of the success message to display
     * @param input the scanner used for waiting for the user to press enter
     */
    public static void successMessage(int successIndex, Scanner input) {
        System.out.println();
        System.out.print(Color.LIME);
        switch (successIndex) {
            case 1:
                System.out.println("Movie Added Successfully!");
                break;
            case 2:
                System.out.println("Movie Deleted Successfully!");
                break;
            case 3:
                System.out.println("Account deleted successfully");
                break;
            case 4:
                System.out.println("Login Success.");
                break;
            case 5:
                System.out.println("Account registered successfully");
                break;
            case 6:
                System.out.println("Movie updated successfully");
                break;
            default:
                System.out.println("Action successful.");
                break;
        }
        input.nextLine();
        Util.waitForEnter(input);
        System.out.print(Color.RESET);
        return;
    }
}
