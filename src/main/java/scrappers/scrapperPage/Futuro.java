package scrappers.scrapperPage;

import enums.PagesList;
import models.Article;
import org.jsoup.select.Elements;
import services.HtmlProcess;

import java.io.IOException;

/**
 * Created by echavez on 6/29/16.
 */
public class Futuro extends Article {

    public Futuro(String pageUrl, HtmlProcess htmlProcess) throws IOException {
        super(pageUrl, htmlProcess);
        setDate();
    }

    @Override
    public void setTitle() {
        Elements aux = this.html.select("#page #u1345-4 p");
        this.title = aux.text().trim();
    }

    @Override
    public void setThumbnail() {
        Elements aux = this.html.select("#u1374_img");
        this.thumbnail.add(PagesList.getRootUrls().get(PagesList.pages.FUTURO)+aux.attr("src"));
    }

    @Override
    public void setContent() {
        Elements aux = this.html.select("#u1350-2");
        this.content = aux.html();
    }

    public void setDate() {
        Elements aux = this.html.select("#u1350-21");
        if(!aux.isEmpty()) {
            String[] str = aux.text().replace("Publicado el día ", "").split(" ");
            this.date = str[str.length-1];
        }
    }
}
