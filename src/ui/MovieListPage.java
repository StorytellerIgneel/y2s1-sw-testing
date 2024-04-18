package ui;

import java.util.ArrayList;

import movie.Movie;
import movie.MovieCRUD;
import util.Util;

public class MovieListPage implements MovieCRUD {
    @Override
    public void execute(ArrayList<Movie> movieList) {
        MovieCRUDGeneralPage.showAllMovie(movieList); 
        Util.waitForEnter();
        return;
    }
}
