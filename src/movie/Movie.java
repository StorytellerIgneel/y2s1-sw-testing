package movie;

import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import color.Color;
import showtime.Showtime;

public class Movie {
    private String title;
    private String category;
    private ArrayList<Showtime> showtimes;
    private double normalPrice; 

    // Constructor
    public Movie() {};

    public Movie(String title, String category, ArrayList<Showtime> showtimes, double normalPrice) {
        this.title = title;
        this.category = category;
        this.showtimes = showtimes;
        this.normalPrice = normalPrice;
    }

    // Getter and Setter methods

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public ArrayList<Showtime> getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(ArrayList<Showtime> showtimes) {
        this.showtimes = showtimes;
    }

    public double getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(double normalPrice) {
        this.normalPrice = normalPrice;
    }

    // other methods
    public String viewInformation() {
        int index = 0;
        StringBuilder movie_info = new StringBuilder();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
 
        movie_info.append(Color.RED + "Title: " + Color.LIME).append(title).append("\n").append(Color.RESET);
        movie_info.append(Color.RED + "Category: " + Color.LIME).append(category).append("\n").append(Color.RESET);
        movie_info.append(Color.RED + "Showtimes: " + Color.LIME);
        for (Showtime showtime : showtimes) {
            movie_info.append(index + ". " );
            movie_info.append(showtime.getDate().format(dateFormatter)).append(" - ");
            movie_info.append(showtime.getTime().format(timeFormatter)).append("\n");
        }
        return movie_info.toString();
    }
}
