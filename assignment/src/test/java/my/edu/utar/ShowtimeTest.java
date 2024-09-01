package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;

public class ShowtimeTest {
    private Object[] getParamsFordetermineTicketPriceValidTest(){
        return new Object[] {
            "$%^&*()"
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getParamsFordetermineTicketPriceValidTest")
    public void determineTicketPriceValidTest(String test){
        Validation.isAlphaNumerical(test);
    }

    // private Object[] getParamsForShowtimeAvailableValidTest(){
    //     return new Object[] {
    //         "$%^&*()"
    //     };
    // }

    // @Test(expected = IllegalArgumentException.class)
    // @Parameters(method = "getParamsForShowtimeAvailableValidTest")
    // public void ShowtimeAvailableValidTest(String test){
    //     Movie movieMock = mock(Movie.class);
    //     Showtime showtime = new Showtime(movieMock, null, null, null)
    //     Validation.isAlphaNumerical(test);
    // }
}
