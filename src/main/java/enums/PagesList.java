package enums;

import java.util.HashMap;

/**
 * Created by echavez on 5/20/16.
 */
public class PagesList {

    public enum pages {
        TIEMPO,
        OPCION,
        SEGUNDOASEGUNDO,
        CRONICA,
        NORTEDIGITAL,
        CHIHUAHUANOTICIAS,
        OMNIA,
        PARADADIGITAL,
        ENTRELINEAS,
        HERALDO,
        POLAKA,
        DIARIO,
        MONITORPARRAL,
        AHORAMISMO,
        REDNOTICIAS,
        FUTURO,
        INFORMACIONTOTAL,
        PUEBLO,
        VOZ,
        OTHER
    }

    public static HashMap getRootUrls(){

        HashMap<pages, String> rootUrls = new HashMap<pages, String>();

        rootUrls.put(pages.TIEMPO, "http://tiempo.com.mx");
        rootUrls.put(pages.OPCION, "http://laopcion.com.mx/");
        rootUrls.put(pages.SEGUNDOASEGUNDO, "http://www.segundoasegundo.com/");
        rootUrls.put(pages.CRONICA, "http://www.cronicadechihuahua.com/");
        rootUrls.put(pages.NORTEDIGITAL, "http://nortedigital.mx/");
        rootUrls.put(pages.CHIHUAHUANOTICIAS, "http://chihuahuanoticias.com/");
        rootUrls.put(pages.OMNIA, "http://www.omnia.com.mx/");
        rootUrls.put(pages.PARADADIGITAL, "http://www.laparadadigital.com/");
        rootUrls.put(pages.ENTRELINEAS, "http://entrelineas.com.mx/");
        rootUrls.put(pages.HERALDO, "https://www.elheraldodechihuahua.com.mx/");
        rootUrls.put(pages.DIARIO, "http://eldiariodechihuahua.mx/");
        rootUrls.put(pages.POLAKA, "http://www.lapolaka.com/");
        rootUrls.put(pages.MONITORPARRAL, "http://www.elmonitorparral.com/");
        rootUrls.put(pages.AHORAMISMO, "http://ahoramismo.mx/");
        rootUrls.put(pages.REDNOTICIAS, "http://larednoticias.com.mx/");
        rootUrls.put(pages.FUTURO,"http://www.futuro.mx/");
        rootUrls.put(pages.INFORMACIONTOTAL, "http://informaciontotal.com.mx/");
        rootUrls.put(pages.PUEBLO, "http://elpueblo.com/");
        rootUrls.put(pages.VOZ, "http://vozenred.com/2015/");

        return rootUrls;
    }


}
