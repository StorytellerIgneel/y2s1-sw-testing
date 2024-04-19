package ui;

import java.util.ArrayList;
import java.util.Scanner;

import movie.Movie;
import movie.MovieCRUD;
import util.Util;

public class MovieListPage implements MovieCRUD {
    @Override
    public void execute(ArrayList<Movie> movieList) {
        Scanner scanner = new Scanner(System.in);
        MovieCRUDGeneralPage.showAllMovie(movieList); 
        Util.waitForEnter(scanner);
        return;
    }
}
