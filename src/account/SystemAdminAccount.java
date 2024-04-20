package account;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import color.Color;
import util.*; 
import ui.UserProfilePage;

public class SystemAdminAccount extends Account
{
    // constructor
    public SystemAdminAccount(String accountId, String name, String password, String registerDate, String email, String phoneNo)
    {
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
        if (adminList == null)
        {
            adminList = new ArrayList<SystemAdminAccount>();
        }
        return adminList;
    }

    public static int privilegedLogin(ArrayList<UserAccount> users, String accountID)
    {
        for(int i = 0; i < users.size(); i++)
        {
            // admin logins into a user account without password as they have privileged access
            if(users.get(i).getAccountId().equals(accountID))
                return i;
        }
        return -1;
    }

    public static int accessUser(ArrayList<UserAccount> users, Scanner input)
    {

        int userIdx = 0;
        CommonIcon.printHeader();
        System.out.println(Color.RED+"As an admin, you are allowed to login user account with privileged access."+Color.RESET);
        input.nextLine();
        do
        {
            //entering details
            System.out.println("Enter the User ID of the user account to be logged in (':b' to back, ':q' to quit): ");
            String accountID = input.nextLine();

            if(Validation.isBack(accountID))
                return -1;
            if(Validation.isQuit(accountID))
                return -2;

            userIdx = privilegedLogin(users, accountID);
            if (userIdx == -1)
                SystemMessage.errorMessage(5, input);
            else
            {
                SystemMessage.successMessage(4, input);
                break;
            }
        } while (userIdx != 1);

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
        return userIdx; //return the user index for tracking user activities
    }

    public static void updateUserAccount(ArrayList<UserAccount> users, Scanner scanner)
    {
        int userIdx = SystemAdminAccount.accessUser(users, scanner);
        
        if(userIdx == -1) //back
            return;
        else if(userIdx == -2) //quit
            CommonIcon.adminQuit(scanner);

        UserProfilePage userProfilePage = new UserProfilePage(users, userIdx, scanner);
        userProfilePage.printUserInfo();
        UserAccount.saveUsers(users);
    }

    public static void viewListOfUsers(ArrayList<UserAccount> users, Scanner scanner)
    {
        CommonIcon.printHeader();
        System.out.println("List of Users");
        System.out.printf("%10s %-30s %-12s %-30s\n", "Account ID", "Username", "Contact", "Email");
        for (int i = 0; i < users.size(); i++)
        {
            System.out.printf("%10s %-30s %-12s %-30s\n",  users.get(i).getAccountId(), users.get(i).getName(), users.get(i).getPhoneNo(), users.get(i).getEmail());
        }
        CommonIcon.printChar('-', 60);
        scanner.nextLine(); // clear scanner
        Util.waitForEnter(scanner);
    }
}