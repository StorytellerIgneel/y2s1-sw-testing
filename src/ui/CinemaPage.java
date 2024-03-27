<<<<<<< HEAD:src/GeneralSRC/CinemaPage.java
package GeneralSRC;
=======
package ui;
import cinema.Cinema;
import util.CommonIcon;

>>>>>>> de02b6f2023db24b66cd0ee64525621f85e4c359:src/ui/CinemaPage.java
public class CinemaPage 
{
    private static Cinema[] cinemas = Cinema.getCinemaLocation();
    public static void printAllCinemaLocation()
    {
        CommonIcon.printHeader();
        System.out.printf("%-30s\t%-150s\n", "Cinema Name", "Cinema Address");
        for (Cinema cinema : cinemas)
        {
            System.out.printf("%-30s\t%-150s\n", cinema.getCinemaName(), cinema.getCinemaAddress());
        }
    }
}
