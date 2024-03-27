package GeneralSRC;
public class CommonIcon {
    public static void printHeader()
    {
        printChar('-', 60);
        System.out.println("TVG Cinemas");
        printChar('-', 60);
    }

    public static void printChar(char ch, int times)
    {
        for (int i = 0; i < times; i++)
        {
            System.out.print(ch);
        }
        System.out.println();
    }
}
