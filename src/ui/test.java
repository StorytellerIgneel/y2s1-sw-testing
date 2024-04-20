package ui;

import java.util.Scanner;

// TODO remove file in production
public class test {
    public static void main(String[] args) {
        MovieCRUDGeneralPage moviePage = new MovieCRUDGeneralPage();
        Scanner scanner = new Scanner(System.in);
        moviePage.MainPage(scanner);
    }
}
