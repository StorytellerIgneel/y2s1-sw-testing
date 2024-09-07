package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.lang.reflect.Field;
import java.time.LocalDate;

@RunWith(JUnitParamsRunner.class)
public class AccountTest {

	//ACC_TC1_V001
	//Test method to test createAccount with valid inputs
    private Object[] getParamForCreateAccountValid() {
        return new Object[] {
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 6, 28},	//All valid inputs
            new Object[] {"Kirito", "teohwh2004@gmail.com", 1900, 6, 29},	//BVA - year 1900
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2024, 6, 30},	//BVA - year 2024
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 1, 31},	//BVA - month 1
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 12, 31},	//BVA - month 12
            new Object[] {"Kirito", "teohwh2004@gmail.com", 1962, 6, 29},	//EP - year 1962
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 6, 30},	//EP - month 6
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 6, 15},	//EP - day 15
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 1, 1},	//beginning of year
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2024, 2, 29},	//leap year
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2023, 2, 28},	//non leap year
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2023, 12, 31},	//month of 31 days
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2023, 9, 30},	//month of 30 days

        };
    }
    
    @Test
    @Parameters(method = "getParamForCreateAccountValid")
    public void createAccountValidTest(String name, String email, Integer birthday_year, Integer birthday_month, Integer birthday_day){
        assertNotNull(Account.createAccount(name, email, birthday_year, birthday_month, birthday_day));
    }

    //ACC_TC1_INV001
    //Test method to test createAccount with invalid inputs including both BVA and EP
    private Object[] getParamForCreateAccountInvalid() {
        return new Object[] {
            new Object[] {null, "teohwh2004@gmail.com", 2004, 6, 30},				//null name
            new Object[] {"Kirito", null, 2004, 6, 30},								//null email
            new Object[] {"Kirito", "teohwh2004@gmail.com", 1899, 2, 20},			//BVA birthday_year 1899
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2025, 2, 20},			//BVA birthday_year 2025
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, -1, 8},			//BVA birthday_month -1
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 13, 8},			//BVA birthday_month 13
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 8, -1},			//BVA birthday_day -1
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 8, 32},			//BVA birthday_day 32 on month with 31 days
            new Object[] {"Kirito", "teohwh2004@gmail.com", 1500, 8, 30},			//EP birthday_year 1500
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2500, 8, 30},			//EP birthday_year 2500
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, -50, 30},			//EP birthday_month -50
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 50, 30},			//EP birthday_month 50
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 8, -30},			//EP birthday_day -30
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 8, 60},			//EP birthday_day 60
            new Object[] {"Invalid@#$Name", "teohwh2004@gmail.com", 2004, 8, 30},	//Invalid name - contains non-alphanumeric values
            new Object[] {"Invalid@#$Name", "InvalidEmail@", 2004, 8, 30},			//Invalid email - not following email address pattern
        };
    }

    
    @Test (expected = IllegalArgumentException.class)
    @Parameters(method = "getParamForCreateAccountInvalid")
    public void createAccountInvalidTest(String name, String email, Integer birthday_year, Integer birthday_month, Integer birthday_day){
    	assertNull(Account.createAccount(name, email, birthday_year, birthday_month, birthday_day));
        
    }
    
    //ACC_TC2_V001
    //Test method for setName method with valid name
    @Test
    public void testSetNameValid() {
        Account account = new Account();
        account.setName("ValidName123");
        assertEquals("ValidName123", account.getName());
    }
    
    //ACC_TC2_INV001
    //Test method for setName method with invalid name and empty string
    @Test (expected = IllegalArgumentException.class)
    @Parameters(
			{"Invalid@Name",
			""})
    public void testSetNameInvalid(String name) {
        Account account = new Account();
        account.setName(name);
    }

    //ACC_TC2_INV002
    //Test method for setName method with null
    @Test (expected = IllegalArgumentException.class)
    public void testSetNameInvalid2() {
        Account account = new Account();
        account.setName(null);
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
    @Test (expected = IllegalArgumentException.class)
    @Parameters(
			{"InvalidEmail@",
			""})
    public void testSetEmailInvalid(String email) {
        Account account = new Account();
        account.setEmail(email);
    }
    
    //ACC_TC3_INV002
    //Test method for setEmail method with null
    @Test (expected = IllegalArgumentException.class)
    public void testSetEmailInvalid2() {
        Account account = new Account();
        account.setEmail(null);
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
    
    //ACC_TC5_V001
    //Test getName method
    @Test
    public void testGetName() {
        Account account = new Account();
        account.setName("TestName");
        assertEquals("TestName", account.getName());
    }

    //ACC_TC6_V001
    //Test getEmail method
    @Test
    public void testGetEmail() {
        Account account = new Account();
        account.setEmail("lowliana@1utar.my");
        assertEquals("lowliana@1utar.my", account.getEmail());
    }

    //ACC_TC7_V001
    //Test getBirthday method
    @Test
    public void testGetBirthday() {
        Account account = new Account();
        LocalDate date = LocalDate.of(1990, 5, 15);
        account.setBirthDay(1990,5,15);
        assertEquals(date, account.getBirthday());
    }
    
    // ACC_TC5_V001
    // Test getName method
    @Test
    @Parameters({"TestName, TestName"})
    public void testGetName(String name, String expectedResult) {
        try {
            Account account = new Account();
            Field nameField = Account.class.getDeclaredField("name");
            nameField.setAccessible(true);
            
            // Set the value of the private field "name"
            nameField.set(account, name);
            
            nameField.setAccessible(false);  // Optionally reset access
            assertEquals(expectedResult, account.getName());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    // ACC_TC6_V001
    // Test getEmail method
    @Test
    @Parameters({"lowliana@1utar.my, lowliana@1utar.my"})
    public void testGetEmail(String email, String expectedResult) {
        try {
            Account account = new Account();
            Field emailField = Account.class.getDeclaredField("email");
            emailField.setAccessible(true);
            
            // Set the value of the private field "email"
            emailField.set(account, email);
            
            emailField.setAccessible(false);  // Optionally reset access
            assertEquals(expectedResult, account.getEmail());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    // ACC_TC7_V001
    // Test getBirthday method
    @Test
    @Parameters({"1990, 5, 15, 1990-05-15"})
    public void testGetBirthday(int year, int month, int day, String expectedResult) {
        try {
            Account account = new Account();
            LocalDate expectedDate = LocalDate.parse(expectedResult);

            Field birthdayField = Account.class.getDeclaredField("birthday");
            birthdayField.setAccessible(true);

            // Set the value of the private field "birthday"
            account.setBirthDay(year, month, day);
            
            assertEquals(expectedDate, account.getBirthday());

            birthdayField.setAccessible(false);  // Optionally reset access
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
