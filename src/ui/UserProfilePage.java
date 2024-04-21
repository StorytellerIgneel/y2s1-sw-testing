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

    /**
     * Prints the user's profile information and prompts the user to update their profile.
     */
    public void printUserInfo() {
        do {
            try {
                Util.clearConsole(input);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            CommonIcon.printHeader();
            CommonIcon.printUserStatus(userIdx, users);
            System.out.println("#Profile Information");
            System.out.println();
            System.out.println(
                    Color.RED + "Username    : " + Color.LIME + users.get(userIdx).getName());
            System.out.println(
                    Color.RED + "Email       : " + Color.LIME + users.get(userIdx).getEmail());
            System.out.println(
                    Color.RED + "Phone Number: " + Color.LIME + users.get(userIdx).getPhoneNo());
            System.out.print(Color.RESET);
            CommonIcon.printChar('-', 60);
            System.out.print("Do you want to update your profile? (y/n): ");
            choice = input.next();
            input.nextLine();
            if (choice.equals("y") || choice.equals("Y")) {
                isValid = true;
                updateProfile();
            } else if (choice.equals("n") || choice.equals("N")) {
                isValid = true;
                return;
            } else {
                isValid = false;
                SystemMessage.errorMessage(11, input);
            }
        } while (!isValid);
    }

    /**
     * Updates the user's profile information. only 3 editable information which are username, email
     * and phone number
     */
    public void updateProfile() {
        boolean resume = true;
        do {
            System.out.println();
            System.out.println("Choose what to update: ");
            System.out.println(Color.RED + "1)" + Color.LIME + " Username");
            System.out.println(Color.RED + "2)" + Color.LIME + " Email");
            System.out.println(Color.RED + "3)" + Color.LIME + " Phone Number");
            System.out.print(Color.RESET);

            System.out.print("Enter your choice (':b' to back): ");
            choice = input.next();
            if (choice.equals("1")) {
                input.nextLine(); // consume the next line character
                String username2;
                do{
                    System.out.print("Enter new username (':b' to back): ");
                    username2 = input.nextLine();
                    if (Validation.isBack(username2))
                        ;
                    else if(Validation.isDuplicateUsername(username2))
                        SystemMessage.errorMessage(23, input);
                    else {
                        users.get(userIdx).setName(username2);
                        UserAccount.saveUsers(users);
                        SystemMessage.successMessage(100, input);
                        resume = false;
                        break;
                    }
                }while(Validation.isDuplicateUsername(username2));
            } else if (choice.equals("2")) {
                input.nextLine();
                String email2;
                do{
                    System.out.print("Enter new email (':b' to back): ");
                    email2 = input.nextLine();
                    if (Validation.isBack(email2))
                        break;
                    else if(!Validation.isValidEmail(email2))
                        SystemMessage.errorMessage(21,input);
                    else {
                        users.get(userIdx).setEmail(email2);
                        UserAccount.saveUsers(users);
                        SystemMessage.successMessage(100, input);
                        resume = false;
                        break;
                    }
                }while(!Validation.isValidEmail(email2));
            } else if (choice.equals("3")) {
                input.nextLine();
                String phoneNo2;
                do{
                    System.out.print("Enter new phone number (':b' to back): ");
                    phoneNo2 = input.nextLine();
                    if (Validation.isBack(phoneNo2))
                        break;
                    else if(!Validation.isValidMalaysiaPhoneNumber(phoneNo2))
                        SystemMessage.errorMessage(22, input);
                    else {
                        users.get(userIdx).setPhoneNo(phoneNo2);
                        UserAccount.saveUsers(users);
                        SystemMessage.successMessage(100, input);
                        resume = false;
                        break;
                    }
                }while(!Validation.isValidMalaysiaPhoneNumber(phoneNo2));
            } else if (Validation.isBack(choice)) {
                return;
            }else{
                SystemMessage.errorMessage(11, input);
            }
        } while (resume);
    }


}
