import FileHandling.FileHandling;
import java.util.ArrayList;
import java.util.Scanner;
import movie.*;

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
        
        ArrayList<Movie> bookings = FileHandling.getMovieList();
        for (Movie booking : bookings) {
            System.out.println(booking.viewInformation());
        }
        //FileHandling.exportBookingData(bookings, null);
    }
}