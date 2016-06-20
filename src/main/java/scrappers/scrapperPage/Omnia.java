package scrappers.scrapperPage;

import models.Article;
import org.jsoup.select.Elements;
import services.HtmlProcess;

import java.io.IOException;

/**
 * Created by echavez on 6/15/16.
 */
public class Omnia extends Article{
    public Omnia(String pageUrl, HtmlProcess htmlProcess) throws IOException {
        super(pageUrl, htmlProcess);
    }

    public void setThumbnail() {
        Elements aux = this.html.select("#img_nota_interna img");
        if(!aux.isEmpty()){
            this.thumbnail.add(aux.get(0).attr("src").toString());
        }
    }

    public void setTitle() {
        Elements aux = this.html.select("#titulo_nota_interna p");
        this.title = aux.text().trim();
    }

    public void setContent() {
        Elements aux = this.html.select("#txt_nota_interna p");
        this.content = aux.text().trim().replaceAll(".+- ","");
    }
}
