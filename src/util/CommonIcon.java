package util;

import java.util.ArrayList;
import movie.Movie;
import account.*;

public class CommonIcon {
    public static void printHeader()
    {
        printChar('-', 60);
        System.out.println("TVG Cinemas");
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
        for(Movie movie : movies)
        {
            System.out.println(movie.getTitle());
        }

    }
    
    public static void printLatest(ArrayList<Movie> movies)
    {
        System.out.println("#Latest Release");
        for(Movie movie : movies)
        {
            System.out.println(movie.getTitle());
        }
    }

    public static void printUserStatus(int index, ArrayList<UserAccount> users)
    {
        // printChar('-', 60);
        System.out.print("Username  : "+users.get(index).getName());
        System.out.println("\t\tUserID    : "+users.get(index).getAccountId());
        printChar('-', 60);
    }
}
