package scrappers;

import enums.PagesList;
import models.Article;
import org.jsoup.select.Elements;

/**
 * Created by echavez on 6/13/16.
 */
public class Cronica extends Article{

    // Builder Design Pattern
    public Cronica(String url) {
        super(url);
        setTitle();
        setContent();
        setThumbnail();
    }

    public void setThumbnail() {
        Elements aux = this.html.select(".content.slide img");
        if(!aux.isEmpty()){
            this.thumbnail.add(PagesList.getRootUrls().get(PagesList.pages.CRONICA)+aux.get(0).attr("src").toString());
        }
    }

    public void setTitle() {
        Elements aux = this.html.select(".content .col7.articulo h1");
        this.title = aux.text().trim();
    }

    public void setContent() {
        Elements aux = this.html.select(".content .col7.articulo > p");
        System.out.println(aux.text());
        this.content = aux.text().replace("¡Sea el primero en escribir un comentario! ---ooOoo---", "").trim();
    }
}
