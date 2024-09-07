package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
    private Object[] getParamForCreateAccountValid(){
        return new Object[] {
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 6, 28},
            new Object[] {"Kirito", "teohwh2004@hotmail.com", 2024, 6, 28},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 2, 29},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 12, 31},
            new Object[] {"Kirito", "teohwh2004@gmail.com", 2004, 1, 1},
        };
    }

    @Test
    @Parameters(method = "getParamForCreateAccountValid")
    public void createAccountValidTest(String name, String email, Integer birthday_year, Integer birthday_month, Integer birthday_day){
        assertNotNull(Account.createAccount(name, email, birthday_year, birthday_month, birthday_day));
    }

    private Object[] getParamForCreateAccountInvalid(){
        return new Object[] {
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
}
