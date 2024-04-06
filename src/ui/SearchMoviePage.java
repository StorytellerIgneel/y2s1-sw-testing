package ui;

import java.util.Scanner;
import java.util.ArrayList;
import account.*;
import movie.Movie;
import util.CommonIcon;
import util.Validation;

public class SearchMoviePage {
    private int userIdx;
    private ArrayList<UserAccount> users;
    private ArrayList<Movie> movies = MovieCRUDGeneralPage.getMovieList();
    private ArrayList<Movie> result = new ArrayList<Movie>();
    private Scanner input;
    private String searchName;
    
    public SearchMoviePage(ArrayList<UserAccount> users, int userIdx, Scanner input)
    {
        this.users = users;
        this.userIdx = userIdx;
        this.input = input;
    }
    public void searchMovie()
    {
        System.out.print("Search for Movies (':q' to quit ':b to back'):");
        searchName = input.nextLine();
        if(Validation.isBack(searchName))
            return;

        for(int i = 0; i < movies.size(); i++)
        {
            if(movies.get(i).getTitle().toLowerCase().contains(searchName.toLowerCase()))
                result.add(movies.get(i));
        }
        
        ViewMovieInfoPage movieInfoPage = new ViewMovieInfoPage(result,userIdx,users,input);
        movieInfoPage.printSearchedMovies();
        movieInfoPage.viewMovieInfo();
    }

 
}
