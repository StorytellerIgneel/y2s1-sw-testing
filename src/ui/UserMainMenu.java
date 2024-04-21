package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import account.*;
import movie.Movie;
import util.*;
import color.Color;

public class UserMainMenu {
    /**
     * Prints the movie lists and user status to the console.
     * 
     * 
     * @param movieList the list of latest movies
     * @param index the index of the currently logged in user
     * @param users the list of all users
     */
    public static void printMovies(ArrayList<Movie> movieList,
            int index, ArrayList<UserAccount> users) {
        CommonIcon.printHeader();
        CommonIcon.printUserStatus(index, users);
        System.out.println();
        CommonIcon.printLatest(movieList);
        CommonIcon.printChar('-', 60);
    }

    /**
     * Prints the user action menu to the console.
     */
    public static void printUserAction() {
        System.out.println("Choose an action:");
        System.out.println(Color.RED + "1." + Color.LIME + " View movies info" + Color.RESET);
        System.out.println(Color.RED + "2." + Color.LIME + " View bookings" + Color.RESET);
        System.out.println(Color.RED + "3." + Color.LIME + " View profile" + Color.RESET);
        System.out.println(Color.RED + "4." + Color.LIME + " View cinema location" + Color.RESET);
    }

    /**
     * Prompts the user to choose an action from a list of options.
     * 
     * @param input the scanner used for user input
     * @return the index of the chosen option, or -1 if the user chose to go back or 5 if user chose
     *         to quit
     */
    public static int chooseUserAction(Scanner input) {
        boolean isValid = false;
        String choice;
        int choiceInt = 0;
        do {
            System.out.print("Your selection (':b' to back, ':q' to quit): ");
            choice = input.next();

            if (Validation.isBack(choice))
                return -1;
            if (Validation.isQuit(choice))
                return 5;
            if (Validation.isNumber(choice)) // checking its a number or not
            {
                choiceInt = Integer.parseInt(choice);
                if (choiceInt < 1 || choiceInt > 4)
                    SystemMessage.errorMessage(2, input);
                else
                    isValid = true;
            } else
                SystemMessage.errorMessage(1, input);
        } while (!isValid);

        try {
            Util.clearConsole(input);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return choiceInt;
    }
}
