package util;

import java.util.ArrayList;
import movie.Movie;

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
}
