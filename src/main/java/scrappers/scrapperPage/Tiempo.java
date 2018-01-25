package scrappers.scrapperPage;

import enums.PagesList;
import models.Article;
import org.jsoup.select.Elements;
import services.HtmlProcess;
import utils.UtilFunctions;

import javax.swing.text.html.parser.Element;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by echavez on 5/20/16.
 */
public class Tiempo extends Article {

    // Builder Design Pattern
    public Tiempo(String url, HtmlProcess htmlProcess) throws IOException {
        super(url, htmlProcess);
        setTags();
        setCategory();
        setSourceId(18);
        setDate();
        setAuthor();
    }

    @Override
    public void setAuthor() {
        Elements aux = this.html.select(".m-r-sm");
        this.author = aux.text().trim();
    }

    @Override
    public void setTitle() {
        Elements auxtitle = this.html.select("header h1");
        this.title = auxtitle.text().trim();
    }

    @Override
    public void setContent() {
        //Get summary
        this.content = "";
        Elements auxSummary = this.html.select("article > blockquote p");
        if(!auxSummary.isEmpty()) {
            this.content = "<p>" + auxSummary.get(0).html() + "</p>";
        }
        Elements aux = this.html.select("#article-post div h1");
        if (!aux.isEmpty()) {
            this.content = this.content + "\n\n" + aux.get(0).html();
        }else {
            Elements iframe = this.html.select(".video-iframe");
            this.content = iframe.html();
        }

    }


    @Override
    public void setThumbnail() {
        Elements aux = this.html.select(".complemento-item .complemento-img");
        this.thumbnail.add(aux.attr("src"));
    }

    @Override
    public void setTags() {
        Elements aux = this.html.select(".tags a");
        for (int i = 0; i < aux.size(); i++) {
            this.tags.add(aux.get(i).text().toString());
        }
    }

    @Override
    public void setCategory() {
        Elements aux = this.html.select(".breadcrumb .active");
        if(!aux.isEmpty())
                this.category = aux.get(0).text().trim();
    }

    @Override
    public void setDate() {
        Elements auxDate = this.html.select("article > blockquote footer");
        if(!auxDate.isEmpty()) {
            String dateString = auxDate.get(1).text();
            String[] parts = dateString.split(" ");
            String day = parts[1];
            String month = UtilFunctions.getMonthBySpanishName(parts[3]);
            String year = parts[parts.length-1];
            String finalString = day + "/" + month + "/" + year;
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            try {
                this.date = formatter.parse(finalString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            this.date = new Date();
        }

    }

}
