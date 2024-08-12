package FileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
import account.Account;
import movie.Movie;
import validation.SystemMessage;
import validation.Validation;
import booking.Booking;

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

    public static ArrayList<Booking> getBookingList() {
        Gson gson = new GsonBuilder()
        .registerTypeAdapterFactory(new LocalDateTypeAdapterFactory())
        .registerTypeAdapterFactory(new LocalTimeTypeAdapterFactory())
        .create();
        Type bookingListType = new TypeToken<ArrayList<Booking>>() {}.getType();
        ArrayList<Booking> bookingList = new ArrayList<>();
        String line = null;

        try {
            File file = new File("./src/resources/booking.json");
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
     * Export booking data to bookings.json
     * 
     * @param bookingList
     */
    public static void exportBookingData(ArrayList<Booking> bookingList, Scanner scanner) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new LocalDateTypeAdapterFactory())
                .registerTypeAdapterFactory(new LocalTimeTypeAdapterFactory())
                .create();
        String toWrite = gson.toJson(bookingList);
        try {
            PrintWriter outputFile = new PrintWriter("./src/resources/booking.json");
            outputFile.println(toWrite);
            outputFile.close();
        } catch (FileNotFoundException error) {
            SystemMessage.errorMessage(3, scanner);
        }
        return;
    }

    public static ArrayList<Account> getAccountList() {
        Gson gson = new GsonBuilder()
        .registerTypeAdapterFactory(new LocalDateTypeAdapterFactory())
        .registerTypeAdapterFactory(new LocalTimeTypeAdapterFactory())
        .create();
        Type AccountListType = new TypeToken<ArrayList<Account>>() {}.getType();
        ArrayList<Account> AccountList = new ArrayList<>();
        String line = null;

        try {
            File file = new File("./src/resources/account.json");
            Scanner inputFile = new Scanner(file);
            while (inputFile.hasNextLine())
                line = inputFile.nextLine();
            inputFile.close();
        } catch (FileNotFoundException error) {
            error.printStackTrace();
        }

        AccountList = gson.fromJson(line, AccountListType);

        return ((Validation.isNull(line)) ? (new ArrayList<Account>()) : AccountList);
    }

    /**
     * Export movie data to bookings.json
     * 
     * @param bookingList
     */
    public static void exportBookingData(ArrayList<Booking> bookingList, Scanner scanner) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new LocalDateTypeAdapterFactory())
                .registerTypeAdapterFactory(new LocalTimeTypeAdapterFactory())
                .create();
        String toWrite = gson.toJson(bookingList);
        try {
            PrintWriter outputFile = new PrintWriter("./src/resources/booking.json");
            outputFile.println(toWrite);
            outputFile.close();
        } catch (FileNotFoundException error) {
            SystemMessage.errorMessage(3, scanner);
        }
        return;
    }
}
