package utils;

import enums.PagesList;
import models.Article;
import models.Video;
import scrappers.Opcion;
import scrappers.Segundoasegundo;
import scrappers.Tiempo;

import java.util.HashSet;

/**
 * Created by echavez on 5/20/16.
 */
public final class Scrapper {

    private String url;
    private Article article;

    public Article getArticle() {
        return this.article;
    }

    //Factory Design Pattern
    public Scrapper(String url){
        this.url = url;

        switch (whichPage()){

            case TIEMPO:
                this.article = new Tiempo(url);
                break;

            case OPCION:
                this.article = new Opcion(url);
                break;

            case SEGUNDOASEGUNDO:
                this.article = new Segundoasegundo(url);
                break;

            default:

                break;
        }

    }

    private final PagesList.pages whichPage(){


        if(this.url.matches(".*tiempo.*")){

            return PagesList.pages.TIEMPO;

        }else if(this.url.matches(".*http://laopcion.com.mx.*")){

            return PagesList.pages.OPCION;

        }else if(this.url.matches(".*http://www.segundoasegundo.com/.*")){

            return PagesList.pages.SEGUNDOASEGUNDO;

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
