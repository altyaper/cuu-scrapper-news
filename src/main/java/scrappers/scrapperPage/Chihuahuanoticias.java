package scrappers.scrapperPage;

import models.Article;
import org.jsoup.select.Elements;
import services.HtmlProcess;

import java.io.IOException;

/**
 * Created by echavez on 6/14/16.
 */
public class Chihuahuanoticias extends Article {

    public Chihuahuanoticias(String url, HtmlProcess htmlProcess) throws IOException {
        super(url, htmlProcess);
        setCategory();
        setTags();
    }

    @Override
    public void setThumbnail() {
        Elements aux = this.html.select(".entry p img");
        if (aux.size() != 0)
            this.thumbnail.add(aux.get(0).attr("src"));
    }

    @Override
    public void setTitle() {
        Elements aux = this.html.select("h1.entry-title");
        this.title = aux.text().trim();
    }

    @Override
    public void setContent() {
        Elements aux = this.html.select(".entry > p");
        this.content = aux.text().replace("  Comentarios","").trim();
    }

    public void setCategory() {
        Elements aux = this.html.select(".entry");
        String[] classes = aux.attr("class").split(" ");
        String categoryclass = null;
        for (int i = 0; i < classes.length; i++) {
            if(classes[i].matches("category-\\w+")){
                String str = classes[i].split("-")[1];
                categoryclass = str.substring(0, 1).toUpperCase() + str.substring(1);
            }
        }
        this.category = categoryclass;
    }


    public void setTags() {

        Elements aux = this.html.select(".entry");
        String[] tags = aux.attr("class").split(" ");
        for (int i = 0; i < tags.length; i++) {
            if(tags[i].matches("tag-.*")){
                String str = tags[i].replace("tag-","");
                this.tags.add(this.capitalize(str.replaceAll("-", " ")));
            }
        }

    }

}
