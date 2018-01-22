package scrappers.scrapperPage;

import models.Article;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import services.HtmlProcess;

import java.io.IOException;

/**
 * Created by echavez on 6/13/16.
 */
public class NorteDigital extends Article {

    public NorteDigital(String url, HtmlProcess htmlProcess) throws IOException {
        super(url, htmlProcess);
        setAuthor();
        setTags();
        setCategory();
        setSourceId(9);
    }

    @Override
    public void setThumbnail() {
        Elements aux = this.html.select(".imagen-nota");
        if (!aux.isEmpty()) {
            for (int i = 0; i < aux.size(); i++) {
                this.thumbnail.add(aux.attr("src").toString());
            }
        }
    }

    @Override
    public void setTitle() {
        Elements aux = this.html.select(".entry-title");
        this.title = aux.text().trim();
    }

    @Override
    public void setContent() {
        Elements aux = this.html.select(".nota");
        this.content = aux.html();
    }

    @Override
    public void setAuthor() {
        Elements aux = this.html.select(".entry-content .entry-meta span");
        this.author = aux.text().trim().replace("Por ", "");
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
