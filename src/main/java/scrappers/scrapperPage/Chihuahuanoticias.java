package scrappers.scrapperPage;

import models.Article;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import services.HtmlProcess;

import java.io.IOException;
import java.util.Date;

/**
 * Created by echavez on 6/14/16.
 */
public class Chihuahuanoticias extends Article {

    public Chihuahuanoticias(String url, HtmlProcess htmlProcess) throws IOException {
        super(url, htmlProcess);
        setCategory();
        setTags();
        setDate();
        setSourceId(2);
    }

    @Override
    public void setThumbnail() {
        Elements aux = this.html.select(".entry-thumb");
        if (aux.size() != 0)
            this.thumbnail.add(aux.get(0).attr("src"));
    }

    @Override
    public void setTitle() {
        Elements aux = this.html.select("h1.entry-title");
        this.title = aux.text().trim();
    }

    @Override
    public void setContent() {
        Elements aux = this.html.select(".td-post-content > p");
        //Clean HTML
        for (Element element : aux.select(".td-post-featured-image")) {
            element.remove();
        }
        for (Element element : aux.select("[st_url]")) {
            element.remove();
        }
        for (Element element : aux.select("fb|comments-count")) {
            element.remove();
        }

        this.content = aux.outerHtml().replace("Comentarios", "").trim();
    }

    public void setCategory() {
        Elements crumbs = this.html.select(".entry-crumbs span");
        Element a = crumbs.get(3);
        this.category = a.text();
    }


    @Override
    public void setDate() {
        Elements aux = this.html.select(".entry-date");
        this.date = new Date();
    }

    public void setTags() {

        Elements aux = this.html.select(".entry");
        String[] tags = aux.attr("class").split(" ");
        for (int i = 0; i < tags.length; i++) {
            if (tags[i].matches("tag-.*")) {
                String str = tags[i].replace("tag-", "");
                this.tags.add(this.capitalize(str.replaceAll("-", " ")));
            }
        }

    }

}
