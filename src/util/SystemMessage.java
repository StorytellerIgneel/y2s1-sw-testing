package util;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class SystemMessage {
    public static void errorMessage(int errorIndex ){
        ByteArrayInputStream inputStream = new ByteArrayInputStream("10\n".getBytes());
        Scanner scanner = new Scanner(inputStream);
        switch(errorIndex) {
            case 1:
                System.out.println("Please enter a valid number"); //used
                break;
            case 2:
                System.out.println("Please enter a valid index. This index is not available."); //used
                break;
            case 3:
                System.out.println("The file movieData.txt is not present in the current directory."); //used
                break;
            case 4:
                System.out.println("The file user.json is not found");
                break;
        }
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
        scanner.close();
        return;
    }

    public static void successMessage(int successIndex) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("10\n".getBytes());
        Scanner scanner = new Scanner(inputStream);
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
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
        scanner.close();
        return;
    }
}