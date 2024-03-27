package movie;
import java.util.Scanner;

public class SystemMessage {
    public static void errorMessage(int errorIndex){
        switch(errorIndex) {
            case 1:
                System.out.println("Please enter a valid number");
                break;
            case 2:
                System.out.println("Please enter a valid index. This index is not available.");
                break;
            case 3:
                System.out.println("The file movieData.txt is not present in the current directory.");
                break;
        }
        System.out.println("Press Enter to continue...");
        CRUDGeneralPage.waitForEnter();
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
                System.out.println("Movie updated successfully");
                break;
        }
        System.out.println("Press Enter to continue...");
        CRUDGeneralPage.waitForEnter();
        return;
    }
}