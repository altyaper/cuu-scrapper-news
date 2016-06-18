package db;

import java.sql.*;
import java.util.Properties;
import java.util.function.BooleanSupplier;

/**
 * Created by echavez on 6/17/16.
 */
public class ConnectionManager {

    Connection connection = null;

    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:8889/nearsoft?autoReconnect=true&serverTimezone=UTC&useSSL=false&useServerPrepStmts=true";
        Properties props = new Properties();
        props.setProperty("user","root");
        props.setProperty("password","root");
        props.setProperty("ssl","false");
        try {

            this.connection = DriverManager.getConnection(url, props);

            System.out.println("Opened database successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return connection;
    }


}
