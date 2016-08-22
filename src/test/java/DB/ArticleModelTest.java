package DB;

import hibernate.ArticleModel;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.varia.NullAppender;
import org.hibernate.PropertyValueException;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.net.URISyntaxException;

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
    public void itShouldaddAnArticle() throws URISyntaxException {
        ArticleModel article = this.createArticle();
        session.save(article);
        ArticleModel articleRetrived = session.get(ArticleModel.class, article.getArticleId());
        assertEquals(article, articleRetrived);
    }

    @Test(expected = PropertyValueException.class)
    public void itShouldNotAddAnEmptyArticle() {
        ArticleModel articleModel = new ArticleModel();
        session.save(articleModel);
        assertNull(session.get(ArticleModel.class, 1));
    }

    @Ignore
    @Test(expected = ConstraintViolationException.class)
    public void itShouldNotAddDuplicateArticles() throws URISyntaxException {
        ArticleModel articleOne = this.createArticle();
        ArticleModel articleTwo = this.createArticle();
        session.persist(articleOne);
        session.persist(articleTwo);
        session.getTransaction().commit();
        assertNull(session.get(ArticleModel.class, 1));
    }

    @Test(expected = PropertyValueException.class)
    public void itShouldNotHaveANullContent() throws URISyntaxException {
        ArticleModel articleModel = this.createArticle();
        articleModel.setContent(null);
        session.save(articleModel);
        assertNull(session.get(ArticleModel.class, 1));
    }

    // TODO: 7/25/16 Fix this test
    @Test
    @Ignore
    public void itShouldNotDuplicateTheSlug() throws URISyntaxException {
        ArticleModel articleOne = this.createArticle();
        ArticleModel articleTwo = this.createArticle();
        String slug = "this-is-the-slug";
        articleOne.setSlug(slug);
        articleTwo.setSlug(slug);
        session.save(articleOne);
        int lastid = (int) session.save(articleTwo);
        ArticleModel expected = session.get(ArticleModel.class, lastid);
        assertNull(lastid);
    }



    @After
    public void after() {
        session.close();
    }
}
