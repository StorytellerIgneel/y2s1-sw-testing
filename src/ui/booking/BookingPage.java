package ui.booking;

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
    public void getChoice()
    {
        int choice = 0;
        boolean validInput = false;
        while(!validInput)
        {
            System.out.println(Color.reset + "What would you like to do with your bookings?");
            System.out.println(Color.red + "1) " + Color.lime + "Create Bookings");
            System.out.println(Color.red + "2) " + Color.lime + "Update Bookings");
            System.out.println(Color.red + "3) " + Color.lime + "Delete Bookings");
            System.out.println(Color.red + "4) " + Color.lime + "Back to Main Menu");
            System.out.println();
            System.out.print(Color.reset + "Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                if (choice < 1 || choice > 4) {
                    System.out.println(Color.red + "Invalid choice. Please enter a number between 1 and 4." + Color.reset);
                    continue;
                }
                validInput = true;
            } else {
                System.out.println(Color.red + "Invalid input. Please enter a number." + Color.reset);
                scanner.next(); // Discard the invalid input
            }
        }
        
        try {
            switch (choice) {
                case 1: // Create bookings
                    CreateBookingPage createBookingPage = new CreateBookingPage(bookingController, scanner);
                    createBookingPage.display();
                    break;                      // Break is unnecessary here in Java, but it's good practice to include it
                case 2: // Update bookings
                    displayUpdateBookingPage();
                    break;
                case 3: // Delete bookings
                    displayDeleteBookingPage();
                    break;
                case 4: // Back to main menu
                    return;
                default:
                    System.out.println(Color.red + "Invalid choice. Please enter a number between 1 and 4." + Color.reset);
                    getChoice();
                    break;
            }
        } catch (IllegalArgumentException e) {
            getChoice();
        }
    }


    /**
     * Displays the update booking page
     * @throws IllegalArgumentException
     */
    public void displayUpdateBookingPage() throws IllegalArgumentException
    {
        // TODO - Add functionality to update bookings

    }


    /**
     * Displays the delete booking page
     * @throws IllegalArgumentException
     */
    public void displayDeleteBookingPage() throws IllegalArgumentException
    {
        // TODO - Add functionality to delete bookings
    }
}
