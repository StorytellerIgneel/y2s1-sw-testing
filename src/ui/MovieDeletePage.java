package ui;
import java.util.ArrayList;

import movie.Movie;
import movie.MovieCRUD;
import util.*;

public class MovieDeletePage implements MovieCRUD {
    @Override
    public void execute(ArrayList<Movie> movieList) {
        int movieIndex = 0;

        MovieCRUDGeneralPage.showAllMovie(movieList);
        movieIndex = MovieCRUDGeneralPage.getMovieIndex(movieList, "delete");
        if (movieIndex == -1)
            return;
        movieList.remove(movieIndex);
        SystemMessage.successMessage(2);
        return;
    }
}