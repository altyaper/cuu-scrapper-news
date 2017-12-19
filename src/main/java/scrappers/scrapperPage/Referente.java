package scrappers.scrapperPage;

import org.jsoup.select.Elements;

import java.io.IOException;

import models.Article;
import services.HtmlProcess;

/**
 * Created by echavez on 7/6/16.
 */
public class Referente extends Article {

    public Referente(String pageUrl, HtmlProcess htmlProcess) throws IOException {
        super(pageUrl, htmlProcess);
        setCategory();
        setAuthor();
        setDate();
        setSourceId(16);
    }

    @Override
    public void setTitle() {
        Elements aux = this.html.select(".tituloentrada h1");
        this.title = aux.text().trim();
    }

    @Override
    public void setThumbnail() {
        Elements aux = this.html.select(".entrada .headimage");
        String src = aux.attr("style");
        if(src != ""){
            String[] parts = src.split("\'");
            this.thumbnail.add(parts[1]);
        }
    }

    @Override
    public void setContent() {
        Elements aux = this.html.select(".mensajeinterno");
        this.content = aux.html();
    }

    @Override
    public void setCategory() {
        Elements aux = this.html.select(".tipo .eltipo");
        this.category = aux.text();
    }

    @Override
    public void setAuthor() {
        Elements aux = this.html.select(".epfr .nombre");
        this.author = aux.text().trim();
    }

    @Override
    public void setDate() {
        Elements aux = this.html.select(".epfr .fecha");
        this.date = aux.text().trim();
    }
}
