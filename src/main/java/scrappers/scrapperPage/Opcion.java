package scrappers.scrapperPage;

import models.Article;
import models.Video;
import org.jsoup.select.Elements;
import services.HtmlProcess;

import java.io.IOException;

/**
 * Created by echavez on 5/23/16.
 */
public class Opcion extends Article {

    // Builder Design Pattern
    public Opcion(String url, HtmlProcess htmlProcess) throws IOException {
        super(url, htmlProcess);
        setTags();
        setAuthor();
        setVideo();
        setCategory();
    }

    @Override
    public void setVideo(){
        Elements aux = this.html.select(".nvideo iframe");
        if(!aux.isEmpty()){
            this.video = new Video(aux.attr("src"));
        }
    }

    @Override
    public void setThumbnail() {
        Elements aux = this.html.select(".gimg img");

        if(aux.isEmpty()){
            aux = this.html.select(".ncover img");
        }
        for (int i = 0; i < aux.size(); i++) {
            this.thumbnail.add(aux.get(i).attr("src").toString());
        }
    }

    @Override
    public void setTitle() {
        Elements aux = this.html.select("h1.ntitulo");
        this.title = aux.text().trim();
    }

    @Override
    public void setContent() {
        Elements aux = this.html.select(".notainner .nnota");
        this.content = aux.html();
    }

    @Override
    public void setAuthor(){
        Elements auxtitle = this.html.select(".nreportero");
        this.author = auxtitle.text().replace("Reportero:  ","").trim();
    }

    @Override
    public void setCategory(){
        Elements aux = this.html.select(".notatop .ncategoria");
        this.category = aux.text().trim();
    }

}
