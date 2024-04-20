package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import color.Color;

public class Util {
    Util() {};

    public static void clearConsole(Scanner scanner) throws IOException, InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        try {
            if (os.contains("windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            SystemMessage.errorMessage(9, scanner);
        }

    }

    public static void waitForEnter(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        System.out.println("Press Enter to continue...");
        scanner.nextLine(); // Wait for the user to press Enter
    }

    public static String getInput(String prompt, Boolean allowSpaces, Scanner scanner) {
        String input = null;
        while (true) {
            System.out.print(prompt + Color.YELLOW);
            if (allowSpaces.equals(false))
                input = scanner.next();
            else
                input = scanner.nextLine();
            System.out.print(Color.RESET);
            if (Validation.isNull(input))
                SystemMessage.errorMessage(10, scanner);
            else
                break;
        }
        return input.trim();
    }

    public static String getLimitedInput(String prompt, ArrayList<String> allowedInputs,Scanner scanner) {
        allowedInputs.add(":b");
        allowedInputs.add(":q");
        String input = null;
        while (true) {
            System.out.print(prompt + Color.YELLOW);
            input = scanner.next();
            if (allowedInputs.contains(input))
                break;
            else if (Validation.isQuit(input))
                System.exit(0);
            else
                SystemMessage.errorMessage(11, scanner);
        }
        System.out.print(Color.RESET);
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
