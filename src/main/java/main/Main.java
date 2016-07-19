package main;

import hibernate.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.*;

import org.jsoup.parser.Tag;
import utils.ScrapCover;

/**
 * Created by echavez on 5/20/16.
 */
public class Main {

    public static void main(String... strings) throws SQLException, URISyntaxException, IOException {

//        ArticleModel article = new ArticleModel();
//        article.setUrl("http://tiempo.com.mx");
//        article.setDate("20 de Agosto del 2016");
//        article.setContent("This is the content of the current article");
//        article.setThumbnail("http://tiempo.com/thumbnail.jpg");
//        String title = "Titulo de la noticia";
//        article.setTitle(title);
//        article.setSlug(title);
//        article.setCategory("Deportes");
//        article.setAuthor("Jorge");
//
//        SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(article);
//        session.getTransaction().commit();
//        session.close();

        ScrapCover scrapCover = new ScrapCover();
        try {
            scrapCover.scrappAllCovers();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }



}
