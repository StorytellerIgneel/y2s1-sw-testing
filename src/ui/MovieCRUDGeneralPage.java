package ui;

import java.util.ArrayList;
import java.util.Scanner;
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

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MovieCRUDGeneralPage {
    ArrayList<Movie> movieList;

    // constructor
    public MovieCRUDGeneralPage() {};

    public void MainPage(Scanner scanner) {
        ArrayList<MovieCRUD> movieFunctions = new ArrayList<>();

        // lambda expression implementing interface
        MovieCRUD addMovie = (ArrayList<Movie> movieList) -> {
            new MovieAddPage().execute(movieList);
        };
        MovieCRUD listMovie = (ArrayList<Movie> movieList) -> {
            new MovieListPage().execute(movieList);
        };
        MovieCRUD updateMovie = (ArrayList<Movie> movieList) -> {
            new MovieUpdatePage().execute(movieList);
        };
        MovieCRUD deleteMovie = (ArrayList<Movie> movieList) -> {
            new MovieDeletePage().execute(movieList);
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
            mainPageChoice = Util.getInput("Enter your choice (':b' to back, ':q to quit'): ",
                    false, scanner);
            if (Validation.isNumber(mainPageChoice)) {
                mainPageChoiceInt = Integer.parseInt(mainPageChoice);
                if (mainPageChoiceInt > 0 && mainPageChoiceInt < 5) {
                    try {
                        Util.clearConsole(scanner);
                    } catch (Exception e) {
                        SystemMessage.errorMessage(6, scanner);
                    }
                    movieFunctions.get(mainPageChoiceInt - 1).execute(movieList);
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

    public static ArrayList<Movie> getMovieList() {
        // Gson gson = new GsonBuilder().registerTypeAdapterFactory(new
        // LocalDateTimeTypeAdapterFactory()).create(); TODO throws error, below fixes, remove this
        // line if fixed
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

    public static void showAllMovie(ArrayList<Movie> movieList) {
        int counter = 1;
        for (Movie movie : movieList) {
            System.out.println("\n\nMovie index: " + counter);
            System.out.println(movie.viewInformation());
            counter += 1;
        }
        return;
    }

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
}
