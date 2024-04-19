package utils;

import java.time.LocalDateTime;
import java.util.Scanner;

import cinema.Cinema;
import color.Color;
import movie.Movie;

public class BookingUtils {
    /**
     * Get the cinema location from user input
     * @param scanner Scanner object to get user input
     * @return Cinema object representing the selected cinema
     */
    public static Cinema getCinemaInput(Scanner scanner){
        Cinema[] cinemaList = Cinema.getCinemaLocation();

        // Get cinema location
        int choice = 0;
        boolean validInput = false;
        while (!validInput) {
            // Print cinema locations
            System.out.println(Color.RED + "Select a cinema location:");
            for (int i = 0; i < cinemaList.length; i++) { // 1-based index
                System.out.println(Color.RED + (i+1) + ") \t" + Color.LIME + cinemaList[i].getCinemaName() + Color.RESET);
                System.out.println("\t" + Color.LIME + cinemaList[i].getCinemaAddress() + Color.RESET);
            }

            // Get user choice for cinema location
            System.out.print(Color.RESET + "Select the cinema you would like to book: ");
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

    /**
     * Get the showtime from user input
     * @param scanner Scanner object to get user input
     * @param showtimes Array of showtimes to choose from
     * @return LocalDateTime representing the selected showtime
     */
    public static LocalDateTime getShowtimeInput(Scanner scanner, Movie selectedMovie){
        // Get showtime
        int choice = 0;
        boolean validInput = false;
        while (!validInput)
        {
            System.out.println("Available showtimes:");
            for (int i = 0; i < selectedMovie.getShowtimes().size(); i++) {
                System.out.println(Color.RED + (i+1) + ") \t" + Color.LIME + selectedMovie.getShowtimes().get(i) + Color.RESET);
            }
            System.out.print(Color.RESET + "Select a showtime: " + Color.RESET);
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice <= 0 || choice > selectedMovie.getShowtimes().size()) { // 1-based index
                    System.out.println("Showtime out of bounds. Please enter a number between 1 and " + selectedMovie.getShowtimes().size() + ".");
                    continue;
                }
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Discard the invalid input
            }
        }

        // Get selected showtime
        LocalDateTime selectedShowtime = selectedMovie.getShowtimes().get(choice - 1); // Adjust for 0-based index
        System.out.println("Showtime selected: " + selectedShowtime);
        System.out.println(); // Add a newline for layout
        return selectedShowtime;
    }
    
    /**
     * Get the quantity of child tickets from user input
     * @param scanner Scanner object to get user input
     * @return int representing the quantity of child tickets
     */
    public static int getTicketQuantityInput(Scanner scanner, String ticketType){
        int ticketQuantity = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print(Color.RESET + "Enter number of "+ ticketType + " tickets: ");
            if (scanner.hasNextInt()) {
                ticketQuantity = scanner.nextInt();
                if (ticketQuantity < 0 || ticketQuantity > 1000) 
                {
                    System.out.println("Invalid input. Please enter a positive number.");
                    continue;
                }
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next(); // Discard the invalid input
            }
        }
        return ticketQuantity;
    }
}
