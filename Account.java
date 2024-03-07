import java.util.Date;

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
  // public boolean verifyLogin()
}
