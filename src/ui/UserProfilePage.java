package ui;
import java.io.IOException;
import java.util.ArrayList;
import account.*;

import java.util.Scanner;
import color.Color;
import util.*;

public class UserProfilePage {
    private ArrayList<UserAccount> users;
    private int userIdx;
    private Scanner input;
    private String choice;
    private boolean isValid;

    public UserProfilePage(ArrayList<UserAccount> users, int userIdx, Scanner input) {
        this.users = users;
        this.userIdx = userIdx;
        this.input = input;
    }

    public void printUserInfo()
    {
        do
        {   
            try
            {
                Util.clearConsole(input);
            }
            catch(IOException | InterruptedException e)
            {
                e.printStackTrace();
            }
            CommonIcon.printHeader();
            CommonIcon.printUserStatus(userIdx, users);
            System.out.println("#Profile Information");
            System.out.println();
            System.out.println(Color.RED + "Username    : " + Color.LIME + users.get(userIdx).getName());
            System.out.println(Color.RED + "Email       : " + Color.LIME + users.get(userIdx).getEmail());
            System.out.println(Color.RED + "Phone Number: " + Color.LIME + users.get(userIdx).getPhoneNo());
            System.out.print(Color.RESET);
            CommonIcon.printChar('-', 60);
            System.out.print("Do you want to update your profile? (y/n): ");
            choice = input.next();
            input.nextLine();
            if(choice.equals("y") || choice.equals("Y"))
            {
                isValid = true;
                updateProfile();
            }
            else if(choice.equals("n")|| choice.equals("N"))
            {
                isValid = true;
                return;
            }
            else 
            {
                isValid = false;
                SystemMessage.errorMessage(11, input);
            }
        }while(!isValid);
    }

    public void updateProfile()
    {
        boolean resume = true;
        do
        {
            System.out.println();
            System.out.println("Choose what to update: ");
            System.out.println(Color.RED + "1)" + Color.LIME + " Username");
            System.out.println(Color.RED + "2)" + Color.LIME + " Email");
            System.out.println(Color.RED + "3)" + Color.LIME + " Phone Number");
            System.out.print(Color.RESET);
    
            System.out.print("Enter your choice (':b' to back): ");
            choice = input.next();
    
            if(choice.equals("1"))
            {   
                input.nextLine(); //consume the next line character
                System.out.print("Enter new username (':b' to back): ");
                String username = input.nextLine();
                if(Validation.isBack(username))
                    ;
                else 
                {
                    users.get(userIdx).setName(username);
                    resume = false;
                }
            }
            else if(choice.equals("2"))
            {
                System.out.print("Enter new email (':b' to back): ");
                String email = input.nextLine();
                if(Validation.isBack(email))
                    ;
                else 
                {
                    users.get(userIdx).setEmail(email);
                    resume = false;
                }
            }
            else if(choice.equals("3"))
            {
                System.out.print("Enter new phone number (':b' to back): ");
                String phoneNo = input.nextLine();
                if(Validation.isBack(phoneNo))
                    ;
                else
                {
                    users.get(userIdx).setPhoneNo(phoneNo);
                    resume = false;
                }
            }
            else if(Validation.isBack(choice))
            {
                return;
            }
        }while(resume);
    }

    
}
