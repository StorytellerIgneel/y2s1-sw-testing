package ui.systemAdmin;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import account.UserAccount;
import util.Util;
import util.CommonIcon;
import report.*;

public class GenerateReportPage {
    
    public static void printReport(ArrayList<UserAccount> users, ArrayList<Report> data,
            Scanner scanner) {
        CommonIcon.printHeader();
        System.out.println("Report for Month "
                + LocalDate.now().format(DateTimeFormatter.ofPattern("MM-yyyy")));
        CommonIcon.printChar('-', 100);
        System.out.println("Report Generated on: " + Report.getReportDate());
        CommonIcon.printChar('-', 100);
        System.out.println();
        System.out.println("Total number of users: " + users.size());
        System.out.println("Total number of movies: " + data.size());
        System.out.println();
        System.out.println("A* = Adult  C* = Children");
        System.out.println();
        System.out.printf("%-3s %-9s\t %-50s\t %-3s\t %-3s %10s\n", "No", "Movie ID", "Movie Name",
                "A*", "C*", "Revenue");
        double totalRevenue = 0;
        for (int i = 0; i < data.size(); i++) {
            Report current = data.get(i);
            double revenue = current.calculateTotalRevenue();
            totalRevenue += revenue;
            // trim movie name if it is too long
            String movieName = current.getMovieName();
            if (movieName.length() > 50) {
                movieName = movieName.substring(0, 47) + "...";
            }
            System.out.printf("%02d. %-9s\t %-50s\t %-3s\t %-3s %10.2f\n", i + 1,
                    current.getMovieId(), movieName, current.getTotalAdult(),
                    current.getTotalChildren(), revenue);
        }
        CommonIcon.printChar('-', 100);
        System.out.printf("%84s %10.2f\n", "Total Revenue:", totalRevenue);
        scanner.nextLine();
        CommonIcon.printChar('-', 100);
        Util.waitForEnter(scanner);
    }
}

