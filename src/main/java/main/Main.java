package main;

import utils.ScrapCover;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

/**
 * Created by echavez on 5/20/16.
 */
public class Main {

    public static void main(String... strings) throws SQLException, URISyntaxException {

//        Map<String, String> env = System.getenv();

        ScrapCover scrapCover = new ScrapCover();
        try {
            scrapCover.scrappAllCovers();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }



}
