package scrappers.scrapperPage;

import enums.PagesList;
import models.Article;
import org.jsoup.select.Elements;
import services.HtmlProcess;

import java.io.IOException;

/**
 * Created by echavez on 6/13/16.
 */
public class Cronica extends Article{

    // Builder Design Pattern
    public Cronica(String url, HtmlProcess htmlProcess) throws IOException {
        super(url, htmlProcess);
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
        this.content = aux.outerHtml().replace("<p><strong>¡Sea el primero en escribir un comentario!</strong></p>\n" +
                "<p><small>---ooOoo---</small></p>", "").trim();
    }
}
