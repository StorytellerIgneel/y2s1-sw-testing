package booking;

import java.util.ArrayList;

import account.UserAccount;
import cinema.Cinema;
import color.Color;
import movie.Movie;

public class BookingController {
    // Attributes
    private ArrayList<UserAccount> users;
    private int userIdx;
    private ArrayList<Booking>bookings = new ArrayList<Booking>();

    /**
     * Constructor for BookingController
     * @param user
     * TODO Add administrator functionality
     */
    public BookingController(ArrayList<UserAccount> users, int userIdx) {
        this.users = users;
        bookings = users.get(userIdx).getBookings();
    }

    /**
     * Create and adds a booking to the user's list of bookings
     * @param movie
     * @param cinema
     * @param showtime
     * @param quantityAdult
     * @param quantityChildren
     */
    public void createBooking(
        Movie movie,
        Cinema cinema,
        String showtime,
        int quantityAdult, 
        int quantityChildren
        ) throws IllegalArgumentException
    {
        bookings = users.get(userIdx).getBookings();
        Booking booking = new Booking(movie, cinema, showtime, quantityAdult, quantityChildren);
        if (bookings.contains(booking))
        {
            throw new IllegalArgumentException("Booking already exists.");
        }
        bookings.add(booking);
        users.get(userIdx).setBookings(bookings);
        UserAccount.saveUsers(users);
    }

    /**
     * Updates the booking details
     * @param index is 0-indexed
     * @param movie
     * @param cinema
     * @param showtime
     * @param quantityAdult
     * @param quantityChildren
     */
    public void updateBooking(
        int index,
        Movie movie,
        Cinema cinema,
        String showtime,
        int quantityAdult, 
        int quantityChildren
        )
    {
        bookings = users.get(userIdx).getBookings();
        Booking booking = bookings.get(index);
        booking.setMovie(movie);
        booking.setCinema(cinema);
        booking.setShowtime(showtime);
        booking.setQuantityAdult(quantityAdult);
        booking.setQuantityChildren(quantityChildren);
        bookings.set(index, booking);
        users.get(userIdx).setBookings(bookings);
        UserAccount.saveUsers(users);
    }

    /**
     * Prints the details of a booking
     * @param index is 0-indexed
     * @param booking
     */
    public void printBookingDetails(int index, Booking booking)
    {
        System.out.println(Color.red + (index + 1) + ". \tMovie: " + Color.lime + booking.getMovieName());
        System.out.println(Color.red + "\tShowtime: " + Color.lime + booking.getShowtime());
        System.out.println(Color.red + "\tCinema: " + Color.lime + booking.getCinemaName());
        System.out.println(Color.red + "\tLocation: " + Color.lime + booking.getCinemaAddress());
        System.out.println(Color.red + "\tChildren: " + Color.lime + booking.getQuantityChildren());
        System.out.println(Color.red + "\tAdults: " + Color.lime + booking.getQuantityAdult());
        System.out.println(Color.red + "\tTotal Price: " + Color.lime + "RM " + booking.calculateTotalPrice());
    }

    /**
     * Prints all bookings
     */
    public void printAllBookings()
    {
        for (int i = 0; i < users.get(userIdx).getBookings().size(); i++)
        {
            printBookingDetails(i, users.get(userIdx).getBookings().get(i));
            System.out.println();
        }
    }

    /**
     * Deletes a booking
     * @param index is 0-indexed
     */
    public void deleteBooking(int index) throws IllegalArgumentException
    {
        bookings = users.get(userIdx).getBookings();
        if (index < 0 || index >= bookings.size())
        {
            throw new IllegalArgumentException("Index out of bounds.");
        }
        bookings.remove(index);
        users.get(userIdx).setBookings(bookings);
        UserAccount.saveUsers(users);
    }

    /**
     * Getter for bookings
     * @return ArrayList of bookings
     */
    public ArrayList<Booking> getBookings()
    {
        return bookings;
    }
}
