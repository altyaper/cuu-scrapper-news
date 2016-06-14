package main;

import enums.PagesList;
import models.Article;
import utils.Scrapper;

/**
 * Created by echavez on 5/20/16.
 */
public class Main {


    public static void main(String... strings){


        Scrapper s = new Scrapper("http://www.cronicadechihuahua.com/Hoy-el-vigesimo-segundo-ejecutado,44533.html");

        System.out.println(s.scrapTitle());



    }


}
