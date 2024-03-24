public class CommonIcon {
    public static void printHeader()
    {
        printDashes('-', 60);
        System.out.println("TVG Cinemas");
        printDashes('-', 60);
    }

    public static void printDashes(char ch, int times)
    {
        for (int i = 0; i < times; i++)
        {
            System.out.print(ch);
        }
        System.out.println();
    }
}
