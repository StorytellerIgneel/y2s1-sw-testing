package ui;

import java.awt.Color;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import movie.Movie;
import movie.MovieCRUD;
import movie.Result;
import movie.MovieInfoInput;
import util.*;

public class MovieAddPage implements MovieCRUD {
    MovieAddPage() {};

    @Override
    public void execute(ArrayList<Movie> movieList) {
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

        while(result.step < functionList.size()){
            Function<Result, Result> function = functionList.get(result.step);
            result = function.apply(result);
        }
        
        Movie movie = new Movie(result.getMovieId(), result.getTitle(), result.getDescription(), result.getShowtimes(), result.getLanguages(), result.getReleaseDate(), result.getGenre(), result.getPriceAdult(), result.getPriceChildren());
        movieList.add(movie);
        SystemMessage.successMessage(1);
        return;
    }

    
}