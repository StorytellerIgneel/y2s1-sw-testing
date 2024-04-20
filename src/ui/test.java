package ui;

import java.util.Scanner;

// TODO remove file in production
public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieCRUDGeneralPage moviePage = new MovieCRUDGeneralPage(scanner);
        moviePage.MainPage();
    }
}
