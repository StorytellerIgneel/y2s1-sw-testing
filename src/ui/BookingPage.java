package ui;

import java.util.Scanner;

import account.UserAccount;
import booking.BookingController;
import color.Color;
import util.CommonIcon;

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
     */
    public void display()
    {   
        CommonIcon.printHeader();
        System.out.println();
        System.out.println(Color.reset + "Welcome, " + user.getName() + "!\n");
        System.out.println(Color.reset + "Your Bookings:");

        // Prints all booking details
        bookingController.printAllBookings();

        System.out.println(Color.reset + "What would you like to do with your bookings?"); // TODO add booking controller
        System.out.println(Color.red + "1) " + Color.lime + "Create Bookings");
        System.out.println(Color.red + "2) " + Color.lime + "Update Bookings");
        System.out.println(Color.red + "3) " + Color.lime + "Delete Bookings");
        System.out.println(Color.red + "4) " + Color.lime + "Back to Main Menu");
        System.out.println();
        System.out.print(Color.reset + "Enter your choice: ");
        
        // TODO Call the booking controller
    }    
}
