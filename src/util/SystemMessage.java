package util;

import color.Color;

public class SystemMessage {
    public static void errorMessage(int errorIndex ){
        System.out.println();
        System.out.print(Color.red);
        switch(errorIndex) {
            case 1:
                System.out.println("Please enter a valid number."); //used
                break;
            case 2:
                System.out.println("Please enter a valid index. This index is not available."); //used
                break;
            case 3:
                System.out.println("The file movieData.txt is not present in the current directory."); //used
                break;
            case 4:
                System.out.println("The file user.json is not found.");//used
                break;
            case 5:
                System.out.println("Login failed.");//used
                break;
            case 6:
                System.out.println("No movies found. Please try again.");//used
                break;
            case 7:
                System.out.println("Please enter a valid string of characters.");
                break;
            case 8:
                System.out.println("Please enter a valid time.");
                break;
            case 9:
                System.out.println("There was an error when attempting to clear the console screen. Please try again.");
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
        }
        Util.waitForEnter();
        System.out.print(Color.reset);
        return;
    }

    public static void successMessage(int successIndex) {
        System.out.println();
        System.out.print(Color.lime);
        switch(successIndex) {
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
        }
        Util.waitForEnter();
        System.out.print(Color.reset);
        return;
    }
}