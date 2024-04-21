package report;

import java.util.ArrayList;
import account.UserAccount;
import ui.systemAdmin.GenerateReport;

// TODO remove in production
public class test {
    public static void main(String[] args) {
        ArrayList<UserAccount> users = UserAccount.getUsers();
        GenerateReport.printReport(users);
    }
}
