package my.edu.utar;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Movie {
    private String title;
    private String category;
    private double normalPrice; 

    // Constructor
    public Movie() {};

    public Movie(String title, String category, double normalPrice) {
        this.title = title;
        this.category = category; //Normal, 3D, IMAX
        this.normalPrice = normalPrice;
    }

    public static Movie createMovie(String title, String category, double normalPrice){
        Validation.isNull(title, category, normalPrice);
        Validation.comboValidMovie(title);
        Validation.comboValidString(category);
        Validation.isNegativeNum(normalPrice);
        return new Movie(title, category, normalPrice);
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

    public double getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(double normalPrice) {
        this.normalPrice = normalPrice;
    }

    // // other methods
    // public String viewInformation() {
    //     StringBuilder movie_info = new StringBuilder();
 
    //     movie_info.append(Color.RED + "Title: " + Color.LIME).append(title).append("\n").append(Color.RESET);
    //     movie_info.append(Color.RED + "Category: " + Color.LIME).append(category).append("\n").append(Color.RESET);
    //     return movie_info.toString();
    // }

    // public String getAllShowtimes() {
    //     int index = 1;
    //     StringBuilder movie_info = new StringBuilder();
    //     DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
    //     DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

    //     movie_info.append(Color.RED + "Showtimes: " + Color.LIME).append("\n");
    //     for (Showtime showtime : showtimes) {
    //         movie_info.append(index + ". " );
    //         movie_info.append(showtime.getDate().format(dateFormatter)).append(" - ");
    //         movie_info.append(showtime.getTime().format(timeFormatter)).append("\n");
    //         index ++;
    //     }
    //     return movie_info.toString();
    // }

    public boolean isExpensive(){
        return (getCategory().equals("3D") || getCategory().equals("IMAX"));
    }
}
