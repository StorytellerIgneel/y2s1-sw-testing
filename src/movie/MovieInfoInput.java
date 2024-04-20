package movie;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

import color.Color;
import util.*;

public class MovieInfoInput {
    public Result filler(Result previousResult) { // memang just a filler
        return previousResult;
    }

    public Result getMovieId(Result previousResult) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String movieId = Util.getInput("Enter Movie ID (E.g: MOV000001): MOV", false, scanner);
            if (Validation.isMovie(movieId)) {
                previousResult.step += 1;
                previousResult.setMovieId(movieId);
                break;
            } else if (Validation.isBack(movieId)) {
                previousResult.step -= 1;
                break;
            } else if (Validation.isQuit(movieId))
                System.exit(0);
            else
                SystemMessage.errorMessage(12, scanner);
        }
        return previousResult;
    }

    public Result getTitle(Result previousResult) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String title = Util.getInput("Enter Title: ", true, scanner);
            if (Validation.isNull(title))
                SystemMessage.errorMessage(10, scanner);
            else if (Validation.isBack(title)) {
                previousResult.step -= 1;
                break;
            } else if (Validation.isQuit(title))
                System.exit(0);
            else {
                previousResult.step += 1;
                previousResult.setTitle(title);
                break;
            }
        }
        return previousResult;
    }

    public Result getDesc(Result previousResult) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String description = Util.getInput("Enter Description: ", true, scanner);
            if (Validation.isNull(description))
                SystemMessage.errorMessage(10, scanner);
            else if (Validation.isBack(description)) {
                previousResult.step -= 1;
                break;
            } else if (Validation.isQuit(description))
                System.exit(0);
            else {
                previousResult.step += 1;
                previousResult.setDescription(description);
                break;
            }
        }
        return previousResult;
    }

    public Result getShowtime(Result previousResult){
        Scanner scanner = new Scanner(System.in);
        while(true){
            ArrayList<String> step4Allowed = new ArrayList<String>(List.of("1", "2"));
            ArrayList<String> step4Repeat = new ArrayList<String>(List.of("y", "n", "Y", "N"));
            if (previousResult.getShowtimes().size() > 0){
                String choice = Util.getLimitedInput("Would you like to manually enter a new showtime or create a new showtime based on the previous showtime? Press 1 for former and 2 for latter: ", step4Allowed, scanner);
                if (choice.equals("1")){
                    while(true){
                        String showtime = Util.getInput("Enter a showtime in format of (YYYY MM DD HH MM (The spaces are important!)): ", true, scanner);
                        if(Validation.isShowtime(showtime, scanner)){
                            ArrayList<Integer> timeList = Util.getTime(showtime);
                            previousResult.getShowtimes().add(LocalDateTime.of(timeList.get(0), timeList.get(1), timeList.get(2), timeList.get(3), timeList.get(4), 0));
                            break;
                        }
                        else if (Validation.isBack(showtime)){
                            previousResult.step -= 1;
                            sortShowtime(previousResult.getShowtimes());
                            return previousResult;
                        }
                    }
                }
                else if (choice.equals("2")){
                    String addTime = Util.getInput("Enter the time intended to minus or add after the previous showtime (in 'M D H M' format)", true, scanner);
                    ArrayList<Integer> timeList = Util.getTime(addTime); // M D H M
                    previousResult.getShowtimes().add(previousResult.getShowtimes().get(previousResult.getShowtimes().size() - 1).plusMonths(timeList.get(0)).plusDays(timeList.get(1)).plusHours(timeList.get(2)).plusMinutes(timeList.get(3)));
                }
            }
            else{
                while(true){    
                    String showtime = Util.getInput("Enter a showtime in format of (YYYY MM DD HH SS (The spaces are important!)): ", true, scanner);
                    if( Validation.isNull(showtime))
                        SystemMessage.errorMessage(10, scanner);
                    else if(Validation.isShowtime(showtime, scanner)){
                        ArrayList<Integer> timeList = Util.getTime(showtime);
                        previousResult.getShowtimes().add(LocalDateTime.of(timeList.get(0), timeList.get(1), timeList.get(2), timeList.get(3), timeList.get(4), 0));
                        sortShowtime(previousResult.getShowtimes());
                        break;
                    }
                    else if (Validation.isBack(showtime)){
                        previousResult.step -= 1;
                        return previousResult;
                    }
                    else if (Validation.isQuit(showtime))
                        System.exit(0);
                    else
                        SystemMessage.errorMessage(8, scanner);
                }
            }
            String repeat = Util.getLimitedInput("Do you want to add another showtime? Press y for yes and n for no: ", step4Repeat, scanner);
            if (repeat.equals("n")){
                previousResult.step += 1;
                sortShowtime(previousResult.getShowtimes());
                return previousResult;
            } 
        }
    }

    public Result getLanguage(Result previousResult){
        Scanner scanner = new Scanner(System.in);
        while(true){
            String[] languagesArray = Util.getInput("Enter Languages (separated by spaces): ", true, scanner).split(" ");;
            if (Validation.isLanguage(languagesArray)){
                if( Validation.isNull(languagesArray[0]))
                    SystemMessage.errorMessage(10, scanner);
                else if (Validation.isBack(languagesArray[0])){
                    previousResult.step -= 1;
                    return previousResult;
                }
                else if (Validation.isQuit(languagesArray[0]))
                    System.exit(0);
                else{
                    for (String language : languagesArray)
                        previousResult.getLanguages().add(language.trim().toUpperCase());
                    previousResult.step += 1;
                    return previousResult;
                }
            }
            else
                SystemMessage.errorMessage(7, scanner);
        }
    }

    public Result getReleaseDate(Result previousResult){
        Scanner scanner = new Scanner(System.in);
        while(true){
            ArrayList<Integer> releaseDateList = new ArrayList<Integer>();
            String releaseDateString = Util.getInput("Enter Release Date (YYYY MM DD): ", true, scanner);
            if( Validation.isNull(releaseDateString))
                SystemMessage.errorMessage(10, scanner);
            else if (Validation.isReleaseDate(releaseDateString, scanner)){
                releaseDateList = Util.getTime(releaseDateString);
                int year = releaseDateList.get(0);
                int month = releaseDateList.get(1);
                int day = releaseDateList.get(2);
                previousResult.setReleaseDate(LocalDateTime.of(year, month, day, 0, 0, 0));
                previousResult.step += 1;
                return previousResult;
            }
            else if (Validation.isBack(releaseDateString)){
                previousResult.step -= 1;
                return previousResult;
            }
            else if (Validation.isQuit(releaseDateString))
                System.exit(0);
            else
                SystemMessage.errorMessage(16, scanner);
        }
    }

    public Result getGenre(Result previousResult) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            ArrayList<String> genre = new ArrayList<>();
            String[] genreList =
                    Util.getInput("Enter Genre (seperated by spaces): ", true, scanner).split(" ");
            for (String inputGenre : genreList)
                genre.add(inputGenre.trim().toUpperCase());
            if (Validation.isNull(genre.get(0)))
                SystemMessage.errorMessage(10, scanner);
            else if (Validation.isBack(genre.get(0))) {
                previousResult.step -= 1;
                return previousResult;
            } else if (Validation.isQuit(genre.get(0)))
                System.exit(0);
            else {
                previousResult.step += 1;
                for (String inputGenre : genre)
                    previousResult.getGenre().add(inputGenre);
                return previousResult;
            }
        }
    }

    public Result getPriceAdult(Result previousResult) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String priceAdult = Util.getInput("Enter Price for Adults: ", false, scanner);
            if (Validation.isDouble(priceAdult)) {
                previousResult.setPriceAdult(Double.parseDouble(priceAdult));
                previousResult.step += 1;
                return previousResult;
            } else {
                if (Validation.isBack(priceAdult)) {
                    previousResult.step -= 1;
                    return previousResult;
                } else
                    SystemMessage.errorMessage(1, scanner);
            }
        }
    }

    public Result getPriceChildren(Result previousResult) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            ArrayList<String> confirmList = new ArrayList<String>(List.of("y", "n", "Y", "N"));
            ArrayList<String> choiceList = new ArrayList<String>(List.of("1", "2"));
            String confirm = null;
            String choice = null;
            Double priceChildrenDouble = 0.0;
            while (true) {
                String priceChildren = Util.getInput("Enter Price for Children: ", false, scanner);
                if (Validation.isDouble(priceChildren)) {
                    priceChildrenDouble = Double.parseDouble(priceChildren);
                    if (previousResult.getPriceAdult() != null && priceChildrenDouble > previousResult.getPriceAdult()){
                        confirm = Util.getLimitedInput(Color.RED + "The children price you have entered is more expensive than the adult price! Are you sure this is correct? Press y for yes and n for no: ", confirmList, scanner);
                        if (confirm.equals("y")){
                            previousResult.step += 1;
                            previousResult.setPriceChildren(priceChildrenDouble);
                            return previousResult;
                        } else if (confirm.equals("n")) {
                            choice = Util.getLimitedInput(
                                    "Would you like to change the children price or the adult price? Press 1 for children and 2 for adult",
                                    choiceList, scanner);
                            if (choice == "2") {
                                previousResult.step -= 1;
                                return previousResult;
                            }
                        }
                    } else {
                        previousResult.step += 1;
                        previousResult.setPriceChildren(priceChildrenDouble);
                        return previousResult;
                    }
                } else {
                    if (Validation.isBack(priceChildren)) {
                        previousResult.step -= 1;
                        return previousResult;
                    }
                    if (Validation.isQuit(priceChildren))
                        System.exit(0);
                    else
                        SystemMessage.errorMessage(1, scanner);
                }
            }
        }
    }

    public static void sortShowtime (ArrayList<LocalDateTime> showtimeList){
        Collections.sort(showtimeList);
    }
}