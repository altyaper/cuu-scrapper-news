package main;

import db.ConnectionManager;
import scrappers.scrapperCover.*;
import utils.ScrapCover;
import utils.Scrapper;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by echavez on 5/20/16.
 */
public class Main {

    public static void main(String... strings) throws IOException {

        ScrapCover.scrappAllCovers();

//        Connection a = null;
//
//        ConnectionManager connection = new ConnectionManager();
//        a = connection.getConnection();


    }



}
