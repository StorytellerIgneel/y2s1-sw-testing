package ui;
import java.util.Scanner;

import util.*;

import java.io.IOException;
import java.util.InputMismatchException;
import color.Color;
import java.util.NoSuchElementException;

public class LoginPage {

    public static void printChoice()
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
        CommonIcon.printHeader();
        System.out.println(Color.red + "1. " + Color.lime + "Login" + Color.reset);
        System.out.println(Color.red + "2. " + Color.lime + "Register" + Color.reset);
        System.out.println(Color.red + "3. " + Color.lime + "Login as Administrator" + Color.reset);
        System.out.println(Color.red + "4. " + Color.lime + "Exit" + Color.reset);
        CommonIcon.printChar('-', 60);
    }

    public static int chooseChoice()
    {
        Scanner input = new Scanner(System.in);
        boolean isValid = false;
        int choice = 0;
        
        do
        {
            System.out.print("Enter your choice: ");
            try
            {
                choice = input.nextInt();
                
                if(choice < 1 || choice > 4)   
                    SystemMessage.errorMessage(2);
                else
                    isValid = true;
            }
            catch(InputMismatchException e)
            {
                SystemMessage.errorMessage(1);
            }
            finally
            {
                input.nextLine();
            }

        }while(!isValid);
        
        return choice;
    }
}
