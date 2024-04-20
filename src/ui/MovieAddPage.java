package ui;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

import movie.Movie;
import movie.MovieCRUD;
import movie.Result;
import util.*;
import movie.MovieInfoInput;

public class MovieAddPage implements MovieCRUD {
    MovieAddPage() {};

    @Override
    public void execute(ArrayList<Movie> movieList) {
        Result result = new Result();
        MovieInfoInput input = new MovieInfoInput();
        Scanner scanner = new Scanner(System.in);

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

        while(result.step < functionList.size()){
            if (result.step == 0)
                return;
            Function<Result, Result> function = functionList.get(result.step);
            result = function.apply(result);
        }
        
        Movie movie = new Movie(result.getMovieId(), result.getTitle(), result.getDescription(), result.getShowtimes(), result.getLanguages(), result.getReleaseDate(), result.getGenre(), result.getPriceAdult(), result.getPriceChildren());
        movieList.add(movie);
        SystemMessage.successMessage(1, scanner);
        return;
    }

    
}