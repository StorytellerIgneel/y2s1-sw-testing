package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import account.*;
import movie.Movie;
import util.*;
import movie.*;



public class UserMainMenu {

    public static void printMovies(ArrayList<Movie> trendMovies, ArrayList<Movie> latestMovies, int index, ArrayList<UserAccount> users)
    {
        CommonIcon.printHeader();
        CommonIcon.printUserStatus(index, users);
        CommonIcon.printTrend(trendMovies);
        System.out.println();
        CommonIcon.printLatest(latestMovies);
        CommonIcon.printChar('-', 60);
    }

    public static void printUserAction()
    {
        System.out.println("Choose an action:");
        System.out.println("1. Search movies");
        System.out.println("2. View bookings");
        System.out.println("3. View profile");
        System.out.println("4. View cinema locations");
        System.out.println("5. Exit");
    }

    public static int chooseUserAction()
    {
        Scanner input = new Scanner(System.in);
        boolean isValid = false;
        String choice;
        int choiceInt = 0;
        do
        {
            System.out.print("Your selection (':b' to back): ");
            choice = input.next();

            if(Validation.isBack(choice))
                return -1;
            
            if(Validation.isNumber(choice)) //checking its a number or not
            {
                choiceInt = Integer.parseInt(choice);
                // if(choiceInt == 5)
                // {
                //     isValid = true;
                //     System.exit(0);
                // }
                if(choiceInt < 1 || choiceInt > 5) //checkings its a valid number or not
                    SystemMessage.errorMessage(1);
                else
                    isValid = true;
            }
            else
                SystemMessage.errorMessage(6);
        }while(!isValid);
        
        try
        {
            Util.clearConsole();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }



        return choiceInt;
    }
}
