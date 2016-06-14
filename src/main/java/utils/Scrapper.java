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

        if(url.matches(".*tiempo.com.mx.*")){

            return new Tiempo(url);

        }else if(url.matches(".*laopcion.com.mx.*")){

            return new Opcion(url);

        }else if(url.matches(".*segundoasegundo.com.*")){

            return new Segundoasegundo(url);

        }else if(url.matches(".*cronicadechihuahua.com.*")){

            return new Cronica(url);

        }else if(url.matches(".*nortedigital.mx.*")){

            return new NorteDigital(url);

        }else if(url.matches(".*chihuahuanoticias.com.*")){

            return new Chihuahuanoticias(url);
        }

        return null;
    }

}
