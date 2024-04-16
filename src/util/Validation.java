package util;

public class Validation {
    public static boolean isNumber(String value) {
        try{
            Integer.parseInt(value);
            return true;
        }catch (NumberFormatException error){
            return false;
        }
    }

    public static boolean isTime(String[] showtimes) {
        for (String time : showtimes){
            if (!time.matches("[0-1][0-9][0-5][0-9]") && !time.matches("2[0-3][0-5][0-9]"))
                return false;
        }
        return true;
    }

    public static boolean isLanguage(String[] languages){
        for (String language : languages){
            if (!language.matches("[a-zA-Z]+"))
                return false;
        }
        return true;
    }

    public static boolean isDouble(String value) {
        try{
            Double.parseDouble(value);
            return true;
        }catch (NumberFormatException error){
            return false;
        }
    }

    public static boolean isMovie(String value){
        return value.matches("[a-zA-Z]+");
    }

    public static boolean isBack(String value){
        return (value.equals(":b"));
    } 

    public static boolean isQuit(String value)
    {
        return (value.equals(":q"));
    }
}