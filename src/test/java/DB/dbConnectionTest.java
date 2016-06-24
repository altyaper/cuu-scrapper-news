package DB;

import db.ConnectionManager;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by echavez on 6/23/16.
 */
public class dbConnectionTest {

    private ConnectionManager connectionm;


    @Before
    public void setup(){
        this.connectionm = new ConnectionManager();
    }
    @Test
    public void itShouldGetAConnection(){

//        this.connection = this.connectionm.getConnection();

    }

}
