import CinemaHall.CinemaHall;
import account.Account;
import booking.Booking;
import color.Color;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import movie.*;
import showtime.Showtime;
import util.*;

public class userInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cineplex ABC: Movie ticket booking system");
        Movie[] movie_array = {
            new Movie("Sword Art Online: Ordinal Scale", "Anime",  new ArrayList<Showtime>(Arrays.asList(
                new Showtime("Sword Art Online: Ordinal Scale", new CinemaHall(1, 50), LocalTime.of(14, 0), LocalDate.of(2024, 7, 21)), 
                new Showtime("Sword Art Online: Ordinal Scale", new CinemaHall(2, 50), LocalTime.of(16, 0), LocalDate.of(2024, 7, 22)))), 10.00),
            new Movie("My Hero Academia: Two Heroes", "Anime", new ArrayList<Showtime>(Arrays.asList(
                new Showtime("My Hero Academia: Two Heroes", new CinemaHall(3, 50), LocalTime.of(18, 0), LocalDate.of(2024, 7, 23)), 
                new Showtime("My Hero Academia: Two Heroes", new CinemaHall(4, 50), LocalTime.of(20, 0), LocalDate.of(2024, 7, 24)))), 10.00),
            new Movie("Attack on Titan: The Roar of Awakening", "Anime", new ArrayList<Showtime>(Arrays.asList(
                new Showtime("Attack on Titan: The Roar of Awakening", new CinemaHall(5, 50), LocalTime.of(12, 0), LocalDate.of(2024, 7, 25)),
                new Showtime("Attack on Titan: The Roar of Awakening", new CinemaHall(6, 50), LocalTime.of(14, 0), LocalDate.of(2024, 7, 26)))), 10.00)
    };

        // Account entries
        Account[] account_array = {
            new Account("Kirito", "kirito@sao.com", LocalDate.of(2008, 10, 7)),
            new Account("Asuna", "asuna@sao.com", LocalDate.of(2008, 9, 30)),
            new Account("Suguha", "suguha@sao.com", LocalDate.of(2011, 6, 6))
        };

        // Booking entries
        Booking[] booking_array = {
            new Booking("B001", account_array[0], movie_array[0], movie_array[0].getShowtimes().get(0), 2, 0, 0, 0, 0),
            new Booking("B002", account_array[1], movie_array[1], movie_array[1].getShowtimes().get(1), 1, 0, 0, 0, 0),
            new Booking("B003", account_array[2], movie_array[2], movie_array[2].getShowtimes().get(0), 3, 0, 0, 0, 0)
        };

        //Show movies and showtimes
        for (Movie movie : movie_array) {
            System.out.println(movie.viewInformation() + Color.RESET);
        }
        
        //Select movie and showtimes
        System.out.println("Please choose your movie (1 - 3) : ");
        while(true){
            String movieChoice = scanner.nextLine();
            if (Validation.isNumber(movieChoice)){
                int movie = Integer.parseInt(movieChoice);
                if (movie < 1 || movie > 3){
                    System.out.println("Please enter a valid choice (1 - 3)");
                }
                else {
                    break;
                }    
            }
            else {
                System.out.println("Please enter a valid number.");
            }
        }
            
        //Select tickets
        System.out.println(Color.RESET + "Purchase Tickets");
        int adultTickets = BookingUtils.getTicketQuantityInput(scanner, "adult");
        int childrenTickets = BookingUtils.getTicketQuantityInput(scanner, "children");
        int okuTickets = BookingUtils.getTicketQuantityInput(scanner, "OKU");
        int seniorTickets = BookingUtils.getTicketQuantityInput(scanner, "senior");
        int studentTickets = BookingUtils.getTicketQuantityInput(scanner, "student");

        //Create booking object
        Booking booking = new Booking("B004", account_array[2], movie_array[0], movie_array[0].getShowtimes().get(0), adultTickets, childrenTickets, okuTickets, seniorTickets, studentTickets);

        // Calculate total tickets and total price
        int totalTickets = adultTickets + childrenTickets + okuTickets + seniorTickets + studentTickets;
        double totalPrice = booking.calculateTotalPrice();

        // Display total tickets and total price
        System.out.println("Total tickets: " + totalTickets);
        System.out.println("Total price: " + totalPrice);

        // Display options
        System.out.println("[1] PAYMENT");
        System.out.println("[2] CANCEL");

        // Get user choice
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Payment successful!");
        } else {
            booking.setStatus("CANCELLED");
            System.out.println("Booking cancelled.");
        }

        scanner.close();
    }
}