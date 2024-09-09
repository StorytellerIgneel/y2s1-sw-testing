package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(JUnitParamsRunner.class)
public class AccountTest {
	 public List<Object[]> readInputData(String fileName){
        List<Object[]> accountData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Skip comment lines
                if (line.startsWith("#") || line.trim().isEmpty()) {
                    continue;
                }
                
                // Process the valid data here (split by comma, etc.)
                String[] parts = line.split(",");	                
                // Account instantiation
                String name = parts[0].trim();
                String email = parts[1].trim();
                String year = parts[2].trim();
                String month = parts[3].trim();
                String day = parts[4].trim();
                name = "null".equals(name) ? null : name;
                email = "null".equals(email) ? null : email;
                accountData.add(new Object[] {name,email,Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day)});
            }
            
            return accountData;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return accountData;
    }

    //ACC_TC1_V001
	//Test method to test createAccount with valid inputs
    public List<Object[]> getValidCreateAccountData() {
        return readInputData("ValidInputCreateAccount.txt");
    }
    
    @Test
    @Parameters(method = "getValidCreateAccountData")
    public void createAccountValidTest(String name, String email, Integer birthday_year, Integer birthday_month, Integer birthday_day){
        assertNotNull(Account.createAccount(name, email, birthday_year, birthday_month, birthday_day));
    }

    //ACC_TC1_INV001
    //Test method to test createAccount with invalid inputs including both BVA and EP
    public List<Object[]>getInvalidCreateAccountData(){
        return readInputData("InvalidInputCreateAccount.txt");
    }
    
    @Test (expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidCreateAccountData")
    public void createAccountInvalidTest(String name, String email, int birthday_year, int birthday_month, int birthday_day){
    	Account.createAccount(name, email, birthday_year, birthday_month, birthday_day);
    }
    
    //ACC_TC2_V001
    //Test method for setName method with valid name
    @Test
    @Parameters({"ValidName123", "ValidName123"})
    public void testSetNameValid(String name, String ER) {
        Account account = new Account();
        account.setName(name);
        assertEquals(ER, account.getName());
    }
    
    //ACC_TC2_INV001
    //Test method for setName method with invalid name and empty string
    private Object[] getParamsForTestSetNameInvalid() {
        return new Object[] {
            new Object[] {"Invalid@%^&*Name"},  // Other symbols
            new Object[] {""},                  // nothing
            new Object[] {null},                // Null title
        };
    }

    @Test (expected = IllegalArgumentException.class)
    @Parameters(method = "getParamsForTestSetNameInvalid")
    public void testSetNameInvalid(String name) {
        Account account = new Account();
        account.setName(name);
    }
    
    //ACC_TC3_V001
    //Test method for setEmail method with valid email address
    @Test
    public void testSetEmailValid() {
        Account account = new Account();
        account.setEmail("lowliana@1utar.my");
        assertEquals("lowliana@1utar.my", account.getEmail());
    }

    //ACC_TC3_INV001
    //Test method for setEmail method with invalid email address
    private Object[] getParamsForTestSetEmailInvalid() {
        return new Object[] {
            
            new Object[] {"Invalid@%^&*Email"},  // Other symbols
            new Object[] {"teohwh@gmail"},      // no .com
            new Object[] {"teohwhgmail.com"},   // no @
            new Object[] {"teohwh"},            // no @gmail.com
            new Object[] {"teohwh@.com"},       // no gmail
            new Object[] {""},                  // nothing
            new Object[] {null},                // Null
        };
    }

    @Test (expected = IllegalArgumentException.class)
    @Parameters(method = "getParamsForTestSetEmailInvalid")
    public void testSetEmailInvalid(String email) {
        Account account = new Account();
        account.setEmail(email);
    }

    //ACC_TC4_V001
    //Test method for setBirthday method with valid year, month, day
    @Test
    @Parameters(
	    {"1900, 6, 29",	//BVA year 1900
	    "2024, 6, 30",	//BVA year 2024
	    "2004, 1, 31",	//BVA month 1
	    "2004, 12, 31",	//BVA month 12
	    "1962, 6, 29",	//EP year 1962
	    "2004, 6, 30",	//EP month 6
	    "2004, 6, 15",	//EP day 15
	    "2004, 1, 1",	//BVA day 1
	    "2024, 2, 29",	//Leap year February with 29 days
	    "2023, 2, 28",	//Non Leap year February with 28 days
	    "2023, 12, 31",	//BVA day 31 for month with 31 days
	    "2023, 9, 30"})	//BVA day 30 for month with 30 days
    public void testSetBirthDay(int year, int month, int day) {
        Account account = new Account();
        LocalDate date = LocalDate.of(year, month, day);
        account.setBirthDay(year,month,day);
        assertEquals(date, account.getBirthday());
    }

    //ACC_TC4_INV001
    //Test method for setBirthday method with Invalid year, month, day
    @Test (expected = IllegalArgumentException.class)
    @Parameters(
	    {// Invalid Dates
	        "1899, 2, 20",  // Invalid year (too early)
	        "2025, 2, 20",  // Invalid year (too late)
	        "2004, -1, 8",  // Invalid month (-1)
	        "2004, 13, 8",  // Invalid month (13)
	        "2004, 8, -1",  // Invalid day (-1)
	        "2004, 8, 32",  // Invalid day (32)
	        "1500, 8, 30",  // Invalid year (too early)
	        "2500, 8, 30",  // Invalid year (too late)
	        "2004, -50, 30",// Invalid month (-50)
	        "2004, 50, 30", // Invalid month (50)
	        "2004, 8, -30", // Invalid day (-30)
	        "2004, 8, 60",  // Invalid day (60)
	        "2023, 2, 29",  // Invalid day in non-leap year February (February has only 29 days in leap years)
	        "2023, 4, 31",  // Invalid day in April (April has only 30 days)
	        "2023, 10, 32",  // Invalid day in October (October has only 30 days)
	    })
    public void testSetBirthDayInvalid(int year, int month, int day) {
        Account account = new Account();
        account.setBirthDay(year,month,day);
    }
}
