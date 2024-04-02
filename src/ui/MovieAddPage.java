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
        Scanner input = new Scanner(System.in);
        
        String movieId = null;
        String title = null;
        String description = null;
        ArrayList<String> showtimes = new ArrayList<>();
        ArrayList<String> languages = new ArrayList<>();
        String releaseDate = null;
        ArrayList<String> genre = new ArrayList<>();
        Double priceAdultDouble = null;
        Double priceChildrenDouble = null;

        while(true)
        {
            if(step == 1){    
                System.out.print("Enter Movie ID: ");
                movieId = input.nextLine(); // Consume newline character
                if (Validation.isBack(movieId))
                    return;
                else if (Validation.isQuit(movieId))
                    System.exit(0);
                else
                    step += 1;
            }
            if(step == 2){  
                System.out.print("Enter Title: ");
                title = input.nextLine();
                if (Validation.isBack(title))
                    return;
                else if (Validation.isQuit(title))
                    System.exit(0);
                else
                    step += 1;
            }

            if(step == 3){  
                System.out.print("Enter Description: ");
                description = input.nextLine();
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
                    System.out.print("Enter Showtimes in 24hour format (separated by spaces): ");
                    String[] showtimesArray = input.nextLine().split(" ");
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
                    System.out.print("Enter Languages (separated by spaces): ");
                    String[] languagesArray = input.nextLine().split(" ");
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
                System.out.print("Enter Release Date (DD/MM/YYYY): ");
                releaseDate = input.nextLine();
                step += (title == ":q"? -1: 1);
            }
            
            if (step == 7){
                System.out.print("Enter Genre (seperated by spaces): ");
                String[] genreList = input.nextLine().split(" ");
                for (String inputGenre : genreList)
                    genre.add(inputGenre.trim());
                step += (title == ":q"? -1: 1);
            }

            if (step == 8){
                while(true)
                {
                    System.out.print("Enter Price for Adults: ");
                    String priceAdult = input.nextLine();
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
                    System.out.print("Enter Price for Children: ");
                    String priceChildren = input.nextLine();
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
