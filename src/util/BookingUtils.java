package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import cinema.Cinema;
import color.Color;
import movie.Movie;

public class BookingUtils {
    /**
     * Get the quantity of child tickets from user input
     * 
     * @param scanner Scanner object to get user input
     * @return int representing the quantity of child tickets
     */
    public static int getTicketQuantityInput(Scanner scanner, String ticketType) {
        int ticketQuantity = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print(Color.RESET + "Enter number of " + ticketType + " tickets: ");
            if (scanner.hasNextInt()) {
                ticketQuantity = scanner.nextInt();
                if (ticketQuantity < 0 || ticketQuantity > 1000) {
                    System.out.println("Invalid input. Please enter a positive number.");
                    continue;
                }
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next(); // Discard the invalid input
            }
        }
        return ticketQuantity;
    }
}
