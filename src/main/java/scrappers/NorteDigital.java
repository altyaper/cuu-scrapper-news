package scrappers;

import models.Article;
import org.jsoup.select.Elements;

/**
 * Created by echavez on 6/13/16.
 */
public class NorteDigital extends Article {
    public NorteDigital(String pageUrl) {
        super(pageUrl);
        setTitle();
        setContent();
        setThumbnail();
        setAuthor();
    }

    public void setThumbnail() {
        Elements aux = this.html.select(".imagen-post ul li");
        for (int i = 0; i < aux.size(); i++) {
            this.thumbnail.add(aux.get(i).select("a").attr("href").toString());
        }

    }

    public void setTitle() {
        Elements aux = this.html.select("h1.titulo-evento");
        this.title = aux.text().trim();
    }

    public void setContent() {
        Elements aux = this.html.select(".contenido-nota");
        this.content = aux.text().trim();
    }

    @Override
    public void setAuthor() {
        Elements aux = this.html.select(".fuente");
        this.author = aux.text().trim().replace(" | NorteDigital","");
    }
}
