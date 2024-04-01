package account;
// import java.util.Date;
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

  //static methods
  public static boolean verifyLogin(ArrayList<Account> accounts, String name, String pass)
  {
    for(Account account : accounts)
    {
      if(account.getName().equals(name) && account.getPassword().equals(pass))
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
