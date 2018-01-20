package DB;

import hibernate.ArticleModel;
import hibernate.SessionFactorySingleton;
import hibernate.TagModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.UtilFunctions;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by echavez on 7/19/16.
 */
public class UtilDB {

    SessionFactory sessionFactory;
    Session session = null;

    SessionFactory createSessionFactory() {
        SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
        return sessionFactory;
    }

    ArticleModel createArticle() throws URISyntaxException {

        ArticleModel article = new ArticleModel();
        article.setUrl("https://dzone.com/articles/testing-databases-junit-and");
        String title = "Titulo";
        article.setTitle(title);
        article.setContent("Content");
        article.setAuthor("Jorge Chavez");
        article.setCategory("Category");
        article.setThumbnail("https://dzone.com/themes/dz20/images/logo.png");
        Date date = new Date();
        article.setDate(date);

        return article;
    }

    protected List<TagModel> createTagList() {
        List<TagModel> tags = new ArrayList<>();
        TagModel tag1 = new TagModel();
        TagModel tag2 = new TagModel();
        tag1.setName("Tag 1");
        tag2.setName("Tag 2");
        tags.add(tag1);
        tags.add(tag2);
        return tags;
    }
}
