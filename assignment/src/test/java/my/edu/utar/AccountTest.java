package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;

@RunWith(JUnitParamsRunner.class)
public class AccountTest {

	//Test method to test createAccount with valid inputs
    private Object[] getParamForCreateAccountValid() {
        return new Object[] {
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 6, 28},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 1900, 6, 29},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2024, 6, 30},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 1, 31},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 12, 31},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 1962, 6, 29},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 6, 30},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 6, 15},
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

    //Test method to test createAccount with invalid inputs including both BVA and EP
    private Object[] getParamForCreateAccountInvalid() {
        return new Object[] {
            new Object[] {null, "teohwh2004@gmail.com", 2004, 6, 30},
            new Object[] {"Kirito", null, 2004, 6, 30},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 1899, 2, 20},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2025, 2, 20},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, -1, 8},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 13, 8},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 8, -1},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 8, 32},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 1500, 8, 30},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2500, 8, 30},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, -50, 30},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 50, 30},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 8, -30},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 8, 60},
            new Object[] {"Invalid@#$Name", "teohwh2004@gmail.com", 2004, 8, 30},
            new Object[] {"Invalid@#$Name", "InvalidEmail@", 2004, 8, 30},
            new Object[] {"$%^&*()", "teohwh2004@gmail.com", 2004, 6, 28},
            new Object[] {"Kirito", "@gmail", 2004, 6, 28},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 1, 0},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 6, 31},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2005, 2, 29},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 13, 8},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 12, 32},
            new Object[] {"Kirito", "teohwh2004@gmail.com", -2004, 6, 28},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, -6, 28},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 6, -28},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004.5, 6, 28},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 6.5, 28},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 6, 28.5},
            new Object[] {null, "teohwh2004gmail.com", 2004, 6, 28},
            new Object[] {"Kirito", null, 2004, 6, 28},
            new Object[] {"Kirito", "teohwh2004gmail.com", null, 6, 28},
            new Object[] {"Kirito", "teohwh2004gmail.com", 2004, null, 28},
            new Object[] {"Kirito", "teohwh2004gmail.com", 2004, 6, null},
        };
    }

    
    @Test (expected = IllegalArgumentException.class)
    @Parameters(method = "getParamForCreateAccountInvalid")
    public void createAccountInvalidTest(String name, String email, Integer birthday_year, Integer birthday_month, Integer birthday_day){
        Account.createAccount(name, email, birthday_year, birthday_month, birthday_day);
        
    }
    
    //Test method for setName method with valid name
    @Test
    public void testSetNameValid() {
        Account account = new Account();
        account.setName("ValidName123");
        assertEquals("ValidName123", account.getName());
    }
        
    //Test method for setName method with invalid name and empty string
    @Test (expected = IllegalArgumentException.class)
    @Parameters(
			{"Invalid@Name",
			""})
    public void testSetNameInvalid(String name) {
        Account account = new Account();
        account.setName(name);
    }

    //Test method for setName method with null
    @Test (expected = IllegalArgumentException.class)
    public void testSetNameInvalid2() {
        Account account = new Account();
        account.setName(null);
    }
    
    //Test method for setEmail method with valid email address
    @Test
    public void testSetEmailValid() {
        Account account = new Account();
        account.setEmail("lowliana@1utar.my");
        assertEquals("lowliana@1utar.my", account.getEmail());
    }

    //Test method for setEmail method with invalid email address
    @Test (expected = IllegalArgumentException.class)
    @Parameters(
			{"InvalidEmail@",
			""})
    public void testSetEmailInvalid(String email) {
        Account account = new Account();
        account.setEmail(email);
    }
    
    //Test method for setEmail method with null
    @Test (expected = IllegalArgumentException.class)
    public void testSetEmailInvalid2() {
        Account account = new Account();
        account.setEmail(null);
    }

    //Test method for setBirthday method with valid year, month, day
    @Test
    @Parameters(
	    {"1900, 6, 29",
	    "2024, 6, 30",
	    "2004, 1, 31",
	    "2004, 12, 31",
	    "1962, 6, 29",
	    "2004, 6, 30",
	    "2004, 6, 15",
	    "2004, 1, 1",
	    "2024, 2, 29", // Leap year
	    "2023, 2, 28",
	    "2023, 12, 31",
	    "2023, 9, 30"})
    public void testSetBirthDay(int year, int month, int day) {
        Account account = new Account();
        LocalDate date = LocalDate.of(year, month, day);
        account.setBirthDay(year,month,day);
        assertEquals(date, account.getBirthday());
    }

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
    
    //Test getters for Account
    @Test
    public void testGetName() {
        Account account = new Account();
        account.setName("TestName");
        assertEquals("TestName", account.getName());
    }

    //Test getEmail method
    @Test
    public void testGetEmail() {
        Account account = new Account();
        account.setEmail("lowliana@1utar.my");
        assertEquals("lowliana@1utar.my", account.getEmail());
    }

    @Test
    public void testGetBirthday() {
        Account account = new Account();
        LocalDate date = LocalDate.of(1990, 5, 15);
        account.setBirthDay(1990,5,15);
        assertEquals(date, account.getBirthday());
    }
}
