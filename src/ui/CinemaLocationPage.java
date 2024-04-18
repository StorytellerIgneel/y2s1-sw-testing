package ui;
import cinema.Cinema;
import util.*;
import account.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import color.Color;


public class CinemaLocationPage {
    private int userIdx;
    private ArrayList<UserAccount> users;
    private Scanner input;

    public CinemaLocationPage(int userIdx, ArrayList<UserAccount> users, Scanner input) {
        this.userIdx = userIdx;
        this.users = users;
        this.input = input;
    }

    public void printCinema()
    {
        try
        {
            Util.clearConsole();
        }
        catch(IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
        CommonIcon.printHeader();
        CommonIcon.printUserStatus(userIdx, users);
        System.out.println("Available cinema locations:");
        for(int i = 0; i < Cinema.getCinemaLocation().length; i++)
        {
            System.out.println(Color.RED + (i+1) + ") " + Cinema.getCinemaLocation()[i].getCinemaName());
            System.out.println(Color.LIME + Cinema.getCinemaLocation()[i].getCinemaAddress());
            System.out.print(Color.RESET);
        }
        CommonIcon.printChar('-', 60);
        System.out.print("Press enter to go back...");
        input.nextLine();
        
    }

}
