import java.util.Date;
import java.util.ArrayList;

public class Account {
  //instance variables to be inherited
  protected String accountId;
  protected String name;
  protected String password;
  protected String registerDate;

  //constructor
  public Account(String accountId, String name, String password, String registerDate) {
    this.accountId = accountId;
    this.name = name;
    this.password = password;
    this.registerDate = registerDate;
  }

  //instance variables
  public static boolean verifyLogin(ArrayList<UserAccount> accounts, String id, String pass)
  {
    for(UserAccount account : accounts)
    {
      if(account.getAccountId().equals(id) && account.getPassword().equals(pass))
      {
        return true;
      }
    }
    return false;
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
}