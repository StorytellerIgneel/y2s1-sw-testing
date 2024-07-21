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
     * Prints the user's status, including their username and user ID.
     * 
     * @param index the index of the user in the list of users
     * @param users the list of user accounts
     */
    public static void printUserStatus(int index, ArrayList<Account> users) {
        System.out.print("Username  : " + users.get(index).getName());
        System.out.println("\t\tUserID    : " + users.get(index).getName());
        printChar('-', 60);
    }
}
