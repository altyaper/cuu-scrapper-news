package scrappers.scrapperPage;

import models.Article;
import org.jsoup.select.Elements;
import services.HtmlProcess;

import java.io.IOException;

/**
 * Created by echavez on 6/30/16.
 */
public class InformacionTotal extends Article {

    public InformacionTotal(String pageUrl, HtmlProcess htmlProcess) throws IOException {
        super(pageUrl, htmlProcess);
        setDate();
        setAuthor();
        setSourceId(7);
    }

    @Override
    public void setTitle() {
        Elements aux = this.html.select("h1.n_title");
        this.title = aux.text().trim();
    }

    @Override
    public void setThumbnail() {

        Elements aux = this.html.select(".n_fgal img");
        if(!aux.isEmpty()){
            this.thumbnail.add(aux.get(0).attr("src"));
        }
    }

    @Override
    public void setContent() {
        Elements aux = this.html.select(".n_body");
        this.content = aux.html();
    }

    public void setDate() {
        Elements aux = this.html.select(".col-xs-12 time");
        this.date = aux.attr("datetime");
    }

    public void setAuthor() {
        Elements aux = this.html.select(".mtop time span");
        this.author = aux.get(1).text().trim();
    }
}
