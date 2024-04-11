package ui;
import java.util.ArrayList;
import java.util.Scanner;

import movie.Movie;
import movie.MovieCRUD;
import util.*;

public class MovieAddPage implements MovieCRUD {
    MovieAddPage(){};

    @Override
    public void execute(ArrayList<Movie> movieList) {
        int step = 1;
        
        String movieId = null;
        String title = null;
        String description = null;
        String showtimeString = null;
        ArrayList<String> showtimes = new ArrayList<>();
        ArrayList<String> languages = new ArrayList<>();
        String releaseDate = null;
        ArrayList<String> genre = new ArrayList<>();
        Double priceAdultDouble = null;
        Double priceChildrenDouble = null;

        while(true)
        {
            if(step == 1){    
                movieId = Util.getInput("Enter Movie ID: ");
                if (Validation.isBack(movieId))
                    return;
                else if (Validation.isQuit(movieId))
                    System.exit(0);
                else
                    step += 1;
            }
            if(step == 2){  
                title = Util.getInput("Enter Title: ");
                if (Validation.isBack(title))
                    return;
                else if (Validation.isQuit(title))
                    System.exit(0);
                else
                    step += 1;
            }

            if(step == 3){
                description = Util.getInput("Enter Description: ");
                if (Validation.isBack(description))
                    return;
                else if (Validation.isQuit(description))
                    System.exit(0);
                else
                    step += 1;
            }

            if(step == 4){ 
                while(true)
                {
                    String[] showtimesArray = Util.getInput("Enter Showtimes in 24hour format (separated by spaces): ").split(" ");
                    if(Validation.isTime(showtimesArray))
                    {
                        for (String showtime : showtimesArray)
                            showtimes.add(showtime.trim());
                        step += 1;
                        break;
                    }
                    else if (Validation.isBack(description))
                        return;
                    else if (Validation.isQuit(description))
                        System.exit(0);
                    else
                        SystemMessage.errorMessage(8);
                }
            }
            
            if (step == 5){
                while(true){
                    String[] languagesArray = Util.getInput("Enter Languages (separated by spaces): ").split(" ");;
                    if (Validation.isLanguage(languagesArray))
                    {
                        if (Validation.isBack(description))
                            return;
                        else if (Validation.isQuit(description))
                            System.exit(0);
                        else{
                            for (String language : languagesArray)
                                languages.add(language.trim());
                            step += 1;
                            break;
                        }
                    }
                    else
                        SystemMessage.errorMessage(7);
                }
            }
            
            if (step == 6){
                releaseDate = Util.getInput("Enter Release Date (DD/MM/YYYY): ");
                step += (title == ":q"? -1: 1);
            }
            
            if (step == 7){
                String[] genreList = Util.getInput("Enter Genre (seperated by spaces): ").split(" ");
                for (String inputGenre : genreList)
                    genre.add(inputGenre.trim());
                step += (title == ":q"? -1: 1);
            }

            if (step == 8){
                while(true)
                {
                    String priceAdult = Util.getInput("Enter Price for Adults: ");
                    if (Validation.isDouble(priceAdult)){
                        priceAdultDouble = Double.parseDouble(priceAdult);
                        step += 1;
                        break;
                    }
                    else{
                        if (Validation.isBack(priceAdult)){
                            step -= 1;
                            break;
                        }
                        else
                            SystemMessage.errorMessage(1);
                    }
                }
            }
            
            if (step == 9){
                while(true){
                    String priceChildren = Util.getInput("Enter Price for Children: ");
                    if (Validation.isDouble(priceChildren)){
                        priceChildrenDouble = Double.parseDouble(priceChildren);
                        step += 1;
                        break;
                    }
                    else{
                        if (Validation.isBack(priceChildren)){
                            step -= 1;
                            break;
                        }
                        else
                            SystemMessage.errorMessage(1);
                    }
                }
            }
            if(step == 10)
                break;
        }
        
        Movie movie = new Movie(movieId, title, description, showtimes, languages, releaseDate, genre, priceAdultDouble, priceChildrenDouble);
        movieList.add(movie);
        SystemMessage.successMessage(1);
        return;
    }
}
