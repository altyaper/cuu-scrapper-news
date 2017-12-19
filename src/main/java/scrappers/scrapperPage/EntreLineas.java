package scrappers.scrapperPage;

import models.Article;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import services.HtmlProcess;

import java.io.IOException;

/**
 * Created by echavez on 6/20/16.
 */
public class EntreLineas extends Article {

    public EntreLineas(String pageUrl, HtmlProcess htmlProcess) throws IOException {
        super(pageUrl, htmlProcess);
        setAuthor();
        setSourceId(5);
    }

    @Override
    public void setThumbnail() {
        Elements aux = this.html.select(".apw-gallery-grid-wrapper img");
        if(!aux.isEmpty()){
            for(Element img : aux )  {
                this.thumbnail.add(img.attr("src").toString());
            }
        }else{
            aux = this.html.select(".post-thumbnail img");
            String src = aux.attr("src");
            this.thumbnail.add(src);
        }
    }

    @Override
    public void setTitle() {
        Elements aux = this.html.select("h1.entry-title");
        this.title = aux.text().trim();
    }

    @Override
    public void setContent() {
        Elements aux = this.html.select(".entry-content");
        for (Element element : aux.select(".apw-gallery-grid-wrapper")) {
            element.remove();
        }
        this.content = aux.html();
    }

    @Override
    public void setAuthor(){
        Elements aux = this.html.select(".apw-post-meta-dd .url");
        this.author = aux.text().trim();
    }
}
