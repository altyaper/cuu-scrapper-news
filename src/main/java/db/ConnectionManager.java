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

//        String url = "jdbc:mysql://localhost:8889/nearsoft?autoReconnect=true&serverTimezone=UTC&useSSL=false&useServerPrepStmts=true";
//        String url = "jdbc:mysql://bd9e4068d77781,9401abbb@us-cdbr-iron-east-04.cleardb.net:3306/heroku_f369fa6d40d0e2d?reconnect=true";

//        URI dbUri = new URI("mysql://bd9e4068d77781:9401abbb@us-cdbr-iron-east-04.cleardb.net/heroku_f369fa6d40d0e2d?reconnect=true");
//
//        String username = dbUri.getUserInfo().split(":")[0];
//        String password = dbUri.getUserInfo().split(":")[1];
//        String url = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath()+"?useSSL=true";

        String url = "jdbc:mysql://localhost:8889/nearsoft?autoReconnect=true&serverTimezone=UTC&useSSL=false&useServerPrepStmts=true";
        Properties props = new Properties();
        props.setProperty("user","root");
        props.setProperty("password","root");
        props.setProperty("ssl","false");

        try {

            this.connection = DriverManager.getConnection(url, props);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return connection;
    }


}
