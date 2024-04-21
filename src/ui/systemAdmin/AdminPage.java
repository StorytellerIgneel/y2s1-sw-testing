package ui.systemAdmin;

import java.util.Scanner;

public abstract class AdminPage {
    public abstract void printAdminAction();
    public abstract int chooseAdminAction(Scanner scanner);
}
