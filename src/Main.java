import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import account.*;

import booking.Booking;

import ui.LoginPage;
import util.CommonIcon;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<UserAccount> users = UserAccount.getUsers();
        LoginPage.printChoice();
        int choice = LoginPage.chooseChoice();
        switch(choice)
        {
            case 1:
                ArrayList<Account> accounts = new ArrayList<Account>();
                for(int i = 0; i < users.size(); i++) //convert UserAccount to Account type
                {
                    accounts.add(users.get(i));
                }
                UserAccount.login(accounts);
                break;
            case 2:
                UserAccount user = UserAccount.register();
                users.add(user);
                break;
        }

    }
}