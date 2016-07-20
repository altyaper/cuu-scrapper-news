package DB;

import hibernate.ArticleModel;
import hibernate.SessionFactorySingleton;
import hibernate.TagModel;
import models.Article;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.varia.NullAppender;
import org.hibernate.PropertyValueException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.jsoup.parser.Tag;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.UtilFunctions;

import javax.swing.text.html.parser.TagElement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by echavez on 7/18/16.
 */
public class ArticleModelTest extends UtilDB{

    @Before
    public void setup() {
        BasicConfigurator.configure(new NullAppender());
        sessionFactory = this.createSessionFactory();
        session = this.sessionFactory.openSession();
        Transaction transaction = this.session.beginTransaction();
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
        session.persist(articleOne);
        session.persist(articleTwo);
        session.getTransaction().commit();
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
        ArticleModel expected = session.get(ArticleModel.class, 1);
        assertNull(expected);
    }



    @After
    public void after() {
        session.close();
    }
}
