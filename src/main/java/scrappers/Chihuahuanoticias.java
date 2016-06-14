package scrappers;

import models.Article;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by echavez on 6/14/16.
 */
public class Chihuahuanoticias extends Article {

    public Chihuahuanoticias(String url) {
        super(url);
        setTitle();
        setThumbnail();
    }

    public void setThumbnail() {
        Set<String> thumbnails = new HashSet<String>();
        Elements aux = this.html.select(".entry p img");
        thumbnails.add(aux.get(0).attr("src"));
//        this.setThumbnail(thumbnails);
    }

    public void setTitle() {
        Elements aux = this.html.select("h1.entry-title");
        this.title = aux.text().trim();
    }

    public void setContent() {

    }
}
