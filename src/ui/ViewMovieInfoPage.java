package ui;

import account.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import movie.Movie;
import util.CommonIcon;
import util.Util;

public class ViewMovieInfoPage {
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
        chooseMovie(result);
    }

    public static void chooseMovie(ArrayList<Movie> result) 
    {
        int choice;
        System.out.print("Select a movie: ");
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();
        String movieInfo = result.get(choice-1).viewInformation();
        System.out.println(movieInfo);
        CommonIcon.printChar('-', 60);
        System.out.println("Press enter to continue...");
        input.nextLine();
        input.nextLine();
    }
}
