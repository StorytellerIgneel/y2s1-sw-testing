package ui;

import java.util.ArrayList;
import java.util.Scanner;

import movie.*;
import util.*;
import util.Util;

import java.util.function.Function;

public class MovieUpdatePage implements MovieCRUD {
    MovieUpdatePage() {};

     /**
     * Updating page to update the existing movie information
     * 
     * @param movieList, @param scanner
     */
    @Override
    public void execute(ArrayList<Movie> movieList, Scanner scanner) {
        int movieIndex = 0;
        Result result = new Result();
        MovieInfoInput input = new MovieInfoInput();

        ArrayList<Function<Result, Result>> functionList = new ArrayList<>();
        functionList.add(input::filler);
        functionList.add(input::getMovieId);
        functionList.add(input::getTitle);
        functionList.add(input::getDesc);        
        functionList.add(input::getReleaseDate);
        functionList.add(input::getShowtime);
        functionList.add(input::getLanguage);
        functionList.add(input::getGenre);
        functionList.add(input::getPriceAdult);
        functionList.add(input::getPriceChildren);

        MovieCRUDGeneralPage.showAllMovieTitle(movieList);
        movieIndex = MovieCRUDGeneralPage.getMovieIndex(movieList, "update", scanner);
        if (movieIndex == -1)
            return;
        System.out.println("Current Movie Information:");
        System.out.println(movieList.get(movieIndex).viewInformation());
        System.out.println("Which attribute would you like to update?");
        System.out.println("1. Movie ID");
        System.out.println("2. Title");
        System.out.println("3. Description");
        System.out.println("4. Release Date");
        System.out.println("5. Showtimes");
        System.out.println("6. Language");
        System.out.println("7. Genre");
        System.out.println("8. Price (Adult)");
        System.out.println("9. Price (Children)");

        while (true) {
            String choiceString = Util.getInput("Enter your choice: ", false, scanner);
            if(Validation.isNumber(choiceString)){
                int choiceInt = Integer.parseInt(choiceString);
                if (0 < choiceInt && choiceInt < functionList.size()) {
                    Function<Result, Result> function = functionList.get(choiceInt);
                    result = function.apply(result);
                    System.out.println(result.step);
                    if (!result.step.equals(0)){
                        movieList.set(movieIndex,
                                NullFinder.findNull(result, movieList.get(movieIndex)));
                        SystemMessage.successMessage(6, scanner);
                        return;
                    }
                } else
                    SystemMessage.errorMessage(2, scanner);
            } else if (Validation.isBack(choiceString)) {
                return;
            } else if (Validation.isQuit(choiceString)) {
                System.exit(0);
            } else
                SystemMessage.errorMessage(11, scanner);
        }
    }
}
