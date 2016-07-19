package db;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import hibernate.ArticleModel;
import hibernate.AuthorModel;
import hibernate.CategoryModel;
import hibernate.SessionFactorySingleton;
import models.Article;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import utils.UtilFunctions;

import static org.osgi.util.measurement.Unit.s;

/**
 * Created by echavez on 6/17/16.
 */
public class QueryManager{

    public int saveArticle(Article article) throws SQLException {

        ArticleModel articleModel = new ArticleModel();
        articleModel.setTitle(article.getTitle());
        articleModel.setContent(article.getContent());
        articleModel.setUrl(article.getPageUrl());
        articleModel.setCategory(article.getCategory());

        articleModel.setAuthor(article.getAuthor());

        articleModel.setDate(article.getDate());
        articleModel.setThumbnail(UtilFunctions.convertCollectionToString((HashSet<String>) article.getThumbnail()));
        articleModel.setSlug(article.getTitle());

        Session session = SessionFactorySingleton.getInstance().openSession();

        try{
            session.beginTransaction();
            session.persist(articleModel);
            session.getTransaction().commit();
        }catch (HibernateException e){
//            e.printStackTrace();
            System.out.println("Error: "+e.getMessage());
        }finally {
            session.close();
            SessionFactorySingleton.getInstance().close();
        }

        // TODO: 7/13/16 Verify if the user was added
        return 1;
    }


}
