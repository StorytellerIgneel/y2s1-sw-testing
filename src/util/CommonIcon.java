package util;

import java.util.ArrayList;
import movie.Movie;
import account.*;
import color.Color;
import java.io.IOException;
import java.util.Scanner;

public class CommonIcon {
    /**
     * The name of the system icon
     */
    public static void printHeader() {
        System.out.println(Color.RESET);
        printChar('-', 60);
        System.out.println("▀█▀░█░█░█▀▀░ ░█▀▀░█░█▄░█░█▀▀░█▀▄▀█░▄▀█░█▀");
        System.out.println("░█░░▀▄▀░█▄█░ ░█▄▄░█░█░▀█░██▄░█░▀░█░█▀█░▄█");
        printChar('-', 60);
    }

    /**
     * Prints a character a specified number of times.
     * 
     * @param ch the character to be printed
     * @param times the number of times to print the character
     */
    public static void printChar(char ch, int times) {
        for (int i = 0; i < times; i++) {
            System.out.print(ch);
        }
        System.out.println();
    }

    /**
     * Prints the trending movies.
     * 
     * @param movies the list of movie objects
     */
    public static void printTrend(ArrayList<Movie> movies) {
        System.out.println("#Trending Now");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(Color.RED + "  " + (i + 1) + ") " + Color.LIME
                    + movies.get(i).getTitle() + Color.RESET);
        }

    }

    /**
     * Prints the latest movie releases.
     * 
     * @param movies the list of movie objects
     */
    public static void printLatest(ArrayList<Movie> movies) {
        System.out.println("#Latest Release");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(Color.RED + "  " + (i + 1) + ") " + Color.LIME
                    + movies.get(i).getTitle() + Color.RESET);
        }

    }

    /**
     * Prints the user's status, including their username and user ID.
     * 
     * @param index the index of the user in the list of users
     * @param users the list of user accounts
     */
    public static void printUserStatus(int index, ArrayList<UserAccount> users) {
        System.out.print("Username  : " + users.get(index).getName());
        System.out.println("\t\tUserID    : " + users.get(index).getAccountId());
        printChar('-', 60);
    }

    /**
     * Prints the admin's status, including their username.
     * 
     * @param admin the object of SystemAdminAccount
     */
    public static void printAdminStatus(SystemAdminAccount admin)
    {
        System.out.print("Username : " + admin.getName());
        System.out.println();
        printChar('-', 60);
    }

    public static void printAdminHeader(SystemAdminAccount admin)
    {
        CommonIcon.printHeader();
        CommonIcon.printAdminStatus(admin);
    }

    public static void printAdminHeader(SystemAdminAccount admin)
    {
        CommonIcon.printHeader();
        CommonIcon.printAdminStatus(admin);
    }

    public static void adminQuit(Scanner scanner) {
        try {
            Util.clearConsole(scanner);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        CommonIcon.printHeader();
        System.out.print(Color.LIME);
        System.out.println("Admin Session Ended.");
        System.out.print(Color.RESET);
        System.exit(0);
    }
}
