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

    public String getCategory() {
        return category;
    }
    
    public double getNormalPrice() {
        return normalPrice;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }

    public void setNormalPrice(double normalPrice) {
        this.normalPrice = normalPrice;
    }

    public boolean isExpensive(){
        return (getCategory().equals("3D") || getCategory().equals("IMAX"));
    }
}
