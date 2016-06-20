package db;

import models.Article;

import java.sql.*;

/**
 * Created by echavez on 6/17/16.
 */
public class QueryManager extends ConnectionManager{


    public QueryManager() {
        this.connection = this.getConnection();
    }

    public QueryManager(Connection conn) {
        this.connection = conn;
    }

    public void setTables() throws SQLException {

        Statement comando = this.connection.createStatement();
        comando.executeUpdate("CREATE TABLE IF NOT EXISTS news ( new_id INT(255) AUTO_INCREMENT , title VARCHAR(255), content TEXT, url VARCHAR(255) UNIQUE, thumbnail TEXT, author VARCHAR(255), tags VARCHAR(255), PRIMARY KEY (new_id))");

    }

    public int saveArticle(Article article) throws SQLException {

        String sql =  "INSERT INTO news (title, content, thumbnail, author, tags, url) VALUES(?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
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

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, new_id);

        return preparedStatement.executeUpdate();

    }

    public boolean existNew(String url) throws SQLException {
        String sql =  "SELECT new_id FROM news WHERE url = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, url);
        ResultSet rs = preparedStatement.executeQuery();
        return (rs.next()) ? true : false;
    }
}
