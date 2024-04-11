package ui;
import java.util.ArrayList;
import account.*;
import util.*;
import java.util.Scanner;

public class UserProfilePage {
    private ArrayList<UserAccount> users;
    private int userIdx;
    private Scanner input;
    private String choice;

    public UserProfilePage(ArrayList<UserAccount> users, int userIdx, Scanner input) {
        this.users = users;
        this.userIdx = userIdx;
        this.input = input;
    }

    public void printUserInfo()
    {
        CommonIcon.printHeader();
        CommonIcon.printUserStatus(userIdx, users);
        System.out.println("#Profile Information");
        System.out.println();
        System.out.println("Username    : " + users.get(userIdx).getName());
        System.out.println("Email       : " + users.get(userIdx).getEmail());
        System.out.println("Phone Number: " + users.get(userIdx).getPhoneNo());
        CommonIcon.printChar('-', 60);
        System.out.print("Do you want to update your profile? (y/n): ");
        choice = input.next();

        if(choice.equals("y") || choice.equals("Y"))
        {
            updateProfile();
        }
        else if(choice.equals("n")|| choice.equals("N"))
        {
            return;
        }
        else 
        {
            ;
        }
    }

    public void updateProfile()
    {
        boolean resume = true;
        do
        {
            System.out.println();
            System.out.println("Choose what to update: ");
            System.out.println("1) Username");
            System.out.println("2) Email");
            System.out.println("3) Phone Number");
    
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
