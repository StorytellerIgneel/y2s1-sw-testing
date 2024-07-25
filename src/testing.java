import FileHandling.FileHandling;
import booking.*;
import movie.Movie;
import java.util.ArrayList;
import java.util.Scanner;

public class testing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        /* 
        ArrayList<Movie> movie = FileHandling.getMovieList();
        for (Movie movBooking : movie) {
            System.out.println(movBooking.getTitle());
        FileHandling.exportMovieData(movie, scanner);
        }
        */
        
        ArrayList<Booking> bookings = FileHandling.getBookingList();
        for (Booking movBooking : bookings) {
            System.out.println(movBooking.getBookingId());
        FileHandling.exportBookingData(bookings, scanner);
        }
        
    }
}