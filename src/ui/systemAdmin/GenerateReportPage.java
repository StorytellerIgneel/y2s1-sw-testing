package ui.systemAdmin;

import java.util.ArrayList;
import java.util.Scanner;

import account.UserAccount;
import util.Util;
import util.CommonIcon;
import report.*;

public class GenerateReportPage extends AdminPage {
    public void printAdminAction() {

    }

    public int chooseAdminAction(Scanner scanner) {
        return 1;
    }



    public static void printReport(ArrayList<UserAccount> users, ArrayList<Report> data,
            Scanner scanner) {
        CommonIcon.printHeader();
        System.out.println("" + "Report"); // TODO add year and month
        CommonIcon.printChar('-', 60);
        System.out.println("Report Generated on: " + Report.getReportDate());
        CommonIcon.printChar('-', 60);
        System.out.println("*A = Adult  C = Children");
        System.out.printf("%-3s %-9s\t%-30s\t%-3s %-3s %10s\n", "No", "Movie ID", "Movie Name",
                "A*", "C*", "Revenue");
        double totalRevenue = 0;
        for (int i = 0; i < data.size(); i++) {
            Report current = data.get(i);
            double revenue = current.calculateTotalRevenue();
            totalRevenue += revenue;
            System.out.printf("%02d. %-9s\t%-30s\t%-3s %-3s %10.2f\n", i + 1, current.getMovieId(),
                    current.getMovieName(), current.getTotalAdult(), current.getTotalChildren(),
                    revenue);
        }
        CommonIcon.printChar('-', 60);
        System.out.printf("%55s %10.2f\n", "Total Revenue:", totalRevenue);
        scanner.nextLine();
        Util.waitForEnter(scanner);
    }
}

