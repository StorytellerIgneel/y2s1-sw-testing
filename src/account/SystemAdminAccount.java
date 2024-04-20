package account;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import util.*; 

public class SystemAdminAccount extends Account
{
    // constructor
    public SystemAdminAccount(String accountId, String name, String password, String registerDate, String email, String phoneNo) {
        super(accountId, name, password, registerDate, email, phoneNo);
    }

    // static methods
    public static ArrayList<SystemAdminAccount> getAdmins()
    {
        Scanner scanner = new Scanner(System.in);
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<SystemAdminAccount>>() {}.getType();

        String line = "";
        try
        {
        File inFile = new File("src\\resources\\admin.json");
        Scanner inputFile = new Scanner(inFile);
        while(inputFile.hasNextLine())
        {
            line = inputFile.nextLine();
        }
        inputFile.close();
        }catch(IOException e)
        {
            SystemMessage.errorMessage(4, scanner);
        }

        ArrayList<SystemAdminAccount> adminList = gson.fromJson(line, type);
        if (adminList == null) {
            adminList = new ArrayList<SystemAdminAccount>();
        }
        return adminList;
    }

    public static int privilegedLogin(ArrayList<UserAccount> accounts, String accountID)
    {
        for(int i = 0; i < accounts.size(); i++)
        {
            // admin logins into a user account without password as they have privileged access
            if(accounts.get(i).getAccountId().equals(accountID))
                return i;
        }
        return -1;
    }

    public static int accessUser(ArrayList<UserAccount> users, Scanner input)
    {
        int index = 0;
        CommonIcon.printHeader();
        System.out.println("As an admin, you are allowed to login user account with privileged access.");
        input.nextLine(); // clear scanner
        do
        {
            //entering details
            System.out.println("Enter the User ID of the user account to be logged in (':b' to back, ':q' to quit): ");
            String accountID = input.nextLine();

            if(Validation.isBack(accountID))
                return -1;
            if(Validation.isQuit(accountID))
                return -2;

            index = privilegedLogin(users, accountID);
            if (index == -1)
                SystemMessage.errorMessage(5, input);
            else
            {
                SystemMessage.successMessage(4, input);
                break;
            }
        } while (index != 1);

        try
        {
            Util.clearConsole(input);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        return index; //return the user index for tracking user activities
    }
}