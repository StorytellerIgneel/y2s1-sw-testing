package ui;

import java.util.Scanner;
import java.util.ArrayList;

import movie.Movie;
import util.CommonIcon;
import util.Validation;

public class SearchMoviePage {
    public static void printMovies(ArrayList<Movie> trendMovies, ArrayList<Movie> latestMovies)
    {
        CommonIcon.printHeader();
        CommonIcon.printTrend(trendMovies);
        CommonIcon.printLatest(latestMovies);
    }

    public static String searchMovie(ArrayList<Movie> movies)
    {
        System.out.print("Search for Movies (':q' to quit ':b to back'):");
        Scanner input = new Scanner(System.in);
        String searchName = input.nextLine();

        if(Validation.isBack(searchName))
            return;
            
        // for(int i = 0; i < movies.size(); i++)
        // {
        //     if(movies.get(i).getTitle().toLowerCase().contains(searchName.toLowerCase()))
        //     {
        //         System.out.println((i+1) + movies.get(i).getTitle());
        //     }
        // }

        return searchName;
    }
}
