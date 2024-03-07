public class Cinema 
{
    // instance variables
    private String cinemaName;
    private String cinemaLocation;
    private Movie[] moviesAired;

    // constructor
    public Cinema(String cinemaName, String cinemaLocation, Movie[] moviesAired) 
    {
        this.cinemaName = cinemaName;
        this.cinemaLocation = cinemaLocation;
        this.moviesAired = moviesAired;
    }

    // methods
    public String viewLocation() 
    {
        return "Location";
    }

    public void viewMovieInfo() 
    {

    }

    public void viewCinema()
    {

    }

}
