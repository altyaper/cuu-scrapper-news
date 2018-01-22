package scrappers.scrapperPage;

import models.Article;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import services.HtmlProcess;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by echavez on 6/25/16.
 */
public class Polaka extends Article {

    public Polaka(String pageUrl, HtmlProcess htmlProcess) throws IOException {
        super(pageUrl, htmlProcess);
        setDate();
        setTags();
        setCategory();
        setSourceId(13);
    }

    @Override
    public void setTitle() {
        Elements aux = this.html.select(".entry-title");
        this.title = aux.text().trim();
    }

    @Override
    public void setThumbnail() {
        Elements aux = this.html.select(".td-post-featured-image img");
        this.thumbnail.add(aux.attr("src"));
    }

    @Override
    public void setContent() {
        Elements aux = this.html.select(".td-post-content p");
        for (Element element : aux.select("fb|comments-count")) {
            element.remove();
        }
        this.content = aux.outerHtml().replace("<p class=\"commentcount\"> Comentarios</p>", "");
    }

    public void setDate() {
        Elements aux = this.html.select(".td-post-date time");
        String dateString = aux.attr("datetime").trim();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            this.date = format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setTags() {
        Elements aux = this.html.select("meta");
        for (Element meta : aux) {
            if (meta.attr("property").equals("article:tag")) {
                this.tags.add(this.capitalize(meta.attr("content")));
            }
        }
    }

    @Override
    public void setCategory() {
        Elements aux = this.html.select("meta");
        for (Element meta : aux) {
            if (meta.attr("property").equals("article:section")) {
                this.category = this.capitalize(meta.attr("content").toLowerCase());
            }
        }
    }

}
