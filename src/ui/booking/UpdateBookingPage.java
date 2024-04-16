package ui.booking;

import java.util.Scanner;

import booking.Booking;
import booking.BookingController;
import color.Color;

public class UpdateBookingPage implements Page {
    private BookingController bookingController;
    private Scanner scanner;

    public UpdateBookingPage(BookingController bookingController, Scanner scanner) {
        this.bookingController = bookingController;
        this.scanner = scanner;
    }

     /**
     * Displays the update booking page
     * @throws IllegalArgumentException
     */
    public void display() throws IllegalArgumentException{
        // Check if there are bookings to update
        if (bookingController.getBookings().size() == 0) {
            System.out.println(Color.red + "You have no bookings to update." + Color.reset);
            return;
        }

        // Get user choice for booking to update
        int choice = -1;
        boolean validInput = false;
        Booking chosenBooking = null;
        while(!validInput || choice < 0 || choice > bookingController.getBookings().size()) {
            System.out.println(Color.reset + "Your Bookings:");
            bookingController.printAllBookings();   // Display all bookings, listed as 1-indexed
            System.out.println(Color.reset + "Which booking would you like to modify? (Enter 0 to go back)");
            System.out.print("Enter your choice: ");
            // Check for integer input
            if (!scanner.hasNextInt()) {
                System.out.println(Color.red + "Invalid input. Please enter a number." + Color.reset);
                continue;
            }
            choice = scanner.nextInt();
            // Check if input is out of bounds
            if (choice < 0 || choice > bookingController.getBookings().size()) {
                System.out.println(Color.red + "Invalid input. Please enter a number between 0 and " + bookingController.getBookings().size() + Color.reset);
                continue;
            }
            validInput = true;
            if (choice == 0) {
                return; // Go back to main menu
            }
        }
        chosenBooking = bookingController.getBookings().get(choice - 1); // Convert to 0-indexed

        // Choose what to update
        choice = -1;
        validInput = false;
        while(!validInput || choice < 0 || choice > 3) {
            System.out.println(Color.reset + "What would you like to update?");
            System.out.println(Color.red + "0) " + Color.lime + "Go back");
            System.out.println(Color.red + "1) " + Color.lime + "Change Cinema Location");
            System.out.println(Color.red + "2) " + Color.lime + "Update Showtime");
            System.out.println(Color.red + "3) " + Color.lime + "Update Number of Tickets");
            System.out.println();
            System.out.print(Color.reset + "Enter your choice: ");
            if (!scanner.hasNextInt()) {
                System.out.println(Color.red + "Invalid input. Please enter a number." + Color.reset);
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            if (choice < 0 || choice > 3) {
                System.out.println(Color.red + "Invalid input. Please enter a number between 1 and 3." + Color.reset);
                continue;
            }
            validInput = true;
        }

        // Switch statement to update different parts of the booking
        try {
            switch (choice) {
                case 0:
                    return;
                case 1:
                    //updateDate(chosenBooking);
                    break;
                case 2:
                    //pdateTime(chosenBooking);
                    break;
                case 3:
                    //updateTickets(chosenBooking);
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(Color.red + e.getMessage() + Color.reset);
        }
    }
}
