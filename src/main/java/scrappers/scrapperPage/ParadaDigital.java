package scrappers.scrapperPage;

import enums.PagesList;
import models.Article;
import org.jsoup.select.Elements;
import services.HtmlProcess;

import java.io.IOException;

/**
 * Created by echavez on 6/20/16.
 */
public class ParadaDigital extends Article {

    public ParadaDigital(String pageUrl, HtmlProcess htmlProcess) throws IOException {
        super(pageUrl, htmlProcess);
        setDate();
    }

    @Override
    public void setThumbnail() {
        Elements aux = this.html.select("article .imgpost img");
        if(!aux.isEmpty()){
            this.thumbnail.add(PagesList.getRootUrls().get(PagesList.pages.PARADADIGITAL)+aux.get(0).attr("src").toString().substring(1));
        }
    }

    @Override
    public void setTitle() {
        Elements aux = this.html.select("header h1");
        this.title = aux.text().trim();
    }

    @Override
    public void setContent() {
        Elements aux = this.html.select("article .post-content > p");
        this.content = aux.outerHtml();
    }

    @Override
    public void setDate(){
        Elements aux = this.html.select(".postmeta .meta-date");
        this.date = aux.text().trim().substring(0, aux.text().length()-1);
    }
}
