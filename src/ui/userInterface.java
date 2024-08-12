package ui;
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
import validation.*;

public class userInterface {
    public void getMovie() {
        Scanner scanner = new Scanner(System.in);
        int movieCHOICE = 1;
        int showtimeCHOICE = 1;
        boolean pp = true;

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
            new Account("Sinon", "sinon@sao.com", LocalDate.of(2008, 10, 7)),
            new Account("Asuna", "asuna@sao.com", LocalDate.of(2008, 9, 30)),
            new Account("Suguha", "suguha@sao.com", LocalDate.of(2011, 6, 6))
        };

        Account MC = new Account("Kirito", "sinon@sao.com", LocalDate.of(2008, 10, 7));

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
        while(pp){
            String movieChoice = scanner.nextLine();
            if (Validation.isNumber(movieChoice)){
                movieCHOICE = Integer.parseInt(movieChoice);
                if (movieCHOICE < 1 || movieCHOICE > 3){
                    System.out.println("Please enter a valid choice (1 - 3)");
                }
                else {
                    System.out.println(movie_array[movieCHOICE-1].getAllShowtimes());
                    System.out.println("Please choose a showtime : ");
                    while(pp){
                        String showtimeChoice = scanner.nextLine();
                        if (Validation.isNumber(showtimeChoice)){
                            showtimeCHOICE = Integer.parseInt(showtimeChoice);
                            if (showtimeCHOICE < 1 || showtimeCHOICE > 2)
                                System.out.println("Please enter a valid choice (1 - 2)");
                            else 
                                pp = false; 
                        }
                        else
                            System.out.println("Please enter a valid number.");
                    }
                }   
            }
            else 
                System.out.println("Please enter a valid number.");
        }
        
        ticketPayment(movie_array[movieCHOICE-1], movie_array[movieCHOICE-1].getShowtimes().get(showtimeCHOICE-1), MC, scanner);
    }

            public void ticketPayment(Movie movie, Showtime showtime, Account account, Scanner scanner){
                int adultTickets;
                int childrenTickets;
                int okuTickets;
                int seniorTickets;
                int studentTickets;
                while (true) { 
                    //Select tickets
                    System.out.println(Color.RESET + "Purchase Tickets");
                    adultTickets = BookingUtils.getTicketQuantityInput(scanner, "adult");
                    childrenTickets = BookingUtils.getTicketQuantityInput(scanner, "children");
                    okuTickets = BookingUtils.getTicketQuantityInput(scanner, "OKU");
                    seniorTickets = BookingUtils.getTicketQuantityInput(scanner, "senior");
                    studentTickets = BookingUtils.getTicketQuantityInput(scanner, "student");
        
                    if ((adultTickets + childrenTickets + okuTickets + seniorTickets + studentTickets) > showtime.getHallNumber().getAvailableSeats())
                        System.out.println("There are only " + showtime.getHallNumber().getAvailableSeats() + " available spaces in the cinema hall.\nPlease enter a valid number of seats\n");
                    else
                        break;
                }
                //Create booking object
                Booking booking = new Booking("B004", account, movie, showtime, adultTickets, childrenTickets, okuTickets, seniorTickets, studentTickets);
        
                // Display total tickets and total price
                System.out.println("Total tickets: " + booking.getTotalNumberOfSeats());
                System.out.println("Total price: " + booking.getTotalPrice());
        
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
            }
        }