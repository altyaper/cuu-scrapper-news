package enums;

import java.util.HashMap;

/**
 * Created by echavez on 5/20/16.
 */
public class PagesList {



    public enum pages {
        TIEMPO, OPCION, OTHER
    }

    private HashMap<pages, String> rootUrls = new HashMap<pages, String>();

    public HashMap getRootUrls(){

        rootUrls.put(pages.TIEMPO, "http://tiempo.com.mx");
        rootUrls.put(pages.OPCION, "http://laopcion.com.mx/");

        return this.rootUrls;
    }


}
