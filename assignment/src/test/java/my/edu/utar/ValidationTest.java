////package my.edu.utar;
////
////import junitparams.JUnitParamsRunner;
////import junitparams.Parameters;
////import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal;
////
////import org.junit.Test;
////import org.junit.runner.RunWith;
////import org.junit.runner.RunWith;
////
////import static org.junit.Assert.assertEquals;
////import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
////import static org.mockito.ArgumentMatchers.nullable;
////
////import java.time.LocalDate;
////import java.time.LocalTime;
////import java.util.ArrayList;
////
////import org.junit.Before;
////
////@RunWith(JUnitParamsRunner.class)
////public class ValidationTest {
////    private Object[] getParamsForIsAlphaNumericalValidTest(){
////        return new Object[] {
////            "123", "abc", "1bdx", "SDFGHJK", "abUX1Do"
////        };
////    }
////
////    @Test
////    @Parameters(method = "getParamsForIsAlphaNumericalValidTest")
////    public void isAlphaNumericalValidtest(String test){
////        assertDoesNotThrow(() -> Validation.isAlphaNumerical(test));
////    }
////
////    private Object[] getParamsForIsAlphaNumericalInvalidTest(){
////        return new Object[] {
////            "$%^&*()"
////        };
////    }
////
////    @Test(expected = IllegalArgumentException.class)
////    @Parameters(method = "getParamsForIsAlphaNumericalInvalidTest")
////    public void isAlphaNumericalInvalidtest(String test){
////        Validation.isAlphaNumerical(test);
////    }
////
////    private Object[] getParamsForIsNullValidTest(){
////        return new Object[] {
////            "   ", " 4 "
////        };
////    }
////
////    @Test
////    @Parameters(method = "getParamsForIsNullValidTest")
////    public void isNullValidTest(String test){
////        assertDoesNotThrow(() -> Validation.isNull(test));
////    }
////
////    private Object[] getParamsForIsNullInvalidTest(){
////        return new Object[] {
////            new Object[] {null}, 
////            new Object[] {""}, 
////        };
////    }
////
////    @Test (expected = IllegalArgumentException.class)
////    @Parameters(method = "getParamsForIsNullInvalidTest")
////    public void isNullInvalidTest(String test){
////        Validation.isNull(test);
////    }
////
////}
//
//
//
////incomplete
//// x tally w cases
//// cc jiu hao
//package my.edu.utar;
//
//import junitparams.JUnitParamsRunner;
//import junitparams.Parameters;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import static org.junit.Assert.*;
//
//@RunWith(JUnitParamsRunner.class)
//public class ValidationTest {
//
//    // Test for isAlphaNumerical
//    private Object[] getParamForIsAlphaNumericalValid() {
//        return new Object[] {
//            new Object[] {"abc123"},
//            new Object[] {"abc 123"},
//            new Object[] {"ABC(123)"},
//        };
//    }
//
//    @Test
//    @Parameters(method = "getParamForIsAlphaNumericalValid")
//    public void isAlphaNumericalValidTest(String value) {
//        Validation.isAlphaNumerical(value); // Should pass without exception
//    }
//
//    private Object[] getParamForIsAlphaNumericalInvalid() {
//        return new Object[] {
//            new Object[] {"abc_123"},  // contains an underscore
//            new Object[] {"abc@123"}   // contains @ symbol
//        };
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    @Parameters(method = "getParamForIsAlphaNumericalInvalid")
//    public void isAlphaNumericalInvalidTest(String value) {
//        Validation.isAlphaNumerical(value); // Should throw IllegalArgumentException
//    }
//
//    // Test for isValidMovieName
//    private Object[] getParamForIsValidMovieNameValid() {
//        return new Object[] {
//            new Object[] {"Movie Title"},
//            new Object[] {"Movie Title: The Sequel"},
//            new Object[] {"Movie Title - The Final Chapter"}
//        };
//    }
//
//    @Test
//    @Parameters(method = "getParamForIsValidMovieNameValid")
//    public void isValidMovieNameValidTest(String value) {
//        Validation.isValidMovieName(value); // Should pass without exception
//    }
//
//    private Object[] getParamForIsValidMovieNameInvalid() {
//        return new Object[] {
//            new Object[] {"Movie Title@"},   // contains @ symbol
//            new Object[] {"Movie@Title"},    // contains @ symbol
//            new Object[] {"!@#$%^&*()"}      // contains special characters
//        };
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    @Parameters(method = "getParamForIsValidMovieNameInvalid")
//    public void isValidMovieNameInvalidTest(String value) {
//        Validation.isValidMovieName(value); // Should throw IllegalArgumentException
//    }
//
//    // Test for isNull
//    private Object[] getParamForIsNullValid() {
//        return new Object[] {
//            new Object[] {"Valid String"},
//            new Object[] {"Another Valid String"}
//        };
//    }
//
//    @Test
//    @Parameters(method = "getParamForIsNullValid")
//    public void isNullValidTest(String value) {
//        Validation.isNull(value); // Should pass without exception
//    }
//
//    private Object[] getParamForIsNullInvalid() {
//        return new Object[] {
//            new Object[] {null},
//            new Object[] {""}
//        };
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    @Parameters(method = "getParamForIsNullInvalid")
//    public void isNullInvalidTest(String value) {
//        Validation.isNull(value); // Should throw IllegalArgumentException
//    }
//
////    // Test for isWhiteSpace
//    private Object[] getParamForIsWhiteSpaceValid() {
//        return new Object[] {
//            new Object[] {"   "},
//            new Object[] {"\t"},
//            new Object[] {"\n"}
//        };
//    }
////
//    @Test
//    @Parameters(method = "getParamForIsWhiteSpaceValid")
//    public void isWhiteSpaceValidTest(String value) {
//        Validation.isWhiteSpace(value); // Should pass without exception
//    }
//
////    private Object[] getParamForIsWhiteSpaceInvalid() {
////        return new Object[] {
////            new Object[] {"not whitespace"},
////            new Object[] {"12345"}
////        };
////    }
////
////    @Test(expected = IllegalArgumentException.class)
////    @Parameters(method = "getParamForIsWhiteSpaceInvalid")
////    public void isWhiteSpaceInvalidTest(String value) {
////        Validation.isWhiteSpace(value); // Should throw IllegalArgumentException
////    }
//
//    // Test for isNegativeNum
//    private Object[] getParamForIsNegativeNumValid() {
//        return new Object[] {
//            new Object[] {0.0},
//            new Object[] {1.0},
//            new Object[] {123.45}
//        };
//    }
//
//    @Test
//    @Parameters(method = "getParamForIsNegativeNumValid")
//    public void isNegativeNumValidTest(Double value) {
//        Validation.isNegativeNum(value); // Should pass without exception
//    }
//
//    private Object[] getParamForIsNegativeNumInvalid() {
//        return new Object[] {
//            new Object[] {-1.0},
//            new Object[] {-123.45}
//        };
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    @Parameters(method = "getParamForIsNegativeNumInvalid")
//    public void isNegativeNumInvalidTest(Double value) {
//        Validation.isNegativeNum(value); // Should throw IllegalArgumentException
//    }
//
//    // Test for isMovieCategory
//    private Object[] getParamForIsMovieCategoryValid() {
//        return new Object[] {
//            new Object[] {"2D"},
//            new Object[] {"3D"},
//            new Object[] {"IMAX"}
//        };
//    }
//
//    @Test
//    @Parameters(method = "getParamForIsMovieCategoryValid")
//    public void isMovieCategoryValidTest(String category) {
//        Validation.isMovieCategory(category); // Should pass without exception
//    }
//
//    private Object[] getParamForIsMovieCategoryInvalid() {
//        return new Object[] {
//            new Object[] {"4D"},
//            new Object[] {"IMAX3D"}
//        };
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    @Parameters(method = "getParamForIsMovieCategoryInvalid")
//    public void isMovieCategoryInvalidTest(String category) {
//        Validation.isMovieCategory(category); // Should throw IllegalArgumentException
//    }
//
//    // Test for isShowtimeStatus
//    private Object[] getParamForIsShowtimeStatusValid() {
//        return new Object[] {
//            new Object[] {"Available"},
//            new Object[] {"NotAvailable"},
//            new Object[] {"FullyBooked"},
//            new Object[] {"Cancelled"}
//        };
//    }
//
//    @Test
//    @Parameters(method = "getParamForIsShowtimeStatusValid")
//    public void isShowtimeStatusValidTest(String status) {
//        Validation.isShowtimeStatus(status); // Should pass without exception
//    }
//
//    private Object[] getParamForIsShowtimeStatusInvalid() {
//        return new Object[] {
//            new Object[] {"Open"},
//            new Object[] {"Booked"}
//        };
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    @Parameters(method = "getParamForIsShowtimeStatusInvalid")
//    public void isShowtimeStatusInvalidTest(String status) {
//        Validation.isShowtimeStatus(status); // Should throw IllegalArgumentException
//    }
//
//    // Test for isHalltimeHallstatus
//    private Object[] getParamForIsHalltimeHallstatusValid() {
//        return new Object[] {
//            new Object[] {"FullyBooked"},
//            new Object[] {"Available"},
//            new Object[] {"NotAvailable"},
//            new Object[] {"Repair"}
//        };
//    }
//
//    @Test
//    @Parameters(method = "getParamForIsHalltimeHallstatusValid")
//    public void isHalltimeHallstatusValidTest(String hallstatus) {
//        Validation.isHalltimeHallstatus(hallstatus); // Should pass without exception
//    }
//
//    private Object[] getParamForIsHalltimeHallstatusInvalid() {
//        return new Object[] {
//            new Object[] {"Occupied"},
//            new Object[] {"UnderConstruction"}
//        };
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    @Parameters(method = "getParamForIsHalltimeHallstatusInvalid")
//    public void isHalltimeHallstatusInvalidTest(String hallstatus) {
//        Validation.isHalltimeHallstatus(hallstatus); // Should throw IllegalArgumentException
//    }
//}
//
