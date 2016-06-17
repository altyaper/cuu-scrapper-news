package main;

import scrappers.scrapperCover.*;
import scrappers.scrapperPage.Omnia;
import scrappers.scrapperPage.Tiempo;
import utils.Scrapper;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by echavez on 5/20/16.
 */
public class Main {


    public static void main(String... strings){


        CoverPage t = new NorteDigitalCover();

        HashSet<String> s = t.getArticlesLinks();
        Iterator<String> i = s.iterator();


        while(i.hasNext()){
            String st = i.next();
            System.out.println(st);
        }



    }


}
