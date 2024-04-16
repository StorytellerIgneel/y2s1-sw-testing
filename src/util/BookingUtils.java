package util;

import java.util.Scanner;

import cinema.Cinema;
import color.Color;

public class BookingUtils {
    public static Cinema getCinemaInput(Scanner scanner){
        Cinema[] cinemaList = Cinema.getCinemaLocation();

        // Get cinema location
        int choice = 0;
        boolean validInput = false;
        while (!validInput) {
            // Print cinema locations
            System.out.println(Color.red + "Select a cinema location:");
            for (int i = 0; i < cinemaList.length; i++) { // 1-based index
                System.out.println(Color.red + (i+1) + ") \t" + Color.lime + cinemaList[i].getCinemaName() + Color.reset);
                System.out.println("\t" + Color.lime + cinemaList[i].getCinemaAddress() + Color.reset);
            }

            // Get user choice for cinema location
            System.out.print(Color.reset + "Select the cinema you would like to book: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice <= 0 || choice > cinemaList.length) {
                    System.out.println("Cinema out of bounds. Please enter a number between 1 and " + cinemaList.length + ".");
                    continue;
                }
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Discard the invalid input
            }
        }

        // Get selected cinema
        Cinema selectedCinema = cinemaList[choice - 1]; // Adjust for 0-based index
        System.out.println("You have selected: " + selectedCinema.getCinemaName());
        System.out.println(); // Add a newline for layout
        return selectedCinema;
    }
}
