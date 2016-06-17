package scrappers.scrapperPage;

import models.Article;
import org.jsoup.select.Elements;

/**
 * Created by echavez on 6/13/16.
 */
public class Segundoasegundo extends Article {

    // Builder Design Pattern
    public Segundoasegundo(String pageUrl) {
        super(pageUrl);
        setThumbnail();
        setContent();
        setTitle();
    }

    public void setThumbnail() {
        Elements aux = this.html.select("img.entry-thumb");
        this.thumbnail.add(aux.text().trim());
    }

    public void setTitle() {
        Elements aux = this.html.select("header h1.entry-title");
        this.title = aux.text().trim();
    }

    public void setContent() {
        Elements auxtitle = this.html.select(".td-post-content p");
        this.content = auxtitle.text().trim();
    }
}
