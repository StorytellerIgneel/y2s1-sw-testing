package util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Validation {
    /**
     * Checks if a given string is a number.
     * 
     * @param value the string to be checked
     * @return true if the string is a number, false otherwise
     */
    public static boolean isNumber(String value) {
        try {
            Integer valueInt = Integer.parseInt(value);
            if (valueInt >= 0)
                return (true);
            else
                return false;
        } catch (NumberFormatException error) {
            return false;
        }
    }

    public static boolean isTime(String[] showtimes) {
        for (String time : showtimes) {
            if (!time.matches("[0-1][0-9][0-5][0-9]") && !time.matches("2[0-3][0-5][0-9]"))
                return false;
        }
        return true;
    }

    public static boolean isLanguage(String[] languages) {
        for (String language : languages) {
            if (!language.matches("[a-zA-Z]+"))
                return false;
        }
        return true;
    }

    public static boolean isDouble(String value) {
        try {
            Double valueDouble = Double.parseDouble(value);
            if (valueDouble >= 0)
                return (true);
            else
                return false;
        } catch (NumberFormatException error) {
            return false;
        }
    }

    public static boolean isBack(String value) {
        return (value.equals(":b") || value.equals(":B"));
    }

    public static boolean isQuit(String value) {
        return (value.equals(":q") || value.equals(":Q"));
    }

    public static boolean isMovie(String value) {
        return value.matches("[0-9][0-9][0-9][0-9][0-9][0-9]");
    }

    public static boolean isShowtime(String value, Scanner scanner) {
        LocalDateTime currentTime = LocalDateTime.now();
        ArrayList<Integer> times = new ArrayList<Integer>();
        int currentYear = currentTime.getYear();
        int currentMonth = currentTime.getMonthValue();
        int currentDay = currentTime.getDayOfMonth();
        int febDays = (currentYear % 4 == 0) ? 29 : 28; // check leap year
        ArrayList<Integer> daysInMonth =
                new ArrayList<>(List.of(0, 31, febDays, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31));

        // it would like like: 2024 12 31 10 30
        if (value.matches(
                "(202[4-9]) (0?[1-9]|1[0-2]) (0?[1-9]|[12][0-9]|3[01]) ([01]?[0-9]|2[0-3]) ([0-5]?[0-9])")) {
            String[] list = value.split(" ");
            for (String time : list)
                times.add(Integer.parseInt(time));
            int givenYear = times.get(0);
            int givenMonth = times.get(1);
            int givenDay = times.get(2);
            if (givenYear > (currentYear + 1)) {
                SystemMessage.errorMessage(15, scanner);
                return false;
            }
            if (givenYear < currentYear) { // entered last year RD like 2023
                SystemMessage.errorMessage(17, scanner);
                return false;
            }
            if ((givenYear <= currentYear) && (givenMonth < currentMonth)) { // last year or same
                                                                             // year but previous
                                                                             // months like 2024 3
                                                                             // 20
                if (givenDay <= currentDay) {
                    SystemMessage.errorMessage(19, scanner);
                    return false;
                } else {
                    SystemMessage.errorMessage(18, scanner);
                    return false;
                }
            }
            if (givenDay > daysInMonth.get(givenMonth)) {
                SystemMessage.errorMessage(14, scanner);
                return false;
            }
            return true;
        } else {
            SystemMessage.errorMessage(13, scanner);
            return false;
        }
    }

    public static boolean isAddTime(String value) { // add time: month day hour minute
        return value.matches("[0-1] [0-30] [0-24] [0-60]");
    }

    public static boolean isReleaseDate(String value, Scanner scanner) { // remove time: month day
                                                                         // hour minute
        LocalDateTime currentTime = LocalDateTime.now();
        ArrayList<Integer> times = new ArrayList<Integer>();
        int currentYear = currentTime.getYear();
        int currentMonth = currentTime.getMonthValue();
        int currentDay = currentTime.getDayOfMonth();

        int febDays = (currentYear % 4 == 0) ? 29 : 28; // check leap year
        ArrayList<Integer> daysInMonth =
                new ArrayList<>(List.of(0, 31, febDays, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31));

        if (value.matches(
                "(202[4-9]) (0?[1-9]|1[0-2]) (0?[1-9]|[12][0-9]|3[01])")) {
            String[] list = value.split(" ");
            for (String time : list)
                times.add(Integer.parseInt(time));
            int givenYear = times.get(0);
            int givenMonth = times.get(1);
            int givenDay = times.get(2);

            if (givenYear > (currentYear + 1)) {
                SystemMessage.errorMessage(15, scanner);
                return false;
            }
            if (givenYear < currentYear) { // entered last year RD like 2023
                SystemMessage.errorMessage(17, scanner);
                return false;
            }
            if ((givenYear <= currentYear) && (givenMonth < currentMonth)) { // last year or same
                                                                             // year but previous
                                                                             // months like 2024 3
                                                                             // 20
                if (givenDay <= currentDay) {
                    SystemMessage.errorMessage(19, scanner);
                    return false;
                } else {
                    SystemMessage.errorMessage(18, scanner);
                    return false;
                }
            }
            if (givenDay > daysInMonth.get(givenMonth)) {
                SystemMessage.errorMessage(14, scanner);
                return false;
            }
            return true;
        } else {
            SystemMessage.errorMessage(16, scanner);
            return false;
        }
    }

    public static boolean isNull(String value) {
        return (value.equals(null) || value.equals(""));
    }
}
