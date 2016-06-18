package main;

import db.ConnectionManager;
import db.QueryManager;
import models.Article;
import scrappers.scrapperCover.*;
import scrappers.scrapperPage.Tiempo;
import services.HtmlProcess;
import utils.ScrapCover;
import utils.Scrapper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by echavez on 5/20/16.
 */
public class Main {

    public static void main(String... strings) throws SQLException {

        try {
            ScrapCover.scrappAllCovers();
        } catch (IOException e) {
//            e.printStackTrace();
        }

//        Connection conn = null;
//        ConnectionManager connection = new ConnectionManager();
//        conn = connection.getConnection();
//        QueryManager query = new QueryManager(conn);
//        query.setTables();
//
//        Article a = new Tiempo("http://tiempo.com.mx/noticia/34472-declina_abril_padilla_a_favor_/2", new HtmlProcess());
//        query.saveArticle(a);


    }



}
