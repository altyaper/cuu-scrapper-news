package scrappers.scrapperPage;

import enums.PagesList;
import models.Article;
import org.jsoup.select.Elements;
import services.HtmlProcess;

import java.io.IOException;

/**
 * Created by echavez on 6/20/16.
 */
public class EntreLineas extends Article {

    public EntreLineas(String pageUrl, HtmlProcess htmlProcess) throws IOException {
        super(pageUrl, htmlProcess);
        setAuthor();
    }

    @Override
    public void setThumbnail() {
        Elements aux = this.html.select(".nota-featured-image img");
        if(!aux.isEmpty()){
            this.thumbnail.add(aux.get(0).attr("src").toString());
        }
    }

    @Override
    public void setTitle() {
        Elements aux = this.html.select(".titulo-nota h1");
        this.title = aux.text().trim();
    }

    @Override
    public void setContent() {
        Elements aux = this.html.select(".post");
        this.content = aux.text().trim();
    }

    @Override
    public void setAuthor(){
        Elements aux = this.html.select(".autor-fecha .izquierdo");
        String [] elements = aux.text().split("\\|");

        String auxAuthor = elements[0].replace("Por: ", "");
        int lenght = auxAuthor.length()-1;

        this.author = auxAuthor.substring(0, lenght);
    }
}
