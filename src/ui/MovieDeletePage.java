<<<<<<< HEAD:src/GeneralSRC/MovieDeletePage.java
package GeneralSRC;
=======
package ui;
>>>>>>> de02b6f2023db24b66cd0ee64525621f85e4c359:src/ui/MovieDeletePage.java
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