import FileHandling.FileHandling;
import booking.*;
import movie.*;
import java.util.ArrayList;
import java.util.Scanner;

public class testing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Movie> bookings = FileHandling.getMovieList();
        for (Movie booking : bookings) {
            System.out.println(booking.viewInformation());
        }
        //FileHandling.exportBookingData(bookings, null);
    }
}