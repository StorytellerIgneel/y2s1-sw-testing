package ui;
import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;
import color.Color;
import util.*;

public class LoginPage {

    public static void printChoice(Scanner scanner)
    {
        try
        {
            Util.clearConsole(scanner);
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
        System.out.println(Color.RED + "1. " + Color.LIME + "Login" + Color.RESET);
        System.out.println(Color.RED + "2. " + Color.LIME + "Register" + Color.RESET);
        System.out.println(Color.RED + "3. " + Color.LIME + "Login as Administrator" + Color.RESET);
        System.out.println(Color.RED + "4. " + Color.LIME + "Exit" + Color.RESET);

        CommonIcon.printChar('-', 60);
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
                    SystemMessage.errorMessage(2, input);
                else
                    isValid = true;
            }
            catch(InputMismatchException e)
            {
                SystemMessage.errorMessage(1, input);
            }
            finally
            {
                input.nextLine();
            }

        }while(!isValid);
        
        return choice;
    }
}
