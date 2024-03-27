package movie;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieListPage implements MovieCRUD {
    @Override
    public void execute(ArrayList<Movie> movieList) {
        Scanner input = new Scanner(System.in);
        
        CRUDGeneralPage.showAllMovie(movieList); 
        input.nextLine();
        return;
    }
}
