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
  public static int verifyLogin(ArrayList<Account> accounts, String name, String pass)
  {
    // for(Account account : accounts)
    // {
    //   if(account.getName().equals(name) && account.getPassword().equals(pass))
    //   {
    //     return true;
    //   }
    // }
    // return false;

    for(int i = 0; i < accounts.size(); i++)
    {
      if(accounts.get(i).getName().equals(name) && accounts.get(i).getPassword().equals(pass))
        return i;
    }
    return -1;
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
