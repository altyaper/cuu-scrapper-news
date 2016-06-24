package scrappers.scrapperPage;

import models.Article;
import org.jsoup.select.Elements;
import services.HtmlProcess;

import java.io.IOException;

/**
 * Created by echavez on 6/23/16.
 */
public class Diario extends Article {
    public Diario(String url, HtmlProcess htmlProcessStub) throws IOException {
        super(url, htmlProcessStub);
    }

    @Override
    public void setThumbnail() {
        Elements aux = this.html.select("#img_ppal img");
        if(!aux.isEmpty()){
            this.thumbnail.add(aux.get(0).attr("src").toString());
        }
    }

    @Override
    public void setTitle() {
        Elements aux = this.html.select("h1");
        this.title = aux.text().trim();
    }

    @Override
    public void setContent() {
        Elements aux = this.html.select("#texto_nota");
        this.content = aux.html();
    }
}
