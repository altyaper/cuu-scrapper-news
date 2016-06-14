package scrappers;

import models.Article;
import models.Video;
import org.jsoup.select.Elements;

/**
 * Created by echavez on 5/23/16.
 */
public class Opcion extends Article {

    // Builder Design Pattern
    public Opcion(String url){
        super(url);
        setHTML();
        setTitle();
        setContent();
        setThumbnail();
        setTags();
        setAuthor();
        setVideo();
    }

    public void setTags() {}

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

    public void setTitle() {
        Elements aux = this.html.select("h1.ntitulo");
        this.title = aux.text().trim();
    }

    public void setContent() {
        Elements auxtitle = this.html.select(".notainner .nnota");
        this.content = auxtitle.text().trim();
    }

    @Override
    public void setAuthor(){
        Elements auxtitle = this.html.select(".nreportero");
        this.author = auxtitle.text().replace("Reportero:  ","").trim();
    }

}
