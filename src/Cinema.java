package Application;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.reflect.Type;
import java.io.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import util.*;

public class Cinema {
    // variables
    private String cinemaName;
    private String cinemaAddress;
    private static ArrayList<Cinema> cinemaLocation = getCinemas();

    // constructors
    public Cinema(String cinemaName, String cinemaAddress) {
        this.cinemaName = cinemaName;
        this.cinemaAddress = cinemaAddress;
    }

    public static ArrayList<Cinema> getCinemas() {
        Scanner scanner = new Scanner(System.in);
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Cinema>>() {}.getType();

        String line = "";
        try {
            File inFile = new File("src\\resources\\cinema.json");
            Scanner inputFile = new Scanner(inFile);
            while (inputFile.hasNextLine()) {
                line = inputFile.nextLine();
            }
            inputFile.close();
        } catch (IOException e) {
            SystemMessage.errorMessage(4, scanner);
        }

        ArrayList<Cinema> cinemaList = gson.fromJson(line, type);
        if (cinemaList == null) {
            cinemaList = new ArrayList<Cinema>();
        }
        return cinemaList;
    }

    // accessors
    public String getCinemaName() {
        return cinemaName;
    }

    public String getCinemaAddress() {
        return cinemaAddress;
    }

    public static ArrayList<Cinema> getCinemaLocation() {
        return cinemaLocation;
    }

}
