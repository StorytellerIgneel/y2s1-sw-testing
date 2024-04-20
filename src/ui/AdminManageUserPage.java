package ui;

import color.*;
import util.*;

import account.*;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class AdminManageUserPage {
    private Scanner input;

    // constructor
    public AdminManageUserPage() {};

    public static void printAdminAction(int index, ArrayList<SystemAdminAccount> admins)
    {
        CommonIcon.printHeader();
        CommonIcon.printAdminStatus(index, admins);
        System.out.println("Choose an action:");
        System.out.println(Color.RED + "1." + Color.LIME + " View List of Users" + Color.RESET);
        System.out.println(Color.RED + "2." + Color.LIME + " Update User Account Info" + Color.RESET);

    }

    public static int chooseAdminAction()
    {
        Scanner input = new Scanner(System.in);
        boolean isValid = false;
        String choice;
        int choiceInt = 0;
        do
        {
            System.out.print("Enter your choice (':b' to back, ':q to quit'): ");
            choice = input.next();

            if(Validation.isBack(choice))
                return -1;
            if(Validation.isQuit(choice))
                return 5;
            if(Validation.isNumber(choice)) //checking its a number or not
            {
                choiceInt = Integer.parseInt(choice);
                if(choiceInt < 1 || choiceInt > 2) 
                    SystemMessage.errorMessage(2);
                else
                    isValid = true;
            }
            else
                SystemMessage.errorMessage(1);
        } while(!isValid);
        
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
        return choiceInt;
    }

    public void manageUserPage(int userIdx, ArrayList<SystemAdminAccount> admins, ArrayList<UserAccount> users)
    {
        boolean resumeProgram = true;
        while(resumeProgram){
            try
            {
                Util.clearConsole();
            }
            catch(IOException | InterruptedException e)
            {
                e.printStackTrace();
            }
            printAdminAction(userIdx, admins);
            int choice = AdminManageUserPage.chooseAdminAction();
            if (choice == 1)
            {
                // View list of users
                CommonIcon.printHeader();
                System.out.println("List of Users");
                System.out.printf("%10s\t%-30s\n", "Account ID", "Username");
                ArrayList<UserAccount> userAccounts = UserAccount.getUsers();
                for (int i = 0; i < userAccounts.size(); i++)
                {
                    System.out.printf("%10s\t%-30s\n",  userAccounts.get(i).getAccountId(), userAccounts.get(i).getName());
                }
                CommonIcon.printChar('-', 60);
                Util.waitForEnter();
            }
            if (choice == 2)
            {
                // Update user account
                updateUserAccount(userIdx, users);
            }
            if (choice == 5)
            {
                CommonIcon.adminQuit();
            }
            else if (choice == -1)
            {
                return;
            }
        }
    }

    public void updateUserAccount(int userIdx, ArrayList<UserAccount> users)
    {
        ArrayList<UserAccount> userAccounts = new ArrayList<UserAccount>();
        for(int i = 0; i < users.size(); i++) 
        {
            userAccounts.add(users.get(i));
        }
        userIdx = SystemAdminAccount.accessUser(userAccounts);
        
        if(userIdx == -1) //back
        {
            return;
        }
        else if(userIdx == -2) //quit
        {
            CommonIcon.adminQuit();
        }

        UserProfilePage userProfilePage = new UserProfilePage(users, userIdx, input);
        userProfilePage.printUserInfo();
        // userProfilePage.updateProfile();
        
    }
    
}
