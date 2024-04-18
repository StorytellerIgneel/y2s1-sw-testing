package ui;

import java.awt.Color;
import java.time.LocalDateTime;
import java.util.ArrayList;

import movie.Movie;
import movie.MovieCRUD;
import util.*;

public class MovieAddPage implements MovieCRUD {
    MovieAddPage() {
    };

    @Override
    public void execute(ArrayList<Movie> movieList) {
        int step = 1;
        
        String movieId = null;
        String title = null;
        String description = null;
        ArrayList<LocalDateTime> showtimes = new ArrayList<>();
        ArrayList<String> languages = new ArrayList<>();
        LocalDateTime releaseDate = null;
        ArrayList<String> genre = new ArrayList<>();
        Double priceAdultDouble = null;
        Double priceChildrenDouble = null;

        while(true)
        {
            if(step == 1){    
                while(true){
                    movieId = Util.getInput("Enter Movie ID (E.g: MOV000001): ");
                    if (Validation.isMovie(movieId)){
                        step += 1;
                        break;
                    }
                    else if (Validation.isBack(movieId)){
                        step -= 1;
                        break;
                    }
                    else if (Validation.isQuit(movieId))
                        System.exit(0);
                    else
                        SystemMessage.errorMessage(12);
                }
            }

            if(step == 2){
                while(1){
                    
                }
                title = Util.getInput("Enter Title: ");
                if (Validation.isBack(title))
                    step -= 1;
                else if (Validation.isQuit(title))
                    System.exit(0);
                else
                    step += 1;
            }

            if(step == 3){
                description = Util.getInput("Enter Description: ");
                if (Validation.isBack(description))
                    step -= 1;
                else if (Validation.isQuit(description))
                    System.exit(0);
                else
                    step += 1;
            }

            if(step == 4){ 
                while(true)
                {
                    if (showtimes.size() > 0){
                        while(true){
                            String choice = Util.getInput("Would you like to manually enter a new showtime or create a new showtime based on the previous showtime? Press 1 for former and 2 for latter: ");
                            if (choice == "1"){
                                while(true){    
                                    String showtime = Util.getInput("Enter Showtimes in format of (YYYY MM DD HH SS (The spaces are important!)): ");
                                    if(Validation.isShowtime(showtime)){
                                        ArrayList<Integer> timeList = Util.getTime(showtime);
                                        showtimes.add(LocalDateTime.of(timeList.get(1), timeList.get(2), timeList.get(3), timeList.get(4), timeList.get(5), 0));
                                        break;
                                    }
                                    else if (Validation.isBack(description)){
                                        step -= 1;
                                        return;
                                    }
                                    else if (Validation.isQuit(description))
                                        System.exit(0);
                                    else
                                        SystemMessage.errorMessage(8);
                                }
                            }
                            else if (choice == "2"){
                                String addTime = Util.getInput("Enter the time intended to minus or add after the previous showtime (in 'M D H M' format)");
                                ArrayList<Integer> timeList = Util.getTime(addTime); // M D H M
                                showtimes.add(showtimes.get(showtimes.size() - 1).plusMonths(timeList.get(0)).plusDays(timeList.get(1)).plusHours(timeList.get(2)).plusMinutes(timeList.get(3)));
                                break;
                            }
                            else
                                SystemMessage.errorMessage(11);
                        }
                        String choice = Util.getInput("Do you want to add another showtim? Press y for yes and n for no: ");
                        if (choice == "n"){
                            step += 1;
                            break;
                        } 
                    }
                    else{
                        while(true){    
                            String showtime = Util.getInput("Enter Showtimes in format of (YYYY MM DD HH SS (The spaces are important!)): ");
                            if(Validation.isShowtime(showtime)){
                                System.out.println("passed");
                                ArrayList<Integer> timeList = Util.getTime(showtime);
                                showtimes.add(LocalDateTime.of(timeList.get(1), timeList.get(2), timeList.get(3), timeList.get(4), timeList.get(5), 0));
                                break;
                            }
                            else if (Validation.isBack(description)){
                                step -= 1;
                                return;
                            }
                            else if (Validation.isQuit(description))
                                System.exit(0);
                            else
                                SystemMessage.errorMessage(8);
                        }
                    }
                }
            }
            
            if (step == 5){
                while(true){
                    String[] languagesArray = Util.getInput("Enter Languages (separated by spaces): ").split(" ");;
                    if (Validation.isLanguage(languagesArray))
                    {
                        if (Validation.isBack(languagesArray[0])){
                            step -= 1;
                            break;
                        }
                        else if (Validation.isQuit(description))
                            System.exit(0);
                        else{
                            for (String language : languagesArray)
                                languages.add(language.trim().toUpperCase());
                            step += 1;
                            break;
                        }
                    }
                    else
                        SystemMessage.errorMessage(7);
                }
            }
            
            if (step == 6){
                while(true){
                    ArrayList<Integer> releaseDateList = new ArrayList<Integer>();
                    String releaseDateString = Util.getInput("Enter Release Date (YYYY MM DD): ");
                    if (Validation.isReleaseDate(releaseDateString)){
                        releaseDateList = Util.getTime(releaseDateString);
                        int year = releaseDateList.get(0);
                        int month = releaseDateList.get(1);
                        int day = releaseDateList.get(2);
                        releaseDate = LocalDateTime.of(year, month, day, 0, 0, 0);
                        step += 1;
                        break;
                    }
                    if (Validation.isBack(genre.get(0))){
                        step -= 1;
                        break;
                    }
                    else if (Validation.isQuit(genre.get(0)))
                        System.exit(0);
                    else
                        SystemMessage.errorMessage(16);
                }
            }
            
            if (step == 7){
                String[] genreList = Util.getInput("Enter Genre (seperated by spaces): ").split(" ");
                for (String inputGenre : genreList)
                    genre.add(inputGenre.trim().toUpperCase());
                if (Validation.isBack(genre.get(0))){
                    step -= 1;
                    break;
                }
                else if (Validation.isQuit(genre.get(0)))
                    System.exit(0);
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
                Boolean resetAdult = false; //reset price for adult
                Boolean reset = false;
                while(true){
                    if (resetAdult == true){
                        step -= 1;
                        break;
                    }
                    resetAdult = false; //reset price for adult
                    reset = false;
                    String priceChildren = Util.getInput("Enter Price for Children: ");
                    if (Validation.isDouble(priceChildren)){
                        priceChildrenDouble = Double.parseDouble(priceChildren);
                        if (priceChildrenDouble > priceAdultDouble){
                            while(true){
                                String choice = Util.getInput(Color.RED + "The children price you have entered is more expensive than the adult price! Are you sure this is correct? Press y for yes and n for no: ");
                                if (choice == "y"){
                                    step += 1;
                                    break;
                                }
                                else if (choice == "n"){
                                    if (reset == true)
                                        break;
                                    while(true){
                                        choice = Util.getInput("Would you like to change the children price or the adult price? Press 1 for children and 2 for adult");
                                        if (choice == "1"){
                                            reset = true;
                                            break;
                                        }
                                        else if (choice == "2"){
                                            reset = true;
                                            resetAdult = true;
                                            break;
                                        }
                                        else if (Validation.isBack(choice))
                                            break;
                                        else
                                            SystemMessage.errorMessage(11);
                                    }
                                }
                                else
                                    SystemMessage.errorMessage(11);
                                
                                if(reset == true){
                                    step -= 1;
                                    break;
                                }
                            }
                        }
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