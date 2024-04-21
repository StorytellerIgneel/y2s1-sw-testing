package ui.systemAdmin;

import java.util.ArrayList;
import account.UserAccount;
import util.CommonIcon;
import report.*;

public class GenerateReport {
    public static void printReport(ArrayList<UserAccount> users) {
        ArrayList<Report> data = new ArrayList<Report>();
        Report.generateTicketSalesReport(users, data);
        CommonIcon.printHeader();
        System.out.println("Monthly Report");
        CommonIcon.printChar('-', 60);
        System.out.println("Report Month: "); //
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
        System.out.printf("%55s %10.2f", "Total Revenue:", totalRevenue);
    }
}
