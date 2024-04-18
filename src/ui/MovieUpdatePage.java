package ui;
import java.util.ArrayList;
import java.util.Scanner;

import movie.Movie;
import movie.MovieCRUD;
import util.Validation;
import util.SystemMessage;

public class MovieUpdatePage implements MovieCRUD{
    MovieUpdatePage(){};

    @Override
    public void execute(ArrayList<Movie> movieList)
    {
        int movieIndex = 0;

        MovieCRUDGeneralPage.showAllMovie(movieList);
        movieIndex = MovieCRUDGeneralPage.getMovieIndex(movieList, "update");
        Scanner input = new Scanner(System.in);

        System.out.println("Current Movie Information:");
        System.out.println(movieList.get(movieIndex).viewInformation());

        System.out.println("Which attribute would you like to update?");
        System.out.println("1. Movie ID");
        System.out.println("2. Title");
        System.out.println("3. Description");
        System.out.println("4. Showtimes");
        System.out.println("5. Languages");
        System.out.println("6. Release Date");
        System.out.println("7. Genre");
        System.out.println("8. Price (Adult)");
        System.out.println("9. Price (Children)");

        // Read user's choice
        int choice = input.nextInt();
        input.nextLine();

        System.out.print("Enter the new value (Enter :q to quit): ");
        String newValue = input.nextLine();
        if(Validation.isBack(newValue))
            return;
        // Update the chosen attribute
    }
}
