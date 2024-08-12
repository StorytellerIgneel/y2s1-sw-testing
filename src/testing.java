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
        Scanner scanner = new Scanner(System.in);
        userInterface ui = new userInterface();
        ui.getMovie();
    }
}