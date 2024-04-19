package account;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import util.*; 

public class SystemAdminAccount extends Account
{
    // constructor
    public SystemAdminAccount(String accountId, String name, String password, String registerDate, String email, String phoneNo) {
        super(accountId, name, password, registerDate, email, phoneNo);
    }

    // static methods
    public static ArrayList<SystemAdminAccount> getAdmins()
    {
        Scanner scanner = new Scanner(System.in);
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<SystemAdminAccount>>() {}.getType();

        String line = "";
        try
        {
        File inFile = new File("src\\resources\\admin.json");
        Scanner inputFile = new Scanner(inFile);
        while(inputFile.hasNextLine())
        {
            line = inputFile.nextLine();
        }
        inputFile.close();
        }catch(IOException e)
        {
            SystemMessage.errorMessage(4, scanner);
        }

        ArrayList<SystemAdminAccount> adminList = gson.fromJson(line, type);
        if (adminList == null) {
            adminList = new ArrayList<SystemAdminAccount>();
        }
        return adminList;
    }

    


}