package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import hibernate.ArticleModel;

/**
 * Created by echavez on 5/20/16.
 */
public class Main {

    public static void main(String... strings) throws SQLException, URISyntaxException, IOException {

        ArticleModel article1 = new ArticleModel();
        article1.setAuthor("Jorge Chavez");
        article1.setCategory("Deportes");
        article1.setContent("Contenido");
        article1.setTitle("Titulo");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(article1);

        session.getTransaction().commit();




//        ScrapCover scrapCover = new ScrapCover();
//        try {
//            scrapCover.scrappAllCovers();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }

    }



}
