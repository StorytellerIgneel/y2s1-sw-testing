<<<<<<< HEAD:src/GeneralSRC/CommonIcon.java
package GeneralSRC;
import java.util.ArrayList;

=======
package util;
>>>>>>> de02b6f2023db24b66cd0ee64525621f85e4c359:src/util/CommonIcon.java
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
