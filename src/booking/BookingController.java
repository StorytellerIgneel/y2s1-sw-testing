package booking;

import java.time.LocalDateTime;
import java.util.ArrayList;

import account.UserAccount;
import cinema.Cinema;
import color.Color;
import movie.Movie;

public class BookingController {
    // Attributes
    private ArrayList<UserAccount> users;
    private int userIdx;
    private ArrayList<Booking> bookings = new ArrayList<Booking>();

    /**
     * Constructor for BookingController
     * 
     * @param user
     */
    public BookingController(ArrayList<UserAccount> users, int userIdx) {
        this.userIdx = userIdx;
        this.users = users;
        bookings = users.get(userIdx).getBookings();
    }

    /**
     * Create and adds a booking to the user's list of bookings
     * 
     * @param movie
     * @param cinema
     * @param showtime
     * @param quantityAdult
     * @param quantityChildren
     */
    public void createBooking(Movie movie, Cinema cinema, LocalDateTime showtime, int quantityAdult,
            int quantityChildren) throws IllegalArgumentException {
        bookings = users.get(userIdx).getBookings();
        Booking booking = new Booking(movie, cinema, showtime, quantityAdult, quantityChildren);
        if (bookings.contains(booking)) {
            throw new IllegalArgumentException("Booking already exists.");
        }
        bookings.add(booking);
        users.get(userIdx).setBookings(bookings);
        UserAccount.saveUsers(users);
    }

    /**
     * Overloaded method Updates the booking cinema only
     * 
     * @param index is 0-indexed
     * @param cinema
     */
    public void updateBooking(int index, Cinema cinema) {
        bookings = users.get(userIdx).getBookings();
        Booking booking = bookings.get(index);
        booking.setCinema(cinema);
        bookings.set(index, booking);
        users.get(userIdx).setBookings(bookings);
        UserAccount.saveUsers(users);
    }

    /**
     * Overloaded method Updates the booking showtime only
     * 
     * @param index is 0-indexed
     * @param showtime
     */
    public void updateBooking(int index, LocalDateTime showtime) {
        bookings = users.get(userIdx).getBookings();
        Booking booking = bookings.get(index);
        booking.setShowtime(showtime);
        bookings.set(index, booking);
        users.get(userIdx).setBookings(bookings);
        UserAccount.saveUsers(users);
    }

    /**
     * Updates the booking details
     * 
     * @param index is 0-indexed
     * @param quantityAdult
     * @param quantityChildren
     */
    public void updateBooking(int index, int quantityAdult, int quantityChildren) {
        bookings = users.get(userIdx).getBookings();
        Booking booking = bookings.get(index);
        booking.setQuantityAdult(quantityAdult);
        booking.setQuantityChildren(quantityChildren);
        bookings.set(index, booking);
        users.get(userIdx).setBookings(bookings);
        UserAccount.saveUsers(users);
    }

    /**
     * Prints the details of a booking
     * 
     * @param index is 0-indexed
     * @param booking
     */
    public void printBookingDetails(int index, Booking booking) {
        System.out.println(
                Color.RED + (index + 1) + ". \tMovie: " + Color.LIME + booking.getMovieName());
        System.out.println(Color.RED + "\tShowtime: " + Color.LIME + booking.getShowtime());
        System.out.println(Color.RED + "\tCinema: " + Color.LIME + booking.getCinemaName());
        System.out.println(Color.RED + "\tLocation: " + Color.LIME + booking.getCinemaAddress());
        System.out.println(Color.RED + "\tChildren: " + Color.LIME + booking.getQuantityChildren());
        System.out.println(Color.RED + "\tAdults: " + Color.LIME + booking.getQuantityAdult());
        System.out.println(
                Color.RED + "\tTotal Price: " + Color.LIME + "RM " + booking.calculateTotalPrice());
    }

    /**
     * Prints all bookings of the user List is 1-indexed
     */
    public void printAllBookings() {
        if (users.get(userIdx).getBookings().size() == 0) {
            System.out.println(Color.RED + "No bookings found." + Color.RESET);
            return;
        }
        for (int i = 0; i < users.get(userIdx).getBookings().size(); i++) {
            System.out.println(userIdx);
            printBookingDetails(i, users.get(userIdx).getBookings().get(i));
            System.out.println();
        }
    }

    /**
     * Deletes a booking
     * 
     * @param index is 0-indexed
     */
    public void deleteBooking(int index) throws IllegalArgumentException {
        bookings = users.get(userIdx).getBookings();
        if (index < 0 || index >= bookings.size()) {
            throw new IllegalArgumentException("Index out of bounds.");
        }
        bookings.remove(index);
        users.get(userIdx).setBookings(bookings);
        UserAccount.saveUsers(users);
    }

    /**
     * Getter for bookings
     * 
     * @return ArrayList of bookings
     */
    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    /**
     * Search for bookings by movie name
     * 
     * @param query
     */
    public void searchBookings(String query) {
        System.out.println(Color.RED + "Search results for: " + Color.LIME + query + Color.RESET);
        bookings = users.get(userIdx).getBookings();
        int count = 0;
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getMovieName().toLowerCase().contains(query.toLowerCase())) {
                printBookingDetails(i, bookings.get(i));
                System.out.println();
                count++;
            }
        }
        if (count == 0) {
            System.out.println(Color.RED + "No bookings found." + Color.RESET);
        }
    }
}
