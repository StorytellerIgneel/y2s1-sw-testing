package FileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import movie.Movie;
import booking.Booking;
import util.SystemMessage;
import util.Validation;

public class FileHandling {
        public static ArrayList<Movie> getMovieList() {
        Gson gson = new GsonBuilder()
            .registerTypeAdapterFactory(new LocalDateTypeAdapterFactory())
            .registerTypeAdapterFactory(new LocalTimeTypeAdapterFactory())
            .create();
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
    public static void exportBookingData(ArrayList<Movie> movieList, Scanner scanner) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new LocalDateTypeAdapterFactory())
                .registerTypeAdapterFactory(new LocalTimeTypeAdapterFactory())
                .create();
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

    public static ArrayList<Booking> getBookingList() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new LocalDateTypeAdapterFactory())
                .registerTypeAdapterFactory(new LocalTimeTypeAdapterFactory())
                .create();
        Type bookingListType = new TypeToken<ArrayList<Booking>>() {}.getType();
        ArrayList<Booking> bookingList = new ArrayList<Booking>();
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

        bookingList = gson.fromJson(line, bookingListType);

        return ((Validation.isNull(line)) ? (new ArrayList<Booking>()) : bookingList);
    }

    /**
     * Export movie data to movieData.json
     * 
     * @param movieList
     */
    public static void exportMovieData(ArrayList<Movie> movieList, Scanner scanner) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new LocalDateTypeAdapterFactory())
                .registerTypeAdapterFactory(new LocalTimeTypeAdapterFactory())
                .create();
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
}
