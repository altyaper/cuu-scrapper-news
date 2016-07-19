package DB;

import hibernate.ArticleModel;
import hibernate.SessionFactorySingleton;
import models.Article;
import org.hibernate.PropertyValueException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.UtilFunctions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by echavez on 7/18/16.
 */
public class ArticleModelTest {

    private SessionFactory sessionFactory;
    private Session session = null;

    @Before
    public void setup() {
        sessionFactory = this.createSessionFactory();
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
    }

    private SessionFactory createSessionFactory() {
        SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
        return sessionFactory;
    }

    @Test
    public void itShouldaddAnArticle() {
        ArticleModel article = this.createArticle();
        session.save(article);
        ArticleModel articleRetrived = session.get(ArticleModel.class, 1);
        assertEquals(article, articleRetrived);
    }

    @Test(expected = PropertyValueException.class)
    public void itShouldNotAddAnEmptyArticle() {
        ArticleModel articleModel = new ArticleModel();
        session.save(articleModel);
        assertNull(session.get(ArticleModel.class, 1));
    }

    @Test(expected = ConstraintViolationException.class)
    public void itShouldNotAddDuplicateArticles() {
        ArticleModel articleOne = this.createArticle();
        ArticleModel articleTwo = this.createArticle();
        session.save(articleOne);
        session.save(articleTwo);
        assertNull(session.get(ArticleModel.class, 1));
    }

    @Test(expected = PropertyValueException.class)
    public void itShouldNotHaveANullContent() {
        ArticleModel articleModel = this.createArticle();
        articleModel.setContent(null);
        session.save(articleModel);
        assertNull(session.get(ArticleModel.class, 1));
    }

    @Test(expected = ConstraintViolationException.class)
    public void itShouldNotDuplicateTheSlug() {
        ArticleModel articleOne = this.createArticle();
        ArticleModel articleTwo = this.createArticle();
        String slug = "this-is-the-slug";
        articleOne.setSlug(slug);
        articleTwo.setSlug(slug);
        session.save(articleOne);
        session.save(articleTwo);
        assertNull(session.get(ArticleModel.class, 1));
    }

    private ArticleModel createArticle() {
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
        return article;
    }

    @After
    public void after() {
        session.close();
    }
}
