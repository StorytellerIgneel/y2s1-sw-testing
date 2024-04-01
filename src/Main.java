import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import account.*;
import movie.MovieCRUDGeneralPage;
import booking.Booking;
import ui.*;
import util.*;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<UserAccount> users = UserAccount.getUsers();
        
        LoginPage.printChoice();
        int choice = LoginPage.chooseChoice(); 

        if(choice == 1)
        {
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
            ArrayList<Account> accounts = new ArrayList<Account>();
            for(int i = 0; i < users.size(); i++) //convert UserAccount to Account type
            {
                accounts.add(users.get(i));
            }
            UserAccount.login(accounts);
            // UserMainMenu.printMovies(null, null);
            UserMainMenu.printUserAction();
            choice = UserMainMenu.chooseUserAction(); // -1 means re-run main
        }
        else if(choice == 2)
        {
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
            UserAccount user = UserAccount.register();
            users.add(user);
            UserAccount.saveUsers(users);
        }
    }
}