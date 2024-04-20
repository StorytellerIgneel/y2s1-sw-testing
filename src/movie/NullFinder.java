package movie;
import movie.Result;
import util.Util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Scanner;

public class NullFinder {
    NullFinder(){};

    public static Movie findNull(Result result, Movie movie) {
        Scanner scanner = new Scanner(System.in);
        Result nullResult = new Result();

        Map <String, Object> nonNullAttribute = findNonNull(result);
        System.out.println("nonNullAttri:" + nonNullAttribute);
        if (nonNullAttribute != null){
            return(setAttribute(result, movie, null, nonNullAttribute));

        }
        else{

        }

        return movie;
    }

    public static Map<String, Object> findNonNull(Result updatedResult) {
        Field[] fields = updatedResult.getClass().getDeclaredFields();
        Map<String, Object> attributeInfo = new HashMap<>();

        for (Field field : fields) {
            field.setAccessible(true); //if field is private make it accessible
            try {
                if (field.get(updatedResult)!= null && !(field.get(updatedResult) instanceof List && ((List) field.get(updatedResult)).isEmpty())) {
                    attributeInfo.put(field.getName(), field.get(updatedResult));
                    return attributeInfo;
                }
            } catch (IllegalAccessException e) {
                //if the access to field kena deny
                e.printStackTrace();
            }
        }
        return null; //no non-null value found, all values are null
    }
    public static Movie setAttribute (Result previousResult, Movie movie, String attributeName, Object attributeValue){
        try{
            System.out.println(attributeName + "=" + attributeValue);
            //get the field of the object with the attribute name
            Field field = previousResult.getClass().getDeclaredField(attributeName);

            //set accessible to true to access private
            field.setAccessible(true);

            //set the value of the field to the attribute value
            field.set(previousResult, attributeValue);
        }catch (NoSuchFieldException e){
            System.out.println("error: no such field");
        }catch(IllegalAccessException e){
            System.out.println("cant access priv");
        }
        return movie;
    }
}