package utils;

import db.QueryManager;
import scrappers.scrapperCover.*;
import services.HtmlProcess;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
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

    public QueryManager query = new QueryManager();

    public ScrapCover() throws URISyntaxException, SQLException {
        query.setTables();
    }


    public HashSet<String> getAllNews() throws IOException {
        HashSet<String> allnews = new HashSet<String>();
        CoverPage single = new CronicaCover(new HtmlProcess());

        allnews.addAll(single.getArticlesLinks());

        single = new TiempoCover(new HtmlProcess());
        allnews.addAll(single.getArticlesLinks());

        single = new NorteDigitalCover(new HtmlProcess());
        allnews.addAll(single.getArticlesLinks());

        single = new ChihuahuanoticiasCover(new HtmlProcess());
        allnews.addAll(single.getArticlesLinks());

        single = new OpcionCover(new HtmlProcess());
        allnews.addAll(single.getArticlesLinks());

        single = new ParadaDigitalCover(new HtmlProcess());
        allnews.addAll(single.getArticlesLinks());

        single = new EntreLineasCover(new HtmlProcess());
        allnews.addAll(single.getArticlesLinks());

        single = new DiarioCover(new HtmlProcess());
        allnews.addAll(single.getArticlesLinks());

        single = new PolakaCover(new HtmlProcess());
        allnews.addAll(single.getArticlesLinks());

        single = new MonitorParralCover(new HtmlProcess());
        allnews.addAll(single.getArticlesLinks());

        single = new AhoramismoCover(new HtmlProcess());
        allnews.addAll(single.getArticlesLinks());

        single = new RedNoticiasCover(new HtmlProcess());
        allnews.addAll(single.getArticlesLinks());

        single = new FuturoCover(new HtmlProcess());
        allnews.addAll(single.getArticlesLinks());

        single = new InformacionTotalCover(new HtmlProcess());
        allnews.addAll(single.getArticlesLinks());

        single = new PuebloCover(new HtmlProcess());
        allnews.addAll(single.getArticlesLinks());

        return  allnews;
    }

    public void scrappAllCovers() throws IOException, SQLException, URISyntaxException {

        HashSet<String> allNews = this.getAllNews();
        this.saveArticles(allNews);

    }

    public void saveArticles(HashSet<String > allNews) throws SQLException, URISyntaxException {

        for (final String link : allNews) {

            if(!query.existNew(link)){

                Runnable task = () -> {

                    Scrapper s = null;

                    try {
                        s = new Scrapper(link);

                        System.out.println(s.getArticle().getTitle());
                        System.out.println(s.getArticle().getThumbnail());
                        System.out.println(s.getArticle().getPageUrl());
                        System.out.println(s.getArticle().getCategory());
                        System.out.println(s.getArticle().getAuthor());

                        if(query.saveArticle(s.getArticle()) == 1 && !s.getArticle().getTitle().equals("")){

                            int lastid = query.getLastArticle();

//                            if(lastid != 0){
//                                URL local = new URL("http://sevenblocks.herokuapp.com/"+lastid);
//                                URLConnection yc = local.openConnection();
//                                BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
//                            }

                            System.out.println();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error: "+e.getMessage());

                    }


                };

                Thread thread = new Thread(task);
                thread.start();
                try {
                    thread.join();
                } catch (Exception e) {
                    System.out.println("Error: "+e.getMessage());
                }

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
