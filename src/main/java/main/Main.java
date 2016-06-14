package main;

import enums.PagesList;
import models.Article;
import scrappers.Cronica;
import scrappers.Opcion;
import utils.Scrapper;

/**
 * Created by echavez on 5/20/16.
 */
public class Main {


    public static void main(String... strings){


        Scrapper s = new Scrapper("http://nortedigital.mx/hallan-cuerpo-acequia-campestre/");

        System.out.println(s.getArticle().getThumbnail());

    }


}
