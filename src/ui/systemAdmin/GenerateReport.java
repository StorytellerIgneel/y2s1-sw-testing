package ui.systemAdmin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import account.UserAccount;
import util.CommonIcon;
import util.Util;
import report.Report;

public class GenerateReport {
    public static void printReport(ArrayList<UserAccount> users, Scanner scanner) {
        ArrayList<Report> data = new ArrayList<Report>();
        Report.generateTicketSalesReport(users, data);
        CommonIcon.printHeader();
        System.out.println("Monthly Report");
        CommonIcon.printChar('-', 100);
        System.out.println("Report Date: " + LocalDate.now()); //
        CommonIcon.printChar('-', 100);
        System.out.println("*A = Adult  *C = Children");
        System.out.println();
        System.out.printf("%-3s %-9s\t %-50s\t %-3s %-3s %10s\n", "No", "Movie ID", "Movie Name",
                "*A", "*C", "Revenue");
        double totalRevenue = 0;
        for (int i = 0; i < data.size(); i++) {
            Report current = data.get(i);
            String movieName = current.getMovieName();
            if (movieName.length() > 50) {
                movieName = current.getMovieName().substring(0, 47) + "...";
            }
            double revenue = current.calculateTotalRevenue(); // calculate revenue
            totalRevenue += revenue;
            System.out.printf("%02d. %-9s\t %-50s\t %-3s %-3s %10.2f\n", i + 1,
                    current.getMovieId(), movieName, current.getTotalAdult(),
                    current.getTotalChildren(), revenue);
        }
        CommonIcon.printChar('-', 100);
        System.out.printf("%85s %10.2f", "Total Revenue:", totalRevenue);
        System.out.println();
        CommonIcon.printChar('-', 100);

        Util.waitForEnter(scanner);
    }
}
