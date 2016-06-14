package enums;

import java.util.HashMap;

/**
 * Created by echavez on 5/20/16.
 */
public class PagesList {



    public enum pages {
        TIEMPO, OPCION, SEGUNDOASEGUNDO, CRONICA,NORTEDIGITAL, OTHER
    }

    public static HashMap getRootUrls(){

        HashMap<pages, String> rootUrls = new HashMap<pages, String>();

        rootUrls.put(pages.TIEMPO, "http://tiempo.com.mx");
        rootUrls.put(pages.OPCION, "http://laopcion.com.mx/");
        rootUrls.put(pages.SEGUNDOASEGUNDO, "http://www.segundoasegundo.com/");
        rootUrls.put(pages.CRONICA, "http://www.cronicadechihuahua.com/");
        rootUrls.put(pages.NORTEDIGITAL, "http://nortedigital.mx/");

        return rootUrls;
    }


}
