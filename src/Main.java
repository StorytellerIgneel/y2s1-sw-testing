import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import account.*;
import movie.*;
import booking.Booking;
import ui.*;
import util.*;
import color.Color;


public class Main
{
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        ArrayList<UserAccount> users = UserAccount.getUsers();
        ArrayList<SystemAdminAccount> admins = SystemAdminAccount.getAdmins();
        ArrayList<Movie> trend = MovieCRUDGeneralPage.getMovieList(); //to be modified
        ArrayList<Movie> latest = MovieCRUDGeneralPage.getMovieList(); //to be modified
        ArrayList<Movie> movieList = MovieCRUDGeneralPage.getMovieList(); //to be modified

        boolean resumeProgram = true;
        int userIdx;
        while(resumeProgram)
        {
            
            boolean resumeMainMenu = true;
            LoginPage.printChoice();
            int choice = LoginPage.chooseChoice(); 
            
            if(choice == 1) //login
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
                for(int i = 0; i < users.size(); i++) //convert UserAccount to Account type for verifying users because it only accept account type
                {
                    accounts.add(users.get(i));
                }
                userIdx = UserAccount.login(accounts);

                if(userIdx == -1) //back
                    continue;
                else if(userIdx == -2) //quit
                    break;

                while(resumeMainMenu)
                {
                    try
                    {
                        Util.clearConsole();
                    }
                    catch(IOException | InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    UserMainMenu.printMovies(trend, latest, userIdx, users); // to be modified
                    UserMainMenu.printUserAction();
                    choice = UserMainMenu.chooseUserAction(); // -1 means re-run main

                    if(choice == 5) //exit the program
                    {
                        resumeMainMenu = false;
                        resumeProgram = false;
                    }
                    else if(choice == -1) //go back login page
                    {
                        resumeMainMenu = false;
                        userIdx = 0;
                    }
                    else if(choice == 1) //view movie info
                    {
                        try
                        {
                            Util.clearConsole();
                        }
                        catch(IOException | InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                        UserMainMenu.printMovies(trend, latest, userIdx, users);
                        SearchMoviePage searchMoviePage = new SearchMoviePage(users, userIdx, input);
                        searchMoviePage.searchMovie();
                    }
                    else if(choice == 2) //view bookings
                    {
                        try
                        {
                            Util.clearConsole();
                        }
                        catch(IOException | InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                        BookingPage bookingPage = new BookingPage(users, userIdx, input);
                        bookingPage.display();
                    }
                    else if(choice == 3) //view user profile
                    {
                        try
                        {
                            Util.clearConsole();
                        }
                        catch(IOException | InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                        UserProfilePage profile = new UserProfilePage(users, userIdx, input);
                        profile.printUserInfo();
                    }
                    else if(choice == 4) //view cinema location
                    {
                        try
                        {
                            Util.clearConsole();
                        }
                        catch(IOException | InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                        CinemaLocationPage cinema = new CinemaLocationPage(userIdx, users, input);
                        cinema.printCinema();
                    }
                }
                
            }
            else if(choice == 2) // register
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
                if(user != null)
                {
                    users.add(user);
                    UserAccount.saveUsers(users);
                    SystemMessage.successMessage(5);
                }
            }
            else if (choice == 3) //login as admin
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
                for(int i = 0; i < admins.size(); i++) //convert SystemAdminAccount to Account type for verifying admins because it only accept account type
                {
                    accounts.add(admins.get(i));
                }
                userIdx = SystemAdminAccount.login(accounts);

                if(userIdx == -1) //back
                    continue;
                else if(userIdx == -2) //quit
                    break;
                
                while(resumeMainMenu)
                {
                    // admin page
                    resumeMainMenu = false;
                    resumeProgram = false; // temporary break :D
                    if (choice == 5)
                    {
                        resumeMainMenu = false;
                        resumeProgram = false;
                    }
                    else if (choice == -1)
                    {
                        resumeMainMenu = false;
                        userIdx = 0;
                    }
                    else if (choice == 1)
                    {
                        // Manage movies
                    }
                    else if (choice == 2)
                    {
                        // Manage User Accounts
                    }
                    else if (choice == 3)
                    {
                        //Manage Bookings
                    }
                    else if (choice == 4)
                    {
                        // Generate Report
                    }
                }
            }
            else if(choice ==4)   //exit
                resumeProgram = false;
            
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
        input.close();
        System.out.print(Color.lime);
        System.out.println("Thank you for using TVG Cinemas.");
        System.out.println("Vist Us Next Time.");
        System.out.print(Color.reset);
    }
}