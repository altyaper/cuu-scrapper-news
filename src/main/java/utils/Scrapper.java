package utils;

import enums.PagesList;
import models.Article;
import models.Video;
import scrappers.*;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by echavez on 5/20/16.
 */
public final class Scrapper {

    private String url;
    private Article article;

    public Article getArticle() {
        return article;
    }

    public Scrapper(String url){
        article = getObjectArticle(url);
    }

    //Factory Design Pattern
    private Article getObjectArticle(String url){

        if(url.matches(".*tiempo.*")){

            return new Tiempo(url);

        }else if(url.matches(".*http://laopcion.com.mx.*")){

            return new Opcion(url);

        }else if(url.matches(".*http://www.segundoasegundo.com/.*")){

            return new Segundoasegundo(url);

        }else if(url.matches(".*http://www.cronicadechihuahua.com/.*")){

            return new Cronica(url);

        }else if(url.matches(".*http://nortedigital.mx/.*")){

            return new NorteDigital(url);

        }

        return null;
    }

}
