package util;

public class SystemMessage {
    public static void errorMessage(int errorIndex ){
        System.out.println();
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
                System.out.println("A problem was encountered when attempting to clean the console screen. Please contact the technical team.");
                break;
            case 7:
                System.out.println("Please enter a valid string of characters.");
                break;
            case 8:
                System.out.println("Please enter a valid time.");
                break;
        }
        Util.waitForEnter();
        return;
    }

    public static void successMessage(int successIndex) {
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
        }
        Util.waitForEnter();
        return;
    }
}