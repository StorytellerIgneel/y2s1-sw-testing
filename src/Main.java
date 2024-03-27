import java.util.ArrayList;
import java.util.Scanner;

import ui.LoginPage;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        LoginPage.printChoice();
        LoginPage.chooseChoice(input);
    }
}