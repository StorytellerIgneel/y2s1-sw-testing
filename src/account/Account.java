package account;
// import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

import util.*;

import java.io.*;


public class Account {
  //instance variables to be inherited
  protected String accountId;
  protected String name;
  protected String password;
  protected String registerDate;
  protected String email;
  protected String phoneNo;

  //constructor
  public Account(String accountId, String name, String password, String registerDate, String email, String phoneNo) {
    this.accountId = accountId;
    this.name = name;
    this.password = password;
    this.registerDate = registerDate;
    this.email = email;
    this.phoneNo = phoneNo;
  }

  //static methods
  /**
 * Verifies the login credentials of a user in the system.
 * 
 * @param accounts the list of accounts in the system
 * @param name the username of the user
 * @param pass the password of the user
 * @return the index of the user in the list if the login is successful, -1 otherwise
 */
  public static int verifyLogin(ArrayList<Account> accounts, String name, String pass)
  {
    for(int i = 0; i < accounts.size(); i++)
    {
      if(accounts.get(i).getName().equals(name) && accounts.get(i).getPassword().equals(pass))
        return i;
    }
    return -1;
  }
  /**
 * This method is used to handle the login process of the user. It takes in the list of accounts and prompts the user to enter their username and password.
 * If the login is successful, the index of the user is returned, 
 * otherwise -1 is returned for back and -2 is returned for quit.
 * 
 * @param accounts the list of accounts used to verify the login process
 * @return the index of the user in the list if the login is successful
 */
  public static int login(ArrayList<Account> accounts)
 {
    Scanner input = new Scanner(System.in);
    int index = 0;
    CommonIcon.printHeader();
    System.out.println("Login: \n");
    do
    {
    //entering details
    System.out.print("Enter your username (':b' to back, ':q' to quit): ");
    String name = input.nextLine();

    if(Validation.isBack(name))
      return -1;
    if(Validation.isQuit(name))
      return -2;

    System.out.print("Enter your password (':b' to back, ':q to quit'): ");
    String pass = input.next();

    if(Validation.isBack(pass))
      return -1;
    if(Validation.isQuit(pass))
      return -2;

    index = verifyLogin(accounts, name, pass);
    if (index == -1)
      SystemMessage.errorMessage(5, input);
    else
      SystemMessage.successMessage(4, input);

    }while (index == -1);
    
    try
    {
        Util.clearConsole(input);
    }
    catch(IOException e)
    {
        e.printStackTrace();
    }
    catch(InterruptedException e)
    {
        e.printStackTrace();
    }
    return index; //return the user index for tracking user activities
  }

  //getter methods
  public String getAccountId() {
    return accountId;
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }

  public String getRegisterDate() {
    return registerDate;
  }

  public String getEmail() {
    return email;
  }

  public String getPhoneNo() {
    return phoneNo;
  }

  //setter methoids
  public void setName(String name)
  {
    this.name = name;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public void setPhoneNo(String phoneNo)
  {
    this.phoneNo = phoneNo;
  }
}
