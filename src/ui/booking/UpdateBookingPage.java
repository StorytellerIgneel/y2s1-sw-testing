package ui.booking;

import java.time.LocalDateTime;
import java.util.Scanner;

import booking.Booking;
import booking.BookingController;
import cinema.Cinema;
import color.Color;
import util.BookingUtils;

public class UpdateBookingPage implements Page {
    private BookingController bookingController;
    private Scanner scanner;

    /**
     * Constructor for UpdateBookingPage
     * 
     * @param bookingController
     * @param scanner
     */
    public UpdateBookingPage(BookingController bookingController, Scanner scanner) {
        this.bookingController = bookingController;
        this.scanner = scanner;
    }

    /**
     * Displays the update booking page
     * 
     * @throws IllegalArgumentException
     */
    public void display() throws IllegalArgumentException {
        // Check if there are bookings to update
        if (bookingController.getBookings().size() == 0) {
            System.out.println(Color.RED + "You have no bookings to update." + Color.RESET);
            return;
        }

        // Get user choice for booking to update
        int choice = -1;
        boolean validInput = false;
        int chosenBookingIndex;
        while (!validInput || choice < 0 || choice > bookingController.getBookings().size()) {
            System.out.println(Color.RESET + "Your Bookings:");
            bookingController.printAllBookings(); // Display all bookings, listed as
                                                  // 1-indexed
            System.out.println(
                    Color.RESET + "Which booking would you like to modify? (Enter 0 to go back)");
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

        // Choose what to update
        choice = -1;
        validInput = false;
        while (!validInput || choice < 0 || choice > 3) {
            System.out.println(Color.RESET + "What would you like to update?");
            System.out.println(Color.RED + "0) " + Color.LIME + "Go back");
            System.out.println(Color.RED + "1) " + Color.LIME + "Change Cinema Location");
            System.out.println(Color.RED + "2) " + Color.LIME + "Update Showtime");
            System.out.println(Color.RED + "3) " + Color.LIME + "Update Number of Tickets");
            System.out.println();
            System.out.print(Color.RESET + "Enter your choice: ");
            if (!scanner.hasNextInt()) {
                System.out
                        .println(Color.RED + "Invalid input. Please enter a number." + Color.RESET);
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            if (choice < 0 || choice > 3) {
                System.out.println(Color.RED
                        + "Invalid input. Please enter a number between 1 and 3." + Color.RESET);
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
                    updateCinema(chosenBookingIndex);
                    break;
                case 2:
                    updateShowtime(chosenBookingIndex);
                    break;
                case 3:
                    updateTickets(chosenBookingIndex);
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(Color.RED + e.getMessage() + Color.RESET);
        }
        return;
    }

    /**
     * Updates the cinema location of the booking
     * 
     * @param booking The booking to update
     */
    private void updateCinema(int chosenBookingIndex) {
        Booking booking = bookingController.getBookings().get(chosenBookingIndex);
        System.out.println(Color.RESET + "Current Cinema: " + booking.getCinemaName());
        System.out.println(Color.RESET + "Current Location: " + booking.getCinemaAddress());
        System.out.print(Color.RESET + "Change to a new cinema location: ");
        Cinema selectedCinema = BookingUtils.getCinemaInput(scanner);
        bookingController.updateBooking(chosenBookingIndex, selectedCinema);
        return;
    }

    /**
     * Updates the showtime of the booking
     * 
     * @param booking The booking to update
     */
    private void updateShowtime(int chosenBookingIndex) {
        Booking booking = bookingController.getBookings().get(chosenBookingIndex);
        System.out.println(Color.RESET + "Current Showtime: " + booking.getCinemaName());
        System.out.print(Color.RESET + "Change to a new showtime: ");
        LocalDateTime selectedShowtime = BookingUtils.getShowtimeInput(scanner, booking.getMovie());
        bookingController.updateBooking(chosenBookingIndex, selectedShowtime);
        return;
    }

    /**
     * Updates the number of tickets of the booking
     * 
     * @param booking The booking to update
     */
    private void updateTickets(int chosenBookingIndex) {
        Booking booking = bookingController.getBookings().get(chosenBookingIndex);
        System.out.println(Color.RESET + "Current Adult Tickets: " + booking.getQuantityAdult());
        System.out.println(Color.RESET + "Current Child Tickets: " + booking.getQuantityChildren());
        System.out.print(Color.RESET + "Enter new number of adult tickets: ");
        int quantityAdult = BookingUtils.getTicketQuantityInput(scanner, "adult");
        System.out.print(Color.RESET + "Enter new number of child tickets: ");
        int quantityChildren = BookingUtils.getTicketQuantityInput(scanner, "child");
        bookingController.updateBooking(chosenBookingIndex, quantityAdult, quantityChildren);
        return;
    }
}
