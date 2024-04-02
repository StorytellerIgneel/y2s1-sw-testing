package movie;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        MovieCRUDGeneralPage test = new MovieCRUDGeneralPage();
        ArrayList<Movie> movieList = test.getMovieList();
        
        test.MainPage();
    }
}
