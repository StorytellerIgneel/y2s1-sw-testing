import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<UserAccount> users = new ArrayList<UserAccount>();
        //user choose to register
        // call register method
        users.add(UserAccount.register());

        //user choose to login
        //after sucessfully login go into the main page
    }
}