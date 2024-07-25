package Application;

import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

public class Movie {
    private String title;
    private String category;
    private double normalPrice; 
//    enum Category {
//        NORMAL("Normal"),
//        THREE_D("3D"),
//        IMAX("IMAX");
//
//        private final String description;
//
//        Category(String description) {
//            this.description = description;
//        }
//
//        public String getDescription() {
//            return description;
//        }
//    }
    
    // Constructor
    public Movie() {};

    public Movie(String title, String category,double normalPrice) {
        this.title = title;
        this.category = category;
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
        return movie_info.toString();
    }
    
    public static void displayMovieList (ArrayList <Movie> movies) {
    	for(int i=0;i<movies.size();i++) {
    		System.out.printf(Color.YELLOW + "%2d. %-30s \n",i+1,movies.get(i).getTitle()+Color.RESET);
    	}
    }
}
