package ui;

import java.awt.Color;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import movie.Movie;
import movie.MovieCRUD;
import util.*;

public class MovieAddPage implements MovieCRUD {
    MovieAddPage() {
    };

    @Override
    public void execute(ArrayList<Movie> movieList) {
        System.out.println(movieList.size());
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
                    movieId = "MOV" + Util.getInput("Enter Movie ID (E.g: MOV000001): MOV", false);
                    if( Validation.isNull(movieId))
                        SystemMessage.errorMessage(10);
                    else if (Validation.isMovie(movieId)){
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
                while(true){
                    title = Util.getInput("Enter Title: ", true);
                    System.out.println(title.equals(""));
                    if( Validation.isNull(title))
                        SystemMessage.errorMessage(10);
                    else if (Validation.isBack(title)){
                        step -= 1;
                        break;
                    }
                    else if (Validation.isQuit(title))
                        System.exit(0);
                    else{
                        step += 1;
                        break;
                    }
                }
            }

            if(step == 3){
                while(true){
                    description = Util.getInput("Enter Description: ", true);
                    if( Validation.isNull(description))
                        SystemMessage.errorMessage(10);
                    else if (Validation.isBack(description)){
                        step -= 1;
                        break;
                    }
                    else if (Validation.isQuit(description))
                        System.exit(0);
                    else{
                        step += 1;
                        break;
                    }
                }
            }

            if(step == 4){ 
                while(true)
                {
                    ArrayList<String> step4Allowed = new ArrayList<String>(List.of("1", "2"));
                    ArrayList<String> step4Repeat = new ArrayList<String>(List.of("y", "n", "Y", "N"));
                    if (showtimes.size() > 0){
                        Boolean pass = false;
                        String choice = Util.getLimitedInput("Would you like to manually enter a new showtime or create a new showtime based on the previous showtime? Press 1 for former and 2 for latter: ", step4Allowed);
                        if (choice == "1"){
                            while(pass == false){    
                                pass = false;
                                String showtime = Util.getInput("Enter a showtime in format of (YYYY MM DD HH SS (The spaces are important!)): ", true);
                                System.out.println(showtime);
                                if(Validation.isShowtime(showtime)){
                                    ArrayList<Integer> timeList = Util.getTime(showtime);
                                    showtimes.add(LocalDateTime.of(timeList.get(1), timeList.get(2), timeList.get(3), timeList.get(4), timeList.get(5), 0));
                                    pass = true;
                                }
                                else if (Validation.isBack(description)){
                                    step -= 1;
                                    pass = true;
                                }
                            }
                        }
                        else if (choice == "2"){
                            String addTime = Util.getInput("Enter the time intended to minus or add after the previous showtime (in 'M D H M' format)", true);
                            ArrayList<Integer> timeList = Util.getTime(addTime); // M D H M
                            showtimes.add(showtimes.get(showtimes.size() - 1).plusMonths(timeList.get(0)).plusDays(timeList.get(1)).plusHours(timeList.get(2)).plusMinutes(timeList.get(3)));
                            break;
                        }
                        String repeat = Util.getLimitedInput("Do you want to add another showtimew? Press y for yes and n for no: ", step4Repeat);
                        if (repeat == "n"){
                            step += 1;
                            break;
                        } 
                    }
                    else{
                        while(true){    
                            String showtime = Util.getInput("Enter a showtime in format of (YYYY MM DD HH SS (The spaces are important!)): ", true);
                            System.out.println(showtime);
                            if( Validation.isNull(showtime))
                                SystemMessage.errorMessage(10);
                            else if(Validation.isShowtime(showtime)){
                                ArrayList<Integer> timeList = Util.getTime(showtime);
                                showtimes.add(LocalDateTime.of(timeList.get(0), timeList.get(1), timeList.get(2), timeList.get(3), timeList.get(4), 0));
                                break;
                            }
                            else if (Validation.isBack(description)){
                                step -= 1;
                                break;
                            }
                            else if (Validation.isQuit(description))
                                System.exit(0);
                            else
                                SystemMessage.errorMessage(8);
                        }
                        String repeat = Util.getLimitedInput("Do you want to add another showtimew? Press y for yes and n for no: ", step4Repeat);
                        System.out.println(repeat);
                        if (repeat.equals("n")){
                            System.out.println("passed");
                            step += 1;
                            break;
                        } 
                    }
                }
            }
            
            if (step == 5){
                while(true){
                    String[] languagesArray = Util.getInput("Enter Languages (separated by spaces): ", true).split(" ");;
                    if (Validation.isLanguage(languagesArray)){
                        if( Validation.isNull(languagesArray[0]))
                            SystemMessage.errorMessage(10);
                        else if (Validation.isBack(languagesArray[0])){
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
                    String releaseDateString = Util.getInput("Enter Release Date (YYYY MM DD): ", true);
                    if( Validation.isNull(releaseDateString))
                        SystemMessage.errorMessage(10);
                    else if (Validation.isReleaseDate(releaseDateString)){
                        releaseDateList = Util.getTime(releaseDateString);
                        int year = releaseDateList.get(0);
                        int month = releaseDateList.get(1);
                        int day = releaseDateList.get(2);
                        releaseDate = LocalDateTime.of(year, month, day, 0, 0, 0);
                        step += 1;
                        break;
                    }
                    else if (Validation.isBack(releaseDateString)){
                        step -= 1;
                        break;
                    }
                    else if (Validation.isQuit(releaseDateString))
                        System.exit(0);
                    else
                        SystemMessage.errorMessage(16);
                }
            }
            
            if (step == 7){
                while(true){
                    String[] genreList = Util.getInput("Enter Genre (seperated by spaces): ", true).split(" ");
                    for (String inputGenre : genreList)
                        genre.add(inputGenre.trim().toUpperCase());
                    if( Validation.isNull(genre.get(0)))
                        SystemMessage.errorMessage(10);
                    else if (Validation.isBack(genre.get(0))){
                        step -= 1;
                        break;
                    }
                    else if (Validation.isQuit(genre.get(0)))
                        System.exit(0);
                    else{
                        step += 1;
                        break;
                    }
                }
            }

            if (step == 8){
                while(true)
                {
                    String priceAdult = Util.getInput("Enter Price for Adults: ", false);
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
                ArrayList<String> step9Confirm = new ArrayList<String>(List.of("y", "n", "Y", "N"));
                ArrayList<String> step9Choice = new ArrayList<String>(List.of("1", "2"));
                Boolean resetAdult = false; //reset price for adult
                Boolean reset = false;
                String confirm = null;
                String choice = null;
                while(true){
                    if (resetAdult == true){
                        step -= 1;
                        break;
                    }
                    resetAdult = false; //reset price for adult
                    reset = false;
                    String priceChildren = Util.getInput("Enter Price for Children: ", false);
                    if (Validation.isDouble(priceChildren)){
                        priceChildrenDouble = Double.parseDouble(priceChildren);
                        if (priceChildrenDouble > priceAdultDouble){
                            confirm = Util.getLimitedInput(Color.RED + "The children price you have entered is more expensive than the adult price! Are you sure this is correct? Press y for yes and n for no: ", step9Confirm);
                            if (confirm == "y"){
                                step += 1;
                                break;
                            }
                            else if (confirm == "n"){
                                choice = Util.getLimitedInput("Would you like to change the children price or the adult price? Press 1 for children and 2 for adult", step9Choice);
                                if (choice == "1")
                                    break;
                                else if (choice == "2"){
                                    step -= 1;
                                    break;
                                }
                            }
                        }
                        else{
                            step += 1;
                            break;
                        }
                    }
                    else{
                        if (Validation.isBack(priceChildren)){
                            step -= 1;
                            break;
                        }
                        if (Validation.isQuit(priceChildren))
                            System.exit(0);
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
        System.out.println(movieList.get(0).getTitle());
        Util.waitForEnter();
        return;
    }
}