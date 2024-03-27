package movie;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        CRUDGeneralPage test = new CRUDGeneralPage();
        ArrayList<Movie> movieList = test.getMovieList();
        
        test.MainPage();
    }
}
