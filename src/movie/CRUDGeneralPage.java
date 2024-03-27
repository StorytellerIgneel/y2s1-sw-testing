//package Movie;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class CRUDGeneralPage{
    ArrayList<Movie> movieList;
    
    CRUDGeneralPage(){}

    public void MainPage()
    {
        movieList = getMovieList();
        ArrayList<MovieCRUD> movieFunctions = new ArrayList<>();

        //lambda expression implementing interface 
        MovieCRUD addMovie = (ArrayList<Movie> movieList) -> {new MovieAddPage().execute(movieList);};
        MovieCRUD listMovie = (ArrayList<Movie> movieList) -> {new MovieListPage().execute(movieList);};
        MovieCRUD updateMovie = (ArrayList<Movie> movieList) -> {new MovieUpdatePage().execute(movieList);};
        MovieCRUD deleteMovie = (ArrayList<Movie> movieList) -> {new MovieDeletePage().execute(movieList);};

        movieFunctions.add(addMovie);
        movieFunctions.add(listMovie);
        movieFunctions.add(updateMovie);
        movieFunctions.add(deleteMovie);
        
        while (true) {
            String mainPageChoice;
            Integer mainPageChoiceInt = 0;

            try{
                clearConsole();
            } catch (IOException | InterruptedException error){
                error.printStackTrace();
            }
            System.out.println("\nCRUD Options for Movie:");
            System.out.println("1. Add a Movie");
            System.out.println("2. List all Movies");
            System.out.println("3. Update a Movie");
            System.out.println("4. Delete a Movie");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            Scanner input = new Scanner(System.in);
            mainPageChoice = input.nextLine();
            if(Validation.isNumber(mainPageChoice))
            {
                mainPageChoiceInt = Integer.parseInt(mainPageChoice);
                if (mainPageChoiceInt > 0 && mainPageChoiceInt < 5)
                    movieFunctions.get(mainPageChoiceInt - 1).execute(movieList);
                else if (mainPageChoiceInt == 5)
                    return;
                else
                    SystemMessage.errorMessage(2);
            }
            else
            {
                if(Validation.isBack(mainPageChoice))
                    return;
                else
                    SystemMessage.errorMessage(1);
            }
        }    
    }

    public ArrayList<Movie> getMovieList()
    {
        Gson gson = new Gson();
        Type movieListType = new TypeToken<ArrayList<Movie>>(){}.getType();
        String line = "";

        try{
            File file = new File("movieData.json");
            Scanner inputFile = new Scanner(file);
            while(inputFile.hasNextLine())
                line = inputFile.nextLine();
            inputFile.close();
        }catch(FileNotFoundException error){
            error.printStackTrace();
        }
        
        ArrayList<Movie> movieList = gson.fromJson(line, movieListType);
        return movieList;
    }

    public void exportMovieData(ArrayList<Movie> movieList){
        Gson gson = new Gson();
        String toWrite = gson.toJson(movieList);

        try{
            PrintWriter outputFile = new PrintWriter("movieData.txt");
            outputFile.println(toWrite);
            outputFile.close();
        }catch(FileNotFoundException error){
            SystemMessage.errorMessage(3);
        }
        
        return;
    }

    public static void showAllMovie(ArrayList<Movie> movieList)
    {
        int counter = 1;
        for (Movie movie : movieList)
        {
            System.out.println("\n\nMovie index: " + counter);
            System.out.println(movie.viewInformation());
            counter += 1;
        }
    }

    public static int getMovieIndex(ArrayList<Movie> movieList, String action)
    {
        Scanner input = new Scanner(System.in);
        String index = "";
        
        while(true)
        {
            System.out.printf("Enter the index of the movie you wish to %s (Enter :q to quit): ", action);
            index = input.nextLine();
            if (Validation.isNumber(index))
            {
                int indexInt = Integer.parseInt(index);
                if (indexInt > 0 && indexInt <= movieList.size() - 1)
                    return indexInt;
                else
                    SystemMessage.errorMessage(2);
            }
            else
            {
                if (Validation.isBack(index))
                    return -1;
                else
                    SystemMessage.errorMessage(1);
            }
        }
    }

    public static void waitForEnter() {
        System.out.println("Press Enter to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Wait for the user to press Enter
    }

    public static void clearConsole() throws IOException, InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        }
    }
}