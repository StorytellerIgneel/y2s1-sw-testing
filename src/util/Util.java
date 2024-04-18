package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import color.Color;

public class Util {
    Util(){};
    public static void clearConsole() throws IOException, InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        try {
            if (os.contains("windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            SystemMessage.errorMessage(9);
        }
        
    }

    public static void waitForEnter() {
        System.out.println("Press Enter to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Wait for the user to press Enter
    }

    public static String getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String input = null;

        while(true) {
            System.out.print(prompt + Color.yellow);
            input = scanner.nextLine();
            System.out.print(Color.reset);
            if (input.equals(""))
                SystemMessage.errorMessage(10);
            else
                break;
        }
        return input;
    }

    public static ArrayList<Integer> getTime(String dateString) {
        String list[] = dateString.split(" ");
        ArrayList<Integer> timeList = new ArrayList<Integer>();
        for (String time : list)
            timeList.add(Integer.parseInt(time));
        return timeList;
    }
}