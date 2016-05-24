package main;

import enums.PagesList;
import utils.Scrapper;

/**
 * Created by echavez on 5/20/16.
 */
public class Main {


    public static void main(String... strings){


        Scrapper scrapper = new Scrapper("http://laopcion.com.mx/noticia/137770/aseguran-cuerno-de-chivo-durante-enfrentamiento-en-bocoyna");
        System.out.println(scrapper.scrapTitle());
        System.out.println(scrapper.scrapContent());
        System.out.println(scrapper.scrapThumbnail());
        System.out.println(scrapper.scrapTags());
        System.out.println(scrapper.scrapVideo());
        System.out.println(scrapper.scrapAuthor());



    }


}
