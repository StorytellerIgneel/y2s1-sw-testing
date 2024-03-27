package GeneralSRC;
import java.util.ArrayList;
import java.util.Scanner;

public class UserMainMenu {

    public static void printMovies(ArrayList<Movie> trendMovies, ArrayList<Movie> latestMovies)
    {
        CommonIcon.printHeader();
        CommonIcon.printTrend(trendMovies);
        CommonIcon.printLatest(latestMovies);
    }

    public static void printUserAction()
    {
        System.out.println("Choose an action:");
        System.out.println("1. Search movies");
        System.out.println("2. View bookings");
        System.out.println("3. Create bookings");
        System.out.println("4. View profile");
        System.out.println("5. View cinema locations");
        System.out.println("6. Exit");
    }

    public static int chooseUserAction()
    {
        Scanner input = new Scanner(System.in);
        boolean isValid = false;
        String choice;
        int choiceInt = 0;
        do
        {
            System.out.print("Your selection: ");
            choice = input.next();

            if(Validation.isNumber(choice)) //checking its a number or not
            {
                choiceInt = Integer.parseInt(choice);
                if(choiceInt < 1 || choiceInt > 6) //checkings its a valid number or not
                    SystemMessage.errorMessage(1);
                else
                    isValid = true;
            }
            else
                SystemMessage.errorMessage(10);
        }while(!isValid);
        input.close();

        return choiceInt;
    }
}
