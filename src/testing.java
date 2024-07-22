import FileHandling.FileHandling;
import booking.*;
import java.util.ArrayList;
import java.util.Scanner;

public class testing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Booking> bookings = FileHandling.getBookingList();
        for (Booking booking : bookings) {
            System.out.println(booking.getBookingId()+booking.getStatus());
        FileHandling.exportBookingData(bookings, null);
        }

        
    }
}