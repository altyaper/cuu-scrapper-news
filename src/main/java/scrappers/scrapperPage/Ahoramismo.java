package scrappers.scrapperPage;

import models.Article;
import org.jsoup.select.Elements;
import services.HtmlProcess;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by echavez on 6/25/16.
 */
public class Ahoramismo extends Article {

    public Ahoramismo(String pageUrl, HtmlProcess htmlProcess) throws IOException {
        super(pageUrl, htmlProcess);
        setAuthor();
        setDate();
        setCategory();
        setSourceId(1);
    }

    @Override
    public void setTitle() {
        Elements aux = this.html.select("h1.post-title");
        this.title = aux.text().trim();
    }

    @Override
    public void setThumbnail() {
        Elements aux = this.html.select(".featured .wp-post-image");
        this.thumbnail.add(aux.attr("src"));
    }

    @Override
    public void setContent() {
        Elements aux = this.html.select(".post-content.description");
        this.content = aux.html();
    }

    public void setDate() {
        Elements aux = this.html.select(".dtreviewed time");
        String dateString = aux.attr("datetime");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            this.date = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setAuthor() {
        Elements aux = this.html.select(".reviewer a");
        this.author = aux.text().trim().replace(" ahoramismo", "");
    }

    public void setCategory() {
        Elements aux = this.html.select(".cats a");
        this.category = aux.text().trim();
    }
}
