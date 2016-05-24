package utils;

import enums.PagesList;
import models.Article;
import models.Video;
import scrappers.Opcion;
import scrappers.Tiempo;

import java.util.HashSet;

/**
 * Created by echavez on 5/20/16.
 */
public class Scrapper {

    private String url;
    private Article article;

    public Article getArticle() {
        return this.article;
    }

    public Scrapper(String url){
        this.url = url;

        switch (whichPage()){

            case TIEMPO:
                this.article = new Tiempo(url);
                break;

            case OPCION:
                this.article = new Opcion(url);
                break;

            default:

                break;
        }

    }

    private PagesList.pages whichPage(){


        if(this.url.matches(".*tiempo.*")){

            return PagesList.pages.TIEMPO;

        }else if(this.url.matches(".*http://laopcion.com.mx.*")){

            return PagesList.pages.OPCION;

        }

        return PagesList.pages.OTHER;
    }

    public Video scrapVideo(){
        return article.getVideo();
    }
    public String scrapTitle(){
        return article.getTitle();
    }

    public String scrapContent(){
        return article.getContent();
    }

    public HashSet<String> scrapThumbnail(){
        return article.getThumbnail();
    }

    public HashSet<String> scrapTags(){
        return article.getTags();
    }

    public String scrapCategory(){
        return "";
    }

    public String scrapAuthor(){
        return article.getAuthor();
    }

    public String scrapHTML(){
        return null;
    }


}
