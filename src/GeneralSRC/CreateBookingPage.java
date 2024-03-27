package GeneralSRC;
import java.util.ArrayList;

public class CreateBookingPage {
    public static void printSearchedMovies(String searchName, ArrayList<Movie> movies)
    {
        for(int i = 0; i < movies.size(); i++) //displays all the related movies
        {
            if(movies.get(i).getTitle().toLowerCase().contains(searchName.toLowerCase()))
            {
                System.out.println((i+1) + movies.get(i).getTitle());
            }
        }
    }

    public static void chooseMovie()
    {
        System.out.println("Select a movie: ");
    }
}
