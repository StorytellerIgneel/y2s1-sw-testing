package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import account.*;
import movie.Movie;
import util.*;
import movie.*;
import color.Color;



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
        System.out.println(Color.red + "1." + Color.lime + " View movies info" + Color.reset);
        System.out.println(Color.red + "2." + Color.lime + " View bookings" + Color.reset);
        System.out.println(Color.red + "3." + Color.lime + " View profile" + Color.reset);
        System.out.println(Color.red + "4." + Color.lime + " View cinema location" + Color.reset);
        System.out.println(Color.red + "5." + Color.lime + " Exit" + Color.reset);
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
                if(choiceInt < 1 || choiceInt > 5) 
                    SystemMessage.errorMessage(2);
                else
                    isValid = true;
            }
            else
                SystemMessage.errorMessage(1);
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
