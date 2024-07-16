package movie;

import java.util.ArrayList;
import java.time.LocalDateTime;
import color.Color;
import showtime.Showtime;

public class Movie {
    private String title;
    private String category;
    private ArrayList<Showtime> showtimes;
    private double normalPrice = 10; 

    // Constructor
    public Movie() {};

    public Movie(String title, String category, ArrayList<Showtime> showtimes){
        this.title = title;
        this.category = category;
        switch (category) {
            case "2D":
                break;
            case "3D":
                normalPrice += 4;
                break;
            case "IMAX":
                normalPrice += 4;
                break;
            default:
                break;
        }
        this.showtimes = showtimes;
    }

    // Getter and Setter methods

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Showtime> getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(ArrayList<Showtime> showtimes) {
        this.showtimes = showtimes;
    }

    public Double getPriceAdult() {
        return priceAdult;
    }

    public void setPriceAdult(double priceAdult) {
        this.priceAdult = priceAdult;
    }

    public Double getPriceChildren() {
        return priceChildren;
    }


    // other methods
    public String viewInformation() {
        StringBuilder movie_info = new StringBuilder();
 
        movie_info.append(Color.RED + "Title: " + Color.LIME).append(title).append("\n")
                .append(Color.RESET);

        movie_info.append(Color.RED + "Showtimes: " + Color.LIME)
                .append(showtimes.toString().substring(1, showtimes.toString().length() - 1))
                .append("\n").append(Color.RESET);
        
        
        movie_info.append(Color.RED + "Price (Adult): " + Color.LIME + "$").append(priceAdult)
                .append("\n").append(Color.RESET);
        movie_info.append(Color.RED + "Price (Children): " + Color.LIME + "$").append(priceChildren)
                .append("\n").append(Color.RESET);
        return movie_info.toString();
    }
}
