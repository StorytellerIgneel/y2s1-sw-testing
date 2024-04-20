package report;

import java.util.ArrayList;
import account.UserAccount;
import ui.systemAdmin.GenerateReport;

public class test {
    public static void main(String[] args) {
        ArrayList<UserAccount> users = UserAccount.getUsers();
        GenerateReport.printReport(users);
    }
}
