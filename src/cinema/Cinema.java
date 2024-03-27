package cinema;

public class Cinema 
{
    // variables
    private String cinemaName;
    private String cinemaAddress;
    // mock data
    private static Cinema[] cinemaLocation = 
    {
        new Cinema("TVG Cheras Sentral", "Level 9, Cheras Sentral Shopping Mall Jalan 2/142A, Taman Len Seng, 56000 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur, Malaysia."),
        new Cinema("TVG Strand Kota Damansara", "Level 2, Jalan PJU 5/22, Encorp Strand Mall, Pusat Perdagangan, Kota Damansara, 47810 Petaling Jaya, Selangor, Malaysia.")
    };

    // constructors
    public Cinema(String cinemaName, String cinemaAddress)
    {
        this.cinemaName = cinemaName;
        this.cinemaAddress = cinemaAddress;
    }
    
    // accessors
    public String getCinemaName()
    {
        return cinemaName;
    }
    
    public String getCinemaAddress()
    {
        return cinemaAddress;
    }

    public static Cinema[] getCinemaLocation()
    {
        return cinemaLocation;
    }

}
