package ui;

import account.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import movie.Movie;
import util.CommonIcon;
import util.Util;

public class CreateBookingPage {
    public static void printSearchedMovies(ArrayList<Movie> result, int userIdx, ArrayList<UserAccount> users) 
    {
        try
        {
            Util.clearConsole();
        }
        catch(IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
        CommonIcon.printHeader();
        CommonIcon.printUserStatus(userIdx, users);
        for(int i = 0; i < result.size(); i++)
        {
            System.out.println((i+1) + ") " + result.get(i).getTitle());
        }
        CommonIcon.printChar('-', 60);
        chooseMovie();
    }

    public static void chooseMovie()
    {
        int choice;
        System.out.print("Select a movie: ");
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();

    }
}
