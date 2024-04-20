package ui;

import java.util.Scanner;
import movie.Movie;
import java.util.ArrayList;
// TODO remove file in production
public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Movie> movieList = MovieCRUDGeneralPage.getMovieList();
        MovieCRUDGeneralPage.sortReleaseDate(movieList);
    }
}
