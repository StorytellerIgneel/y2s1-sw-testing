package ui;

import java.util.Scanner;
import java.util.ArrayList;
import account.*;
import movie.Movie;
import util.CommonIcon;
import util.Validation;

public class SearchMoviePage {
    public static void searchMovie(ArrayList<Movie> movies, int userIdx, ArrayList<UserAccount> users)
    {
        ArrayList<Movie> result = new ArrayList<Movie>();
        System.out.print("Search for Movies (':q' to quit ':b to back'):");
        Scanner input = new Scanner(System.in);
        String searchName = input.nextLine();
        if(Validation.isBack(searchName))
            return;

        for(int i = 0; i < movies.size(); i++)
        {
            if(movies.get(i).getTitle().toLowerCase().contains(searchName.toLowerCase()))
                result.add(movies.get(i));
        }
        ViewMovieInfoPage.printSearchedMovies(result,userIdx, users);
    }

 
}
