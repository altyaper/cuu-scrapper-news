package DB;

import hibernate.ArticleModel;
import hibernate.TagModel;
import models.Article;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.varia.NullAppender;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jsoup.parser.Tag;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by echavez on 7/19/16.
 */
public class TagModelTest extends UtilDB {

    @Before
    public void setup() {
        BasicConfigurator.configure(new NullAppender());
        sessionFactory = this.createSessionFactory();
        session = this.sessionFactory.openSession();
        Transaction transaction = this.session.beginTransaction();
    }

    @Test
    public void itShouldSaveTheTagsOfTheArticle() {
        ArticleModel articleModel = this.createArticle();
        Serializable last = session.save(articleModel);
        ArticleModel lastA = session.get(ArticleModel.class, (Integer) last);
        TagModel tag1 = new TagModel();
        tag1.setName("El Tag");
        tag1.setArticles(lastA);
        session.save(tag1);
        assertEquals(session.get(TagModel.class, 1).getName(), "El Tag");
        assertEquals(session.get(ArticleModel.class, 1).getArticleId(), session.get(TagModel.class,1).getArticles().getArticleId());
    }

    @After
    public void after() {
        session.close();
    }

}
