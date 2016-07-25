package DB;

import db.QueryManager;
import hibernate.ArticleModel;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.varia.NullAppender;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by echavez on 7/19/16.
 */
public class QueryManagerTest extends UtilDB{

    private QueryManager query;
    private Transaction transaction;

    @Before
    public void setup() {
        this.query = new QueryManager();
        BasicConfigurator.configure(new NullAppender());
        sessionFactory = this.createSessionFactory();
        session = this.sessionFactory.openSession();
        transaction = this.session.beginTransaction();
    }

    @Test
    @Ignore
    public void itShouldReturnTrueWhenUrlAlreadyInTheDB() {
        ArticleModel article = this.createArticle();
        session.persist(article);
        transaction.commit();
        assertTrue(query.articleExist(article.getUrl()));
    }

    @After
    public void after() {
        session.close();
    }

}
