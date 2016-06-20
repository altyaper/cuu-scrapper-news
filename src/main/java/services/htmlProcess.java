package services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by echavez on 6/17/16.
 */
public class HtmlProcess {

    public Document getHtml(String url) throws IOException{
        return Jsoup.connect(url).timeout(60*1000).get();
    }

}
