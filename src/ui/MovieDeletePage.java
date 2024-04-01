package ui;
import java.util.ArrayList;

import movie.Movie;
import util.SystemMessage;

public class MovieDeletePage implements MovieCRUD {
    public void deleteMovie (ArrayList<Movie> movieList) {
        int movieIndex = 0;

        UICRUDGeneralPage.showAllMovie(movieList);
        movieIndex = UICRUDGeneralPage.getMovieIndex(movieList, "delete");

        movieList.remove(movieIndex);
        SystemMessage.successMessage(2);
        return;
    }

    public void execute(ArrayList<Movie> movieList) {
        deleteMovie(movieList);
        return;
    }
}