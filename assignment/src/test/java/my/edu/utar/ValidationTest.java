package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Before;

@RunWith(JUnitParamsRunner.class)
public class ValidationTest {
    private Object[] getParamsForIsAlphaNumericalValidTest(){
        return new Object[] {
            "123", "abc", "1bdx", "SDFGHJK", "abUX1Do"
        };
    }

    @Test
    @Parameters(method = "getParamsForIsAlphaNumericalValidTest")
    public void isAlphaNumericalValidtest(String test){
        assertDoesNotThrow(() -> Validation.isAlphaNumerical(test));
    }

    private Object[] getParamsForIsAlphaNumericalInvalidTest(){
        return new Object[] {
            "$%^&*()"
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getParamsForIsAlphaNumericalInvalidTest")
    public void isAlphaNumericalInvalidtest(String test){
        Validation.isAlphaNumerical(test);
    }

    private Object[] getParamsForIsNullValidTest(){
        return new Object[] {
            "   ", " 4 "
        };
    }

    @Test
    @Parameters(method = "getParamsForIsNullValidTest")
    public void isNullValidTest(String test){
        assertDoesNotThrow(() -> Validation.isAlphaNumerical(test));
    }

    private Object[] getParamsForIsNullInvalidTest(){
        return new Object[] {
            null, ""
        };
    }

    @Test
    @Parameters(method = "getParamsForIsNullInvalidTest")
    public void isNullInvalidTest(String test){
        Validation.isAlphaNumerical(test);
    }

}
