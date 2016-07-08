package db;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

/**
 * Created by echavez on 6/17/16.
 */
public class ConnectionManager {

    Connection connection = null;

    public Connection getConnection() throws URISyntaxException {

        Map<String, String> env = System.getenv();

        String username = "bd9e4068d77781";
        String password = "9401abbb";
        String url = "jdbc:mysql://us-cdbr-iron-east-04.cleardb.net/heroku_f369fa6d40d0e2d";

//        String url = "jdbc:mysql://localhost:8889/nearsoft?autoReconnect=true&serverTimezone=UTC&useSSL=false&useServerPrepStmts=true";
//        String username = "root";
//        String password = "root";g

        Properties props = new Properties();
        props.setProperty("user", username);
        props.setProperty("password", password);
        props.setProperty("ssl", "true");

        try {

            this.connection = DriverManager.getConnection(url, props);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return connection;
    }


}
