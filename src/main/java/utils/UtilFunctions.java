package utils;

import java.text.Normalizer;
import java.util.HashSet;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Created by echavez on 6/24/16.
 */
public class UtilFunctions {

    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

    public String capitalize(String str){
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
    public static String convertCollectionToString(HashSet<String> collection){
        StringBuilder aux = new StringBuilder();
        for(String element: collection){
            aux.append(element + ", ");
        }
        return aux.substring(0,aux.length()-2);
    }

    public static String makeSlug(String input) {
        String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }

}
