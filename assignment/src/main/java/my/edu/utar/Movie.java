package my.edu.utar;

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
    	 if (title == null || title.isEmpty())
             throw new IllegalArgumentException("Null param passed");
    	 if (category == null || category.isEmpty())
             throw new IllegalArgumentException("Null param passed");
    	 if (title.equals("") || category.equals(""))
             throw new IllegalArgumentException("Empty String passed");
    	 if (!category.equals("Normal") && !category.equals("3D") && !category.equals("IMAX"))
             throw new IllegalArgumentException("Invalid category passed");
         if (!title.matches("[ '.,\\:\\-a-zA-Z0-9()\\s]+$"))
             throw new IllegalArgumentException("Invalid movie name");
         if (normalPrice < 0)
             throw new IllegalArgumentException("Negative double passed");
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
		 if (title == null || title.isEmpty())
		     throw new IllegalArgumentException("Null param passed");
		 if (title.equals(""))
		     throw new IllegalArgumentException("Empty String passed");
		 if (!title.matches("[ '.,\\:\\-a-zA-Z0-9()\\s]+$"))
		     throw new IllegalArgumentException("Invalid movie name");
		 this.title = title;
    }
    
    public void setCategory(String category) {
    	 
    	 if (category == null || category.isEmpty())
             throw new IllegalArgumentException("Null param passed");
    	 if (category.equals(""))
             throw new IllegalArgumentException("Empty String passed");
    	 if (!category.equals("Normal") && !category.equals("3D") && !category.equals("IMAX"))
             throw new IllegalArgumentException("Invalid category passed");
        this.category = category;
    }

    public void setNormalPrice(double normalPrice) {
         if (normalPrice < 0)
             throw new IllegalArgumentException("Negative double passed");
        this.normalPrice = normalPrice;
    }

    public boolean isExpensive(){
        return (getCategory().equals("3D") || getCategory().equals("IMAX"));
    }
}
