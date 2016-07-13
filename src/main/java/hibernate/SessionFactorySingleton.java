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
            instance = new Configuration().configure().buildSessionFactory();
        }
        return instance;
    }

}
