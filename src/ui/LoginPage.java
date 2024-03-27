package ui;
import java.util.Scanner;

import util.CommonIcon;
import util.SystemMessage;

import java.util.InputMismatchException;

public class LoginPage {

    public static void printChoice()
    {
        CommonIcon.printHeader();
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Login as Administrator");
        System.out.println("4. Exit"); 
    }

    public static int chooseChoice(Scanner input)
    {
        boolean isValid = false;
        int choice = 0;
        
        do
        {
            System.out.print("Enter your choice: ");
            try
            {
                choice = input.nextInt();
                if(choice < 1 || choice > 4)
                {
                    SystemMessage.errorMessage(1);
                }
                else
                    isValid = true;
            }
            catch(InputMismatchException e)
            {
                SystemMessage.errorMessage(10);
                input.nextLine();
            }
        }while(!isValid);
        return choice;
    }
}
