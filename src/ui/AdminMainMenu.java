package ui;
import java.util.Scanner;
import java.io.IOException;

import color.Color;
import account.SystemAdminAccount;
import java.util.ArrayList;
import util.*;

public class AdminMainMenu {
    public static void printAdminInfo(int index, ArrayList<SystemAdminAccount> admins)
    {
        CommonIcon.printHeader();
        CommonIcon.printAdminStatus(index, admins);
    }

    public static void printAdminAction()
    {
        System.out.println("Choose an action:");
        System.out.println(Color.red + "1." + Color.lime + " Manage movies" + Color.reset);
        System.out.println(Color.red + "2." + Color.lime + " Manage user accounts" + Color.reset);
        System.out.println(Color.red + "3." + Color.lime + " Manage bookings" + Color.reset);
        System.out.println(Color.red + "4." + Color.lime + " Generate report" + Color.reset);
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
                if(choiceInt < 1 || choiceInt > 4) 
                    SystemMessage.errorMessage(2);
                else
                    isValid = true;
            }
            else
                SystemMessage.errorMessage(1);
        }while(!isValid);
        
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
}
