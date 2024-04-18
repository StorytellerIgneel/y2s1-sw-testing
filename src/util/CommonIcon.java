package util;

import java.util.ArrayList;
import movie.Movie;
import account.*;
import color.Color;

public class CommonIcon {
    public static void printHeader()
    {
        printChar('-', 60);
        System.out.println("▀█▀░█░█░█▀▀░ ░█▀▀░█░█▄░█░█▀▀░█▀▄▀█░▄▀█░█▀");
        System.out.println("░█░░▀▄▀░█▄█░ ░█▄▄░█░█░▀█░██▄░█░▀░█░█▀█░▄█");
        printChar('-', 60);
    }

    public static void printChar(char ch, int times)
    {
        for (int i = 0; i < times; i++)
        {
            System.out.print(ch);
        }
        System.out.println();
    }

    public static void printTrend(ArrayList<Movie> movies)
    {
        System.out.println("#Trending Now");
        for(int i = 0; i < movies.size(); i++)
        {
            System.out.println(Color.RED + "  " + (i+1) + ") " + Color.LIME + movies.get(i).getTitle() + Color.RESET);
        }

    }
    
    public static void printLatest(ArrayList<Movie> movies)
    {
        System.out.println("#Latest Release");
        for(int i = 0; i < movies.size(); i++)
        {
            System.out.println( Color.RED + "  " + (i+1) + ") " + Color.LIME + movies.get(i).getTitle() + Color.RESET);
        }

    }

    public static void printUserStatus(int index, ArrayList<UserAccount> users)
    {
        System.out.print("Username  : "+users.get(index).getName());
        System.out.println("\t\tUserID    : "+users.get(index).getAccountId());
        printChar('-', 60);
    }
    // public static void printUserStatus(UserAccount user)
    // {
    //     System.out.print("Username  : "+user.getName());
    //     System.out.println("\t\tUserID    : "+user.getAccountId());
    //     printChar('-', 60);
    // }

    public static void printAdminStatus(int index, ArrayList<SystemAdminAccount> admins)
    {
        System.out.print("Username : " + admins.get(index).getName());
        System.out.println();
    }
}
