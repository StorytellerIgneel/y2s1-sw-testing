package report;

import java.util.ArrayList;
import java.util.Scanner;
import account.UserAccount;
import ui.systemAdmin.GenerateReport;

// TODO remove in production
public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<UserAccount> users = UserAccount.getUsers();
        GenerateReport.printReport(users, scanner);
    }
}
