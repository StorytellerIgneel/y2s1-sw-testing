package movie;
import java.util.ArrayList;

public class MovieDeletePage implements MovieCRUD {
    @Override
    public void execute (ArrayList<Movie> movieList) {
        int movieIndex = 0;

        MovieCRUDGeneralPage.showAllMovie(movieList);
        movieIndex = MovieCRUDGeneralPage.getMovieIndex(movieList, "delete");

        movieList.remove(movieIndex);
        SystemMessage.successMessage(2);
        return;
    }
}