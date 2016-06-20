package scrappers.scrapperPage;

import models.Article;
import org.jsoup.select.Elements;
import services.HtmlProcess;

import java.io.IOException;

/**
 * Created by echavez on 6/14/16.
 */
public class Chihuahuanoticias extends Article {

    public Chihuahuanoticias(String url, HtmlProcess htmlProcess) throws IOException {
        super(url, htmlProcess);
        setTitle();
        setThumbnail();
        setContent();
    }

    public void setThumbnail() {
        Elements aux = this.html.select(".entry p img");
        if (aux.size() != 0)
            this.thumbnail.add(aux.get(0).attr("src"));
    }

    public void setTitle() {
        Elements aux = this.html.select("h1.entry-title");
        this.title = aux.text().trim();
    }

    public void setContent() {
        Elements aux = this.html.select(".entry > p");
        this.content = aux.text().replace("  Comentarios","").trim();
    }
}
