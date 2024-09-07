package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;

@RunWith(JUnitParamsRunner.class)
public class MovieTest {
    @Test
    @Parameters("Example Movie, Normal, 18.50")
    public void MovieConstructorTest(String title, String category, double normalPrice){
        // Arrange
        Movie movie = new Movie(title, category, normalPrice);
        assertNotNull(movie);
        assertEquals("Example Movie", movie.getTitle());
        assertEquals("Normal", movie.getCategory());
        assertEquals(18.50, movie.getNormalPrice(), 0.0);
    }

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

    private Object[] getParamForCreateMovieInvalid() {
        return new Object[] {
            //new Object[] {"Example Movie", "Normal", 18.50},
            //new Object[] {"Example Movie", "Normal", 18.50},
            new Object[] {null, "Normal", 18.50},  // Null title
            new Object[] {"Example Movie", null, 18.50},  // Null category
            new Object[] {"Example Movie", "Normal", null},
            new Object[] {"Invalid@#$Title", "Normal", 18.50},  // Invalid title
            new Object[] {"Example Movie", "Invalid@#Category!", 18.50},  // Invalid category
            new Object[] {"Example Movie", "Normal", -1},  // Negative price
            new Object[] {"Example Movie", "Normal", -50}  // Negative price
        };
    }

    @Test (expected = IllegalArgumentException.class)
    @Parameters(method = "getParamForCreateMovieInvalid")
    public void createMovieInvalidTest(String title, String category, double normalPrice){
        Movie.createMovie(title, category, normalPrice);
    }

    @Test
    @Parameters("Example Movie, Example Movie")
    public void setTitleValidTest(String title1, String ER){
        Movie movieSpy = spy(new Movie());
        movieSpy.setTitle(title1);
        verify(movieSpy).setTitle(title1);
    }

    // @Test
    // @Parameters("Example Movie, normal, 18.50, null")
    // public void setTitleInvalidTest(String title1, String category, double normalPrice, double ER){
    //     // Arrange
    //     Movie movie1 = new Movie(title1, category, normalPrice);
    //     assertEquals("Example Movie", movie1.getTitle());
    // }
    @Test
    @Parameters("Normal, Normal")
    public void setCategoryValidTest(String category, String ER){
        Movie movieSpy = spy(new Movie());
        movieSpy.setTitle(category);
        verify(movieSpy).setTitle(ER);
    }

    @Test
    @Parameters("18.50, 18.50")
    public void setNormalPriceValidTest(double title1, double ER){
        Movie movieSpy = spy(new Movie());
        movieSpy.setNormalPrice(title1);
        verify(movieSpy).setNormalPrice(ER);
    }

    //getter tests
    @Test
    @Parameters("Example Movie, Example Movie")
    public void getTitleTest(String title, String ER){
        Movie movieSpy = spy(new Movie());
        // Use reflection to set the private field 'title'
        try {
            Field titleField = Movie.class.getDeclaredField("title");
            titleField.setAccessible(true);  // Make the field accessible to manipulate it
        
            titleField.set(movieSpy, title);  // Set the value for the specific instance (movieSpy)
        
            titleField.setAccessible(false);  // Optionally, set it back to inaccessible
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();  // Handle the exception appropriately
        }
        assertEquals(ER, movieSpy.getTitle());
    }

    @Test
    @Parameters("18.50, 18.50")
    public void getNormalPriceTest(double normalPrice, double ER){
        // Arrange
        Movie movieSpy = spy(new Movie());
        // Use reflection to set the private field 'title'
        try {
            Field titleField = Movie.class.getDeclaredField("normalPrice");
            titleField.setAccessible(true);  // Make the field accessible to manipulate it
        
            titleField.set(movieSpy, normalPrice);  // Set the value for the specific instance (movieSpy)
        
            titleField.setAccessible(false);  // Optionally, set it back to inaccessible
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();  // Handle the exception appropriately
        }
        assertEquals(ER, movieSpy.getNormalPrice(), 0.0);
    }

    @Test
    @Parameters("normal, normal")
    public void getCategoryTest(String category, String ER){
        // Arrange
        Movie movieSpy = spy(new Movie());
        // Use reflection to set the private field 'title'
        try {
            Field titleField = Movie.class.getDeclaredField("category");
            titleField.setAccessible(true);  // Make the field accessible to manipulate it
        
            titleField.set(movieSpy, category);  // Set the value for the specific instance (movieSpy)
        
            titleField.setAccessible(false);  // Optionally, set it back to inaccessible
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();  // Handle the exception appropriately
        }
        assertEquals(ER, movieSpy.getCategory());
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
        Movie movieSpy = spy(new Movie());
        when(movieSpy.getCategory()).thenReturn(category);
        assertEquals(ER, movieSpy.isExpensive());
    }
}
