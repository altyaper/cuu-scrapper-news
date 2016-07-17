package main;

import hibernate.CategoryModel;
import hibernate.SessionFactorySingleton;
import hibernate.TagModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.*;

import hibernate.ArticleModel;
import org.jsoup.parser.Tag;
import utils.ScrapCover;

/**
 * Created by echavez on 5/20/16.
 */
public class Main {

    public static void main(String... strings) throws SQLException, URISyntaxException, IOException {

        ArticleModel article = new ArticleModel();
        article.setAuthor("Jorge Chavez");
        article.setUrl("http://tiempo.com.mx");
        article.setDate("20 de Agosto del 2016");
        article.setContent("This is the content of the current article");
        article.setThumbnail("http://tiempo.com/thumbnail.jpg");
        article.setTitle("Titulo de la noticia");
        article.setCreated_at(new Date());

        CategoryModel category = new CategoryModel();
        category.setName("Deportes");
        article.setCategory(category);

        TagModel tag1 = new TagModel();
        tag1.setName("Tag 1");
        TagModel tag2 = new TagModel();
        tag1.setName("Tag 2");

        Collection<TagModel> tags = new ArrayList<TagModel>();
        tags.add(tag1);
        tags.add(tag2);

        article.setTags(tags);

        SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(article);
        session.getTransaction().commit();
        session.close();

//        ScrapCover scrapCover = new ScrapCover();
//        try {
//            scrapCover.scrappAllCovers();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }

    }



}
