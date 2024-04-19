package ui;
import java.util.ArrayList;
import java.util.Scanner;

import movie.*;
import util.*;
import utils.Util;

import java.util.function.Function;

public class MovieUpdatePage implements MovieCRUD{
    MovieUpdatePage(){};

    @Override
    public void execute(ArrayList<Movie> movieList)
    {
        Scanner scanner = new Scanner(System.in);
        int movieIndex = 0;
        Result result = new Result();
        MovieInfoInput input = new MovieInfoInput();

        ArrayList<Function<Result,Result>> functionList = new ArrayList<>();
        functionList.add(input::filler);
        functionList.add(input::getMovieId);
        functionList.add(input::getTitle);
        functionList.add(input::getDesc);
        functionList.add(input::getShowtime);
        functionList.add(input::getLanguage);
        functionList.add(input::getReleaseDate);
        functionList.add(input::getGenre);
        functionList.add(input::getPriceAdult);
        functionList.add(input::getPriceChildren);

        MovieCRUDGeneralPage.showAllMovie(movieList);
        movieIndex = MovieCRUDGeneralPage.getMovieIndex(movieList, "update", scanner);

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

        String choiceString = Util.getInput("Enter your choice: ", false);
        
        if(Validation.isBack(newValue))
            return;
        // Update the chosen attribute
    }
}
