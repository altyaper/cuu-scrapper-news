package db;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import utils.UtilFunctions;

import javax.persistence.PersistenceException;

import static org.osgi.util.measurement.Unit.s;

/**
 * Created by echavez on 6/17/16.
 */
public class QueryManager{

    public boolean articleExist(String url){
        SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
        Session session = sessionFactory.openSession();
        String hql = "FROM ArticleModel WHERE url = '"+url+"'";
        Query query = session.createQuery(hql);
        List results = query.list();
        return !results.isEmpty();
    }

    public int saveArticle(Article article) throws SQLException, URISyntaxException {

        ArticleModel articleModel = new ArticleModel();
        articleModel.setUrl(article.getPageUrl());
        articleModel.setTitle(article.getTitle());
        articleModel.setContent(article.getContent());
        articleModel.setCategory(article.getCategory());
        articleModel.setAuthor(article.getAuthor());
        articleModel.setDate(article.getDate());
        articleModel.setUrl(article.getPageUrl());
        articleModel.setThumbnail(UtilFunctions.convertCollectionToString((HashSet<String>) article.getThumbnail()));
        Session session = SessionFactorySingleton.getInstance().openSession();

        try{
            session.beginTransaction();
            session.persist(articleModel);
            session.getTransaction().commit();
        }catch (ConstraintViolationException e) {
            // TODO: 7/20/16 Handle duplicated slug
            System.out.println(articleModel);
            System.out.println("Error: "+e.getMessage());
        }catch (HibernateException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }catch (PersistenceException e){
//            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }finally {
            session.close();
        }

        // TODO: 7/13/16 Verify if the user was added correcly
        return 1;
    }



}
