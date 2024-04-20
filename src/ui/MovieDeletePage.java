package ui;

import java.util.ArrayList;
import java.util.Scanner;

import movie.Movie;
import movie.MovieCRUD;
import util.*;

public class MovieDeletePage implements MovieCRUD {

     /**
     * Delete page for deleting existing movies
     * 
     * @param movieList, @param scanner
     */
    @Override
    public void execute(ArrayList<Movie> movieList, Scanner scanner) {
        int movieIndex = 0;
        MovieCRUDGeneralPage.showAllMovieTitle(movieList);
        movieIndex = MovieCRUDGeneralPage.getMovieIndex(movieList, "delete", scanner);
        if (movieIndex == -1)
            return;
        movieList.remove(movieIndex);
        SystemMessage.successMessage(2, scanner);
        return;
    }
}
