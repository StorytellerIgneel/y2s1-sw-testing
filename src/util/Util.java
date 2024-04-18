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

    public static String getInput(String prompt, Boolean allowSpaces) {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        while(true){
            System.out.print(prompt + Color.yellow);
            if (allowSpaces.equals(false))
                input = scanner.next();
            else
                input = scanner.nextLine();
            System.out.print(Color.reset);
            if (Validation.isNull(input))
                SystemMessage.errorMessage(10);
            else
                break;
        }
        return input.trim();
    }

    public static String getLimitedInput(String prompt, ArrayList<String> allowedInputs){
        Scanner scanner = new Scanner(System.in);
        String input = null;
        while(true){
            System.out.print(prompt + Color.yellow);
            input = scanner.next();
            if (allowedInputs.contains(input))
                break;
            else if (Validation.isQuit(input))
                System.exit(0);
            else
                SystemMessage.errorMessage(11);
        }
        System.out.print(Color.reset);
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