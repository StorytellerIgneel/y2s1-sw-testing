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

    public void getChoice()
    {
        System.out.println(Color.reset + "What would you like to do with your bookings?");
        System.out.println(Color.red + "1) " + Color.lime + "Create Bookings");
        System.out.println(Color.red + "2) " + Color.lime + "Update Bookings");
        System.out.println(Color.red + "3) " + Color.lime + "Delete Bookings");
        System.out.println(Color.red + "4) " + Color.lime + "Back to Main Menu");
        System.out.println();
        System.out.print(Color.reset + "Enter your choice: ");

        try {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayCreateBookingPage();
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
     * Displays the booking page
     */
    public void display()
    {   
        CommonIcon.printHeader();
        System.out.println();
        System.out.println(Color.reset + "Welcome, " + user.getName() + "!\n");
        System.out.println(Color.reset + "Your Bookings:");

        // Prints all booking details
        bookingController.printAllBookings();

        // Get user choice
        getChoice();
    }

    public void displayCreateBookingPage()
    {   
        ArrayList<Movie> movieList = ui.CRUDGeneralPage.getMovieList();
        Cinema[] cinemaList = Cinema.getCinemaLocation();
        System.out.println(Color.reset + "Create a Booking");
        System.out.println();
        System.out.println(Color.red + "Select a movie to book:");
    }
}
