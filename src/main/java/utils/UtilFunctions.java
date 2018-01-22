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
        if(!aux.toString().isEmpty()){
            return aux.substring(0,aux.length()-2);
        }
        return null;

    }

    public static String makeSlug(String input) {
        String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }

    public static String getMonthBySpanishName(String month) {
        String monthString = "01";
        String lowerMonth = month.toLowerCase();
        switch (lowerMonth) {
            case "enero":
            case "ene":
                monthString = "01";
                break;
            case "febrero":
            case "feb":
                monthString = "02";
                break;
            case "marzo":
            case "mar":
                monthString = "03";
                break;
            case "abril":
            case "abr":
                monthString = "04";
                break;
            case "mayo":
            case "may":
                monthString = "05";
                break;
            case "junio":
            case "jun":
                monthString = "06";
                break;
            case "julio":
            case "jul":
                monthString = "07";
                break;
            case "agosto":
            case "ago":
                monthString = "08";
                break;
            case "septiembre":
            case "sep":
                monthString = "09";
                break;
            case "octubre":
            case "oct":
                monthString = "10";
                break;
            case "noviembre":
            case "nov":
                monthString = "11";
                break;
            case "diciembre":
            case "dic":
                monthString = "12";
                break;
        }
        return monthString;
    }

}
