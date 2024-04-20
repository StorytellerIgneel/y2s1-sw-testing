package ui;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import movie.Movie;
import movie.MovieCRUD;
import util.*;
import color.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MovieCRUDGeneralPage {
    ArrayList<Movie> movieList;
    Scanner scanner;

    /**
     * Constructor
     */
    public MovieCRUDGeneralPage(Scanner scanner) {
        this.scanner = scanner;
    };

    /**
     * Main page for movie CRUD operations
     * 
     * @param scanner
     */
    public void MainPage() {
        ArrayList<MovieCRUD> movieFunctions = new ArrayList<>();

        // lambda expression implementing interface
        MovieCRUD addMovie = (ArrayList<Movie> movieList, Scanner lambdaScanner) -> {
            new MovieAddPage().execute(movieList, scanner);
        };
        MovieCRUD listMovie = (ArrayList<Movie> movieList, Scanner lambdaScanner) -> {
            new MovieListPage().execute(movieList, scanner);
        };
        MovieCRUD updateMovie = (ArrayList<Movie> movieList, Scanner lambdaScanner) -> {
            new MovieUpdatePage().execute(movieList, scanner);
        };
        MovieCRUD deleteMovie = (ArrayList<Movie> movieList, Scanner lambdaScanner) -> {
            new MovieDeletePage().execute(movieList, scanner);
        };

        movieFunctions.add(addMovie);
        movieFunctions.add(listMovie);
        movieFunctions.add(updateMovie);
        movieFunctions.add(deleteMovie);

        while (true) {
            String mainPageChoice;
            Integer mainPageChoiceInt = 0;

            try {
                Util.clearConsole(scanner);
            } catch (Exception e) {
                SystemMessage.errorMessage(6, scanner);
            }
            movieList = getMovieList();

            CommonIcon.printHeader();
            System.out.println("Choose an action:");
            System.out.println(Color.RED + "1." + Color.LIME + " Add a Movie" + Color.RESET);
            System.out.println(Color.RED + "2." + Color.LIME + " List all Movies" + Color.RESET);
            System.out.println(Color.RED + "3." + Color.LIME + " Update a Movie" + Color.RESET);
            System.out.println(Color.RED + "4." + Color.LIME + " Delete a Movie" + Color.RESET);
            mainPageChoice = Util.getInput("Enter your choice (':b' to back, ':q' to quit, this is applicable throughout the entire section of movie handling):", false,
                    scanner);
            if (Validation.isNumber(mainPageChoice)) {
                mainPageChoiceInt = Integer.parseInt(mainPageChoice);
                if (mainPageChoiceInt > 0 && mainPageChoiceInt < 5) {
                    try {
                        Util.clearConsole(scanner);
                    } catch (Exception e) {
                        SystemMessage.errorMessage(6, scanner);
                    }
                    movieFunctions.get(mainPageChoiceInt - 1).execute(movieList, scanner);
                } else if (mainPageChoiceInt == 5) {
                    exportMovieData(movieList, scanner);
                    return;
                } else
                    SystemMessage.errorMessage(2, scanner);
            } else {
                if (Validation.isBack(mainPageChoice))
                    return;
                else if (Validation.isQuit(mainPageChoice)) {
                    exportMovieData(movieList, scanner);
                    return;
                } else
                    SystemMessage.errorMessage(1, scanner);
            }
            exportMovieData(movieList, scanner);
        }
    }

    /**
     * Get movie list from movieData.json
     * 
     * @return ArrayList<Movie> movieList
     */
    public static ArrayList<Movie> getMovieList() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
                    @Override
                    public LocalDateTime deserialize(JsonElement json, Type typeOfT,
                            JsonDeserializationContext context) throws JsonParseException {
                        return LocalDateTime.parse(json.getAsString(),
                                DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                    }
                }).create();
        Type movieListType = new TypeToken<ArrayList<Movie>>() {}.getType();
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        String line = null;

        try {
            File file = new File("./src/resources/movieData.json");
            Scanner inputFile = new Scanner(file);
            while (inputFile.hasNextLine())
                line = inputFile.nextLine();
            inputFile.close();
        } catch (FileNotFoundException error) {
            error.printStackTrace();
        }

        movieList = gson.fromJson(line, movieListType);

        return ((Validation.isNull(line)) ? (new ArrayList<Movie>()) : movieList);
    }

    /**
     * Export movie data to movieData.json
     * 
     * @param movieList
     */
    public static void exportMovieData(ArrayList<Movie> movieList, Scanner scanner) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new LocalDateTimeTypeAdapterFactory()).create();
        String toWrite = gson.toJson(movieList);
        try {
            PrintWriter outputFile = new PrintWriter("./src/resources/movieData.json");
            outputFile.println(toWrite);
            outputFile.close();
        } catch (FileNotFoundException error) {
            SystemMessage.errorMessage(3, scanner);
        }
        return;
    }

    /**
     * Show all movies in the movieList
     * 
     * @param movieList
     */
    public static void showAllMovie(ArrayList<Movie> movieList) {
        int counter = 1;
        for (Movie movie : movieList) {
            System.out.println("\n\nMovie index: " + counter);
            System.out.println(movie.viewInformation());
            counter += 1;
        }
        return;
    }

    /**
     * Show all movie titles in the movieList
     * 
     * @param movieList
     */
    public static void showAllMovieTitle(ArrayList<Movie> movieList) {
        for (Movie movie : movieList)
            System.out
                    .println("Index " + (movieList.indexOf(movie) + 1) + ": " + (movie.getTitle()));
        return;
    }


    /**
     * Get movie index from user input so that the calling programme can choose the correct movie to be changed
     * 
     * @param movieList
     * @param action
     * @param scanner
     * @return int index
     */
    public static int getMovieIndex(ArrayList<Movie> movieList, String action, Scanner scanner) {
        String index = null;

        while (true) {
            index = Util.getInput("Enter the index of the movie you wish to " + action + ": ",
                    false, scanner);
            if (Validation.isNumber(index)) {
                int indexInt = Integer.parseInt(index);
                if (indexInt > 0 && indexInt <= movieList.size())
                    return indexInt - 1;
                else
                    SystemMessage.errorMessage(2, scanner);
            } else {
                if (Validation.isBack(index))
                    return -1;
                else
                    SystemMessage.errorMessage(1, scanner);
            }
        }
    }

    /**
     * Sort the movie List by the Release date of the movie by descending (The latest released movies will be at first)
     * Used to show the latest released movies in the calling pages
     * @param movieList
     */
    public static void sortReleaseDate (ArrayList<Movie> movieList){
        Collections.sort(movieList, Comparator.comparing(Movie::getReleaseDate).reversed());
    }
}
