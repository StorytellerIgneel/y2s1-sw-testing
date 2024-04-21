package account;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import color.Color;
import util.*;
import ui.UserProfilePage;

public class SystemAdminAccount extends Account {
    /**
     * Constructor for SystemAdminAccount
     * 
     * @param accountId
     * @param name
     * @param password
     * @param registerDate
     * @param email
     * @param phoneNo
     */
    public SystemAdminAccount(String accountId, String name, String password, String registerDate,
            String email, String phoneNo) {
        super(accountId, name, password, registerDate, email, phoneNo);
    }

    // static methods
    /**
     * Reads file with system administrator account information
     * 
     * @return ArrayList of SystemAdminAccount objects
     */
    public static ArrayList<SystemAdminAccount> getAdmins() {
        Scanner scanner = new Scanner(System.in);
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<SystemAdminAccount>>() {}.getType();

        String line = "";
        try {
            File inFile = new File("src\\resources\\admin.json");
            Scanner inputFile = new Scanner(inFile);
            while (inputFile.hasNextLine()) {
                line = inputFile.nextLine();
            }
            inputFile.close();
        } catch (IOException e) {
            SystemMessage.errorMessage(4, scanner);
        }

        ArrayList<SystemAdminAccount> adminList = gson.fromJson(line, type);
        if (adminList == null) {
            adminList = new ArrayList<SystemAdminAccount>();
        }
        return adminList;
    }

    /**
     * Log in a user account without password
     * 
     * @param users
     * @param accountID
     * @return userIdx (the index of the UserAccount)
     *         -1 (indicates login failure)
     */
    public static int privilegedLogin(ArrayList<UserAccount> users, String accountID) {
        for (int userIdx = 0; userIdx < users.size(); userIdx++) {
            // admin logins into a user account without password as they have privileged access
            if (users.get(userIdx).getAccountId().equals(accountID))
                return userIdx;
        }
        return -1;
    }

    /**
     * Access the user account
     * 
     * @param users
     * @param scanner
     * @return -1 to go back to previous page
     *         -2 to stop the programme
     *         userIdx (the index of the user account)
     */
    public static int accessUser(ArrayList<UserAccount> users, Scanner scanner) {

        CommonIcon.printHeader();
        System.out.println(Color.RED
        + "As an admin, you are allowed to login user account with privileged access."
        + Color.RESET);
        scanner.nextLine();
        int userIdx = 0;
        do {
            // entering details
            System.out.println(
                    "Enter the User ID of the user account to be logged in (':b' to back, ':q' to quit): ");
            String accountID = scanner.nextLine();

            if (Validation.isBack(accountID))
                return -1;
            if (Validation.isQuit(accountID))
                return -2;

            userIdx = privilegedLogin(users, accountID);
            if (userIdx == -1)
                SystemMessage.errorMessage(5, scanner);
            else {
                SystemMessage.successMessage(4, scanner);
                break;
            }
        } while (userIdx != 1);

        try {
            Util.clearConsole(scanner);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userIdx; 
    }

    /**
     * Updates the info of user accounts
     * 
     * @param users
     * @param scanner
     */
    public static void updateUserAccount(ArrayList<UserAccount> users, Scanner scanner) {
        int userIdx = SystemAdminAccount.accessUser(users, scanner);

        if (userIdx == -1) // back
            return;
        else if (userIdx == -2) // quit
            CommonIcon.adminQuit(scanner);

        UserProfilePage userProfilePage = new UserProfilePage(users, userIdx, scanner);
        userProfilePage.printUserInfo();
        UserAccount.saveUsers(users);
    }
}
