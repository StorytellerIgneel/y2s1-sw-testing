package ui;

import java.util.ArrayList;
import java.util.Scanner;

import movie.Movie;
import movie.MovieCRUD;
import util.Util;

public class MovieListPage implements MovieCRUD {

     /**
     * List page for Listing all existing movies with their informations (not only title)
     * 
     * @param movieList, @param scanner
     */
    @Override
    public void execute(ArrayList<Movie> movieList, Scanner scanner) {
        MovieCRUDGeneralPage.showAllMovie(movieList);
        scanner.nextLine();
        Util.waitForEnter(scanner);
        return;
    }
}
