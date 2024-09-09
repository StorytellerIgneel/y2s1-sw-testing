package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.lang.reflect.Field;

import static org.mockito.Mockito.*;

@RunWith(JUnitParamsRunner.class)
public class MovieTest {
	
    // MVE_TC1_V001
	// Test method to test Movie constructor with valid inputs
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
    
    // MVE_TC2_V001
    // Test method to test createMovie with valid inputs
    private Object[] getParamForCreateMovieValid() {
        return new Object[] {
            new Object[] {"Example Movie", "Normal", 18.50},	// Valid title
            new Object[] {"Example Movie", "Normal", 18.50},	// Valid "Normal" category movie
            new Object[] {"Example Movie", "3D", 18.50},		// Valid "3D" category movie
            new Object[] {"Example Movie", "IMAX", 18.50},		// Valid "IMAX" category movie
            new Object[] {"Example Movie", "IMAX", 0.01},		// BVA normalPrice 0.01
            new Object[] {"Example Movie", "IMAX", 100},		// EP normalPrice 100
            new Object[] {"Example1234", "Normal", 18.50},		// Valid alphanumeric title
        };
    }

    @Test
    @Parameters(method = "getParamForCreateMovieValid")
    public void createMovieValidTest(String title, String category, double normalPrice) {
        Movie movie = Movie.createMovie(title, category, normalPrice);
        assertNotNull(movie);
        assertEquals(title, movie.getTitle());
        assertEquals(category, movie.getCategory());
        assertEquals(normalPrice, movie.getNormalPrice(), 0.0);
    }

    // MVE_TC2_INV001
    // Test method to test createMovie with invalid inputs
    private Object[] getParamForCreateMovieInvalid() {
        return new Object[] {
            new Object[] {null, "Normal", 18.50},             		// Null title
            new Object[] {"", "Normal", 18.50},              		// Empty title
            new Object[] {"Movie!", "Normal", 18.50},        		// Invalid title with special characters
            new Object[] {"Example Movie", null, 18.50},         	// Null category
            new Object[] {"Example Movie", "", 18.50},            	// Empty category
            new Object[] {"Example Movie", "OtherCategory", 18.50},	// Invalid category (not Normal, 3D, IMAX)
            new Object[] {"Example Movie", "Normal", -0.01},       	// BVA - Negative price near zero
            new Object[] {"Example Movie", "Normal", -100},      	// EP - Negative price -100
        };
    }
    
    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getParamForCreateMovieInvalid")
    public void createMovieInvalidTest(String title, String category, double normalPrice) {
        assertNull(Movie.createMovie(title, category, normalPrice));
    }

    //MVE_TC3_V001
    //test method for gettTitle 
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

    //MVE_TC4_V001
    //test method for getNormalPrice 
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

    //MVE_TC5_V001
    //test method for getCategory
    @Test
    @Parameters("Normal, Normal")
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
    
    //MVE_TC6_V001
    //Test method for setTitle
    @Test
    @Parameters("Movie123, Movie123")
    public void setTitleValidTest(String title1, String ER){
        Movie movieSpy = spy(new Movie());
        movieSpy.setTitle(title1);
        verify(movieSpy).setTitle(title1);
        assertEquals(ER, movieSpy.getTitle());
    }
    
    //MVE_TC6_INV001
    //Test method for setTitle invalid
    @Test (expected = IllegalArgumentException.class)
    @Parameters("null,'',Invalid^&%Movie")
    public void setTitleInvalidTest(String title){
    	 Movie movieSpy = spy(new Movie());
         movieSpy.setTitle(title);
    }
    
    //MVE_TC7_V001
    //Test method for setCategory valid
    @Test
    @Parameters({
    	"3D,3D",
    	"IMAX,IMAX",
    	"Normal, Normal",
    })
    public void setCategoryValidTest(String category, String ER){
        Movie movie = (new Movie());
        movie.setCategory(category);
        assertEquals(ER, movie.getCategory());
    }

    //MVE_TC7_INV001
    //Test method for setCategory valid
    @Test (expected = IllegalArgumentException.class)
    @Parameters("null, '' ,InvalidCategory")
    public void setCategoryInvalidTest(String category){
    	Movie movie = (new Movie());
        movie.setCategory(category);
    }
    
    //MVE_TC8_V001
    //Test method for setNormalPrice valid
	@Test
    @Parameters({	
	    "0,0",		//BVA
	    "100,100"}	//EP
    )
    public void setNormalPriceValidTest(double price, double ER){
        Movie movie = (new Movie());
        movie.setNormalPrice(price);
        assertEquals(ER, movie.getNormalPrice(),0.0);
    }
	
	//MVE_TC8_INV001
    //Test method for setNormalPrice valid
    @Test (expected = IllegalArgumentException.class)
    @Parameters({	
	    "-100",		//EP
	    "-0.01"}	//BVA
    )
    public void setNormalPriceInvalidTest(double price){
        Movie movie = (new Movie());
        movie.setNormalPrice(price);
    }

    //MVE_TC9_V001
    //Test method for isExpensive valid
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

    //IT for IsExpensive
    @Test
    public void isExpensiveIntegrationValidTest(String category, boolean ER){
        Movie movie = (new Movie());
        movie.setCategory(category);
        assertEquals(ER, movie.isExpensive());
    }
}
