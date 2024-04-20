package ui;

import movie.Movie;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
// TODO remove file in production

public class Main {
    public static void main(String[] args) {
        // Initialize a Movie object
        Scanner scanner = new Scanner(System.in);
        Movie movie = new Movie();
        ArrayList<LocalDateTime> showtimes = new ArrayList<>();
        ArrayList<String> languages = new ArrayList<>();
        ArrayList<String> genres = new ArrayList<>();

        movie.setMovieId("123");
        movie.setTitle("Example Movie");
        movie.setDescription("This is an example movie.");
        movie.setReleaseDate(LocalDateTime.of(2024, 4, 18, 12, 0)); // Example release date
        movie.setPriceAdult(10.99); // Example adult price
        movie.setPriceChildren(6.99); // Example children price
        showtimes.add(LocalDateTime.of(2024, 4, 18, 14, 0)); // Example showtime
        movie.setShowtimes(showtimes); // Example);
        languages.add("English"); // Example language
        movie.setLanguages(languages); // Example language
        genres.add("Action"); // Example genre
        movie.setGenre(genres); // Example genre

        // Print the initialized movie object
        System.out.println("Initialized Movie:");
        System.out.println(movie);

        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(movie);

        MovieCRUDGeneralPage.exportMovieData(movies, scanner);
    }
}
