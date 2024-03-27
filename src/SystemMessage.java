import java.util.Scanner;

public class SystemMessage {
    public static void errorMessage(int errorIndex){
        Scanner scanner = new Scanner(System.in);
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
            case 4:
                System.out.println("Please enter a valid account id");
                break;
            case 5:
                System.out.println("Please enter a valid password");
                break;
            case 6:
                System.out.println("Please enter a valid account name");
                break;
            case 7:
                System.out.println("Please enter a valid account id");
                break;
            case 8:
                System.out.println("Please enter a valid password");
                break;
            case 9:
                System.out.println("Please enter a valid account name");
                break;
            case 10:
                System.out.println("Please enter a number.");
                break;
        }
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
        scanner.close();
        return;
    }

    public static void successMessage(int successIndex) {
        Scanner scanner = new Scanner(System.in);
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
        }
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
        scanner.close();
        return;
    }
}