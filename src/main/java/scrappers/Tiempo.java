package scrappers;

import models.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static jdk.nashorn.internal.objects.NativeString.trim;

/**
 * Created by echavez on 5/20/16.
 */
public class Tiempo extends Article{

    public Tiempo(String url){
        super(url);
        setHTML();
        setTitle();
        setContent();
        setThumbnail();
        setTags();
    }


    public void setTitle() {
        Elements auxtitle = this.html.select("header h1");
        this.title = auxtitle.text().trim();
    }

    public void setContent(){
        Elements aux = this.html.select("#article-post div h1");
        this.content = aux.text().trim();
    }

    public void setThumbnail(){
        Elements aux = this.html.select(".complemento-item .complemento-img");
        this.thumbnail.add(aux.attr("src"));
    }

    @Override
    public void setTags(){
        Elements aux = this.html.select(".tags a");
        for (int i = 0; i < aux.size(); i++) {
            this.tags.add(aux.get(i).text().toString());
        }
    }

}
