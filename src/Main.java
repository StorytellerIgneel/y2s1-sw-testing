import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import account.*;
import movie.*;
import booking.Booking;
import ui.*;
import util.*;

public class Main
{
    
    public static void main(String[] args)
    {
        ArrayList<UserAccount> users = UserAccount.getUsers();
        ArrayList<Movie> trend = MovieCRUDGeneralPage.getMovieList(); //to be modified
        ArrayList<Movie> latest = MovieCRUDGeneralPage.getMovieList(); //to be modified
        ArrayList<Movie> movieList = MovieCRUDGeneralPage.getMovieList(); //to be modified

        boolean resume = true;
        int userIdx;
        while(resume)
        {
            LoginPage.printChoice();
            int choice = LoginPage.chooseChoice(); 
            
            if(choice == 1)
            {
                try
                {
                    Util.clearConsole();
                }
                catch(IOException | InterruptedException e)
                {
                    e.printStackTrace();
                }
                ArrayList<Account> accounts = new ArrayList<Account>();
                for(int i = 0; i < users.size(); i++) //convert UserAccount to Account type for verifying users
                {
                    accounts.add(users.get(i));
                }
                userIdx = UserAccount.login(accounts);

                UserMainMenu.printMovies(trend, latest, userIdx, users); // to be modified
                UserMainMenu.printUserAction();
                choice = UserMainMenu.chooseUserAction(); // -1 means re-run main

                if(choice == 5) //exit the program
                    resume = false;
                else if(choice == -1) //re-run main
                    ;
                else if(choice == 1)
                {
                    UserMainMenu.printMovies(trend, latest, userIdx, users);
                    SearchMoviePage.searchMovie(movieList, userIdx, users);
                }
            }
            else if(choice == 2)
            {
                try
                {
                    Util.clearConsole();
                }
                catch(IOException | InterruptedException e)
                {
                    e.printStackTrace();
                }
                UserAccount user = UserAccount.register();
                users.add(user);
                UserAccount.saveUsers(users);
            }
            else if (choice == 3) 
            {
                
            }
            else if(choice ==4)    
                resume = false;
            
        }

        try
        {
            Util.clearConsole();
        }
        catch(IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
        CommonIcon.printHeader();
        System.out.println("Thank you for using TVG Cinemas.");
        System.out.println("Vist Us Next Time.");
    }
}