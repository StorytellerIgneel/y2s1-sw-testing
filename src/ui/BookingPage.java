package ui;

import java.util.ArrayList;
import java.util.Scanner;

import account.UserAccount;
import booking.BookingController;
import color.Color;
import movie.Movie;
import util.CommonIcon;
import cinema.Cinema;

public class BookingPage {
    private UserAccount user;
    private Scanner scanner;
    private BookingController bookingController;

    /**
     * Constructor for BookingPage for a user
     * @param user
     * @param scanner
     */
    public BookingPage(UserAccount user, Scanner scanner) 
    {
        this.user = user;
        this.scanner = scanner;
        this.bookingController = new BookingController(user);
    }

    
    /**
     * Displays the booking page
     * @return 0 if no errors occur
     */
    public void display()
    {   
        CommonIcon.printHeader();
        System.out.println();
        System.out.println(Color.reset + "Welcome, " + user.getName() + "!\n");
        System.out.println(Color.reset + "Your Bookings:");
        
        // Prints all booking details
        bookingController.printAllBookings();
        

        // Show booking menu
        getChoice();
        return;
    }

    /**
     * Gets user choice for booking
     * @throws IllegalArgumentException
     */
    public void getChoice() throws IllegalArgumentException // TODO - Refactor error validation
    {
        System.out.println(Color.reset + "What would you like to do with your bookings?");
        System.out.println(Color.red + "1) " + Color.lime + "Create Bookings");
        System.out.println(Color.red + "2) " + Color.lime + "Update Bookings");
        System.out.println(Color.red + "3) " + Color.lime + "Delete Bookings");
        System.out.println(Color.red + "4) " + Color.lime + "Back to Main Menu");
        System.out.println();
        System.out.print(Color.reset + "Enter your choice: ");

        try {
            String input = scanner.nextLine();
            int choice = Integer.parseInt(input);
            switch (choice) {
                case 1:
                try {
                    displayCreateBookingPage();
                } catch (IllegalArgumentException e) {
                    getChoice();
                }
                    break; // Break is unnecessary here in Java, but it's good practice to include it
                case 2:
                    // TODO - Add functionality to update bookings
                    break;
                case 3:
                    // TODO - Add functionality to delete bookings
                    break;
                case 4:
                    return;
                default:
                    System.out.println(Color.red + "Invalid choice. Please enter a number between 1 and 4." + Color.reset);
                    getChoice();
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println(Color.red + "Invalid input. Please enter a number." + Color.reset);
            getChoice();
        }
    }

    /**
     * Displays the create booking page
     * @throws IllegalArgumentException
     */
    public void displayCreateBookingPage() throws IllegalArgumentException
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
            System.out.println();
            System.out.println(Color.red + "Search for movie title:");
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
                System.out.print("\033\143"); // TODO Modify or test thoroughly, this shouldn't work perfectly on Windows
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
