package utils;

import java.util.HashSet;

/**
 * Created by echavez on 6/24/16.
 */
public class UtilFunctions {

    public String capitalize(String str){
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
    public static String convertCollectionToString(HashSet<String> collection){
        StringBuilder aux = new StringBuilder();
        for(String element: collection){
            aux.append(element + ",");
            if(aux.toString().length() != 0){
                String str = aux.toString();
                return str.substring(0, str.length() - 1);
            }
        }
        return null;
    }

}
