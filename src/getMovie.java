//package src

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import com.google.gson.Gson;

public class getMovie {
    public static ArrayList<Movie> getMovies(){
        ArrayList <Movie> movies = new ArrayList<Movie>();
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python", "webscrapping.py");
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                Gson gson = new Gson();
                
                Movie new_movie = gson.fromJson(line, Movie.class); //switch json to Movie class

                movies.add(new_movie); //append into list
            }
            int exitCode = process.waitFor();
            //System.out.println("Python script exited with code " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return movies;
    }
}