package ui.systemAdmin;

import color.*;
import util.*;

import account.*;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class ManageUserPage extends AdminPage {
    // constructor
    public ManageUserPage() {};

    public void printAdminAction() {
        System.out.println("Choose an action:");
        System.out.println(Color.RED + "1." + Color.LIME + " View List of Users" + Color.RESET);
        System.out
                .println(Color.RED + "2." + Color.LIME + " Update User Account Info" + Color.RESET);

    }

    public int chooseAdminAction(Scanner scanner) {
        boolean isValid = false;
        String choice;
        int choiceInt = 0;
        do {
            System.out.print("Enter your choice (':b' to back, ':q to quit'): ");
            choice = scanner.next();

            if (Validation.isBack(choice))
                return -1;
            if (Validation.isQuit(choice))
                return 5;
            if (Validation.isNumber(choice)) // checking its a number or not
            {
                choiceInt = Integer.parseInt(choice);
                if (choiceInt < 1 || choiceInt > 2)
                    SystemMessage.errorMessage(2, scanner);
                else
                    isValid = true;
            } else
                SystemMessage.errorMessage(1, scanner);
        } while (!isValid);

        try {
            Util.clearConsole(scanner);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return choiceInt;
    }

    public void adminManageUserPage(SystemAdminAccount admin, ArrayList<UserAccount> users,
            Scanner scanner) {
        boolean resumeProgram = true;
        while (resumeProgram) {
            try {
                Util.clearConsole(scanner);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            CommonIcon.printAdminHeader(admin);
            printAdminAction();
            int choice = chooseAdminAction(scanner);
            if (choice == 1) {
                // View list of users
                printListOfUsers(users, scanner);
            }
            if (choice == 2) {
                // Update user account
                SystemAdminAccount.updateUserAccount(users, scanner);
            }
            if (choice == 5) {
                CommonIcon.adminQuit(scanner);
            } else if (choice == -1) {
                return;
            }
        }
    }

    public static void printListOfUsers(ArrayList<UserAccount> users, Scanner scanner) {
        CommonIcon.printHeader();
        System.out.println("List of Users");
        System.out.printf("%10s %-30s %-12s %-30s\n", "Account ID", "Username", "Contact", "Email");
        for (int i = 0; i < users.size(); i++) {
            System.out.printf("%-10s %-30s %-12s %-30s\n", users.get(i).getAccountId(),
                    users.get(i).getName(), users.get(i).getPhoneNo(), users.get(i).getEmail());
        }
        CommonIcon.printChar('-', 60);
        scanner.nextLine();
        Util.waitForEnter(scanner);
    }
}
