package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by echavez on 7/13/16.
 */
public class SessionFactorySingleton {

    private static SessionFactory instance = null;

    public static SessionFactory getInstance() {
        if(instance == null) {
            Configuration cfg = new Configuration();
            String DATABASE_URL = "";
            String DATABASE_USER = "";
            String DATABASE_PASSWORD = "";
            String env = System.getenv("HIBERNATE_ENVIRONMENT");
            if(env.equals("development")) {
                DATABASE_URL = System.getenv("HIBERNATE_DATABASE_URL");
                DATABASE_USER = System.getenv("HIBERNATE_DATABASE_USER");
                DATABASE_PASSWORD = System.getenv("HIBERNATE_DATABASE_PASSWORD");
            } else if(env.equals("production")) {
                DATABASE_URL = System.getenv("PRODUCTION_HIBERNATE_DATABASE_URL");
                DATABASE_USER = System.getenv("PRODUCTION_HIBERNATE_DATABASE_USER");
                DATABASE_PASSWORD = System.getenv("PRODUCTION_HIBERNATE_DATABASE_PASSWORD");
            }
            cfg.setProperty("hibernate.connection.url", DATABASE_URL);
            cfg.setProperty("hibernate.connection.username", DATABASE_USER);
            cfg.setProperty("hibernate.connection.password", DATABASE_PASSWORD);
            instance = cfg.configure().buildSessionFactory();
        }
        return instance;
    }

}
