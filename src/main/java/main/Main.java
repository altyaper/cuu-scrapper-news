package main;

import hibernate.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import utils.ScrapCover;

/**
 * Created by echavez on 5/20/16.
 */
public class Main {

    public static void main(String... strings) throws SQLException, URISyntaxException, IOException {
        ScrapCover scrapCover = new ScrapCover();
        try {
            scrapCover.scrappAllCovers();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            SessionFactorySingleton.getInstance().close();
        }

    }



}
