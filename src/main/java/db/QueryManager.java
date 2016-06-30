package db;

import models.Article;

import java.net.URISyntaxException;
import java.sql.*;

/**
 * Created by echavez on 6/17/16.
 */
public class QueryManager extends ConnectionManager{


    public QueryManager() throws URISyntaxException {
        this.connection = this.getConnection();
    }

    public QueryManager(Connection conn) {
        this.connection = conn;
    }

    public void setTables() throws SQLException {

        Statement comando = this.connection.createStatement();
        comando.executeUpdate("CREATE TABLE IF NOT EXISTS news ( id INT(255) AUTO_INCREMENT , title VARCHAR(255), slug VARCHAR(255) UNIQUE, content TEXT, url VARCHAR(255) UNIQUE, category VARCHAR(255), thumbnail TEXT, author VARCHAR(255), tags VARCHAR(255),date VARCHAR(255),created_at TIMESTAMP, updated_at TIMESTAMP, PRIMARY KEY (id))");
        comando.executeUpdate("CREATE TABLE IF NOT EXISTS favs ( id INT(255) AUTO_INCREMENT, article_id INT(255), profile_id INT(255), created_at TIMESTAMP, updated_at TIMESTAMP, PRIMARY KEY(id))");
        comando.executeUpdate("CREATE TABLE IF NOT EXISTS users (id INT(255) AUTO_INCREMENT, profile_id INT(255), name VARCHAR(255), username VARCHAR(255), photo VARCHAR(255), created_at TIMESTAMP, updated_at TIMESTAMP, PRIMARY KEY(id))");

    }

    public int saveArticle(Article article) throws SQLException {

        String sql =  "INSERT INTO news (title, content, thumbnail, author, tags, url, date, category) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, article.getTitle());
        preparedStatement.setString(2, article.getContent());
        preparedStatement.setString(3, article.getThumbnail().toString());
        preparedStatement.setString(4, article.getAuthor());
        preparedStatement.setString(5, article.getTags().toString());
        preparedStatement.setString(6, article.getPageUrl());
        preparedStatement.setString(7, article.getDate());
        preparedStatement.setString(8, article.getCategory());

        return preparedStatement.executeUpdate();
    }

    public int deleteAnArticle(int new_id) throws SQLException {

        String sql = "DELETE FROM new WHERE id = ?";

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, new_id);

        return preparedStatement.executeUpdate();

    }

    public boolean existNew(String url) throws SQLException {
        String sql =  "SELECT id FROM news WHERE url = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, url);
        ResultSet rs = preparedStatement.executeQuery();
        return (rs.next()) ? true : false;
    }

    public int getLastArticle() throws SQLException {
        String sql =  "SELECT MAX(id) AS id FROM news;";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery(sql);

        while(rs.next()){
            int lastid = rs.getInt("id");
            return lastid;
        }

        return 0;
    }
}
