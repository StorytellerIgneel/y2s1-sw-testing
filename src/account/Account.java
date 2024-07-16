package account;

// import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import util.*;

import java.io.*;
import java.time.LocalDateTime;


public class Account {
  // instance variables to be inherited
  private String name;
  private String email;
  private LocalDateTime birthday;

  // constructor
  public Account(String name, String email, LocalDateTime birthday) {
    this.name = name;
    this.email = email;
    this.birthday = birthday;
  }

  // static methods
  /**
   * Verifies the login credentials of a user in the system.
   * 
   * @param accounts the list of accounts in the system
   * @param name the username of the user
   * @param pass the password of the user
   * @return the index of the user in the list if the login is successful, -1 otherwise
   */
  public static int verifyLogin(ArrayList<Account> accounts, String name) {
    for (int i = 0; i < accounts.size(); i++) {
      if (accounts.get(i).getName().equals(name))
        return i;
    }
    return -1;
  }

  /**
   * This method is used to handle the login process of the user. It takes in the list of accounts
   * and prompts the user to enter their username and password. If the login is successful, the
   * index of the user is returned, otherwise -1 is returned for back and -2 is returned for quit.
   * 
   * @param accounts the list of accounts used to verify the login process
   * @return the index of the user in the list if the login is successful
   */
  public static int login(ArrayList<Account> accounts) {
    Scanner input = new Scanner(System.in);
    int index = 0;
    CommonIcon.printHeader();
    System.out.println("Login: \n");
    do {
      // entering details
      System.out.print("Enter your name (':b' to back, ':q' to quit): ");
      String name = input.nextLine();

      if (Validation.isBack(name))
        return -1;
      if (Validation.isQuit(name))
        return -2;

      index = verifyLogin(accounts, name);
      if (index == -1)
        SystemMessage.errorMessage(5, input);
      else
        SystemMessage.successMessage(4, input);

    } while (index == -1);

    try {
      Util.clearConsole(input);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return index; // return the user index for tracking user activities
  }

   // Method to generate a unique account ID
   /*
  public static String generateAccountId() {
      // Generate a random UUID (Universally Unique Identifier)
      // and remove hyphens to make it shorter
      String uuid = UUID.randomUUID().toString().replaceAll("-", "");
      // Extract the first 8 characters to create a shorter ID
      return uuid.substring(0, 8);
  }
      */

  // getter methods
  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  // setter methoids
  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
