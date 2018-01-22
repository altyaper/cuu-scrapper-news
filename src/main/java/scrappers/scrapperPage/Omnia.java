package scrappers.scrapperPage;

import models.Article;
import org.jsoup.select.Elements;
import services.HtmlProcess;
import utils.UtilFunctions;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by echavez on 6/15/16.
 */
public class Omnia extends Article{
    public Omnia(String pageUrl, HtmlProcess htmlProcess) throws IOException {
        super(pageUrl, htmlProcess);
        setAuthor();
        setDate();
        setSourceId(10);
    }

    public void setThumbnail() {
        Elements aux = this.html.select("article .content .field-name-field-image img");
        if(!aux.isEmpty()){
            this.thumbnail.add(aux.get(0).attr("src").toString());
        }
    }

    public void setTitle() {
        Elements aux = this.html.select("h1.title");
        this.title = aux.text().trim();
    }

    public void setContent() {
        Elements aux = this.html.select("article .content .field-name-body");
        this.content = aux.text().trim();
    }

    public void setAuthor() {
        Elements aux = this.html.select(".field-name-field-autoria");
        this.author = aux.text().trim().replace("Por:  ", "");
    }

    public void setDate() {
        Elements aux = this.html.select("article .field-name-post-date");
        String dateString = aux.text().trim();
        String[] parts = dateString.split(",");
        String[] twoParts = parts[1].trim().split(" ");
        String monthInt = UtilFunctions.getMonthBySpanishName(twoParts[0]);
        String year = parts[2].trim();
        String finalDateString = twoParts[1] + "/" + monthInt + "/" + year;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
        try {
            this.date = format.parse(finalDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
