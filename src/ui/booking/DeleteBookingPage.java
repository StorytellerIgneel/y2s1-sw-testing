package ui.booking;

import java.util.Scanner;

import booking.BookingController;
import color.Color;

public class DeleteBookingPage implements Page {
    private BookingController bookingController;
    private Scanner scanner;

    /**
     * Constructor for DeleteBookingPage
     * 
     * @param bookingController
     * @param scanner
     */
    public DeleteBookingPage(BookingController bookingController, Scanner scanner) {
        this.bookingController = bookingController;
        this.scanner = scanner;
    }

    /**
     * Displays the delete booking page
     * 
     * @throws IllegalArgumentException
     */
    public void display() {
        System.out.println("Select a booking to delete (0 to go back): ");
        bookingController.printAllBookings();
        int choice = -1;
        boolean validInput = false;
        int chosenBookingIndex;
        while (!validInput || choice < 0 || choice > bookingController.getBookings().size()) {
            System.out.println(Color.RESET + "Your Bookings:");
            bookingController.printAllBookings(); // Display all bookings, listed as
                                                  // 1-indexed
            System.out.println(
                    Color.RESET + "Which booking would you like to delete? (Enter 0 to go back)");
            System.out.print("Enter your choice: ");
            // Check for integer input
            if (!scanner.hasNextInt()) {
                System.out
                        .println(Color.RED + "Invalid input. Please enter a number." + Color.RESET);
                continue;
            }
            choice = scanner.nextInt();
            // Check if input is out of bounds
            if (choice < 0 || choice > bookingController.getBookings().size()) {
                System.out.println(Color.RED + "Invalid input. Please enter a number between 0 and "
                        + bookingController.getBookings().size() + Color.RESET);
                continue;
            }
            validInput = true;
            if (choice == 0) {
                return; // Go back to main menu
            }
        }
        chosenBookingIndex = choice - 1; // Convert to 0-indexed
        try {
            bookingController.deleteBooking(chosenBookingIndex);
            System.out.println(Color.LIME + "Booking deleted successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(Color.RED + e.getMessage() + Color.RESET);
        }
    }
}
