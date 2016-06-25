package scrappers.scrapperPage;

import models.Article;
import org.jsoup.select.Elements;
import services.HtmlProcess;

import java.io.IOException;

/**
 * Created by echavez on 5/20/16.
 */
public class Tiempo extends Article {

    // Builder Design Pattern
    public Tiempo(String url, HtmlProcess htmlProcess) throws IOException {
        super(url, htmlProcess);
        setTags();
        setCategory();
    }

    @Override
    public void setTitle() {
        Elements auxtitle = this.html.select("header h1");
        this.title = auxtitle.text().trim();
    }

    @Override
    public void setContent() {
        Elements aux = this.html.select("#article-post div h1");
        if (!aux.isEmpty())
            this.content = aux.get(0).html();
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

}
