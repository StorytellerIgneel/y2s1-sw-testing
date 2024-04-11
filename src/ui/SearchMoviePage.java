package ui;

import java.util.Scanner;
import java.util.ArrayList;
import account.*;
import movie.Movie;
import util.*;


public class SearchMoviePage {
    private int userIdx;
    private ArrayList<UserAccount> users;
    private ArrayList<Movie> movies = MovieCRUDGeneralPage.getMovieList();
    private ArrayList<Movie> result = new ArrayList<Movie>();
    private Scanner input;
    private String searchName;
    private boolean found;
    
    
    public SearchMoviePage(ArrayList<UserAccount> users, int userIdx, Scanner input)
    {
        this.users = users;
        this.userIdx = userIdx;
        this.input = input;
    }
    public void searchMovie()
    {
        do
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
            if(result.size() != 0)
            {
                found = true;
                ViewMovieInfoPage movieInfoPage = new ViewMovieInfoPage(result,userIdx,users,input);
                movieInfoPage.printSearchedMovies();
                movieInfoPage.viewMovieInfo();
            }
            else
            {
                found = false;
                SystemMessage.errorMessage(6);
            }
        }while(!found);
    }

 
}
