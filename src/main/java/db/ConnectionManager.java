package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by echavez on 6/17/16.
 */
public class ConnectionManager {

    Connection connection = null;

    public Connection getConnection() {
        String url = "jdbc:postgresql://localhost/test";
        Properties props = new Properties();
        props.setProperty("user","admin");
        props.setProperty("password","");
        props.setProperty("ssl","false");
        try {
            Connection conn = DriverManager.getConnection(url, props);
            System.out.println("Opened database successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

}
