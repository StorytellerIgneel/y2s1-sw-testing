package account;
// import java.util.Date;
import java.util.ArrayList;

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
