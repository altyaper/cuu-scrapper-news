package utils;

import scrappers.scrapperCover.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by echavez on 6/17/16.
 */
public class ScrapCover {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void scrappAllCovers() {

        HashSet<String> allnews = new HashSet<String>();
        CoverPage single = new CronicaCover();

        allnews.addAll(single.getArticlesLinks());

        single = new TiempoCover();
        allnews.addAll(single.getArticlesLinks());

        single = new NorteDigitalCover();
        allnews.addAll(single.getArticlesLinks());

        single = new ChihuahuanoticiasCover();
        allnews.addAll(single.getArticlesLinks());

        single = new OpcionCover();
        allnews.addAll(single.getArticlesLinks());

        for (final String link : allnews) {

            Runnable task = () -> {
                Scrapper s = null;
                try {
                    s = new Scrapper(link);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(s.getArticle().getTitle());
                System.out.println(s.getArticle().getThumbnail());
                System.out.println();
            };

            Thread thread = new Thread(task);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public static void iterar(CoverPage covers) {
        HashSet<String> hash = covers.getArticlesLinks();

        Iterator<String> i = hash.iterator();
        System.out.println(ANSI_RED + covers.url + ANSI_RESET);
        while (i.hasNext()) {
            String s = i.next();
            System.out.println(s);
        }

    }

}
