package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

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
public class MovieTest {
    private Object[] getParamForCreateMovieValid(){

        return new Object[] {
            // Valid case with minimum valid length for title, "3D" category, and minimum price boundary
            new Object[] {"G", "3D", 0.00},  // Title at minimum boundary, price at 0.00
            
            // Valid case with typical title, "3D" category, and price just above the minimum boundary
            new Object[] {"Mobile Suit Gundam Hathaway", "3D", 0.01},  // Price just above minimum
            
            // Valid case with longer title, "3D" category, and a high price (upper boundary)
            new Object[] {"Mobile Suit Gundam Narrative: NT", "3D", 999.99},  // Price at upper boundary
            
            // Case with title near the maximum allowable length, "3D" category, and a mid-level price
            new Object[] {"Mobile Suit Gundam: The Witch from Mercury - Season 2 Part 2", "3D", 25.00},

            // Case with a full title, "3D" category, and showtimes with "Cancelled" status
            new Object[] {"Mobile Suit Gundam: Cucuruz Doan's Island", "3D", 15.00},

            // Case with a full title, "3D" category, and multiple showtimes
            new Object[] {"Mobile Suit Gundam Hathaway", "3D", 20.00}
        };
    }

    @Test
    @Parameters(method = "getParamForCreateMovieValid")
    public void createMovieValidTest(String title, String category, double normalPrice){
        assertNotNull(Movie.createMovie(title, category, normalPrice));
    }

    private Object[] getParamForCreateMovieInvalid(){
        return new Object[] {
            // Valid case with minimum valid length for title, "3D" category, and minimum price boundary
            new Object[] {"G", "3D", 0.00},  // Title at minimum boundary, price at 0.00
            
            // Valid case with typical title, "3D" category, and price just above the minimum boundary
            new Object[] {"Mobile Suit Gundam Hathaway", "3D", 0.01},  // Price just above minimum
            
            // Valid case with longer title, "3D" category, and a high price (upper boundary)
            new Object[] {"Mobile Suit Gundam Narrative: NT", "3D", 999.99},  // Price at upper boundary
            
            // Case with title near the maximum allowable length, "3D" category, and a mid-level price
            new Object[] {"Mobile Suit Gundam: The Witch from Mercury - Season 2 Part 2", "3D", 25.00},

            // Case with a full title, "3D" category, and showtimes with "Cancelled" status
            new Object[] {"Mobile Suit Gundam: Cucuruz Doan's Island", "3D", 15.00},

            // Case with a full title, "3D" category, and multiple showtimes
            new Object[] {"Mobile Suit Gundam Hathaway", "3D", 20.00}
        };
    }

    @Test (expected = IllegalArgumentException.class)
    @Parameters(method = "getParamForCreateMovieInvalid")
    public void createMovieValidTest(String title, String category, double normalPrice){
        Movie.createMovie(title, category, normalPrice);
    }

    private Object[] getParamsForIsExpensive(){
        return new Object[] {
            new Object[] {"3D", true},
            new Object[] {"IMAX", true},
            new Object[] {"Normal", false},
        };
    }

    @Test
    @Parameters(method = "getParamsForIsExpensive")
    public void isExpensiveTest(String category, boolean ER){
        Movie movieMock = mock(Movie.class);
        when(movieMock.getCategory()).thenReturn(category);
        assertEquals(ER, movieMock.isExpensive());
    }
}
