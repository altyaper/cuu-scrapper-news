package db;

import models.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by echavez on 6/17/16.
 */
public class QueryManager {

    Connection conn;

    public QueryManager(Connection conn) {
        this.conn = conn;
    }

    public void setTables() throws SQLException {

        Statement comando = this.conn.createStatement();
        comando.executeUpdate("CREATE TABLE IF NOT EXISTS news ( new_id INT(255) AUTO_INCREMENT , title VARCHAR(255) UNIQUE, content TEXT, url VARCHAR(255) UNIQUE, thumbnail VARCHAR(255), author VARCHAR(255), tags VARCHAR(255), PRIMARY KEY (new_id))");

    }

    public int saveArticle(Article article) throws SQLException {

        String sql =  "INSERT INTO news (title, content, thumbnail, author, tags, url) VALUES(?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
        preparedStatement.setString(1, article.getTitle());
        preparedStatement.setString(2, article.getContent());
        preparedStatement.setString(3, article.getThumbnail().toString());
        preparedStatement.setString(4, article.getAuthor());
        preparedStatement.setString(5, article.getTags().toString());
        preparedStatement.setString(6, article.getPageUrl());

        return preparedStatement.executeUpdate();
    }

    public int deleteAnArticle(int new_id) throws SQLException {

        String sql = "DELETE FROM new WHERE new_id = ?";

        PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
        preparedStatement.setInt(1, new_id);

        return preparedStatement.executeUpdate();

    }
}
