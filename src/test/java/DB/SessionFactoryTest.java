package DB;

import hibernate.SessionFactorySingleton;
import org.junit.Before;
import org.junit.Test;
import org.apache.log4j.Logger;

import static org.junit.Assert.assertEquals;

/**
 * Created by echavez on 7/13/16.
 */
public class SessionFactoryTest {


    private SessionFactorySingleton sone = null, stwo = null;

    @Before
    public void setup() {
        SessionFactorySingleton sone = new SessionFactorySingleton();
        SessionFactorySingleton stwo = new SessionFactorySingleton();
    }

    @Test
    public void itShouldGetASingletonForSessionFactory() {
        assertEquals(true, this.sone == this.stwo);
    }


}
