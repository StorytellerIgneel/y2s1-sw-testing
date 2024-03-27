package ui;
import java.util.ArrayList;

import movie.Movie;
import util.SystemMessage;

public class MovieDeletePage implements MovieCRUD {
    public void deleteMovie (ArrayList<Movie> movieList) {
        int movieIndex = 0;

        CRUDGeneralPage.showAllMovie(movieList);
        movieIndex = CRUDGeneralPage.getMovieIndex(movieList, "delete");

        movieList.remove(movieIndex);
        SystemMessage.successMessage(2);
        return;
    }

    public void execute(ArrayList<Movie> movieList) {
        deleteMovie(movieList);
        return;
    }
}