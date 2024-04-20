package ui;

import account.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import movie.Movie;
import util.*;
import color.Color;

public class ViewMovieInfoPage {

    private ArrayList<Movie> searchedMovieList;
    private int userIdx;
    private ArrayList<UserAccount> users;
    private int choice;
    private String choiceStr;
    private Scanner input;
    private boolean isValid;
    

    public ViewMovieInfoPage(ArrayList<Movie> searchedMovieList, int userIdx, ArrayList<UserAccount> users, Scanner input)
    {
        this.searchedMovieList = searchedMovieList;
        this.userIdx = userIdx;
        this.users = users;
        this.input = input;
    }
    /**
    * Prints the list of searched movies and prompts the user to select one.
    */
    public void printSearchedMovies() 
    {
        
        try
        {
            Util.clearConsole(input);
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
            System.out.println("\t"+ Color.RED +(i+1) + ") " + Color.LIME + searchedMovieList.get(i).getTitle() + Color.RESET);
        }
        CommonIcon.printChar('-', 60);
        chooseMovie();
        
    }
    /**
    * Prompts the user to select a movie from the list of searched movies.
    */
    public void chooseMovie()
    {
        do
        {
            System.out.print("Select a movie: ");
            choiceStr = input.next();
            if(Validation.isNumber(choiceStr))
            {
                choice = Integer.parseInt(choiceStr);
                if(choice < 1 || choice > searchedMovieList.size())
                {
                    isValid = false;
                    SystemMessage.errorMessage(2, input);
                }
                else
                    isValid = true;
            }
            else
            {
                isValid = false;
                SystemMessage.errorMessage(1, input);
            }
        }while(!isValid);

    }
    /**
 * Prints the information of the selected movie
 */
    public void viewMovieInfo()
    {
        try
        {
            Util.clearConsole(input);
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
