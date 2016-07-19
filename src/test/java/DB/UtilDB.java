package DB;

import hibernate.ArticleModel;
import hibernate.SessionFactorySingleton;
import hibernate.TagModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.UtilFunctions;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by echavez on 7/19/16.
 */
public class UtilDB {

    protected SessionFactory sessionFactory;
    protected Session session = null;

    protected SessionFactory createSessionFactory() {
        SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
        return sessionFactory;
    }

    protected ArticleModel createArticle() {
        ArticleModel article = new ArticleModel();
        String title = "Titulo";
        article.setTitle(title);
        article.setContent("Content");
        article.setAuthor("Jorge Chavez");
        article.setSlug(UtilFunctions.makeSlug(title));
        article.setCategory("Category");
        article.setThumbnail("https://dzone.com/themes/dz20/images/logo.png");
        article.setDate("23 de Agosto del 2016");
        article.setUrl("https://dzone.com/articles/testing-databases-junit-and");

        Set<TagModel> tags = new HashSet<>();
        TagModel tag1 = new TagModel();
        tag1.setName("Tag 1");
        tags.add(tag1);

        article.setTags(tags);

        return article;
    }

}
