package ui;
import java.util.ArrayList;
import java.util.Scanner;

import movie.Movie;
import util.SystemMessage;
import util.Validation;

public class MovieUpdatePage implements MovieCRUD{
    MovieUpdatePage(){};

    public void updateMovie(ArrayList<Movie> movieList)
    {
        int movieIndex = 0;

        CRUDGeneralPage.showAllMovie(movieList);
        movieIndex = CRUDGeneralPage.getMovieIndex(movieList, "update");
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
        switch (choice) {
            case 1:
                movieList.get(movieIndex).setMovieId(newValue);
                break;
            case 2:
                movieList.get(movieIndex).setTitle(newValue);
                break;
            case 3:
                movieList.get(movieIndex).setDescription(newValue);
                break;
            case 4:
                // Assuming showtimes are provided as a comma-separated string
                String[] showtimes = newValue.split(",");
                ArrayList<String> showtimesList = new ArrayList<>();
                for (String time : showtimes) {
                    showtimesList.add(time.trim());
                }
                movieList.get(movieIndex).setShowtimes(showtimesList);
                break;
            case 5:
                // Assuming languages are provided as a comma-separated string
                String[] languages = newValue.split(",");
                ArrayList<String> languagesList = new ArrayList<>();
                for (String language : languages) {
                    languagesList.add(language.trim());
                }
                movieList.get(movieIndex).setLanguages(languagesList);
                break;
            case 6:
                movieList.get(movieIndex).setReleaseDate(newValue);
                break;
            case 7:
                movieList.get(movieIndex).setGenre(newValue);
                break;
            case 8:
                movieList.get(movieIndex).setPriceAdult(Double.parseDouble(newValue));
                break;
            case 9:
                movieList.get(movieIndex).setPriceChildren(Double.parseDouble(newValue));
                break;
            default:
                SystemMessage.errorMessage(2);
        }
        input.close();
        return;
    }

    public void execute(ArrayList<Movie> movieList)
    {
        updateMovie(movieList);
        return;
    }
}
