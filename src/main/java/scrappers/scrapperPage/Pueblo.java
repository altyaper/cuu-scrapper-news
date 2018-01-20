package scrappers.scrapperPage;

import enums.PagesList;
import models.Article;
import org.jsoup.select.Elements;
import services.HtmlProcess;

import java.io.IOException;
import java.util.Date;

/**
 * Created by echavez on 6/30/16.
 */
public class Pueblo extends Article {

    public Pueblo(String pageUrl, HtmlProcess htmlProcess) throws IOException {
        super(pageUrl, htmlProcess);
        setDate();
        setCategory();
        setAuthor();
        setSourceId(14);
    }

    @Override
    public void setTitle() {
        Elements aux = this.html.select("h1.note-title");
        this.title = aux.text().trim();
    }

    @Override
    public void setThumbnail() {
        Elements aux = this.html.select(".note-img img");
        if(!aux.isEmpty()){
            String src = aux.attr("src");
            String page = (String) PagesList.getRootUrls().get(PagesList.pages.PUEBLO);
            this.thumbnail.add(page+src.substring(1, src.length()));
        }
    }

    @Override
    public void setContent() {
        String intro = this.html.select("h2.note-intro").html();
        String content = this.html.select(".note-content").html();
        this.content = intro + "\n" + content;
    }

    @Override
    public void setDate() {
        Elements aux = this.html.select(".note-date");
        String[] parts = aux.html().split(" - ");
        Date date = new Date();
        this.date = date;
    }

    @Override
    public void setAuthor() {
        Elements aux = this.html.select(".note-date");
        String[] parts = aux.html().split(" - ");
        this.author = parts[1];
    }

    @Override
    public void setCategory() {
        Elements aux = this.html.select("h3.note-category-title");
        this.category = aux.text().trim();
    }
}
