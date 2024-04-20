package ui.systemAdmin;
import java.util.Scanner;
import java.io.IOException;

import color.Color;
import util.*;

public class mainMenu {
    public static void printAdminAction()
    {
        System.out.println("Choose an action:");
        System.out.println(Color.RED + "1." + Color.LIME + " Manage movies" + Color.RESET);
        System.out.println(Color.RED + "2." + Color.LIME + " Manage user accounts" + Color.RESET);
        System.out.println(Color.RED + "3." + Color.LIME + " Manage bookings" + Color.RESET);
        System.out.println(Color.RED + "4." + Color.LIME + " Generate report" + Color.RESET);
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
                    SystemMessage.errorMessage(2, input);
                else
                    isValid = true;
            }
            else
                SystemMessage.errorMessage(1,input);
        }while(!isValid);
        
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
        return choiceInt;
    }
}
