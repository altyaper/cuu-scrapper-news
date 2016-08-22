package DB;

import hibernate.ArticleModel;
import hibernate.TagModel;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.varia.NullAppender;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.Serializable;
import java.net.URISyntaxException;

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
    @Ignore
    public void itShouldSaveTheTagsOfTheArticle() throws URISyntaxException {
        ArticleModel articleModel = this.createArticle();
        Serializable last = session.save(articleModel);
        ArticleModel lastA = session.get(ArticleModel.class, (Integer) last);
        TagModel tag1 = new TagModel();
        tag1.setName("El Tag");
        tag1.setArticles(lastA);
        session.save(tag1);
        TagModel lastTag = session.get(TagModel.class, 1);

        int articleId = session.get(ArticleModel.class, 1).getArticleId();
        int articleIdFromTags = lastTag.getArticles().getArticleId();

        assertEquals(lastTag.getName(), "El Tag");
        assertEquals(articleId, articleIdFromTags);
    }

    @Test(expected = ConstraintViolationException.class)
    public void itShouldNotRepeatTheArticleIdAndTagId() throws URISyntaxException {
        ArticleModel articleModel = this.createArticle();
        Serializable last = session.save(articleModel);
        ArticleModel lastA = session.get(ArticleModel.class, (Integer) last);
        TagModel tag1 = new TagModel();
        tag1.setName("El Tag");
        TagModel tag2 = new TagModel();
        tag2.setName("El Tag");
        tag2.setArticles(lastA);
        tag1.setArticles(lastA);
        session.save(tag1);
        session.save(tag2);
    }

    @After
    public void after() {
        session.close();
    }

}
