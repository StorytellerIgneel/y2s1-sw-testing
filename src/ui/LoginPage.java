package ui;
import java.util.Scanner;

import util.*;

import java.io.IOException;
import java.util.InputMismatchException;
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
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Login as Administrator");
        System.out.println("4. Exit"); 
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
                {
                    System.out.println("Invalid");
                    // SystemMessage.errorMessage(1);
                }
                else
                isValid = true;
            }
            catch(InputMismatchException e)
            {
                SystemMessage.errorMessage(10);
            }
            catch (NoSuchElementException e)
            {
                System.out.println("No such element");
            }
            finally
            {
                input.nextLine();
            }

        }while(!isValid);
        
        return choice;
    }
}
