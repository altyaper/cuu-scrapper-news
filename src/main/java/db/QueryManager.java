package db;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.ExecutionException;

import hibernate.ArticleModel;
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
        articleModel.setCreated_at(new Date());
        articleModel.setUrl(article.getPageUrl());
        articleModel.setCategory(article.getCategory());
        articleModel.setAuthor(article.getAuthor());
        articleModel.setDate(article.getDate());
        System.out.println(UtilFunctions.convertCollectionToString((HashSet<String>) article.getThumbnail()));
        articleModel.setThumbnail(UtilFunctions.convertCollectionToString((HashSet<String>) article.getThumbnail()));
        articleModel.setTags(UtilFunctions.convertCollectionToString(article.getTags()));

        Session session = SessionFactorySingleton.getInstance().openSession();

        try{
            session.beginTransaction();
            session.save(articleModel);
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }

        // TODO: 7/13/16 Verify if the user was added
        return 1;
    }


}
