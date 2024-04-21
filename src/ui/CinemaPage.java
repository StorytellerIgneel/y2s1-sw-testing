package ui;

import java.util.ArrayList;
import cinema.Cinema;
import util.CommonIcon;

public class CinemaPage {
    private static ArrayList<Cinema> cinemas = Cinema.getCinemaLocation();

    public static void printAllCinemaLocation() {
        CommonIcon.printHeader();
        System.out.printf("%-30s\t%-150s\n", "Cinema Name", "Cinema Address");
        for (Cinema cinema : cinemas) {
            System.out.printf("%-30s\t%-150s\n", cinema.getCinemaName(), cinema.getCinemaAddress());
        }
    }
}
