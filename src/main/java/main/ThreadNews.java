package main;

import db.QueryManager;
import scrappers.scrapperCover.*;
import services.HtmlProcess;
import utils.Scrapper;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * Created by echavez on 8/21/16.
 */
public class ThreadNews {

    private final List<Class> AClass = new ArrayList<Class>();
    private final QueryManager query = new QueryManager();

    public void fillArray() {
        AClass.add(AhoramismoCover.class);
        AClass.add(ChihuahuanoticiasCover.class);
        AClass.add(CronicaCover.class);
        AClass.add(DiarioCover.class);
        AClass.add(EntreLineasCover.class);
        AClass.add(FuturoCover.class);
        AClass.add(InformacionTotalCover.class);
        AClass.add(MonitorParralCover.class);
//        AClass.add(NorteDigitalCover.class);
        AClass.add(OmniaCover.class); //Something weird
        AClass.add(OpcionCover.class);
        AClass.add(ParadaDigitalCover.class);
        AClass.add(PolakaCover.class);
        AClass.add(PuebloCover.class);
        AClass.add(RedNoticiasCover.class);
        AClass.add(ReferenteCover.class);
//        AClass.add(SegundoasegundoCover.class);
        AClass.add(TiempoCover.class);
    }

    public void getCovers() throws Exception {

        this.fillArray();
        System.out.println(new Date());
        for (Class cover: AClass) {

            Runnable task = () -> {

                Class classtoload = cover;
                Class[] arg = new Class[1];
                arg[0] = HtmlProcess.class;
                HtmlProcess h = new HtmlProcess();
                try {
                    CoverPage p = (CoverPage) classtoload.getDeclaredConstructor(arg).newInstance(h);
                    saveArticles(p.getArticlesLinks());
                    System.out.println(new Date());
                } catch (Exception e) {
                    e.printStackTrace();
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

    private void saveArticles(HashSet<String> allNews) throws SQLException, URISyntaxException {

        for (final String link : allNews) {
            if(!query.articleExist(link)){
                Runnable task = () -> {

                    Scrapper s = null;

                    try {
                        s = new Scrapper(link);
                        System.out.println(link);
                        System.out.println(s.getArticle().getTitle());
                        if(query.saveArticle(s.getArticle()) == 1){
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



}
