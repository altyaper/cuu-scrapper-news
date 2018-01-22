package scrappers.scrapperPage;

import models.Article;
import org.jsoup.select.Elements;
import services.HtmlProcess;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        String aux = this.html.select(".col-xs-12 time").attr("datetime");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        try {
            this.date = format.parse(aux);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setAuthor() {
        Elements aux = this.html.select(".mtop time span");
        this.author = aux.get(1).text().trim();
    }
}
