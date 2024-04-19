package ui;
import java.util.ArrayList;
import java.util.Scanner;

import movie.Movie;
import movie.MovieCRUD;
import util.*;

public class MovieDeletePage implements MovieCRUD {
    @Override
    public void execute(ArrayList<Movie> movieList) {
        int movieIndex = 0;
        Scanner scanner = new Scanner(System.in);
        MovieCRUDGeneralPage.showAllMovie(movieList);
        movieIndex = MovieCRUDGeneralPage.getMovieIndex(movieList, "delete", scanner);
        if (movieIndex == -1)
            return;
        movieList.remove(movieIndex);
        SystemMessage.successMessage(2, scanner);
        return;
    }
}