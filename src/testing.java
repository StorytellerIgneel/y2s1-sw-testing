import CinemaHall.CinemaHall;
import account.Account;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import movie.Movie;
import showtime.Showtime;
import util.Validation;

public class testing {
    public static void main(String[] args) {
        Movie[] movie_array = {
            new Movie("Sword Art Online: Ordinal Scale", "2D",  new ArrayList<Showtime>(Arrays.asList(
                new Showtime("Sword Art Online: Ordinal Scale", new CinemaHall(1, 50), LocalTime.of(14, 0), LocalDate.of(2024, 7, 21)), 
                new Showtime("Sword Art Online: Ordinal Scale", new CinemaHall(2, 50), LocalTime.of(16, 0), LocalDate.of(2024, 7, 22)))), 10.00),
            new Movie("My Hero Academia: Two Heroes", "Anime", new ArrayList<Showtime>(Arrays.asList(
                new Showtime("My Hero Academia: Two Heroes", new CinemaHall(3, 50), LocalTime.of(18, 0), LocalDate.of(2024, 7, 23)), 
                new Showtime("My Hero Academia: Two Heroes", new CinemaHall(4, 50), LocalTime.of(20, 0), LocalDate.of(2024, 7, 24)))), 10.00),
            new Movie("Attack on Titan: The Roar of Awakening", "Anime", new ArrayList<Showtime>(Arrays.asList(
                new Showtime("Attack on Titan: The Roar of Awakening", new CinemaHall(5, 50), LocalTime.of(12, 0), LocalDate.of(2024, 7, 25)),
                new Showtime("Attack on Titan: The Roar of Awakening", new CinemaHall(6, 50), LocalTime.of(14, 0), LocalDate.of(2024, 7, 26)))), 10.00)
        };
        

        ArrayList<Account> accountList = new ArrayList<>(Arrays.asList(
            new Account("Sinon", "sinon@sao.com", LocalDate.of(2008, 10, 7)),
            new Account("Asuna", "asuna@sao.com", LocalDate.of(2008, 9, 30)),
            new Account("Suguha", "suguha@sao.com", LocalDate.of(2011, 6, 6))
        ));
        Scanner scanner = new Scanner(System.in);
        while (true) { 
            //String pp = scanner.next();
                if (Validation.isRegisteredUser(accountList, "Sino")){
                    System.out.println("true");
                    break;
                } else
                    System.out.println("false");
                    break;
        }
    } 
}