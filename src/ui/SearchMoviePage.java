package ui;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import account.*;
import color.Color;
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


    public SearchMoviePage(ArrayList<UserAccount> users, int userIdx, Scanner input) {
        this.users = users;
        this.userIdx = userIdx;
        this.input = input;
    }

    /**
     * This method is used to search for movies in the movieList. It takes the user input and
     * searches for the movies based on the input. If the movie is found, it will display the movie
     * information. If the movie is not found, it will display an error message.
     *
     */
    public void searchMovie() {
        do {
            System.out.print("Search for Movies (':q' to quit ':b to back'):");
            input.nextLine();
            searchName = input.nextLine();
            if (Validation.isBack(searchName))
                return;
            if (Validation.isQuit(searchName)) {
                try {
                    Util.clearConsole(input);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
                CommonIcon.printHeader();
                input.close();
                System.out.print(Color.LIME);
                System.out.println("Thank you for using TVG Cinemas.");
                System.out.println("Vist Us Next Time.");
                System.out.print(Color.RESET);
                System.exit(0);
            }


            for (int i = 0; i < movies.size(); i++) {
                if (movies.get(i).getTitle().toLowerCase().contains(searchName.toLowerCase()))
                    result.add(movies.get(i));
            }
            if (result.size() != 0) {
                found = true;
                ViewMovieInfoPage movieInfoPage =
                        new ViewMovieInfoPage(result, userIdx, users, input);
                movieInfoPage.printSearchedMovies();
                movieInfoPage.viewMovieInfo();
            } else {
                found = false;
                SystemMessage.errorMessage(6, input);
            }
        } while (!found);
    }
}
