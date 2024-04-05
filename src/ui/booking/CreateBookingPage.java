package ui.booking;

import java.util.ArrayList;

import cinema.Cinema;
import color.Color;
import movie.Movie;
import booking.BookingController;
import java.util.Scanner;

public class CreateBookingPage {
    private BookingController bookingController;
    private Scanner scanner;

    public CreateBookingPage(BookingController bookingController, Scanner scanner) {
        this.bookingController = bookingController;
        this.scanner = scanner;
    }

    /**
     * Displays the create booking page
     * @throws IllegalArgumentException
     */
    public void display() throws IllegalArgumentException
    {   
        if (ui.MovieCRUDGeneralPage.getMovieList() == null || ui.MovieCRUDGeneralPage.getMovieList().isEmpty()) {
            System.out.println("No movies available for booking.");
            throw new IllegalArgumentException("No movies available for booking.");
        }
        ArrayList<Movie> movieList = ui.MovieCRUDGeneralPage.getMovieList();
        Cinema[] cinemaList = Cinema.getCinemaLocation();

        // Search for movie
        int resultCount = 0;
        ArrayList<Movie> movieSearchResults = new ArrayList<Movie>();
        while(resultCount == 0)
        {
            // Get user query input
            System.out.println(Color.reset + "Create a Booking");
            System.out.print(Color.reset + "Search for movie title:");
            String query = scanner.nextLine();
            System.out.println(Color.reset + "Search results:");
            
            // Search for movie in movieList
                     
            query = query.replaceAll("\\s", "").toLowerCase(); // Remove whitespace and convert to lowercase
            for (Movie movie : movieList) {
                if (movie.getTitle().replaceAll("\\s", "").toLowerCase().contains(query)) {
                    movieSearchResults.add(movie);
                    resultCount++;
                }
            }

            // Skip to next iteration if no results found
            if (resultCount == 0){
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
            System.out.println(Color.red + "Search Results:");
            for (int i = 0; i < movieSearchResults.size(); i++){
                System.out.println(Color.red + (i+1) + ") \t" + Color.lime + movieSearchResults.get(i).getTitle() + Color.reset);
            }

            // Get user choice for movie
            System.out.print(Color.reset + "Select the movie you would like to book: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice <= 0 || choice > movieSearchResults.size()) { // 1-based index
                    System.out.println("Movie out of bounds. Please enter a number between 1 and " + movieSearchResults.size() + ".");
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

        // Get cinema location
        choice = 0;
        validInput = false;
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
                    System.out.println("Cinema out of bounds. Please enter a number between 1 and " + movieSearchResults.size() + ".");
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

        // Get showtime
        choice = 0;
        validInput = false;
        while (!validInput)
        {
            System.out.println("Available showtimes:");
            for (int i = 0; i < selectedMovie.getShowtimes().size(); i++) {
                System.out.println(Color.red + (i+1) + ") \t" + Color.lime + selectedMovie.getShowtimes().get(i) + Color.reset);
            }
            System.out.print(Color.reset + "Select a showtime: " + Color.reset);
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice <= 0 || choice > selectedMovie.getShowtimes().size()) { // 1-based index
                    System.out.println("Showtime out of bounds. Please enter a number between 1 and " + movieSearchResults.size() + ".");
                    continue;
                }
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Discard the invalid input
            }
        }

        // Get selected showtime
        String selectedShowtime = selectedMovie.getShowtimes().get(choice - 1); // Adjust for 0-based index
        System.out.println("Showtime selected: " + selectedShowtime);
        System.out.println(); // Add a newline for layout

        // Get Adult and Child ticket quantity
        int quantityAdult = 0;
        validInput = false;
        while (!validInput) {
            System.out.print(Color.reset + "Enter number of adult tickets: ");
            if (scanner.hasNextInt()) {
                quantityAdult = scanner.nextInt();
                if (quantityAdult < 0 || quantityAdult > 1000) 
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

        int quantityChildren = 0;
        validInput = false;
        while (!validInput) {
            System.out.print(Color.reset + "Enter number of child tickets: ");
            if (scanner.hasNextInt()) {
                quantityChildren = scanner.nextInt();
                if (quantityChildren < 0 || quantityChildren > 1000) {
                    System.out.println("Invalid input. Please enter a positive number.");
                    continue;
                }
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Discard the invalid input
            }
        }
        System.out.println("Adult tickets: " + quantityAdult);
        System.out.println("Child tickets: " + quantityChildren);

        // Confirm booking
        choice = 0;
        validInput = false;
        while (!validInput) {
            System.out.println(Color.red + "Confirm booking?");
            System.out.println(Color.red + "1) " + Color.lime + "Yes"); 
            System.out.println(Color.red + "2) " + Color.lime + "No");
            System.out.print(Color.reset + "Enter your choice: ");
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
            bookingController.createBooking(selectedMovie, selectedCinema, selectedShowtime, quantityAdult, quantityChildren);
            System.out.println("Booking created successfully.");
        } else {
            System.out.println("Booking cancelled.");
            throw new IllegalArgumentException("Booking cancelled.");
        }
        return;
    }
}
