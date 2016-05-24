package models;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by echavez on 5/20/16.
 */
public abstract class Article{

    public String title;
    public String content;
    private String category;
    public HashSet<String> thumbnail = new HashSet<String>();;

    public String author;
    protected String pageUrl;
    public Video video;
    private Date date;
    private Enum page;
    public Document html;

    public HashSet<String> tags = new HashSet<String>();

    public Article(String pageUrl) {

        this.pageUrl = pageUrl;

    }

    public boolean setHTML(){

        Document doc = null;
        try {
            this.html = Jsoup.connect(this.pageUrl).get();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public HashSet<String> getTags(){
        return this.tags;
    }

    public void setTags(){

    }

    public HashSet<String> getThumbnail() {
        return thumbnail;
    }

    abstract public void setThumbnail();

    public String getTitle() {
        return title;
    }

    abstract public void setTitle();

    public String getContent() {
        return content;
    }

    abstract public void setContent();

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor() {}

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo() {}

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Enum getPage() {
        return page;
    }

    public void setPage(Enum page) {
        this.page = page;
    }

}
