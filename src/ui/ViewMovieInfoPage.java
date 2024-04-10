package ui;

import account.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import movie.Movie;
import util.*;

public class ViewMovieInfoPage {

    private ArrayList<Movie> searchedMovieList;
    private int userIdx;
    private ArrayList<UserAccount> users;
    private int choice;
    private Scanner input;
    

    public ViewMovieInfoPage(ArrayList<Movie> searchedMovieList, int userIdx, ArrayList<UserAccount> users, Scanner input)
    {
        this.searchedMovieList = searchedMovieList;
        this.userIdx = userIdx;
        this.users = users;
        this.input = input;
    }

    public void printSearchedMovies() 
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
        System.out.println(searchedMovieList.size() + " Movie Found: ");
        for(int i = 0; i < searchedMovieList.size(); i++)
        {
            System.out.println("\t"+(i+1) + ") " + searchedMovieList.get(i).getTitle());
        }
        CommonIcon.printChar('-', 60);
        chooseMovie();
        
    }

    public void chooseMovie()
    {
        System.out.print("Select a movie: ");
        choice = input.nextInt();
    }

    public void viewMovieInfo()
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
        String movieInfo = searchedMovieList.get(choice-1).viewInformation();
        System.out.println(movieInfo);
        CommonIcon.printChar('-', 60);
        System.out.println("Press enter to go back...");
        input.nextLine();
        input.nextLine();
    }
    
}
