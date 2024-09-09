package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameter;

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
    
    
    //MVE_TC6_V001
    //Test method for setTitle
    @Test
    @Parameters("Movie123, Movie123")
    public void setTitleValidTest(String title1, String ER){
        Movie movie = spy(new Movie());
        movie.setTitle(title1);
        verify(movie).setTitle(title1);
        assertEquals(ER, movie.getTitle());
    }
    
    //MVE_TC6_INV001
    //Test method for setTitleInvalid
	private Object[] getParamForSetTitleInvalidTest() {
        return new Object[] {
        	//isExpensive return true, all ticket price calculation return 10
            new Object[] {null},
            
          //isExpensive return false, all ticket price calculation return 10
            new Object[] {""},
            new Object[] {"Invalid^&%Movie"}  // Invalid characters
        };
    }
    @Parameters(method="getParamForSetTitleInvalidTest")
    @Test(expected = IllegalArgumentException.class)
    public void setTitleInvalidTest(String title) {
        Movie movie = new Movie();
        movie.setTitle(title);  // This should throw IllegalArgumentException for invalid inputs
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
    //Test method for setCategory invalid
    private Object[] getParamsForSetCategoryInvalid() {
        return new Object[] {
            new Object[] {null},
            new Object[] {" "},
            new Object[] {"InvalidCategory"},
        };
    }
    @Test (expected = IllegalArgumentException.class)
    @Parameters(method = "getParamsForSetCategoryInvalid")
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
    @Parameters(method = "getParamsForIsExpensive")
    public void isExpensiveIntegrationValidTest(String category, boolean ER){
        Movie movie = (new Movie());
        movie.setCategory(category);
        assertEquals(ER, movie.isExpensive());
    }
}

