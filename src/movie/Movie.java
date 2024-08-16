package movie;

import color.Color;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import showtime.Showtime;
import validation.Validation;

public class Movie {
    private String title;
    private String category;
    private ArrayList<Showtime> showtimes;
    private double normalPrice; 

    // Constructor
    public Movie() {};

    public Movie(String title, String category, ArrayList<Showtime> showtimes, double normalPrice) {
        this.title = title;
        this.category = category; //Normal, 3D, IMAX
        this.showtimes = showtimes;
        this.normalPrice = normalPrice;
    }

    public static Movie createBooking(String title, String category, ArrayList<Showtime> showtimes, double normalPrice){
        if (Validation.isNullParams(title, category, showtimes, normalPrice))
        {
            System.out.println("In the createBooking method");
            return null;
        }
        if (!Validation.comboValidString(title) || !Validation.comboValidString(category)){
            System.out.println("Invalid title or category.");
            return null;
        }
        if (Validation.isNegativeNum(normalPrice)){
            System.out.println("Invalid price.");
            return null;
        }
        return new Movie(title, category, showtimes, normalPrice);
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
        StringBuilder movie_info = new StringBuilder();
 
        movie_info.append(Color.RED + "Title: " + Color.LIME).append(title).append("\n").append(Color.RESET);
        movie_info.append(Color.RED + "Category: " + Color.LIME).append(category).append("\n").append(Color.RESET);
        return movie_info.toString();
    }

    public String getAllShowtimes() {
        int index = 1;
        StringBuilder movie_info = new StringBuilder();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

        movie_info.append(Color.RED + "Showtimes: " + Color.LIME).append("\n");
        for (Showtime showtime : showtimes) {
            movie_info.append(index + ". " );
            movie_info.append(showtime.getDate().format(dateFormatter)).append(" - ");
            movie_info.append(showtime.getTime().format(timeFormatter)).append("\n");
            index ++;
        }
        return movie_info.toString();
    }

    public boolean isExpensive(){
        return (category.equals("3D") || category.equals("IMAX"));
    }
}
