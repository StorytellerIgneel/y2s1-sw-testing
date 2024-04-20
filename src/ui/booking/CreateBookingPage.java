package ui.booking;

import java.time.LocalDateTime;
import java.util.ArrayList;

import cinema.Cinema;
import color.Color;
import movie.Movie;
import util.BookingUtils;
import booking.BookingController;
import java.util.Scanner;
import javax.swing.colorchooser.ColorSelectionModel;

public class CreateBookingPage implements Page {
    private BookingController bookingController;
    private Scanner scanner;

    public CreateBookingPage(BookingController bookingController, Scanner scanner) {
        this.bookingController = bookingController;
        this.scanner = scanner;
    }

    /**
     * Displays the create booking page
     * 
     * @throws IllegalArgumentException
     */
    public void display() throws IllegalArgumentException {
        if (ui.MovieCRUDGeneralPage.getMovieList() == null
                || ui.MovieCRUDGeneralPage.getMovieList().isEmpty()) {
            System.out.println("No movies available for booking.");
            throw new IllegalArgumentException("No movies available for booking.");
        }
        ArrayList<Movie> movieList = ui.MovieCRUDGeneralPage.getMovieList();


        // Search for movie
        int resultCount = 0;
        ArrayList<Movie> movieSearchResults = new ArrayList<Movie>();
        while (resultCount == 0) {
            // Get user query input
            System.out.println(Color.RESET + "Create a Booking");
            System.out.print(Color.RESET + "Search for movie title:");
            String query = scanner.nextLine();
            System.out.println(Color.RESET + "Search results:");

            // Search for movie in movieList

            query = query.replaceAll("\\s", "").toLowerCase(); // Remove whitespace and convert to
                                                               // lowercase
            for (Movie movie : movieList) {
                if (movie.getTitle().replaceAll("\\s", "").toLowerCase().contains(query)) {
                    movieSearchResults.add(movie);
                    resultCount++;
                }
            }

            // Skip to next iteration if no results found
            if (resultCount == 0) {
                System.out.println("No movies found. Please try again.");
                continue;
            }

            // Print search results count
            System.out.println("Found " + resultCount + " results.");
        }

        // Get movie
        int choice = 0;
        boolean validInput = false;
        while (!validInput) {
            // Print search results
            System.out.println(Color.RED + "Search Results:");
            for (int i = 0; i < movieSearchResults.size(); i++) {
                System.out.println(Color.RED + (i + 1) + ") \t" + Color.LIME
                        + movieSearchResults.get(i).getTitle() + Color.RESET);
            }

            // Get user choice for movie
            System.out.print(Color.RESET + "Select the movie you would like to book: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice <= 0 || choice > movieSearchResults.size()) { // 1-based index
                    System.out.println("Movie out of bounds. Please enter a number between 1 and "
                            + movieSearchResults.size() + ".");
                    continue;
                }
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Discard the invalid input
            }
        }

        // Get selected movie
        Movie selectedMovie = movieSearchResults.get(choice - 1); // Adjust for 0-based index
        System.out.println("You have selected: " + selectedMovie.getTitle());
        System.out.println(); // Add a newline for layout

        // Get cinema location from user
        Cinema selectedCinema = BookingUtils.getCinemaInput(scanner);

        // Get showtime from user
        LocalDateTime selectedShowtime = BookingUtils.getShowtimeInput(scanner, selectedMovie);

        // Get Adult and Child ticket quantity
        int quantityAdult = BookingUtils.getTicketQuantityInput(scanner, "adult");
        int quantityChildren = BookingUtils.getTicketQuantityInput(scanner, "child");

        // Print ticket quantity
        System.out.println("Adult tickets: " + quantityAdult);
        System.out.println("Child tickets: " + quantityChildren);

        // Confirm booking
        choice = 0;
        validInput = false;
        while (!validInput) {
            System.out.println(Color.RED + "Confirm booking?");
            System.out.println(Color.RED + "1) " + Color.LIME + "Yes");
            System.out.println(Color.RED + "2) " + Color.LIME + "No");
            System.out.print(Color.RESET + "Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice < 1 || choice > 2) {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                    continue;
                }
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Discard the invalid input
            }
        }
        if (choice == 1) {
            // Create booking
            bookingController.createBooking(selectedMovie, selectedCinema, selectedShowtime,
                    quantityAdult, quantityChildren);
            System.out.println(Color.LIME + "Booking created successfully." + Color.RESET);
            System.out.println(); // Add a newline for layout
        } else {
            System.out.println(Color.RED + "Booking cancelled." + Color.RESET);
            return;
        }
        return;
    }
}
