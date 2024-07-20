import java.util.ArrayList;
import java.util.Scanner;

import FileHandling.FileHandling;
import movie.*;

public class testing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Movie> movies = FileHandling.getMovieList();
        for (Movie movie : movies) {
            System.out.println(movie.getTitle());
        FileHandling.exportMovieData(movies, null);
        }

        
    }
}