package ui.booking;

import java.util.Scanner;

import account.UserAccount;
import booking.BookingController;
import color.Color;
import util.CommonIcon;
import java.util.ArrayList;

public class BookingPage implements Page{
    private ArrayList<UserAccount> users;
    private int user_index;
    private Scanner scanner;
    private BookingController bookingController;

    /**
     * Constructor for BookingPage for a user
     * @param user
     * @param scanner
     */
    public BookingPage(ArrayList<UserAccount> users, int user_index, Scanner scanner) 
    {
        this.users = users;
        this.scanner = scanner;
        this.user_index = user_index;
        this.bookingController = new BookingController(users, user_index);
    }

    
    /**
     * Displays the booking page
     * @return 0 if no errors occur
     */
    public void display()
    {   
        CommonIcon.printHeader();
        System.out.println();
        System.out.println(Color.reset + "Welcome, " + users.get(user_index).getName() + "!\n");
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
        while(!validInput || choice != 4)
        {
            System.out.println(Color.reset + "What would you like to do with your bookings?");
            System.out.println(Color.red + "1) " + Color.lime + "Create Bookings");
            System.out.println(Color.red + "2) " + Color.lime + "Update Bookings");
            System.out.println(Color.red + "3) " + Color.lime + "Delete Bookings");
            System.out.println(Color.red + "4) " + Color.lime + "Back to Main Menu");
            System.out.println();
            System.out.print(Color.reset + "Enter your choice: ");
            if (scanner.hasNextInt()) { // Check if input is an integer
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
                continue;
            }

            // Switch statements
            try {
                switch (choice) {
                    case 1: // Create bookings
                        CreateBookingPage createBookingPage = new CreateBookingPage(bookingController, scanner);
                        createBookingPage.display();
                        break;
                    case 2: // Update bookings
                        UpdateBookingPage updateBookingPage = new UpdateBookingPage(bookingController, scanner);
                        updateBookingPage.display();
                        break;
                    case 3: // Delete bookings
                        DeleteBookingPage deleteBookingPage = new DeleteBookingPage(bookingController, scanner);
                        deleteBookingPage.display();
                        break;
                    case 4: // Back to main menu
                        System.out.println(Color.reset + "Returning to main menu...");
                        return;
                    default:
                        System.out.println(Color.red + "Invalid choice. Please enter a number between 1 and 4." + Color.reset);
                        break;
                }
            } catch (Exception e) {
                System.out.println(Color.red + "An unexpected error occured:" + e.getMessage() + Color.reset);
                getChoice();
            } finally {
                validInput = false;
                choice = 0;
            }
        }
        
    }
}
